package projects.tankbattle.entities;

import projects.tankbattle.commands.MoveCommand;
import projects.tankbattle.constants.Constants;
import projects.tankbattle.constants.DirectionEnum;
import projects.tankbattle.constants.FactionEnum;
import projects.tankbattle.utils.CommandExecutor;
import projects.tankbattle.utils.TankUtils;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString(callSuper = true)
public class EnemyTank extends AbstractTank implements Runnable {
    private static final int MIN_MOVE_DURATION = 1200;
    private static final int MAX_MOVE_DURATION = 3500;

    public EnemyTank(double x, double y, DirectionEnum direction) {
        super(x, y, direction, 2.2, FactionEnum.ENEMY);
        minShootInterval = 2200;
    }

    @Override
    public void run() {
        int interval = Constants.REPAINT_INTERVAL;
        int originalMinShootInterval = minShootInterval;
        while (isAlive) {
            // 随机移动一段时间后转向另一方向
            int moveDuration = TankUtils.randomInt(MIN_MOVE_DURATION, MAX_MOVE_DURATION);
            while (moveDuration > interval) {
                boolean moveSuccessfully = CommandExecutor.INSTANCE.checkAndExecute(new MoveCommand(this, direction));
                if (moveSuccessfully) {
                    moveDuration -= interval;
                    // 随机发射间隔，但有一个最小值
                    minShootInterval = TankUtils.randomInt(originalMinShootInterval, 2 * originalMinShootInterval);
                    // 射击
                    CommandExecutor.INSTANCE.checkAndExecuteShoot(this);
                    try {
                        Thread.sleep(interval);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    // 移动失败则改变方向并重置移动时间
                    changeDirection();
                    moveDuration = TankUtils.randomInt(MIN_MOVE_DURATION, MAX_MOVE_DURATION);
                }
            }
            // 移动超过一定时间改变方向
            changeDirection();

        }
    }

    private void changeDirection() {
        DirectionEnum nextDirection;
        do {
            nextDirection = DirectionEnum.random();
        } while (nextDirection.equals(direction));
        direction = nextDirection;
    }


}
