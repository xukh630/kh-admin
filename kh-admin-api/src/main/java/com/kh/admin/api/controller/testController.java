package com.kh.admin.api.controller;

import com.alibaba.fastjson.JSON;
import com.kh.admin.model.Finance;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Random;
import java.util.Scanner;

/**
 * @author xukh
 * @create 2017-07-25-16:52
 */
@RestController
@RequestMapping("/test")
public class testController {

    public static void main(String[] args) {
        Finance finance = new Finance();
        Class<? extends Finance> lass = finance.getClass();
        lass.getName();



    }

}



