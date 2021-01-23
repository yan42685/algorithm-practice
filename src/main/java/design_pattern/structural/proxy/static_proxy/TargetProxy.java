package design_pattern.structural.proxy.static_proxy;

public class TargetProxy implements ITarget {
    private ITarget target;

    public TargetProxy(ITarget target) {
        this.target = target;
    }

    @Override
    public void say() {
        System.out.println("Proxy do something before...");
        target.say();
        System.out.println("Proxy do something after...");
    }


}
