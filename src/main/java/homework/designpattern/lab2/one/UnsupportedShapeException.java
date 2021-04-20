package homework.designpattern.lab2.one;

public class UnsupportedShapeException extends RuntimeException {
    public UnsupportedShapeException() {
        super("不能绘制不支持的几何图形");
    }
}
