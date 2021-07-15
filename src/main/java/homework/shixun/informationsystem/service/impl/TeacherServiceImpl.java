package homework.shixun.informationsystem.service.impl;


import homework.shixun.informationsystem.dao.TeacherDao;
import homework.shixun.informationsystem.dao.impl.TeacherDaoImpl;
import homework.shixun.informationsystem.model.Teacher;
import homework.shixun.informationsystem.service.TeacherService;

import java.util.stream.Stream;

public class TeacherServiceImpl implements TeacherService {

    private final TeacherDao teacherDao = new TeacherDaoImpl();

    @Override
    public boolean addTeacher(Teacher t) {
        boolean isSuccess = teacherDao.addTeacher(t);
        if (isSuccess) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
        return isSuccess;
    }

    @Override
    public boolean isIdExists(String id) {
        Teacher[] teachers = teacherDao.findAllTeachers();
        return Stream.of(teachers).anyMatch(teacher -> teacher != null && teacher.getId().equals(id));
    }

    @Override
    public Teacher[] findAllTeachers() {
        return teacherDao.findAllTeachers();
    }

    @Override
    public void deleteById(String id) {
        teacherDao.deleteById(id);
        System.out.println("删除成功");
    }

    @Override
    public void updateById(String id, Teacher newTeacher) {
        teacherDao.updateById(id, newTeacher);
        System.out.println("修改成功");
    }
}
