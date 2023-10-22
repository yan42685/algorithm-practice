package design_pattern.creational.singleton.badpractice;

import design_pattern.creational.singleton.Resource;
/**
 * 懒汉，但是线程不安全
 */
public class BadLazySingleton1 {
    private static Resource instance;
    private BadLazySingleton1() {}
    private static Resource getInstance() {
        if (instance == null) {
            instance = new Resource();
        }
        return instance;
    }
}
