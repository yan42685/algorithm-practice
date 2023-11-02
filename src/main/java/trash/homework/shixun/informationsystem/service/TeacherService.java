package trash.homework.shixun.informationsystem.service;

import trash.homework.shixun.informationsystem.model.Teacher;

public interface TeacherService {
    boolean addTeacher(Teacher t);

    boolean isIdExists(String id);

    Teacher[] findAllTeachers();

    void deleteById(String id);

    void updateById(String id, Teacher newTeacher);

}
