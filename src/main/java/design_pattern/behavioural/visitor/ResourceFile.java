package design_pattern.behavioural.visitor;

public abstract class ResourceFile {
    protected final String path;

    public ResourceFile(String path) {
        this.path = path;
    }

    // 根据对象类型进行函数重载
    abstract public void accept(Visitor visitor);

}

/**
 * 这里是为了看得方便才写在一个文件里，一般会在不同的文件里，用public类
 */
class PdfFile extends ResourceFile {
    public PdfFile(String path) {
        super(path);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class WordFile extends ResourceFile {
    public WordFile(String path) {
        super(path);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class XmlFile extends ResourceFile {
    public XmlFile(String path) {
        super(path);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
