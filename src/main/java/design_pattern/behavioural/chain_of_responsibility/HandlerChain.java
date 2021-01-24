package design_pattern.behavioural.chain_of_responsibility;

import java.util.ArrayList;
import java.util.List;

public class HandlerChain {
    private List<Handler> handlers = new ArrayList<>();

    public void addHandler(Handler handler) {
        handlers.add(handler);
    }

    public void startHandle(String message) {
        for (Handler handler : handlers) {
            boolean finished = handler.handle(message);
            if (finished) {
                break;
            }
        }
    }
}
