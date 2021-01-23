package design_pattern.structural.decorator;

public class DecoratorA implements Target {
    private final Target target;

    public DecoratorA(Target target) {
        this.target = target;
    }

    @Override
    public void say() {
        System.out.println("装饰器 A 增强功能...");
        target.say();
    }
}
