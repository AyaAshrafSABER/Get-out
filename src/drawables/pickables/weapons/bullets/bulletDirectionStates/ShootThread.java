package drawables.pickables.weapons.bullets.bulletDirectionStates;

import drawables.Drawable;
import drawables.characters.MovingObject;
import drawables.pickables.weapons.bullets.Bullet;
import drawables.pickables.weapons.bullets.BulletShootingProperties;
import drawables.roads.Road;
import maze.Maze;
import org.apache.log4j.Logger;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Mahmoud on 12/13/2017.
 */
public class ShootThread extends Thread {

    private Maze maze;
    private ArrayList<BulletShootingProperties> shootingProperties;
    private Logger logger = Logger.getLogger(ShootThread.class);


    public ShootThread() {
        this.shootingProperties = new ArrayList<>();
    }

    public void setMaze(Maze maze) {
        this.maze = maze;
    }

    public void addBullet(BulletShootingProperties properties) {
        this.shootingProperties.add(properties);
    }

    @Override
    public void run() {
        while (this.shootingProperties.size() != 0) {

            for (int i = 0; i < this.shootingProperties.size(); i++) {
                boolean destroyed = false;
                BulletShootingProperties properties = this.shootingProperties.get(i);
                properties.increment();

                Point newPosition = properties.getCurrentPosition();

                Drawable entityInWay = this.maze.getItemInPosition(newPosition);

                if (!(entityInWay instanceof Road)) {
                    entityInWay.takeDamage(properties.getBullet().getDamage());
                    this.shootingProperties.remove(properties);
                    i--;
                    destroyed = true;
                }

                properties.getWeapon().notifyBulletMotionObserver(properties.getBullet(),
                        properties.getPastPosition(), properties.getCurrentPosition(), destroyed);
            }

            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        logger.info("Bullet Thread terminating");
    }
}


