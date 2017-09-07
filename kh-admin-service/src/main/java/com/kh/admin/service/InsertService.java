package com.kh.admin.service;

import com.kh.admin.dao.TestMapperExt;
import com.kh.admin.model.Test;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 所在的包名: com.kh.admin.service
 * 所在的项目名：kh-admin
 *
 * @Author:xukh
 * @Description:
 * @Date: Created in 20:44 2017/9/3
 */
@Service
public class InsertService {


    @Resource
    private TestMapperExt testMapperExt;

    public void insert(){
        Test test = new Test();
        test.setId("5");

        testMapperExt.insertSelective(test);
    }


}
