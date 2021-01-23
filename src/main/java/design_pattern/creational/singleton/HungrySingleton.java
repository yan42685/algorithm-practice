package design_pattern.creational.singleton;

/** 饿汉, 类加载时初始化，线程安全 */
public class HungrySingleton {
    private static final Resource INSTANCE = new Resource();

    private HungrySingleton() {
    }

    public Resource getInstance() {
        return INSTANCE;
    }
}
