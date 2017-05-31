package com.kh.admin.service;



import com.kh.admin.common.utils.DateUtil;
import com.kh.admin.model.LpUser;
import org.springframework.stereotype.Service;

/**
 * 项目：liquidator-admin
 * 包名：com.fshows.liquidatior.admin.service
 * 功能：
 * 时间：2017-01-10
 * 作者：呱牛
 */
@Service("userService")
public class UserServiceImpl {

    /**
     * 根据username查询用户信息
     *
     * @return
     */
    public LpUser findOneByUsername(String username) {
        return null;
    }


    public static void main(String[] args) {
        int i = DateUtil.getNowDate();
        System.out.println(i);
    }
}
