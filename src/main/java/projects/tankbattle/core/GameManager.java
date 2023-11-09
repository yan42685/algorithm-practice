package projects.tankbattle.core;

import lombok.Getter;
import lombok.Setter;
import projects.tankbattle.constants.Constants;
import projects.tankbattle.constants.DirectionEnum;
import projects.tankbattle.constants.FactionEnum;
import projects.tankbattle.entities.AbstractTank;
import projects.tankbattle.entities.Bullet;
import projects.tankbattle.entities.EnemyTank;
import projects.tankbattle.entities.HeroTank;
import projects.tankbattle.ui.Frame;
import projects.tankbattle.ui.MainPanel;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Getter
public class GameManager {

    private static final int ENEMY_COUNT = 4;
    private MainPanel panel;

    @Setter
    private List<Bullet> bullets;
    // 同步队列, 接收多个坦克线程发射的子弹，并在渲染前drainTo(bulletList)
    // 如果不用同步队列、只用Vector<bullet>可能出现遍历时添加子弹抛出ConcurrentModificationException
    @Setter
    private BlockingQueue<Bullet> bulletQueue;
    @Setter
    private List<AbstractTank> tanks;

    public GameManager() {
        CommandExecutor.INSTANCE.setContext(this);
        GameRecorder.INSTANCE.setContext(this);
        beforeStart();
    }

    public void startGame() {
        // 启动画面
        Frame frame = new Frame();
        panel = frame.getMainPanel();
        // 可聚焦, 聚焦这个panel之后才能监听键盘输入
        panel.setFocusable(true);
        panel.setGameManager(this);

        // 定时更新状态与重绘
        Runnable task = () -> {
            while (true) {
                updateStates();
                panel.repaint();
                try {
                    Thread.sleep(Constants.REPAINT_INTERVAL);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        // 绘图线程不必用到线程池
        new Thread(task).start();

        // 初始化坦克与命令监听器
        for (AbstractTank tank : tanks) {
            if (tank instanceof HeroTank) {
                panel.addKeyListener(new HeroCommandListener(this, tank));
            } else if (tank instanceof EnemyTank) {
                ThreadExecutor.execute((EnemyTank) tank);
            }
        }
    }


    /**
     * 运行前建立必要的状态
     */
    private void beforeStart() {
        Runnable initStates = () -> {
            bulletQueue = new LinkedBlockingQueue<>();
            bullets = new LinkedList<>();
            tanks = new LinkedList<>();
            // 添加敌人坦克
            for (int i = 1; i <= ENEMY_COUNT; i++) {
                EnemyTank enemyTank = new EnemyTank(200 * i, 80 * i, DirectionEnum.random());
                tanks.add(enemyTank);
            }
            // 添加主角坦克
            HeroTank heroTank = new HeroTank(200, 200, DirectionEnum.UP);
            tanks.add(heroTank);
        };

        Scanner scanner = new Scanner(System.in);
        // 有存档则让用户选择是否读取存档
        if (GameRecorder.INSTANCE.hasSavedData()) {
            while (true) {
                System.out.println("是否恢复存档？ (y/n)");
                String command = scanner.next();
                if ("y".equalsIgnoreCase(command)) {
                    GameRecorder.INSTANCE.recoverData();
                    break;
                } else if ("n".equalsIgnoreCase(command)) {
                    initStates.run();
                    break;
                }
            }
        } else {
            initStates.run();
        }
    }

    /**
     * 刷新所有组件状态
     */
    private void updateStates() {
        // 发射的子弹添加到MainPanel状态里
        bulletQueue.drainTo(bullets);
        // 遍历子弹的时候刷新状态
        Iterator<Bullet> bulletIterator = bullets.iterator();
        while (bulletIterator.hasNext()) {
            Bullet bullet = bulletIterator.next();
            // 移除失效或越界bullet
            boolean shouldBeRemoved = !bullet.isAlive() || TankUtils.willBeOutOfBounds(panel.battleArea, bullet, bullet.getDirection());
            if (shouldBeRemoved) {
                // 让子弹线程停止while循环
                bullet.setAlive(false);
                // 迭代期间用集合对象删除元素会抛出 ConcurrentModificationException (forEach, 增强for循环，while迭代，都会如此)
                // bullets.remove(bullet);
                bulletIterator.remove();
                continue;
            }

            // 不移除坦克而仅仅减少生命 是为了后续可能支持复活等操作
            tanks.stream()
                    .filter(AbstractTank::isAlive)
                    // 不会击毁同阵营坦克
                    .filter(tank -> !bullet.getFaction().equals(tank.getFaction()))
                    // 找到相交坦克
                    .filter(bullet::intersects)
                    .forEach(tank -> {
                        tank.decreaseHealth(bullet.getDamage());
                        if (!tank.isAlive() && tank.getFaction().equals(FactionEnum.ENEMY)) {
                            GameRecorder.INSTANCE.increaseDeadEnemiesCount(1);
                        }
                        bullet.setAlive(false);
                        bulletIterator.remove();
                    });
        }
    }
}
