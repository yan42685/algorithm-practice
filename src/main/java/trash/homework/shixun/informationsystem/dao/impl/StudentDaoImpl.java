package trash.homework.shixun.informationsystem.dao.impl;

import trash.homework.shixun.informationsystem.dao.StudentDao;
import trash.homework.shixun.informationsystem.model.Student;

public class StudentDaoImpl implements StudentDao {
    // 创建学生对象数组
    private static Student[] stus = new Student[5];

    static {
        Student stu1 = new Student("heima001", "张三", "23", "1999‐11‐11");
        Student stu2 = new Student("heima002", "李四", "24", "2000‐11‐11");
        stus[0] = stu1;
        stus[1] = stu2;
    }

    // 添加学生方法
    @Override
    public boolean addStudent(Student stu) {
        // 2. 添加学生到数组
        //2.1 定义变量index为‐1，假设数组已经全部存满，没有null的元素
        int index = -1;
        //2.2 遍历数组取出每一个元素，判断是否是null
        for (int i = 0; i < stus.length; i++) {
            Student student = stus[i];
            if (student == null) {
                index = i;
                //2.3 如果为null，让index变量记录当前索引位置，并使用break结束循环遍历
                break;
            }
        }
        // 3. 返回是否添加成功的boolean类型状态
        if (index == -1) {
            // 装满了
            return false;
        } else {
            // 没有装满, 正常添加, 返回true
            stus[index] = stu;
            return true;
        }
    }

    // 查看学生方法
    @Override
    public Student[] findAllStudents() {
        return stus;
    }

    @Override
    public void deleteById(String delId) {
        // 1. 查找id在容器中所在的索引位置
        int index = getIndex(delId);
        // 2. 将该索引位置,使用null元素进行覆盖
        stus[index] = null;
    }

    private int getIndex(String id) {
        int index = -1;
        for (int i = 0; i < stus.length; i++) {
            Student stu = stus[i];
            if (stu != null && stu.getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public void updateById(String updateId, Student newStu) {
        // 1. 查找updateId, 在容器中的索引位置
        int index = getIndex(updateId);
        // 2. 将该索引位置, 使用新的学生对象替换
        stus[index] = newStu;
    }
}
