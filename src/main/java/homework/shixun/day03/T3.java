package homework.shixun.day03;

class Manager {
    private String name;
    private String id;
    private double salary;
    private double bonus;

    public Manager() {
    }

    public Manager(String name, String id, double salary, double bonus) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.bonus = bonus;
    }

    public void work() {
        System.out.printf("工号为%s基本工资为%.0f奖金为%.0f的项目经理正在努力的做着管理工作，分配任务，检查员工提交上来的代码.....\n", id, salary, bonus);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}

class Coder {
    private String name;
    private String id;
    private double salary;

    public Coder() {
    }

    public Coder(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void work() {
        System.out.printf("工号为%s基本工资为%.0f的程序员正在努力的写着代码.....\n", id, salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

public class T3 {
    public static void main(String[] args) {
        Manager manager = new Manager("张三", "123", 15000, 6000);
        Coder coder = new Coder("李四", "135", 10000);
        manager.work();
        coder.work();
    }
}

