package com.kh.admin.model.test;

/**
 * 所在的包名: com.kh.admin.model.test
 * 所在的项目名：kh-admin
 *
 * @Author:xukh
 * @Description:
 * @Date: Created in 1:23 2017/9/24
 */
public class Father {

    private String money;

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Father{" +
                "money='" + money + '\'' +
                '}';
    }
}
