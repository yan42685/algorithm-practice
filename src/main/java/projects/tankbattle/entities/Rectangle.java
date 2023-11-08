package projects.tankbattle.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Rectangle {
    protected double x;
    protected double y;
    protected double width;
    protected double height;

    /**
     * 是否与另一个矩形相交
     */
    public boolean intersects(Rectangle another) {
        // 排除四种相离情况就能确定相交
        return !(x + width < another.x || x > another.x + another.width
                || y + height < another.y || y > another.y + another.height);
    }

}
