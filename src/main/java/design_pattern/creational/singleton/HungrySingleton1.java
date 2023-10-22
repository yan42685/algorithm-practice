package design_pattern.creational.singleton;

/**
 * 关于各种单例的详细讲解：
 * https://blog.csdn.net/qq_33591903/article/details/120617447
 * 饿汉1 类加载时初始化，线程安全;
 * 缺点：不是反射安全和序列化安全的
 */
public class HungrySingleton1 {
    private static Resource instance = new Resource();

    private HungrySingleton1() {
    }

    public static Resource getInstance() {
        return instance;
    }
}
