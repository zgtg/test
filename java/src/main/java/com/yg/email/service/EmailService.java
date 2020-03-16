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

    /**
     * 根据ID删除邮件
     * @param id
     * @return
     */
    public boolean deleteById(int id) {
        return new EmailDao().deleteById(id) > 0;
    }
}
