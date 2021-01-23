package design_pattern.structural.proxy.dynamic_proxy.jdk_api;

public class Test {
    public static void main(String[] args) {
        proxyByProxyObject();
        proxyByLambda();
    }

    private static void proxyByProxyObject() {
        ITarget target = new Target();
        ITarget proxyObject = (ITarget) ProxyFactory.create(target, new CustomProxy(target));
        proxyObject.say();
    }

    /**
     * 不常用，定义一个实现InvokeHandler的代理类到处复用更常见
     */
    private static void proxyByLambda() {
        ITarget target = new Target();
        ITarget proxyObject = (ITarget) ProxyFactory.create(target, (proxy, method, arguments) -> {
            System.out.println("通过lambda动态代理之前...");
            Object result = method.invoke(target, arguments);
            System.out.println("通过lambda动态代理之后...");
            return result;
        });

        proxyObject.say();
    }
}
