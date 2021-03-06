package drawables.characters;


import View.Graphics.Sprite.MySprite;
import drawables.Drawable;
import drawables.characters.commands.Command;
import drawables.characters.heros.states.DirectionState;
import drawables.pickables.weapons.bullets.Bullet;
import javafx.scene.canvas.GraphicsContext;
import maze.Maze;

import java.awt.*;

public interface MovingObject extends Drawable {

    public boolean move(Command moveCommand, Maze maze);

    public int getHealthPoints();

    public void setDirectionState(DirectionState state);

    public DirectionState getDirectionState();

    public void takeBullet(Bullet bullet);

    public void receiveExplosionDamage(int damage);

    public MySprite getDownSprite();

    public MySprite getUpSprite();

    public MySprite getRightSprite();

    public MySprite getLeftSprite();

    public Point getOldPosition();
}
