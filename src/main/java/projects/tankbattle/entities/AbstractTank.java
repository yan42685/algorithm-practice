package projects.tankbattle.entities;

import projects.tankbattle.constants.DirectionEnum;
import projects.tankbattle.constants.FactionEnum;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;
import utils.AtomicUtils;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@ToString
public abstract class AbstractTank extends Movable {
    // 重新声明一个于父类同名的属性 可能出现静态绑定问题
    protected AtomicInteger health = new AtomicInteger(1);
    // 最小射击间隔, 单位毫秒
    protected int minShootInterval = 500;
    // 上次射击时间
    protected long lastShootTime = 0;

    public AbstractTank(double x, double y, DirectionEnum direction, double step, FactionEnum faction) {
        // 向上状态的宽与高
        // 宽度为 10 + 20 + 10
        // 高度为 60
        super(x, y, 40, 60, direction, step, faction);
    }


    public @Nullable Bullet shoot() {
        long currentTime = System.currentTimeMillis();
        // 限制射击频率
        if (currentTime - lastShootTime < minShootInterval) {
            return null;
        }

        lastShootTime = currentTime;
        Point shootPoint = getShootPoint();

        return new Bullet(shootPoint.getX(), shootPoint.getY(), direction, faction);
    }

    /**
     * 减少生命，线程安全, 实际上只在主线程MainPanel中减少生命，不会被多个线程修改，这里用作学习更新原子数值
     */
    public void decreaseHealth(int damage) {
        int preValue;
        int newValue;
        do {
            preValue = health.get();
            newValue = preValue - damage;
            // 如果health.get() != preValue，则取消set操作并返回false，说明数据被其他线程修改了
        } while (!health.compareAndSet(preValue, newValue));

        if (health.get() <= 0) {
            setAlive(false);
        }
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


}
