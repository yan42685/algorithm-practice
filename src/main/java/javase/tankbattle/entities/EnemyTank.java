package javase.tankbattle.entities;

import javase.tankbattle.commands.MoveCommand;
import javase.tankbattle.constants.Constants;
import javase.tankbattle.constants.DirectionEnum;
import javase.tankbattle.constants.FactionEnum;
import javase.tankbattle.utils.CommandManager;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString(callSuper = true)
public class EnemyTank extends AbstractTank implements Runnable {
    // 上次移动的方向
    private DirectionEnum previousDirection;

    public EnemyTank(double x, double y, DirectionEnum direction) {
        super(x, y, direction);
        previousDirection = direction;
    }

    @Override
    protected void setFaction() {
        this.faction = FactionEnum.ENEMY;
    }

    @Override
    public void run() {
        int interval = Constants.REPAINT_INTERVAL;
        while (isAlive) {
            // 随机移动1~3.5秒后转向另一方向
            long moveDuration = 1000 + Constants.RANDOM.nextInt(2500);
            while (moveDuration > interval) {
                CommandManager.INSTANCE.checkAndExecute(new MoveCommand(this, direction));
                moveDuration -= interval;
                try {
                    Thread.sleep(interval);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            do {
                direction = DirectionEnum.random();
            } while (direction.equals(previousDirection));
            previousDirection = direction;
        }
    }
}
