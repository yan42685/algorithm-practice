package design_pattern.structural.adaptor.clazz;

public class Test {
    public static void main(String[] args) {
        Target target = new ClazzAdaptor();
        target.newSay();
    }
}
