package javase.tankbattle.entities;

import javase.tankbattle.constants.DirectionEnum;
import javase.tankbattle.constants.FactionEnum;
import lombok.ToString;

@ToString(callSuper = true)
public class EnemyTank extends AbstractTank {
    public EnemyTank(double x, double y, DirectionEnum direction) {
        super(x, y, direction);
    }

    @Override
    protected void setFaction() {
        this.faction = FactionEnum.ENEMY;
    }
}
