package design_pattern.structural.decorator;

public class Test {
    public static void main(String[] args) {
        Target target = new ConcreteTarget();
        target = new DecoratorA(new DecoratorB(target));
        target.say();
    }
}
