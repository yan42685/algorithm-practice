package design_pattern.behavioural.chain_of_responsibility;

public interface Handler {
    boolean handle(Target target);
}

class HandlerA implements Handler {
    @Override
    public boolean handle(Target target) {
        boolean finished = false;
        System.out.println("handlerA handle message: " + target.getContent());
        return finished;
    }
}

class HandlerB implements Handler {
    @Override
    public boolean handle(Target target) {
        boolean finished = false;
        System.out.println("handlerB handle message: " + target.getContent());
        return finished;
    }
}
