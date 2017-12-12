package drawables.obstacles.bombs;

import drawables.characters.Hero;
import drawables.obstacles.Bomb;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import maze.Maze;

import java.awt.*;

public class NormalBomb extends StandardBomb implements Bomb {

    private final int HEALTH = 20;
    private final int RANGE = 1;
    private final int DAMAGE = 20;



    public NormalBomb() {
        setBombRange();
        setDamage();
        setHealthPoints();
    }

    @Override
    protected int getBombOriginalDamage() {
        return DAMAGE;
    }

    @Override
    protected int getBombRange() {
        return RANGE;
    }

    @Override
    protected int getHealthPoints() {
        return HEALTH;
    }

    @Override
    public void animateOnExplosion() {
    //TODO
    }

    @Override
    public void drawOnCanvas(GraphicsContext gc, Point pt, int width, int height) {
        //TODO
    }
}