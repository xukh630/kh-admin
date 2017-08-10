package com.kh.admin.api.controller;

import com.kh.admin.common.utils.ResourceUtil;
import com.kh.admin.service.EmailService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 所在的包名: com.kh.admin.api.controller
 * 所在的项目名：kh-admin
 *
 * @Author:xukh
 * @Description:
 * @Date: Created in 17:25 2017/8/9
 */
@RestController
@RequestMapping("/mail")
public class MailController {

    @Resource
    private EmailService emailService;

    @RequestMapping("/send")
    public void send(){
        String[] mail = ResourceUtil.getSystem("mail.receiver").split(",");

        emailService.send(mail,"text","开门查水表");
    }
}
