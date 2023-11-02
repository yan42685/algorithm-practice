package trash.homework.designpattern.lab2.three2;

public abstract class RoleBuilder {
    protected Role role = new Role();

    public abstract Role getRole();

    public abstract void buildGender();

    public abstract void buildFace();

    public abstract void buildClothes();

    public abstract void buildHair();
}
