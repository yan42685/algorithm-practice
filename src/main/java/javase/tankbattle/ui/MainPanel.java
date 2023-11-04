package javase.tankbattle.ui;

import javase.tankbattle.commands.TankCommandListener;
import javase.tankbattle.constants.Constants;
import javase.tankbattle.constants.Direction;
import javase.tankbattle.entities.Bullet;
import javase.tankbattle.entities.EnemyTank;
import javase.tankbattle.entities.HeroTank;
import javase.tankbattle.utils.TankUtils;
import lombok.Getter;
import utils.Lambda;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;
import java.util.Vector;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Getter
public class MainPanel extends JPanel implements Runnable {
    private static final int ENEMY_COUNT = 4;
    private HeroTank hero;
    // 这个容器的内容会被多个线程修改
    private Vector<EnemyTank> enemyTanks;


    public MainPanel() {
        initTanks();
        addKeyListener(new TankCommandListener(this, hero));

        // 可聚焦, 聚焦这个panel之后才能监听键盘输入
        setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics brush) {
        super.paintComponent(brush);
        // 画背景
        PaintBrush.drawBackground(brush, getSize());
        // 画坦克
        PaintBrush.drawTank(brush, hero);
        enemyTanks.forEach(tank -> PaintBrush.drawTank(brush, tank));
        // 画子弹
        PaintBrush.drawBullets(brush, hero.getFlyingBullets());
        enemyTanks.forEach(tank ->
                PaintBrush.drawBullets(brush, tank.getFlyingBullets()));

    }

    @Override
    public void run() {
        while (true) {
            // 定时刷新状态与重绘
            try {
                Thread.sleep(Constants.REPAINT_INTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            refreshComponentsStates();
            repaint();
        }
    }


    private void initTanks() {
        hero = new HeroTank(200, 200, Direction.UP);
        enemyTanks = new Vector<>();
        for (int i = 1; i <= ENEMY_COUNT; i++) {
            enemyTanks.add(new EnemyTank(100 * i, 50, Direction.random()));
        }
    }

    /**
     * 刷新panel上所有组件状态
     */
    private void refreshComponentsStates() {
        // 刷新子弹状态
        Consumer<Collection<Bullet>> refreshFlyingBullets = bullets -> {
            bullets.removeIf(bullet -> !bullet.isAlive() || !TankUtils.willBeInsideBounds(this, bullet, bullet.getDirection()));
            // 下面两种代码会抛出 ConcurrentModificationException, 因为在迭代期间删除了集合元素；如果是显式调用iterator().next() 则不会抛异常
//            bullets.forEach(bullet -> {
//                boolean shouldBeRemoved = !bullet.isAlive() || !TankUtils.willBeInsideBounds(this, bullet, bullet.getDirection());
//                if (shouldBeRemoved) {
//                    bullets.remove(bullet);
//                }
//            });
//
//            for (Bullet bullet : bullets) {
//                boolean shouldBeRemoved = !bullet.isAlive() || !TankUtils.willBeInsideBounds(this, bullet, bullet.getDirection());
//                if (shouldBeRemoved) {
//                    bullets.remove(bullet);
//                }
//            }
        };
        refreshFlyingBullets.accept(hero.getFlyingBullets());
        enemyTanks.forEach(t -> refreshFlyingBullets.accept(t.getFlyingBullets()));
    }

}
