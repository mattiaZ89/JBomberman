package model.gameObjects.things.obstacles;

import java.awt.Graphics2D;
import java.awt.Point;

import model.animations.JBAnimation;
import model.game.JBGameConstants;

public class JBEndPad extends JBObstacle {
	
	private boolean isReached;

	public JBEndPad(Point position, JBAnimation animation) {
		super(position);
		isReached = false;
		this.animation = animation;
		animation.start();
	}
	
	@SuppressWarnings("deprecation")
	public void reached() {
		
		isReached = true;
		setChanged();
		notifyObservers();
	}
	
	public boolean isReached() {
		
		return isReached;
	}

	@Override
	public void update() {
		
		animation.update();
	}

	@Override
	public void render(Graphics2D g2d) {
		
		g2d.drawImage(animation.getSprite(), position.x, position.y, JBGameConstants.TILE_SIZE, JBGameConstants.TILE_SIZE, null);
	}
}