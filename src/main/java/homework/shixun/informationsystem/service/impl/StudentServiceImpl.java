package homework.shixun.informationsystem.service.impl;

import homework.shixun.informationsystem.dao.StudentDao;
import homework.shixun.informationsystem.dao.impl.StudentDaoImpl;
import homework.shixun.informationsystem.model.Student;
import homework.shixun.informationsystem.service.StudentService;

import java.util.stream.Stream;

public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao = new StudentDaoImpl();

    @Override
    public void updateById(String id, Student student) {
        studentDao.updateById(id, student);
        System.out.println("修改成功");
    }

    @Override
    public void deleteById(String id) {
        studentDao.deleteById(id);
        System.out.println("删除成功");
    }

    @Override
    public Student[] findAllStudents() {
        return studentDao.findAllStudents();
    }

    @Override
    public boolean addStudent(Student student) {
        boolean isSuccess = studentDao.addStudent(student);
        if (isSuccess) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
        return isSuccess;
    }

    @Override
    public boolean isIdExists(String id) {
        Student[] students = studentDao.findAllStudents();
        return Stream.of(students).anyMatch(student -> student != null && student.getId().equals(id));
    }

}
