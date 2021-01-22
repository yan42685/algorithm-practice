package design_pattern.singleton;

/**
 * 最佳实践: 线程安全且不被序列化破坏的单例模式
 */
public enum Singleton {
    INSTANCE;

    private Resource instance;

    Singleton() {
        instance = new Resource();
    }

    public Resource getInstance() {
        return instance;
    }

}

class Resource {

}
