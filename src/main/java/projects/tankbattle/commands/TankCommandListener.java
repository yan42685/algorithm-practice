package projects.tankbattle.commands;

import projects.tankbattle.constants.DirectionEnum;
import projects.tankbattle.entities.AbstractTank;
import projects.tankbattle.ui.MainPanel;
import projects.tankbattle.utils.CommandManager;
import lombok.extern.slf4j.Slf4j;

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
    private final MainPanel panel;

    public TankCommandListener(MainPanel panel, AbstractTank tank) {
        map = new HashMap<>();
        this.panel = panel;
        registerCommands(tank);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Command command = map.get(e.getKeyCode());
        CommandManager.INSTANCE.checkAndExecute(command);
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

        map.put(KeyEvent.VK_J, new ShootCommand(tank, panel.getBulletQueue()));
        map.put(KeyEvent.VK_SPACE, new ShootCommand(tank, panel.getBulletQueue()));
    }

}
