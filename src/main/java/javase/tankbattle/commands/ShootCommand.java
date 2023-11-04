package javase.tankbattle.commands;

import javase.tankbattle.entities.AbstractTank;
import lombok.Getter;

@Getter
public class ShootCommand implements Command {
    private AbstractTank tank;

    public ShootCommand(AbstractTank tank) {
        this.tank = tank;
    }
    @Override
    public boolean execute() {
        return tank.shoot();
    }
}
