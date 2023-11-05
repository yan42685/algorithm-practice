package design_pattern.creational.singleton;

/**
 * 饿汉2 枚举实现
 * 用枚举则可以保证线程安全、反射安全、序列化安全
 * 需要保存状态就用单例模式，不需要就用工具类静态方法
 */
public enum HungrySingleton2 {
    INSTANCE;

    private Resource context;

    // 默认就是private的，因为无法在外部创建枚举类的实例
    public void setContext(Resource context) {
        this.context = context;
    }

    public String doSomething() {
        return "Do something with " + context.toString();
    }

}

class TestHungrySingleton2 {
    public static void main(String[] args) {
        HungrySingleton2.INSTANCE.setContext(new Resource());
        String result = HungrySingleton2.INSTANCE.doSomething();
        System.out.println(result);
    }
}

