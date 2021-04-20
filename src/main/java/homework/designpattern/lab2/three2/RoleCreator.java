package homework.designpattern.lab2.three2;

public class RoleCreator {
    private RoleBuilder roleBuilder;

    public RoleCreator(RoleBuilder roleBuilder) {
        this.roleBuilder = roleBuilder;
    }

    public Role construct() {
        roleBuilder.buildGender();
        roleBuilder.buildFace();
        roleBuilder.buildClothes();
        roleBuilder.buildHair();
        return roleBuilder.getRole();
    }

}
