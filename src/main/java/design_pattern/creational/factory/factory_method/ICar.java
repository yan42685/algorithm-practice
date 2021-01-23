package design_pattern.creational.factory.factory_method;

public interface ICar {
    void drive();
}

class ACar implements ICar {

    @Override
    public void drive() {
        System.out.println("ACar is driving...");
    }
}

class BCar implements ICar {

    @Override
    public void drive() {
        System.out.println("BCar is driving...");
    }
}

