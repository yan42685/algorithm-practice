package trash.homework.designpattern.lab2.three2;

public class RoleBuilderB extends RoleBuilder {
    @Override
    public Role getRole() {
        return this.role;
    }

    @Override
    public void buildGender() {
        this.role.setGender("genderB");
    }

    @Override
    public void buildFace() {
        this.role.setFace("faceB");
    }

    @Override
    public void buildClothes() {
        this.role.setClothes("clothesB");
    }

    @Override
    public void buildHair() {
        this.role.setHair("hairB");
    }

}
