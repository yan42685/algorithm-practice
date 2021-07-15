package homework.shixun.informationsystem.controller;

import homework.shixun.informationsystem.model.Student;
import homework.shixun.informationsystem.service.StudentService;
import homework.shixun.informationsystem.service.impl.StudentServiceImpl;

import java.util.Scanner;


public class StudentController {
    //  业务员对象
    private StudentService studentService = new StudentServiceImpl();
    private Scanner sc = new Scanner(System.in);

    //  开启学生管理系统,  并展示学生管理系统菜单
    public final void start() {
        //Scanner  sc  =  new  Scanner(System.in);
        while (true) {
            System.out.println("‐‐‐‐‐‐‐‐欢迎来到  <学生>  管理系统‐‐‐‐‐‐‐‐");
            System.out.println("请输入您的选择:  1.添加学生    2.删除学生    3.修改学生    4.查看学生 5.退出");
            String command = sc.next();
            switch (command) {
                case "1":
                    //  System.out.println("添加");
                    addStudent();
                    break;
                case "2":
                    //  System.out.println("删除");
                    deleteById();
                    break;
                case "3":
                    //  System.out.println("修改");
                    updateById();
                    break;
                case "4":
                    //  System.out.println("查询");
                    findAllStudents();
                    break;
                case "5":
                    System.out.println("感谢您使用学生管理系统,  再见!");
                    return;
                default:
                    System.out.println("您的输入有误,  请重新输入");
                    break;
            }
        }
    }

    //  修改学生方法
    public final void updateById() {
        String updateId = inputStudentId();
        Student newStu = inputStudentInfo(updateId);
        studentService.updateById(updateId, newStu);
    }

    //  删除学生方法
    public final void deleteById() {
        String delId = inputStudentId();
        //  3.  调用业务员中的deleteStudentById根据id,  删除学生
        studentService.deleteById(delId);
        //  4.  提示删除成功
    }

    //  查看学生方法
    public final void findAllStudents() {
        //  1.  调用业务员中的获取方法,  得到学生的对象数组
        Student[] stus = studentService.findAllStudents();
        //  2.  判断数组的内存地址,  是否为null
        if (stus == null) {
            System.out.println("查无信息,  请添加后重试");
            return;
        }
        //  3.  遍历数组,  获取学生信息并打印在控制台
        System.out.println("学号\t\t姓名\t年龄\t生日");
        for (int i = 0; i < stus.length; i++) {
            Student stu = stus[i];
            if (stu != null) {
                System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu.getAge()
                        + "\t\t" + stu.getBirthday());
            }
        }
    }

    //  添加学生方法
    public final void addStudent() {
        //  StudentService  studentService  =  new  StudentService();
        //  1.  键盘接收学生信息
        String id;
        while (true) {
            System.out.println("请输入学生id:");
            id = sc.next();
            boolean flag = studentService.isIdExists(id);
            if (flag) {
                System.out.println("学号已被占用,  请重新输入");
            } else {
                break;
            }
        }
        Student stu = inputStudentInfo(id);
        //  3.  将学生对象,传递给StudentService(业务员)中的addStudent方法
        boolean result = studentService.addStudent(stu);
    }

    //  键盘录入学生id
    public String inputStudentId() {
        String id;
        while (true) {
            System.out.println("请输入学生id:");
            id = sc.next();
            boolean exists = studentService.isIdExists(id);
            if (!exists) {
                System.out.println("您输入的id不存在,  请重新输入:");
            } else {
                break;
            }
        }
        return id;
    }

    //  键盘录入学生信息
    //  开闭原则:  对扩展内容开放,  对修改内容关闭
    public Student inputStudentInfo(String id) {
        System.out.println("请输入学生姓名:");
        String name = sc.next();
        System.out.println("请输入学生年龄:");
        String age = sc.next();
        System.out.println("请输入学生生日:");
        String birthday = sc.next();
        Student stu = new Student(id, name, age, birthday);
        return stu;
    }
}
