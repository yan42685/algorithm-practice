package homework.shixun.informationsystem.entry;

import homework.shixun.informationsystem.controller.StudentController;
import homework.shixun.informationsystem.controller.TeacherController;

import java.util.Scanner;

public class InformationManagerEntry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("----- 欢迎来到黑马信息管理系统 -----");
            System.out.println("请输入您的选择：1.学生管理 2.老师管理 3.退出");
            String command = scanner.next();
            switch (command) {
                case "1":
                    new StudentController().start();
                    break;
                case "2":
                    new TeacherController().start();
                    break;
                case "3":
                    System.out.println("感谢您的使用");
                    System.exit(0);
                default:
                    System.out.println("您的输入有误，请重新输入");
            }
        }

    }
}
