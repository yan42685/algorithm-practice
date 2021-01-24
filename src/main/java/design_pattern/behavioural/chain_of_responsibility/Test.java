package design_pattern.behavioural.chain_of_responsibility;

public class Test {
    public static void main(String[] args) {
        HandlerChain handlerChain = new HandlerChain();
        handlerChain.addHandler(new HandlerA());
        handlerChain.addHandler(new HandlerB());
        handlerChain.startUtilFinished(new Target("hahah"));
    }
}
