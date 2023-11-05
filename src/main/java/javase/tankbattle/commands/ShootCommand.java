package javase.tankbattle.commands;

import javase.tankbattle.entities.AbstractTank;
import javase.tankbattle.entities.Bullet;
import lombok.Getter;
import lombok.NonNull;

import java.util.Optional;
import java.util.concurrent.BlockingQueue;

@Getter
public class ShootCommand implements Command {
    private final AbstractTank tank;
    private final BlockingQueue<Bullet> bulletQueue;

    public ShootCommand(AbstractTank tank, BlockingQueue<Bullet> bulletQueue) {
        this.tank = tank;
        this.bulletQueue = bulletQueue;
    }

    @Override
    public boolean execute() {
        Bullet bullet = tank.shoot();
        if (bullet != null){
            System.out.println(bullet);
            bulletQueue.offer(bullet);
            System.out.println(bullet);
            return true;
        } else {
            return false;
        }
    }
}
