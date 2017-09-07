package com.kh.admin.service;

import com.kh.admin.common.utils.DateUtil;
import com.kh.admin.dao.FinanceMapperExt;
import com.kh.admin.model.Finance;
import org.springframework.stereotype.Service;
import org.testng.collections.Lists;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * 所在的包名: com.kh.admin.service
 * 所在的项目名：kh-admin
 *
 * @Author:xukh
 * @Description:
 * @Date: Created in 11:58 2017/8/7
 */
@Service
public class testService  {

    @Resource
    private FinanceMapperExt financeMapperExt;

    public void insert(){

        long start = DateUtil.getNow();

        for (int i=0;i <1000000; i++){
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
        List<Object> list = Lists.newArrayList();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        List<Object> lists = Lists.newArrayList();
        lists.add("q");
        lists.add("w");
        lists.add("e");
        lists.add("r");

        list.addAll(lists);

        for (int i = 0; i < list.size();i ++) {
            System.out.println(list.get(i));
        }

        System.out.println("-----------------------------");

        for (int i = 0; i < lists.size();i ++) {
            System.out.println(lists.get(i));
        }



    }

}
