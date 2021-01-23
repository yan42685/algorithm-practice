package design_pattern.creational.factory.simple_factory;

public interface IProduct {
    void say();
}

class ProductA implements IProduct {

    @Override
    public void say() {
        System.out.println("This is Product A");
    }
}

class ProductB implements IProduct {

    @Override
    public void say() {
        System.out.println("This is Product B");
    }
}