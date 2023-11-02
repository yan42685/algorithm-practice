package trash.homework.shixun.informationsystem.dao.impl;


import trash.homework.shixun.informationsystem.dao.TeacherDao;
import trash.homework.shixun.informationsystem.model.Teacher;

public class TeacherDaoImpl implements TeacherDao {

    private static final Teacher[] teachers = new Teacher[5];

    @Override
    public boolean addTeacher(Teacher t) {
        int index = -1;
        for (int i = 0; i < teachers.length; i++) {
            Teacher teacher = teachers[i];
            if (teacher == null) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return false;
        } else {
            teachers[index] = t;
            return true;
        }

    }

    @Override
    public Teacher[] findAllTeachers() {
        return teachers;
    }

    @Override
    public void deleteById(String id) {
        int index = getIndex(id);
        teachers[index] = null;
    }

    @Override
    public void updateById(String id, Teacher newTeacher) {
        int index = getIndex(id);
        teachers[index] = newTeacher;
    }

    private int getIndex(String id) {
        int index = -1;
        for (int i = 0; i < teachers.length; i++) {
            Teacher t = teachers[i];
            if (t != null && t.getId().equals(id)) {
                index = i;
                break;
            }
        }

        return index;
    }

}
