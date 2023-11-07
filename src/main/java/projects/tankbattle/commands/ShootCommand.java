package projects.tankbattle.commands;

import projects.tankbattle.constants.Constants;
import projects.tankbattle.utils.ThreadManager;
import projects.tankbattle.entities.AbstractTank;
import projects.tankbattle.entities.Bullet;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;

@Getter
@Slf4j
public class ShootCommand implements Command {
    private final AbstractTank tank;
    private final BlockingQueue<Bullet> bulletQueue;

    public ShootCommand(AbstractTank tank, BlockingQueue<Bullet> bulletQueue) {
        this.tank = tank;
        this.bulletQueue = bulletQueue;
    }

    @Override
    public boolean execute() {
        if (!tank.isAlive()) {
            return false;
        }
        Bullet bullet = tank.shoot();
        if (bullet == null) {
            return false;
        }

        Runnable task = () -> {
            while (bullet.isAlive()) {
                double remainingDistance = bullet.getRemainingDistance();
                double step = bullet.getStep();
                if (remainingDistance >= step) {
                    try {
                        Thread.sleep(Constants.REPAINT_INTERVAL);
                        bullet.move(bullet.getDirection());
                        bullet.setRemainingDistance(remainingDistance - step);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    bullet.setAlive(false);
                    break;
                }
            }
        };
        // 提交给线程池执行
        ThreadManager.submit(task);

        boolean shootSuccessfully = bulletQueue.offer(bullet);
        if (!shootSuccessfully) {
            log.warn(tank + "发射失败 [线程饥饿]");
        }
        return shootSuccessfully;
    }

}
