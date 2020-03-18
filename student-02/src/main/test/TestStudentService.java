import com.yg.entity.Student;
import com.yg.service.StudentService;
import org.junit.Test;

import java.sql.Date;
import java.util.List;

public class TestStudentService {
    /**
     * 新增student
     */
    @Test
    public void testStudentAdd(){
        StudentService service = new StudentService();
        Student s = new Student();
        s.setName("zhangsan");
        s.setBirthday(new Date(9-9));
        s.setProvince(1);
        s.setSports("1,2");
        s.setSex(1);
        service.studentAdd(s);

    }

    /**
     * 获取所有student信息
     */
    @Test
    public void testGetAll(){
        StudentService service = new StudentService();
        List<Student> studentList = service.getAll();
        for (Student student : studentList){
            System.out.println(student.getId() +":"+ student.getName() +":"+ student.getBirthday() +":"+ student.getSports() +":"+
                    student.getSex() +":"+ student.getSports());
        }
    }

    /**
     * 根据id删除student
     *
     */
    @Test
    public void testDeleteById() {
        StudentService service = new StudentService();
        int result = service.deleteById(7);
        System.out.println(result);
    }
}
