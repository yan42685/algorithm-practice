package design_pattern.structural.adaptor.clazz;

/**
 * 适配器, 替代 Source类的实现
 */
public class ClazzAdaptor extends Source implements Target {

    @Override
    public void newSay() {
        oldSay();
    }
}
