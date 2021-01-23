package design_pattern.structural.decorator;

public class DecoratorB implements Target {
    private final Target target;

    public DecoratorB(Target target) {
        this.target = target;
    }

    @Override
    public void say() {
        System.out.println("装饰器 B 增强功能...");
        target.say();
    }
}
