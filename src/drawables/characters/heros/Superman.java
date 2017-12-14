package drawables.characters.heros;

import drawables.characters.commands.Command;
import drawables.pickables.Weapon;
import maze.Maze;

public class Superman extends StandardHero {
    private static final int HEALTH_POINTS = 300;
    private static final int MOTION_DELAY = 30;
    private static final int WEAPONS_LIMIT = 5;

    public Superman(){
        setHealthPoints();
        SpriteSetters();
    }

    @Override
    public boolean move(Command moveCommand, Maze maze) {
    	boolean moveResult = super.move(moveCommand, maze);
        try {
            Thread.sleep(MOTION_DELAY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return moveResult;
    }

    @Override
    protected int getHeroStartingHealth() {
        return HEALTH_POINTS;
    }

    @Override
    public void addWeapon(Weapon weapon) {
        super.addWeapon(weapon);
        if(getNumberOfWeapons() > WEAPONS_LIMIT){
            removeFirstWeapon();
        }
    }

}
