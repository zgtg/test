package com.yg.email.dao;

import com.yg.email.entity.Email;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 邮件
 */
public class EmailDao {
    /**
     * 注册驱动
     */
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final String URL = "jdbc:mysql://47.98.130.54:3306/email?useUnicode=true&useSSL=false&serverTimezone=GMT%2b8";
    public static final String USER = "root";
    public static final String PASSWORD = "Test@2019";

    /**
     * 获取邮件列表
     * @return
     */
    public List<Email> getEmailList() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            // 获取连接
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            st = conn.createStatement();
            rs = st.executeQuery("select * from tb_email");

            List<Email> emailList = new ArrayList<>();

            while(rs.next()) {
                Email email = new Email();

                int id = rs.getInt("id");
                String senderName = rs.getString("senderName");
                String title = rs.getString("title");
                String content = rs.getString("content");

                email.setId(id);
                email.setSenderName(senderName);
                email.setTitle(title);
                email.setContent(content);

                emailList.add(email);
            }

            return emailList;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (st != null) {
                    st.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    public int deleteById(int id) {
        Connection conn = null;
        Statement st = null;

        try {
            // 获取连接
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            st = conn.createStatement();

            return st.executeUpdate("delete from tb_email where id = " + id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return 0;
    }
}
