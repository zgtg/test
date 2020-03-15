package com.yg.service;

import com.yg.email.entity.Email;
import com.yg.email.service.EmailService;
import org.junit.Test;

import java.util.List;

public class EmailServiceTest {

    /**
     * 邮件列表
     */
    @Test
    public void testGetEmailList() {
        List<Email> emailList = new EmailService().getEmailList();

        System.out.println(emailList);
    }
}
