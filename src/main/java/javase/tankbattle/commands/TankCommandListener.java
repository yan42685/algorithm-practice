package javase.tankbattle.commands;

import javase.tankbattle.constants.Direction;
import javase.tankbattle.entities.AbstractTank;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * 命令模式 + 策略模式
 * 命令模式 将命令的发送者和接受者逻辑解耦
 */
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
            // TODO: 检测与其他坦克碰撞、检测边界
            return true;
        } else {
            return true;
        }
    }

    private void registerCommands(AbstractTank tank) {
        map.put(KeyEvent.VK_W, new MoveCommand(tank, Direction.UP));
        map.put(KeyEvent.VK_S, new MoveCommand(tank, Direction.DOWN));
        map.put(KeyEvent.VK_A, new MoveCommand(tank, Direction.LEFT));
        map.put(KeyEvent.VK_D, new MoveCommand(tank, Direction.RIGHT));
        map.put(KeyEvent.VK_UP, new MoveCommand(tank, Direction.UP));
        map.put(KeyEvent.VK_DOWN, new MoveCommand(tank, Direction.DOWN));
        map.put(KeyEvent.VK_LEFT, new MoveCommand(tank, Direction.LEFT));
        map.put(KeyEvent.VK_RIGHT, new MoveCommand(tank, Direction.RIGHT));

        map.put(KeyEvent.VK_J, new ShootCommand(tank));
        map.put(KeyEvent.VK_SPACE, new ShootCommand(tank));
    }
}
