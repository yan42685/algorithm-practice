package trash.homework.shixun.informationsystem.dao;

import trash.homework.shixun.informationsystem.model.Teacher;

public interface TeacherDao {
    boolean addTeacher(Teacher t);

    Teacher[] findAllTeachers();

    void deleteById(String id);

    void updateById(String id, Teacher newTeacher);
}
