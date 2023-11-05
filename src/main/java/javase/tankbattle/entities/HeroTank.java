package javase.tankbattle.entities;

import javase.tankbattle.constants.DirectionEnum;
import javase.tankbattle.constants.FactionEnum;
import lombok.ToString;

@ToString
public class HeroTank extends AbstractTank {
    public HeroTank(double x, double y, DirectionEnum direction) {
        super(x, y, direction);
        health.set(2);
    }

    @Override
    protected void setFaction() {
        this.faction = FactionEnum.HERO;
    }
}
