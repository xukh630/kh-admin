package com.kh.admin.service.test;



/**
 * 所在的包名: com.kh.admin.service.test
 * 所在的项目名：kh-admin
 *
 * @Author:xukh
 * @Description:
 * @Date: Created in 19:46 2017/10/3
 */
public class GetClass {

    public static void main(String[] args) throws ClassNotFoundException {
        /*Finance finance = new Finance();
        Class<? extends Finance> aClass = finance.getClass();
        String name = aClass.getName();
        System.out.println(name);*/

        //--------------------------------------------------------
        Class<?> finance1 = Class.forName("Finance");


        //--------------------------------------------------------


    }
}
