package javase.tankbattle.entities;

import javase.tankbattle.constants.Direction;
import lombok.Data;
import lombok.Getter;

@Data
public abstract class Movable {
    protected double x;
    protected double y;
    protected Direction direction;
    protected double speed;

    public Movable(double x, double y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void move(Direction direction) {
        // 静态绑定：只要子类对象的编译类型是Movable，就会输出0.0
        // System.out.println("speed: " + speed);
        // 动态绑定, 输出值取决于动态类型
        // System.out.println("speed " + getSpeed());
        switch (direction) {
            case UP:
                this.direction = Direction.UP;
                // 不使用this.speed是因为父类和子类都声明了speed属性，为了避免静态绑定而使用getSpeed()
                // 更好的做法是将getSpeed声明为抽象方法，并移除父类的speed属性，此处不这么做是为了记录静态绑定现象
                y -= getSpeed();
                break;
            case DOWN:
                this.direction = Direction.DOWN;
                y += getSpeed();
                break;
            case LEFT:
                this.direction = Direction.LEFT;
                x -= getSpeed();
                break;
            case RIGHT:
                this.direction = Direction.RIGHT;
                x += getSpeed();
                break;
            default:
                throw new IllegalArgumentException("Illegal direction: " + direction);
        }
    }
}
