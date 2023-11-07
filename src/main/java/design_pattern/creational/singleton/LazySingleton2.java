package design_pattern.creational.singleton;

import java.io.Serializable;
import java.sql.SQLOutput;

/**
 * 线程安全、反射安全、序列化安全
 */
public class LazySingleton2 implements Serializable {
    private static class Holder {
        private static LazySingleton2 instance = new LazySingleton2();
    }

    private LazySingleton2() {
        if (Holder.instance != null) {
            // 保证反射安全
            throw new RuntimeException("Instance already created");
        }
    }

    public static LazySingleton2 getInstance() {
        return Holder.instance;
    }

    // 保证序列化安全，这个方法在反序列化时调用，保证返回的是单例instance
    private Object readResolve() {
        return Holder.instance;
    }


}
