package com.yg.service;

import com.yg.dao.StudentDao;
import com.yg.entity.Student;

import java.util.List;

public class StudentService {

    /**
     * 新增student信息
     * @param student
     * @return
     */
    public int studentAdd (Student student){
        return new StudentDao().studentAdd(student);
    }

    /**
     * 获取所有student信息
     * @return
     */
    public List<Student> getAll(){
        return new StudentDao().getAll();
    }

    /**
     * 根据ID删除student
     * @param id
     * @return
     */
    public int deleteById(int id){
        return new StudentDao().deleteById(id);
    }
}
