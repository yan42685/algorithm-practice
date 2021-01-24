package design_pattern.behavioural.chain_of_responsibility;

public interface Handler {
    boolean handle(String message);
}

class HandlerA implements Handler {
    @Override
    public boolean handle(String message) {
        boolean finished = false;
        System.out.println("handlerA handle message: " + message);
        return finished;
    }
}

class HandlerB implements Handler {
    @Override
    public boolean handle(String message) {
        boolean finished = false;
        System.out.println("handlerB handle message: " + message);
        return finished;
    }
}
