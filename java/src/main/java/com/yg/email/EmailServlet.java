package com.yg.email;

import com.yg.email.entity.Email;
import com.yg.email.service.EmailService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class EmailServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Email> emailList = getEmailList();

        req.setAttribute("emailList", emailList);

        req.setAttribute("msg", "hello");

        // servlet 跳转到jsp页面
        req.getRequestDispatcher("/WEB-INF/list.jsp").forward(req, resp);
    }

    /**
     * 获取邮件列表
     * @return
     */
    public List<Email> getEmailList() {
        return new EmailService().getEmailList();
    }
}
