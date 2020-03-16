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
        String uri = req.getRequestURI();

        if (uri.equals("/email/list")) {
            List<Email> emailList = getEmailList();

            req.setAttribute("emailList", emailList);

            // WEB-INF文件夹下的文件是受保护的，不能通过浏览器访问
            // servlet 跳转到jsp页面
            req.getRequestDispatcher("/WEB-INF/email/list.jsp").forward(req, resp);
        } else if (uri.equals("/email/delete")) {
            String ids = req.getParameter("ids");

            String[] idArr = ids.split(",");

            for(int i=0; i<idArr.length; i++) {
                int id = Integer.parseInt(idArr[i]);// parse 解析

                new EmailService().deleteById(id);
            }

            resp.sendRedirect("/email/list");
        }
    }

    /**
     * 获取邮件列表
     * @return
     */
    public List<Email> getEmailList() {
        return new EmailService().getEmailList();
    }
}
