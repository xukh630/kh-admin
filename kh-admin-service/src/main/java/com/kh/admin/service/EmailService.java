package com.kh.admin.service;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 所在的包名: com.kh.admin.service
 * 所在的项目名：kh-admin
 *
 * @Author:xukh
 * @Description:
 * @Date: Created in 17:12 2017/8/9
 */
@Service
public class EmailService {
    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Resource(name = "mailSender")
    private JavaMailSenderImpl mailSender;


    public void send(String[] sendTo, String subject, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(mailSender.getUsername());
            message.setTo(sendTo);
            message.setSubject(subject);
            message.setText(text);
            mailSender.send(message);
        } catch (Exception e) {
            logger.error("发送邮件出错, subject = {}, text = {}, ex = {}", subject, text, ExceptionUtils.getStackTrace(e));
        }
    }

}
