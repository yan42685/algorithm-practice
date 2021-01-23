package design_pattern.structural.proxy.dynamic_proxy.jdk_api;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomProxy implements InvocationHandler {
    private final Object target;

    public CustomProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("自定义代理 before...");
        Object result = method.invoke(this.target, args);
        System.out.println("自定义代理 after...");
        return result;
    }
}
