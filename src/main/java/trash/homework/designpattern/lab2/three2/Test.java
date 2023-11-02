package trash.homework.designpattern.lab2.three2;

public class Test {
    public static void main(String[] args) {
        RoleCreator roleCreator = new RoleCreator(new RoleBuilderB());
        Role role = roleCreator.construct();
        System.out.println(role.getGender());
        System.out.println(role.getFace());
        System.out.println(role.getClothes());
        System.out.println(role.getHair());
    }
}
