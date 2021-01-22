package design_pattern.template_method;

public class ConcreteClass extends AbstractClass {
    @Override
    protected void beforeSay() {
        System.out.println("before say");
    }
}
