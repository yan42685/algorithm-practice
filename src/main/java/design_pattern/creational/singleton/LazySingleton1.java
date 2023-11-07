package design_pattern.creational.singleton;

/**
 * 懒汉1 静态内部类实现, 简洁且线程安全
 * 缺点：不是反射安全和序列化安全的，具体修改办法问ChatGPT4
 */
public class LazySingleton1 {
    private static class Holder {
        private static LazySingleton1 instance = new LazySingleton1();
    }
    private LazySingleton1() {}
    public static LazySingleton1 getInstance() {
        return Holder.instance;
    }

}
