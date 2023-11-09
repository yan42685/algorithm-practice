package projects.tankbattle.commands;

import projects.tankbattle.constants.Constants;
import projects.tankbattle.core.ThreadExecutor;
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

        // 沿着原来的方向移动直到remainingDistance < step，然后设置为死亡状态
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
        ThreadExecutor.execute(task);

        return bulletQueue.offer(bullet);
    }

}
