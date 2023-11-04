package javase.tankbattle.ui;

import javase.tankbattle.commands.TankCommandListener;
import javase.tankbattle.constants.Constants;
import javase.tankbattle.constants.DirectionEnum;
import javase.tankbattle.constants.FactionEnum;
import javase.tankbattle.entities.Bullet;
import javase.tankbattle.entities.EnemyTank;
import javase.tankbattle.entities.HeroTank;
import javase.tankbattle.utils.TankUtils;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import java.util.function.Consumer;

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
            // 定时更新状态与重绘
            try {
                Thread.sleep(Constants.REPAINT_INTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            updateStates();
            repaint();
        }
    }


    private void initTanks() {
        hero = new HeroTank(200, 200, DirectionEnum.UP);
        enemyTanks = new Vector<>();
        for (int i = 1; i <= ENEMY_COUNT; i++) {
            enemyTanks.add(new EnemyTank(100 * i, 50, DirectionEnum.random()));
        }
    }

    /**
     * 刷新panel上所有组件状态
     */
    private void updateStates() {
        // 遍历子弹的时候刷新状态
        Consumer<Collection<Bullet>> updateStatesByBullets = bullets -> {
            Iterator<Bullet> iterator = bullets.iterator();
            while (iterator.hasNext()) {
                Bullet bullet = iterator.next();
                // 清除失效或越界bullet
                boolean shouldBeRemoved = !bullet.isAlive() || !TankUtils.willBeInsideBounds(this, bullet, bullet.getDirection());
                if (shouldBeRemoved) {
                    // 迭代期间用集合对象删除元素会抛出 ConcurrentModificationException (forEach, 增强for循环，while迭代，都会如此)
                    // bullets.remove(bullet);
                    iterator.remove();
                    continue;
                }

                // 清除有效击中坦克的bullet和tank
                FactionEnum bulletFaction = bullet.getFaction();
                if (!bulletFaction.equals(FactionEnum.HERO) && TankUtils.doBulletIntersectTank(bullet, hero)) {
                    iterator.remove();
                    hero.setAlive(false);
                } else if (!bulletFaction.equals(FactionEnum.ENEMY)) {
                    EnemyTank enemyTank = enemyTanks.stream()
                            .filter(tank -> TankUtils.doBulletIntersectTank(bullet, tank))
                            .findAny().orElse(null);
                    if (enemyTank != null) {
                        iterator.remove();
                        enemyTank.setAlive(false);
                    }
                }
            }
        };
        updateStatesByBullets.accept(hero.getFlyingBullets());
        enemyTanks.forEach(t -> updateStatesByBullets.accept(t.getFlyingBullets()));
    }

}
