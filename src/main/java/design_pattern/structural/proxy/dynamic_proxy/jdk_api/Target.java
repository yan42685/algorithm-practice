package design_pattern.structural.proxy.dynamic_proxy.jdk_api;

public class Target implements ITarget {
    @Override
    public void say() {
        System.out.println("This is target");
    }
}
