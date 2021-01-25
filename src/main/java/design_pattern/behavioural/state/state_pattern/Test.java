package design_pattern.behavioural.state.state_pattern;

public class Test {
    public static void main(String[] args) {
        Context context = new Context();
        context.onEventOne();
        context.onEventTwo();
    }
}
