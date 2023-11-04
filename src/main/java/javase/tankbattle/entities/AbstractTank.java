package javase.tankbattle.entities;

import javase.tankbattle.constants.Direction;
import javase.tankbattle.constants.TankType;
import lombok.Getter;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

@Getter
public abstract class AbstractTank extends Movable {
    // 重新声明一个于父类同名的属性 可能出现静态绑定问题
    protected double step = 5.0;
    protected int health = 1;
    // 最小射击间隔, 单位毫秒
    protected int minShootInterval = 500;
    // 上次射击时间
    protected long lastShootTime = 0;
    // 容器中的元素会被多个线程访问
    protected List<Bullet> flyingBullets;
    protected TankType type;

    public AbstractTank(double x, double y, Direction direction) {
        super(x, y, direction);
        // 向上状态的宽与高
        // 宽度为 10 + 20 + 10
        width = 40;
        // 高度为 60
        height = 60;
        this.flyingBullets = new LinkedList<>();
        setType();
    }


    public boolean shoot() {
        long currentTime = System.currentTimeMillis();
        // 限制射击频率
        if (currentTime - lastShootTime < minShootInterval) {
            return false;
        }

        lastShootTime = currentTime;
        Point shootPoint = getShootPoint();
        Bullet bullet = new Bullet(shootPoint.getX(), shootPoint.getY(), direction);
        flyingBullets.add(bullet);
        new Thread(bullet).start();

        return true;
    }


    // 射击起点
    private Point getShootPoint() {
        switch (direction) {
            case UP:
                return new Point(x + 20, y);
            case DOWN:
                return new Point(x + 20, y + 60);
            case LEFT:
                return new Point(x, y + 20);
            case RIGHT:
                return new Point(x + 60, y + 20);
            default:
                throw new IllegalArgumentException(direction.toString());
        }
    }

    protected abstract void setType();

}
