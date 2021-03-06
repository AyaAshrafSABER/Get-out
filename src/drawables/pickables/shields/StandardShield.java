package drawables.pickables.shields;

import java.awt.Point;

import View.Graphics.ImagesMaps.MazeMap;
import drawables.characters.Hero;
import drawables.pickables.Shield;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import maze.Maze;

public abstract  class StandardShield implements Shield {
	protected Point position;
	protected Maze maze;
	private int shieldPoints;
	
	@Override
	public void addToHandler(Hero hero) {		
		hero.acceptShield(shieldPoints);
		destroy();
	}

	@Override
	public void setMaze(Maze maze) {this.maze = maze;}

	@Override
	public void drawOnCanvas(GraphicsContext gc,Point pt, int widthCell, int heightCell) {
		MazeMap map = MazeMap.getInstance();
		gc.drawImage(map.getBufferedImage("Shield"),
				pt.getX(), pt.getY(),
				widthCell, heightCell);
	}

	@Override
	public void takeDamage(int damage) {
		destroy();
	}

	@Override
	public void destroy() {
		maze.removeShield(this);
	}

	@Override
	public Point getPosition() {
		return this.position;
	}

	@Override
	public void setPosition(Point position) {
		this.position = position;
	}

	protected void setShieldPoints(){
		shieldPoints = getShieldPoints();
	}

	@Override
	public void addArmorPoints(Hero hero) {
		hero.acceptShield(shieldPoints);
	}

	protected abstract int getShieldPoints();

}
