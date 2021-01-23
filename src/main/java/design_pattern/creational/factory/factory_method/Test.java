package design_pattern.creational.factory.factory_method;

public class Test {
    public static void main(String[] args) {
        ICar carA = new ACarFactory().createCar();
    }
}
