package trash.homework.shixun.day03;

import lombok.ToString;

import java.time.LocalDate;
import java.util.stream.Stream;

@ToString
class Teacher {
    private String id;
    private String name;
    private String sex;
    private int age;
    private Course course;

    public Teacher(String id, String name, String sex, int age, Course course) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.course = course;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}

@ToString
class Course {
    private String id;
    private String name;
    private LocalDate createTime;
    private String desc;

    public Course(String id, String name, LocalDate createTime, String desc) {
        this.id = id;
        this.name = name;
        this.createTime = createTime;
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}


public class T2 {
    public static void main(String[] args) {
        Course javaCourse = new Course("s001", "Java", LocalDate.parse("2007-02-08"), "Java学科，包含JavaSE和JavaEE");
        Course iosCourse = new Course("s002", "IOS", LocalDate.parse("2007-02-09"), "IOS系统开发");

        Teacher 薛之谦 = new Teacher("t001", "薛之谦", "男", 26, javaCourse);
        Teacher 张碧晨 = new Teacher("t002", "张碧晨", "女", 24, iosCourse);
        Teacher 张杰 = new Teacher("t003", "张杰", "男", 28, javaCourse);
        Teacher target = Stream.of(薛之谦, 张碧晨, 张杰).reduce((a, b) -> a.getAge() > b.getAge() ? a : b).get();
        System.out.println(target);
    }
}
