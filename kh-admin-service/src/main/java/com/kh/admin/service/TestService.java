package com.kh.admin.service;

import com.kh.admin.common.utils.DateUtil;
import com.kh.admin.dao.FinanceMapperExt;
import com.kh.admin.model.Finance;
import org.springframework.stereotype.Service;
import org.testng.collections.Lists;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 所在的包名: com.kh.admin.service
 * 所在的项目名：kh-admin
 *
 * @Author:xukh
 * @Description:
 * @Date: Created in 11:58 2017/8/7
 */
@Service
public class TestService {

    final int cores = Runtime.getRuntime().availableProcessors();

    @Resource
    private FinanceMapperExt financeMapperExt;

    public void insert(){

        long start = DateUtil.getNow();

        for (int i=109760;i <1000000; i++){
            String s = String.valueOf(i);
            BigDecimal money = BigDecimal.valueOf(1000000);
            BigDecimal m = BigDecimal.valueOf(1);
            BigDecimal fee = BigDecimal.valueOf(0.01);

            Finance f = new Finance();
            f.setOrderSn(s);
            f.setPayPlatformOrderSn("platform" + s);
            f.setLiquidatorOrderSn("liquidator" + s);
            f.setStoreId(s);
            f.setLiquidatorId(s);
            f.setOrderType(1);
            f.setRealMoney(money.subtract(m));
            f.setPayPlatformFee(fee);
            f.setPayPlatformRate(fee);
            f.setBankCommissionFee(fee);
            f.setBankCommissionRate(fee);
            f.setLiquidatorCommissionFee(fee);
            f.setLiquidatorCommissionRate(fee);
            f.setPayStatus(1);
            f.setCreateTime(DateUtil.getNow());
            f.setUpdateTime(DateUtil.getNow());
            f.setCreateDay(DateUtil.getNowDate());
            f.setPayDay(DateUtil.getNowDate());

            financeMapperExt.insertSelective(f);
        }
        long end = DateUtil.getNow();
        System.out.println(start-end);

    }

    public static void main(String[] args) {
        final int cores = Runtime.getRuntime().availableProcessors();
        System.out.println(cores);
    }

    /*public void batchAdd(){
        // cpu核数
        final int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(cores * 4);

        int total = list.size();
        int avg = 1000;
        if (total == 0) {
            return;
        }
        try {
            //根据cpu核数执行线程
            for (int i = 1; i <= total / avg + 1; i++) {
                //根据线程数划分list
                final List<Map<Integer, Object>> newlist;
                //根据线程数划分list
                if (total < i * avg) {
                    newlist = list.subList((i - 1) * avg, total);
                } else {
                    newlist = list.subList((i - 1) * avg, i * avg);
                }
                if (newlist.size() == 0) {
                    break;
                }
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        ruzhu(newlist, liquidatorId);
                    }
                });
            }
        } catch (Exception e) {
            logger.error("batchCreateMerchant >> 商户入驻失败!");
            executorService.shutdown();
        }
    }*/
}
