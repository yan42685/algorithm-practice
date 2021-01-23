package design_pattern.behavioural.template_method;

public abstract class AbstractClass {
    public final void say() {
        // 插槽
        beforeSay();
       
        // 模板代码
        System.out.println("say 1");
        System.out.println("say 2");
        System.out.println("say 3");
    }

    protected abstract void beforeSay();
}
