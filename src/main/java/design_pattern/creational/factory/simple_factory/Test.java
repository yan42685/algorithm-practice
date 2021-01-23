package design_pattern.creational.factory.simple_factory;

public class Test {
    public static void main(String[] args) {
        IProduct productA = SimpleFactory.get(ProductType.TYPE_A);
        IProduct productB = SimpleFactory.get(ProductType.TYPE_B);
        productA.say();
        productB.say();
    }
}
