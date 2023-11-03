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
                setDirection(Direction.UP);
                setY(getY() - getSpeed());
                break;
            case DOWN:
                setDirection(Direction.DOWN);
                setY(getY() + getSpeed());
                break;
            case LEFT:
                setDirection(Direction.LEFT);
                setX(getX() - getSpeed());
                break;
            case RIGHT:
                setDirection(Direction.RIGHT);
                setX(getX() + getSpeed());
                break;
            default:
                throw new IllegalArgumentException("Illegal direction: " + direction);
        }
    }
}
