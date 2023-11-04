package javase.tankbattle.entities;

import javase.tankbattle.constants.DirectionEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class Movable {
    protected double x;
    protected double y;
    protected DirectionEnum direction;
    // 步长
    protected double step;
    protected int width;
    protected int height;
    @Setter
    protected boolean isAlive = true;

    public Movable(double x, double y, DirectionEnum direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    /**
     * 指定方向移动
     */
    public void move(DirectionEnum nextDirection) {
        Point nextPoint = getNextPoint(nextDirection);
        x = nextPoint.getX();
        y = nextPoint.getY();
        direction = nextDirection;
    }

    /**
     * 下一次移动的目的坐标, 用于在移动前检测是否可移动
     */
    public Point getNextPoint(DirectionEnum nextDirection) {
        // 静态绑定：只要子类对象的编译类型是Movable，就会输出0.0
        // System.out.println("step: " + step);
        // 动态绑定, 输出值取决于动态类型
        // System.out.println("step " + getStep());
        switch (nextDirection) {
            case UP:
                // 不使用this.step是因为父类Movable和子类AbstractTank都声明了step属性，为了避免静态绑定而使用getStep()
                // 更好的做法子类不要声明 父类同名属性, 而是在构造函数里修改step的值; 此处不这么做是为了学习静态绑定现象
                return new Point(x, y - getStep());
            case DOWN:
                return new Point(x, y + getStep());
            case LEFT:
                return new Point(x - getStep(), y);
            case RIGHT:
                return new Point(x + getStep(), y);
            default:
                throw new IllegalArgumentException(nextDirection.toString());
        }
    }
}
