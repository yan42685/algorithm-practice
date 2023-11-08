package projects.tankbattle.utils;

import cn.hutool.core.lang.Assert;
import projects.tankbattle.commands.Command;
import projects.tankbattle.commands.MoveCommand;
import projects.tankbattle.commands.ShootCommand;
import projects.tankbattle.constants.DirectionEnum;
import projects.tankbattle.entities.AbstractTank;
import projects.tankbattle.entities.Movable;
import projects.tankbattle.ui.MainPanel;

/**
 * 有状态的公用方法 -> 单例模式
 * 无状态的公用方法 -> 静态方法组成的工具类
 */
public enum CommandManager {
    // 单例对象
    INSTANCE;

    // 上下文
    private MainPanel panel;
    public void setPanel(MainPanel panel) {
        this.panel = panel;
    }

    public boolean checkAndExecute(Command command) {
        if (!canExecute(command)) {
            return false;
        } else {
            return command.execute();
        }
    }

    public boolean checkAndExecuteShoot(AbstractTank tank) {
        return checkAndExecute(new ShootCommand(tank, panel.getBulletQueue()));
    }

    // 检查是否满足执行命令的条件
    private boolean canExecute(Command command) {
        Assert.notNull(panel);
        if (command == null) {
            return false;
        }

        if (command instanceof MoveCommand) {
            // 越界检测
            Movable movable = ((MoveCommand) command).getMovable();
            DirectionEnum nextDirection = ((MoveCommand) command).getNextDirection();
            if (TankUtils.willBeOutOfBounds(panel, movable, nextDirection)) {
                return false;
            }
            if (movable instanceof AbstractTank) {
                // 坦克碰撞检测
                AbstractTank tank = (AbstractTank) movable;
                boolean willIntersect = panel.getTanks().stream()
                        // 排除死亡坦克和自己
                        .filter(t -> t.isAlive() && t != tank)
                        .anyMatch(t -> tank.nextRectangle(nextDirection).intersects(t));
                if (willIntersect) {
                    return false;
                }
            }
        }
        return true;
    }

}
