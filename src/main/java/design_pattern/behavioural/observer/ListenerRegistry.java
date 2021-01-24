package design_pattern.behavioural.observer;

import utils.Asserts;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;

/**
 * 注册 Listener
 */
public class ListenerRegistry {
    // key是事件类型，value是handler
    // CopyOnWriteArraySet可以在保证读写分离，解决读写并发的问题
    private final ConcurrentMap<Class<?>, CopyOnWriteArraySet<EventHandler>> registry = new ConcurrentHashMap<>();

    /**
     * 注册 event 和对应的 listener
     */
    public void register(Object listener) {

        Class<?> clazz = listener.getClass();
        Arrays.stream(clazz.getDeclaredMethods())
                // 获取对象所有带@Subscribe注解的方法, 如果方法带有注解且参数数量不为 1 则会报错
                .filter(method -> method.isAnnotationPresent(Subscribe.class))
                .forEach(method -> {
                    Asserts.argumentsLength(1, method);
                    Class<?> eventClass = method.getParameterTypes()[0];
                    registry.putIfAbsent(eventClass, new CopyOnWriteArraySet<>());
                    // 为该类型的event添加listener回调方法
                    registry.get(eventClass).add((new EventHandler(listener, method)));
                });
    }

    /**
     * 获取 event 对应的 handlers
     */
    // TODO: 解决bug
    public List<EventHandler> getMatchedHandlers(Object event) {
        return registry.entrySet().stream()
                .filter(entry -> entry.getKey().equals(event.getClass()))
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.toList());
    }
}

