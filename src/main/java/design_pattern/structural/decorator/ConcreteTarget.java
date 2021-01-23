package design_pattern.structural.decorator;

public class ConcreteTarget implements Target {
    @Override
    public void say() {
        System.out.println("这是一个具体的target");
    }
}
