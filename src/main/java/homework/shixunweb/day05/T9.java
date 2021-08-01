package homework.shixunweb.day05;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedList;

public class T9 {
    public static void main(String[] args) {
        LinkedList<Student> list = new LinkedList<>();
        list.add(new Student("a", 1, "男"));
        list.add(new Student("b", 2, "男"));
        list.add(new Student("c", 3, "女"));
        list.forEach(System.out::println);
        Student student = list.stream().reduce((a, b) -> a.getAge() > b.getAge() ? a : b).get();
        student.setName("小猪佩奇");
        System.out.println();
        list.forEach(System.out::println);
    }
}

@AllArgsConstructor
@Data
class Student {
    private String name;
    private int age;
    private String gender;
}
