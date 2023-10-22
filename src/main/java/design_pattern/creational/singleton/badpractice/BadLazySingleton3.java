package design_pattern.creational.singleton.badpractice;

import design_pattern.creational.singleton.Resource;

/**
 * 使用双重检查锁定, 线程安全，效率较高，但是代码复杂
 */
public class BadLazySingleton3 {
    // volatile防止指令重排序
    private volatile static Resource instance;
    private BadLazySingleton3() {}
    public Resource getInstance() {
        if (instance == null) {
            synchronized (BadLazySingleton3.class) {
                if (instance == null) {
                    instance = new Resource();
                }
            }
        }
        return instance;
    }
}
