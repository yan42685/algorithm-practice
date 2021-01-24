package design_pattern.behavioural.chain_of_responsibility;

import java.util.ArrayList;
import java.util.List;

public class HandlerChain {
    private List<Handler> handlers = new ArrayList<>();

    public void addHandler(Handler handler) {
        handlers.add(handler);
    }

    /**
     * 完成即停止
     */
    public void startUtilFinished(Target target) {
        for (Handler handler : handlers) {
            boolean finished = handler.handle(target);
            if (finished) {
                break;
            }
        }
    }

    /**
     * 所有handler都执行一遍
     */
    public void startForAllHandlers(Target target) {
        handlers.forEach(handler -> handler.handle(target));
    }
}
