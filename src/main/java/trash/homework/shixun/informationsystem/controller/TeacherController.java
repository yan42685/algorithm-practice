package trash.homework.shixun.informationsystem.controller;


import trash.homework.shixun.informationsystem.model.Teacher;
import trash.homework.shixun.informationsystem.service.TeacherService;
import trash.homework.shixun.informationsystem.service.impl.TeacherServiceImpl;

import java.util.Scanner;

public class TeacherController {
    private final Scanner scanner = new Scanner(System.in);
    private final TeacherService teacherServiceImpl = new TeacherServiceImpl();

    public void start() {
        while (true) {
            System.out.println("--- 欢迎来到老师管理系统 ---");
            System.out.println("请输入您的选择: 1.添加老师  2.删除老师  3.修改老师  4.查看老师  5.退出");
            String command = scanner.next();
            switch (command) {
                case "1":
                    addTeacher();
                    break;
                case "2":
                    deleteById();
                    break;
                case "3":
                    updateById();
                    break;
                case "4":
                    findAllTeacher();
                    break;
                case "5":
                    System.out.println("--- 感谢您使用老师管理系统 ---");
                    return;
                default:
                    System.out.println("您的输入有误, 请重新输入");
                    break;
            }
        }

    }

    public void updateById() {
        String id = inputTeacherId();
        Teacher newTeacher = inputTeacherInfo(id);

        teacherServiceImpl.updateById(id, newTeacher);
    }

    public void deleteById() {
        String id = inputTeacherId();
        teacherServiceImpl.deleteById(id);
    }

    public void findAllTeacher() {
        Teacher[] teachers = teacherServiceImpl.findAllTeachers();

        if (teachers == null) {
            System.out.println("查无信息, 请添加后重试");
            return;
        }

        System.out.println("学号\t姓名\t年龄\t生日");
        for (Teacher t : teachers) {
            if (t != null) {
                System.out.println(t.getId() + "\t\t" + t.getName() + "\t" + t.getAge() + "\t\t" + t.getBirthday());
            }
        }
    }

    public void addTeacher() {
        String id;
        while (true) {
            System.out.println("请输入老师id:");
            id = scanner.next();
            boolean exists = teacherServiceImpl.isIdExists(id);
            if (exists) {
                System.out.println("id已被占用, 请重新输入:");
            } else {
                break;
            }
        }

        Teacher t = inputTeacherInfo(id);
        teacherServiceImpl.addTeacher(t);
    }

    private String inputTeacherId() {
        String id;
        while (true) {
            System.out.println("请输入id");
            id = scanner.next();
            boolean exists = teacherServiceImpl.isIdExists(id);
            if (!exists) {
                System.out.println("您输入的id不存在, 请重新输入:");
            } else {
                break;
            }
        }
        return id;
    }

    private Teacher inputTeacherInfo(String id) {
        System.out.println("请输入老师姓名:");
        String name = scanner.next();
        System.out.println("请输入老师年龄:");
        String age = scanner.next();
        System.out.println("请输入老师生日:");
        String birthday = scanner.next();

        Teacher t = new Teacher();
        t.setId(id);
        t.setName(name);
        t.setAge(age);
        t.setBirthday(birthday);
        return t;
    }
}
