package design_pattern.behavioural.visitor;

public interface Visitor {
    void visit(PdfFile file);

    void visit(WordFile file);

    void visit(XmlFile file);

}

/**
 * 这里是为了看得方便才写在一个文件里，一般会在不同的文件里，用public类
 */
class Extractor implements Visitor {
    @Override
    public void visit(PdfFile file) {
        System.out.println("extract pdf file: " + file.path);
    }

    @Override
    public void visit(WordFile file) {
        System.out.println("extract word file: " + file.path);
    }

    @Override
    public void visit(XmlFile file) {
        System.out.println("extract xml file: " + file.path);
    }

}

class Printer implements Visitor {

    @Override
    public void visit(PdfFile file) {
        System.out.println("print pdf file: " + file.path);
    }

    @Override
    public void visit(WordFile file) {
        System.out.println("print word file: " + file.path);
    }

    @Override
    public void visit(XmlFile file) {
        System.out.println("print xml file: " + file.path);
    }
}

class Compressor implements Visitor {
    @Override
    public void visit(PdfFile file) {
        System.out.println("compress pdf file: " + file.path);
    }

    @Override
    public void visit(WordFile file) {
        System.out.println("compress word file: " + file.path);

    }

    @Override
    public void visit(XmlFile file) {
        System.out.println("compress xml file: " + file.path);
    }
}