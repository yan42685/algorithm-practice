package design_pattern.behavioural.observer;

import utils.Asserts;

import java.lang.reflect.Method;
import java.util.ArrayList;
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
        Class<?> listenerClass = listener.getClass();
        List<Method> annotatedMethods = Arrays.stream(listenerClass.getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(Subscribe.class))
                .collect(Collectors.toList());

        Class<?> eventClass = null;
        ArrayList<EventHandler> handlers = new ArrayList<>();
        for (Method method : annotatedMethods) {
            // 约定使用@Subscribe注解的方法参数数量为 1 则会报错
            Asserts.argumentsLength(1, method);
            eventClass = method.getParameterTypes()[0];
            registry.putIfAbsent(eventClass, new CopyOnWriteArraySet<>());
            handlers.add(new EventHandler(listener, method));
        }
        // NOTE: CopyOnWriteSet的add方法加了可重入锁，一个个add存在性能问题, 所以用辅助list帮忙一次性add
        registry.get(eventClass).addAll(handlers);
    }

    /**
     * 获取 event 对应的 handlers
     */
    public List<EventHandler> getMatchedHandlers(Object event) {
        return registry.entrySet().stream()
                // a.isAssignableFrom(b) 表示 b的对象 instance of a
                // 即 发送子类型事件, 注册了父类型的 handler也会执行
                .filter(entry -> entry.getKey().isAssignableFrom(event.getClass()))
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.toList());
    }
}

