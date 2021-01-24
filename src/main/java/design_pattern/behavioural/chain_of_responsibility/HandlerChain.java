package design_pattern.behavioural.chain_of_responsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * 职责链实现方式很灵活
 * 实现可以为数组也可以为链表，结构可以为线性、树状、环, 可以中途停止也可以全部handle, 看具体需求
 */
public class HandlerChain {
    private final List<Handler> handlers = new ArrayList<>();

    public void addHandler(Handler handler) {
        handlers.add(handler);
    }

    public void triggerPreHandlers(Target target) {
        for (Handler handler : handlers) {
            boolean finished = handler.preHandle(target);
            if (finished) {
                break;
            }
        }
    }

    public void triggerPostHandlers(Target target) {
        for (Handler handler : handlers) {
            boolean finished = handler.postHandle(target);
            if (finished) {
                break;
            }
        }
    }


}
