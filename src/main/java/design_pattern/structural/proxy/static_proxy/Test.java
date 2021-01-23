package design_pattern.structural.proxy.static_proxy;

public class Test {
    public static void main(String[] args) {
        ITarget target = new TargetProxy(new RealTarget());
        target.say();
    }
}
