package projects.tankbattle.core;

import projects.tankbattle.commands.Command;
import projects.tankbattle.commands.MoveCommand;
import projects.tankbattle.commands.ShootCommand;
import projects.tankbattle.constants.DirectionEnum;
import projects.tankbattle.entities.AbstractTank;
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
public class HeroCommandListener extends KeyAdapter {
    private final Map<Integer, Command> map;
    private final GameManager context;

    public HeroCommandListener(GameManager context, AbstractTank tank) {
        map = new HashMap<>();
        this.context = context;
        registerCommands(tank);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Command command = map.get(e.getKeyCode());
        CommandExecutor.INSTANCE.checkAndExecute(command);
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

        map.put(KeyEvent.VK_J, new ShootCommand(tank, context.getBulletQueue()));
        map.put(KeyEvent.VK_SPACE, new ShootCommand(tank, context.getBulletQueue()));
    }

}