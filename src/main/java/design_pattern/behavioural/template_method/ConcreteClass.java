package design_pattern.behavioural.template_method;

public class ConcreteClass extends AbstractClass {
    @Override
    protected void beforeSay() {
        System.out.println("before say");
    }
}
