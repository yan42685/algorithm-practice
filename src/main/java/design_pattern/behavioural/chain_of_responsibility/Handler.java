package design_pattern.behavioural.chain_of_responsibility;

public interface Handler {
    boolean preHandle(Target target);

    boolean postHandle(Target target);
}

class HandlerA implements Handler {
    @Override
    public boolean preHandle(Target target) {
        boolean finished = false;
        System.out.println("handler A preHandle message: " + target.getContent());
        return finished;
    }

    @Override
    public boolean postHandle(Target target) {
        boolean finished = false;
        System.out.println("handler A posthandle message: " + target.getContent());
        return finished;
    }
}

class HandlerB implements Handler {
    @Override
    public boolean preHandle(Target target) {
        boolean finished = false;
        System.out.println("handlerB preHandle message: " + target.getContent());
        return finished;
    }

    @Override
    public boolean postHandle(Target target) {
        boolean finished = false;
        System.out.println("handlerB postHandle message: " + target.getContent());
        return finished;
    }
}
