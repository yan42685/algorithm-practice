package javase.tankbattle.ui;

import javase.tankbattle.commands.TankCommandListener;
import javase.tankbattle.constants.Constants;
import javase.tankbattle.constants.Direction;
import javase.tankbattle.constants.TankType;
import javase.tankbattle.entities.AbstractTank;
import javase.tankbattle.entities.EnemyTank;
import javase.tankbattle.entities.HeroTank;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

@Getter
public class MainPanel extends JPanel implements Runnable {
    private final HeroTank hero;
    // 这个容器的内容会被多个线程修改
    private final Vector<EnemyTank> enemyTanks;

    public MainPanel() {
        hero = new HeroTank(200, 200, Direction.UP);
        enemyTanks = new Vector<>();
        addKeyListener(new TankCommandListener(this, hero));

        // 可聚焦, 聚焦这个panel之后才能监听键盘输入
        setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // 画背景
        PaintBrush.drawBackground(g, getSize());
        // 画坦克
        PaintBrush.drawTank(g, hero);
        enemyTanks.forEach(tank -> PaintBrush.drawTank(g, tank));

    }

    @Override
    public void run() {
        while (true) {
            // 定时重绘
            try {
                Thread.sleep(Constants.REPAINT_INTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }
    }


}
