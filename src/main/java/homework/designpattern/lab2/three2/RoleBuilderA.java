package homework.designpattern.lab2.three2;

public class RoleBuilderA extends RoleBuilder {
    @Override
    public Role getRole() {
        return this.role;
    }

    @Override
    public void buildGender() {
        this.role.setGender("genderA");
    }

    @Override
    public void buildFace() {
        this.role.setFace("faceA");
    }

    @Override
    public void buildClothes() {
        this.role.setClothes("clothesA");
    }

    @Override
    public void buildHair() {
        this.role.setHair("hairA");
    }
}
