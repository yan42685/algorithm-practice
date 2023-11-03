package javase.tankbattle.commands;

import javase.tankbattle.constants.Direction;
import javase.tankbattle.entities.AbstractTank;

public class MoveCommand implements Command {
    private final AbstractTank tank;
    private final Direction direction;

    public MoveCommand(AbstractTank tank, Direction direction) {
        this.tank = tank;
        this.direction = direction;
    }

    @Override
    public boolean execute() {
        tank.move(direction);
        return true;
    }
}
