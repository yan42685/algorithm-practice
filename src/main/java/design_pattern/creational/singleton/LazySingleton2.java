package design_pattern.creational.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 线程安全、反射安全、序列化安全
 */
public class LazySingleton2 implements Serializable {
    private LazySingleton2() {
        // 保证反射安全
        if (SingletonHolder.instance != null) {
            throw new RuntimeException("Instance already exists, cannot instantiate another one.");
        }
    }

    public Resource getInstance() {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static Resource instance = new Resource();
    }

    // 保证序列化安全，这个方法在反序列化时调用，保证返回的是单例instance
    private Object readResolve() {
        return SingletonHolder.instance;
    }


}
