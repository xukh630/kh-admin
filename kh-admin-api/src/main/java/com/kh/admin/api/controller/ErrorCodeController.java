package com.kh.admin.api.controller;

import com.kh.admin.common.result.ResultModle;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 所在的包名: com.kh.admin.api.controller
 * 所在的项目名：kh-admin
 *
 * @Author:xukh
 * @Description:
 * @Date: Created in 10:02 2017/8/30
 */
@RestController
@RequestMapping("/errorCode")
public class ErrorCodeController {

    @RequestMapping("/success")
    public ResultModle success(){
        return ResultModle.success("成功");
    }

    @RequestMapping("/customError")
    public ResultModle customError(){
        return ResultModle.customError("-100","通用错误");
    }

    @RequestMapping("/userPaying")
    public ResultModle userPaying(){
        return ResultModle.userPaying();
    }

    @RequestMapping("/signError")
    public ResultModle signError(){
        return ResultModle.signError();
    }

    @RequestMapping("/paramError")
    public ResultModle paramError(){
        return ResultModle.paramError();
    }

    @RequestMapping("/perssionError")
    public ResultModle perssionError(){
        return ResultModle.perssionError();
    }

    @RequestMapping("/commonError")
    public ResultModle commonError(){
        return ResultModle.commonError("通用错误");
    }

    @RequestMapping("/loginError")
    public ResultModle loginError(){
        return ResultModle.loginError("登录失效");
    }

    @RequestMapping("/serverError")
    public ResultModle serverError(){
        return ResultModle.serverError();
    }

    @RequestMapping("/platformError")
    public ResultModle platformError(){
        return ResultModle.platformError("平台错误");
    }

    @RequestMapping("/payError")
    public ResultModle payError(){
        return ResultModle.payError("支付错误");
    }

    @RequestMapping("/refundError")
    public ResultModle refundError(){
        return ResultModle.refundError("退款错误");
    }

    @RequestMapping("/liquidatorError")
    public ResultModle liquidatorError(){
        return ResultModle.liquidatorError("清算方错误");
    }

    @RequestMapping("/storeError")
    public ResultModle storeError(){
        return ResultModle.storeError("商户错误");
    }

    @RequestMapping("/subMchError")
    public ResultModle subMchError(){
        return ResultModle.subMchError("子商户号错误");
    }

    @RequestMapping("/shopError")
    public ResultModle shopError(){
        return ResultModle.shopError("门店错误");
    }

    @RequestMapping("/channleError")
    public ResultModle channleError(){
        return ResultModle.channleError("渠道号错误");
    }

}
