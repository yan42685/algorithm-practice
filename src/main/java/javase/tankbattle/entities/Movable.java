package javase.tankbattle.entities;

import javase.tankbattle.constants.Direction;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
public abstract class Movable {
    protected double x;
    protected double y;
    protected Direction direction;
    protected double speed;
    protected int width;
    protected int height;
    @Setter
    protected boolean isAlive = true;

    public Movable(double x, double y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    /**
     * 指定方向移动
     */
    public void move(Direction nextDirection) {
        Point nextPoint = getNextPoint(nextDirection);
        x = nextPoint.getX();
        y = nextPoint.getY();
        direction = nextDirection;
    }

    /**
     * 下一次移动的目的坐标, 用于在移动前检测是否可移动
     */
    public Point getNextPoint(Direction nextDirection) {
        // 静态绑定：只要子类对象的编译类型是Movable，就会输出0.0
        // System.out.println("speed: " + speed);
        // 动态绑定, 输出值取决于动态类型
        // System.out.println("speed " + getSpeed());
        switch (nextDirection) {
            case UP:
                // 不使用this.speed是因为父类和子类都声明了speed属性，为了避免静态绑定而使用getSpeed()
                // 更好的做法是在AbstractTank构造函数里修改speed的值，此处不这么做是为了学习静态绑定现象
                return new Point(x, y - getSpeed());
            case DOWN:
                return new Point(x, y + getSpeed());
            case LEFT:
                return new Point(x - getSpeed(), y);
            case RIGHT:
                return new Point(x + getSpeed(), y);
            default:
                throw new IllegalArgumentException(nextDirection.toString());
        }
    }
}
