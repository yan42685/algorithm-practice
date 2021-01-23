package design_pattern.structural.proxy.static_proxy;

public class RealTarget implements ITarget {
    @Override
    public void say() {
        System.out.println("This is real target");
    }
}
