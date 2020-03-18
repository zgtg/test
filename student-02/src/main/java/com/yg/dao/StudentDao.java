package com.yg.dao;

import com.yg.entity.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StudentDao {


    static {
//        注册驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static final String URL = "jdbc:mysql://47.98.130.54:3306/email?useUnicode=true&useSSL=false&serverTimezone=GMT%2b8";
    private static final String NAME = "root";
    private static final String PASSWORD = "Test@2019";
    /**
     * 新增student
     */
    public int studentAdd(Student student){
        Connection conn = null;
        PreparedStatement ps = null;
//        建立连接
        try{
            conn = DriverManager.getConnection(URL, NAME, PASSWORD);
//        创建语句
            ps = conn.prepareStatement("insert into tb_student (name, birthday, province, sex, sports) value (?, ?, ?, ?, ?)");

            ps.setString(1,student.getName());
            ps.setDate(2,new java.sql.Date(student.getBirthday().getTime()));
            ps.setInt(3,student.getProvince());
            ps.setInt(4,student.getSex());
            ps.setString(5,student.getSports());
//        执行语句
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if (ps != null){
                    ps.close();
                }
                if (conn != null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return 0;
    }

    /**
     * 获取所有student信息
     * @return
     */
    public List<Student> getAll(){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        List<Student> list = new ArrayList();
        try{
//            创建连接
            conn = DriverManager.getConnection(URL, NAME, PASSWORD);
//            创建语句
            st = conn.createStatement();
//            执行语句
            rs = st.executeQuery("select * from  tb_student");
//            获取结果集
            while (rs.next()){
                Student student = new Student();
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Date birthday = rs.getDate("birthday");
                int province = rs.getInt("province");
                int sex = rs.getInt("sex");
                String sports = rs.getString("sports");
                student.setId(id);
                student.setName(name);
                student.setBirthday(birthday);
                student.setProvince(province);
                student.setSex(sex);
                student.setSports(sports);
                list.add(student);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if (rs != null){
                    rs.close();
                }
                if (st != null){
                    st.close();
                }

                if (conn != null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return list;
    }

    /**
     * 根据id删除student
     * @param id
     * @return
     */
    public int deleteById(int id){
        Connection conn = null;
        Statement st = null;
        try{
//            创建连接
            conn = DriverManager.getConnection(URL, NAME, PASSWORD);
//            创建语句
            st = conn.createStatement();
//            执行语句
            return st.executeUpdate("delete from tb_student where id = " + id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if (st != null){
                    st.close();
                }
                if (conn != null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return 0;
    }

    public int update(){
        Connection conn = null;
        Statement st = null;
        try{
            conn = DriverManager.getConnection(URL, NAME, PASSWORD);
            st = conn.createStatement();
            st.executeUpdate("update tb_student set ");
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
