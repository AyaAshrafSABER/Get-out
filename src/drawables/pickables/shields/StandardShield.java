package drawables.pickables.shields;

import java.awt.Point;

import drawables.characters.Hero;
import drawables.pickables.Shield;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public abstract  class StandardShield implements Shield {
	protected Point position; 
	
	@Override
	public void addToHandler(Hero hero) {		
		protectedFrom(hero);
		
	}

	@Override
	public void drawOnCanvas(GraphicsContext gc, Point pt, int width, int height) {
		//Gui
		
	}

	@Override
	public Point getPosition() {
		return this.position;
	}

	@Override
	public void setPosition(Point position) {
		this.position = position;
	}

}
