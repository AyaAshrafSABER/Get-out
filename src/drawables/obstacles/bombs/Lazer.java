package drawables.obstacles.bombs;

import drawables.obstacles.Bomb;

public class Lazer extends StandardBomb implements Bomb {


    private final int HEALTH = 25;
    private final int RANGE = 3;
    private final int DAMAGE = 1000;

    public Lazer() {
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

}
