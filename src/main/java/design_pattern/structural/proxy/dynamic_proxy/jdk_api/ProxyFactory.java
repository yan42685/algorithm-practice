package design_pattern.structural.proxy.dynamic_proxy.jdk_api;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 通用的创建动态代理对象工厂
 */
public class ProxyFactory {
    private ProxyFactory() {
    }

    /**
     * @param target  目标对象
     * @param handler 代理逻辑或代理对象
     * @return Object 代理对象
     */
    public static Object create(Object target, InvocationHandler handler) {
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        return Proxy.newProxyInstance(classLoader, interfaces, handler);
    }

}
