package com.kh.admin.api.test;

import com.kh.admin.common.utils.BigDecimalUtil;
import com.kh.admin.model.LpDayOrder;
import com.kh.admin.model.LpRefundOrder;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class RefundTest {


    static final List<Map<String, BigDecimal>> list = new ArrayList();

    public BigDecimal add(BigDecimal a, BigDecimal b) {

        return a.add(b);
    }

    public static void main(String[] args) throws InterruptedException {


        IntStream.rangeClosed(1, 1000).sorted().forEach(i -> {
                    test(new BigDecimal(i), new BigDecimal(i - 1));
                }
        );


        final BigDecimal refundMoney = list.stream().map(i -> i.get("refundMoney")).reduce((a, b) -> a.add(b)).get();
        final BigDecimal bankCommissionFee = list.stream().map(i -> i.get("bankCommissionFee")).reduce((a, b) -> a.add(b)).get();
        final BigDecimal payPlatformFee = list.stream().map(i -> i.get("payPlatformFee")).reduce((a, b) -> a.add(b)).get();
        final BigDecimal liquidatorCommissionFee = list.stream().map(i -> i.get("liquidatorCommissionFee")).reduce((a, b) -> a.add(b)).get();

        list.forEach(System.out::println);

        Thread.sleep(Integer.MAX_VALUE);
    }

    private static void test(BigDecimal oldTotalMoney, BigDecimal newTotalMoney) {
//        //历史已退款总金额
//        final BigDecimal order_money = map.get("order_money");
//
//        // 本次计算订单金额(减方)
//        final BigDecimal oldTotalMoney = finance.getRealMoney().subtract(order_money);
//        // 本次计算订单金额(被减方)
//        final BigDecimal newTotalMoney = oldTotalMoney.subtract(from.getRefundFee());

        final BigDecimal bankCommissionFee = new BigDecimal(0.0005);
        final BigDecimal liquidatorCommissionFee = new BigDecimal(0.0015);
        final BigDecimal payPlatformFee = new BigDecimal(0.002);

        final LpRefundOrder lpRefundOrder = new LpRefundOrder();

        final LpDayOrder oldDayOrder = getRefundLpDayOrder(oldTotalMoney, bankCommissionFee, payPlatformFee, liquidatorCommissionFee);
        final LpDayOrder newDayOrder = getRefundLpDayOrder(newTotalMoney, bankCommissionFee, payPlatformFee, liquidatorCommissionFee);


        //总退款金额
        lpRefundOrder.setRefundMoney(oldDayOrder.getNetMoney().subtract(newDayOrder.getNetMoney()).setScale(2, BigDecimal.ROUND_HALF_UP));
        lpRefundOrder.setBankCommissionFee(oldDayOrder.getBankCommissionFee().subtract(newDayOrder.getBankCommissionFee()).setScale(2, BigDecimal.ROUND_HALF_UP));
        lpRefundOrder.setPayPlatformFee(oldDayOrder.getPayPlatformFee().subtract(newDayOrder.getPayPlatformFee()).setScale(2, BigDecimal.ROUND_HALF_UP));
        lpRefundOrder.setLiquidatorCommissionFee(oldDayOrder.getLiquidatorCommissionFee().subtract(newDayOrder.getLiquidatorCommissionFee()).setScale(2, BigDecimal.ROUND_HALF_UP));
        final Map<String, BigDecimal> map = new ConcurrentHashMap();
        map.put("refundMoney", lpRefundOrder.getRefundMoney());
        map.put("bankCommissionFee", lpRefundOrder.getBankCommissionFee());
        map.put("payPlatformFee", lpRefundOrder.getPayPlatformFee());
        map.put("liquidatorCommissionFee", lpRefundOrder.getLiquidatorCommissionFee());

        list.add(map);
    }


    public static LpDayOrder getRefundLpDayOrder(BigDecimal totalAmount, BigDecimal bankCommissionRate, BigDecimal payPlatformCommissionRate, BigDecimal liquidatorCommissionRate) {
        final LpDayOrder lpDayOrder = new LpDayOrder();

        //  手续费金额计算
        //  实收金额（2位小数，第3位四舍五入）＝ 清算方通过接口上传
        //  平台手续费（2位小数，第3位四舍五入）＝实收金额＊平台手续费
        //  清算方手续费（2位小数，第3位四舍五入）＝实收金额＊清算方续费
        //  净收金额（2位小数，第3位四舍五入）＝实收金额＊（1-平台费率－银行费率－清算方费率）
        //  银行手续费（2位小数，第3位四舍五入）＝实收金额－平台手续费－清算方手续费－净收金额
        BigDecimal bankCommissionFee = BigDecimalUtil.multiply(totalAmount, bankCommissionRate);
        BigDecimal payPlatformFee = BigDecimalUtil.multiply(totalAmount, payPlatformCommissionRate);
        //  实收
        lpDayOrder.setRealMoney(totalAmount);
        // 净收入
        lpDayOrder.setNetMoney( //
                BigDecimalUtil.multiply( //
                        lpDayOrder.getRealMoney(), // 实收金额 *
                        BigDecimal.ONE. // ( 1
                                subtract(payPlatformCommissionRate).     //   - 平台费率
                                subtract(bankCommissionRate).       //   -  银行费率
                                subtract(liquidatorCommissionRate)). //  -  清算方费率）
                        setScale(2, BigDecimal.ROUND_HALF_UP)); //   2位小数，第3位四舍五入
        //  平台费率和手续费
        lpDayOrder.setPayPlatformRate(payPlatformCommissionRate);
        lpDayOrder.setPayPlatformFee(payPlatformFee.setScale(2, BigDecimal.ROUND_HALF_UP));
        //  银行费率和手续费
        lpDayOrder.setBankCommissionRate(bankCommissionRate);
        lpDayOrder.setBankCommissionFee(bankCommissionFee.setScale(2, BigDecimal.ROUND_HALF_UP));  // 2位小数，第3位四舍五入
        //  清算方费率和手续费
        lpDayOrder.setLiquidatorCommissionRate(liquidatorCommissionRate);
        lpDayOrder.setLiquidatorCommissionFee(lpDayOrder.getRealMoney()                       // 实收金额
                .subtract(lpDayOrder.getNetMoney())     //  - 净收入
                .subtract(lpDayOrder.getPayPlatformFee())   // - 平台手续费
                .subtract(lpDayOrder.getBankCommissionFee()) // - 银行手续费
                .setScale(2, BigDecimal.ROUND_HALF_UP));

        // 由于四舍五入，导致清算方手续费是负数，就让商家来承当这个损失
        // 商户净收入 = 商户净收入 + 清算方手续费
        // 清算方手续费 = 0
        if (BigDecimal.ZERO.compareTo(lpDayOrder.getLiquidatorCommissionFee()) > 0) {
            lpDayOrder.setNetMoney(lpDayOrder.getNetMoney().add(lpDayOrder.getLiquidatorCommissionFee()));
            lpDayOrder.setLiquidatorCommissionFee(BigDecimal.ZERO);
        }

        // 设置body
        lpDayOrder.setAttribute2("refund");

        return lpDayOrder;
    }
}
