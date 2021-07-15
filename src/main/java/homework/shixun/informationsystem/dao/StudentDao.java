package homework.shixun.informationsystem.dao;

import homework.shixun.informationsystem.model.Student;

public interface StudentDao {
    void updateById(String id, Student student);

    void deleteById(String id);

    Student[] findAllStudents();

    boolean addStudent(Student student);
}
