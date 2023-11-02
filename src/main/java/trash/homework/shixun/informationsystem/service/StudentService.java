package trash.homework.shixun.informationsystem.service;

import trash.homework.shixun.informationsystem.model.Student;

public interface StudentService {
    void updateById(String id, Student student);

    void deleteById(String id);

    Student[] findAllStudents();

    boolean addStudent(Student student);

    boolean isIdExists(String id);
}
