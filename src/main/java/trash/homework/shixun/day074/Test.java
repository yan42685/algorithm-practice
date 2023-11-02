package trash.homework.shixun.day074;

public class Test {
    public static void main(String[] args) {
        GeneralStaff staff = new Staff();
        staff.setId("staff1");
        staff.setName("Andrew");
        staff.publishNotice("test1");

        System.out.println();

        GeneralStaff manager = new Manager();
        manager.setId("manager1");
        manager.setName("Phillips");
        manager.publishNotice("test2");
    }
}
