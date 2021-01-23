package design_pattern.structural.adaptor.object;

public class Test {
    public static void main(String[] args) {
        Target target = new ObjectAdaptor(new Source());
        target.newSay();
    }
}
