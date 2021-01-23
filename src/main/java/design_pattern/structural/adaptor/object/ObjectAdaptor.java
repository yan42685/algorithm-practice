package design_pattern.structural.adaptor.object;

/**
 * 保留了对源对象的引用
 */
public class ObjectAdaptor implements Target {
    private final Source source;

    public ObjectAdaptor(Source source) {
        this.source = source;
    }

    @Override
    public void newSay() {
        source.oldSay();
    }
}
