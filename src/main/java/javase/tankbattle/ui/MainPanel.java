package javase.tankbattle.ui;

import javase.tankbattle.commands.TankCommandListener;
import javase.tankbattle.constants.Constants;
import javase.tankbattle.constants.DirectionEnum;
import javase.tankbattle.constants.FactionEnum;
import javase.tankbattle.entities.AbstractTank;
import javase.tankbattle.entities.Bullet;
import javase.tankbattle.entities.EnemyTank;
import javase.tankbattle.entities.HeroTank;
import javase.tankbattle.utils.TankUtils;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;

@Getter
public class MainPanel extends JPanel implements Runnable {
    private static final int ENEMY_COUNT = 4;
    private final List<Bullet> bullets;
    // 同步队列, 接收多个坦克线程发射的子弹，并在渲染前drainTo(bulletList)
    // 如果不用同步队列、只用Vector<bullet>可能出现线程饥饿的情况
    private final BlockingQueue<Bullet> bulletQueue;
    // 这个容器的内容会被多个线程修改
    private final Vector<AbstractTank> tanks;


    public MainPanel() {
        bullets = new LinkedList<>();
        bulletQueue = new LinkedBlockingQueue<>();

        tanks = new Vector<>();
        // 添加敌人坦克
        for (int i = 1; i <= ENEMY_COUNT; i++) {
            tanks.add(new EnemyTank(100 * i, 50, DirectionEnum.random()));
        }
        // 添加主角坦克并监听键盘操作
        HeroTank heroTank = new HeroTank(200, 200, DirectionEnum.UP);
        addKeyListener(new TankCommandListener(this, heroTank));
        tanks.add(heroTank);


        // 可聚焦, 聚焦这个panel之后才能监听键盘输入
        setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics brush) {
        super.paintComponent(brush);
        // 画背景
        PaintBrush.drawBackground(brush, getSize());
        // 画坦克
        PaintBrush.drawTanks(brush, tanks);
        // 画子弹
        PaintBrush.drawBullets(brush, bullets);

    }

    @Override
    public void run() {
        while (true) {
            // 定时更新状态与重绘
            updateStates();
            repaint();
            try {
                Thread.sleep(Constants.REPAINT_INTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 刷新panel上所有组件状态
     */
    private void updateStates() {
        // 发射的子弹添加到MainPanel状态里
        bulletQueue.drainTo(bullets);
        // 遍历子弹的时候刷新状态
        Iterator<Bullet> bulletIterator = bullets.iterator();
        while (bulletIterator.hasNext()) {
            Bullet bullet = bulletIterator.next();
            // 移除失效或越界bullet
            boolean shouldBeRemoved = !bullet.isAlive() || TankUtils.willBeOutOfBounds(this, bullet, bullet.getDirection());
            if (shouldBeRemoved) {
                // 让子弹线程停止while循环
                bullet.setAlive(false);
                // 迭代期间用集合对象删除元素会抛出 ConcurrentModificationException (forEach, 增强for循环，while迭代，都会如此)
                // bullets.remove(bullet);
                bulletIterator.remove();
                continue;
            }

            // 不移除坦克而仅仅标记 isAlive = false 是为了后续可能支持复活等操作
            tanks.stream()
                    .filter(AbstractTank::isAlive)
                    // 不会击毁同阵营坦克
                    .filter(tank -> !bullet.getFaction().equals(tank.getFaction()))
                    .filter(tank -> TankUtils.doBulletIntersectTank(bullet, tank))
                    .forEach(tank -> {
                        tank.setAlive(false);
                        bullet.setAlive(false);
                        bulletIterator.remove();
                    });
        }
    }
}
