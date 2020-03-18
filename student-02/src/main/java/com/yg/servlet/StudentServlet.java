package com.yg.servlet;

import com.yg.entity.Student;
import com.yg.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

public class StudentServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
//        新增student get请求
        if ("/student/add".equals(uri)){
            req.getRequestDispatcher("/WEB-INF/student/student.jsp").forward(req, resp);
            //        新增student post请求
        }else if ("/student/addPost".equals(uri)){
            String name = req.getParameter("name");
            String birthday = req.getParameter("birthday");
            String province = req.getParameter("province");
            String sex = req.getParameter("sex");
            String[] sportAll = req.getParameterValues("sport");

            Student student = new Student();
            student.setName(name);
            try{
                student.setBirthday(new SimpleDateFormat("yyyy-MM-hh").parse(birthday));
            }catch (Exception e){
                e.printStackTrace();
            }
            student.setProvince(Integer.parseInt(province));
            student.setSex(Integer.parseInt(sex));


            String sports = "";
            for (String sport : sportAll){
                sports += sport + ",";
            }
            sports = sports.substring(0, sports.length() - 1);
            student.setSports(sports);

            StudentService service = new StudentService();
            service.studentAdd(student);

            resp.sendRedirect("/student/add");
//            获取所有student信息
        }else if ("/student/getAll".equals(uri)){

            List<Student> studentList = new StudentService().getAll();
            req.setAttribute("studentList", studentList);
            req.getRequestDispatcher("/WEB-INF/student/studentGetAll.jsp").forward(req, resp);
        }
    }

}

