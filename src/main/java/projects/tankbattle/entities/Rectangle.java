package projects.tankbattle.entities;

import lombok.*;

@Data
@ToString
public class Rectangle {
    protected boolean isAlive = true;
    protected double x;
    protected double y;
    protected double width;
    protected double height;

    public Rectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * 是否与另一个矩形相交
     */
    public boolean intersects(Rectangle another) {
        // 排除四种相离情况就能确定相交
        return !( x + width < another.x || x > another.x + another.width
                || y + height < another.y || y > another.y + another.height);
    }

}
