package design_pattern.creational.singleton;

/**
 * 懒汉 1 静态内部类实现
 */
public class LazySingleton {
    private LazySingleton() {}
    public Resource getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final Resource INSTANCE = new Resource();
    }
}
