package com.yg.email.service;

import com.yg.email.dao.EmailDao;
import com.yg.email.entity.Email;

import java.util.List;

public class EmailService {
    /**
     * 邮件列表
     * @return
     */
    public List<Email> getEmailList() {
        return new EmailDao().getEmailList();
    }
}
