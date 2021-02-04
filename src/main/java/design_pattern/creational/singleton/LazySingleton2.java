package design_pattern.creational.singleton;

/**
 * 饿汉  枚举实现
 * 用枚举则可以保证反射安全、序列化安全
 * <p>
 * 非enum的实现在序列化时会通过反射调用无参数的构造方法创建一个新的对象
 */
public enum LazySingleton2 {
    /**
     * 单例
     */
    INSTANCE;

    /**
     * 变量默认是 static 的
     */
    private final Resource something;

    LazySingleton2() {
        something = new Resource();
    }

    public Resource getSomething() {
        return something;
    }

}

