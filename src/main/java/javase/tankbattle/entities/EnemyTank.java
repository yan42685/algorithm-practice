package javase.tankbattle.entities;

import javase.tankbattle.commands.MoveCommand;
import javase.tankbattle.constants.Constants;
import javase.tankbattle.constants.DirectionEnum;
import javase.tankbattle.constants.FactionEnum;
import javase.tankbattle.utils.CommandManager;
import javase.tankbattle.utils.TankUtils;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString(callSuper = true)
public class EnemyTank extends AbstractTank implements Runnable {
    private static final int MIN_MOVE_DURATION = 1200;
    private static final int MAX_MOVE_DURATION = 3500;

    public EnemyTank(double x, double y, DirectionEnum direction) {
        super(x, y, direction);
        step = 2.2;
    }

    @Override
    protected void setFaction() {
        this.faction = FactionEnum.ENEMY;
    }

    @Override
    public void run() {
        int interval = Constants.REPAINT_INTERVAL;
        while (isAlive) {
            // 随机移动一段时间后转向另一方向
            int moveDuration = TankUtils.randomInt(MIN_MOVE_DURATION, MAX_MOVE_DURATION);
            while (moveDuration > interval) {
                boolean moveSuccessfully = CommandManager.INSTANCE.checkAndExecute(new MoveCommand(this, direction));
                if (moveSuccessfully) {
                    moveDuration -= interval;
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
        DirectionEnum previousDirection = direction;
        do {
            direction = DirectionEnum.random();
        } while (direction.equals(previousDirection));
    }


}
