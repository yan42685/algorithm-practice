package javase.tankbattle.entities;

import javase.tankbattle.constants.Direction;
import javase.tankbattle.constants.TankType;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
public abstract class AbstractTank {
    // 宽度为 10 + 20 + 10
    protected int width = 40;
    // 长度为 60
    protected int height = 60;
    protected double speed = 5.0;
    protected int health = 1;
    // 最小射击间隔, 单位毫秒
    protected int minShootInterval = 1000;
    // 上次射击时间
    protected long lastShootTime = 0;
    protected List<Bullet> flyingBullets;
    // 横坐标
    protected double x;
    // 纵坐标
    protected double y;

    protected Direction direction;
    protected TankType type;
    @Setter
    protected boolean isAlive = true;

    public AbstractTank(double x, double y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.flyingBullets = new LinkedList<>();
        setType();
    }

    public void move(Direction direction) {
        switch (direction) {
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed;
                break;
            case LEFT:
                x -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
            default:
                throw new IllegalArgumentException("Illegal direction: " + direction);
        }
    }

    public void shoot() {
        long currentTime = System.currentTimeMillis();
        if (lastShootTime == 0 || currentTime - lastShootTime > minShootInterval) {
            lastShootTime = currentTime;
            Bullet bullet = new Bullet(x, y, direction);
            flyingBullets.add(bullet);
            new Thread(bullet).start();
        }

        // 清理失效的子弹
        if (flyingBullets.size() > 50) {
            flyingBullets.removeIf(b -> !b.isAlive());
        }
    }

    protected abstract void setType();

}
