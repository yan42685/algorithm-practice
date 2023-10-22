package design_pattern.creational.singleton.badpractice;

import design_pattern.creational.singleton.Resource;

/**
 * 用synchronize的懒汉，但是效率低
 */
public class BadLazySingleton2 {
    private static Resource instance;
    private BadLazySingleton2() {}
    public synchronized static Resource getInstance() {
        if (instance == null) {
            instance = new Resource();
        }
        return instance;
    }
}
