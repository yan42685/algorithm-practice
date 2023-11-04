package javase.tankbattle.commands;

import javase.tankbattle.constants.DirectionEnum;
import javase.tankbattle.entities.AbstractTank;
import javase.tankbattle.entities.Movable;
import javase.tankbattle.utils.TankUtils;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * 命令模式 + 策略模式
 * 命令模式 将命令的发送者和接受者逻辑解耦
 */
@Slf4j
public class TankCommandListener extends KeyAdapter {
    private final Map<Integer, Command> map;
    private final JPanel panel;

    public TankCommandListener(JPanel panel, AbstractTank tank) {
        map = new HashMap<>();
        this.panel = panel;
        registerCommands(tank);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Command command = map.get(e.getKeyCode());
        if (canExecute(command)) {
            command.execute();
        }
    }


    // 检查是否满足执行命令的条件
    private boolean canExecute(Command command) {
        if (command == null) {
            return false;
        }

        if (command instanceof MoveCommand) {
            // TODO: 检测与其他坦克碰撞
            Movable movable = ((MoveCommand) command).getMovable();
            DirectionEnum nextDirection = ((MoveCommand) command).getNextDirection();

            log.info(movable.toString());
            log.info(nextDirection.toString());
            return TankUtils.willBeInsideBounds(panel, movable, nextDirection);
        } else {
            return true;
        }
    }

    private void registerCommands(AbstractTank tank) {
        map.put(KeyEvent.VK_W, new MoveCommand(tank, DirectionEnum.UP));
        map.put(KeyEvent.VK_S, new MoveCommand(tank, DirectionEnum.DOWN));
        map.put(KeyEvent.VK_A, new MoveCommand(tank, DirectionEnum.LEFT));
        map.put(KeyEvent.VK_D, new MoveCommand(tank, DirectionEnum.RIGHT));
        map.put(KeyEvent.VK_UP, new MoveCommand(tank, DirectionEnum.UP));
        map.put(KeyEvent.VK_DOWN, new MoveCommand(tank, DirectionEnum.DOWN));
        map.put(KeyEvent.VK_LEFT, new MoveCommand(tank, DirectionEnum.LEFT));
        map.put(KeyEvent.VK_RIGHT, new MoveCommand(tank, DirectionEnum.RIGHT));

        map.put(KeyEvent.VK_J, new ShootCommand(tank));
        map.put(KeyEvent.VK_SPACE, new ShootCommand(tank));
    }

}
