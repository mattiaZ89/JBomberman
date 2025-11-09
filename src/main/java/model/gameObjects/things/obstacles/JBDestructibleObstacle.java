package model.gameObjects.things.obstacles;

import java.awt.Graphics2D;
import java.awt.Point;
import model.animations.JBAnimation;
import model.game.JBGameConstants;

public class JBDestructibleObstacle extends JBObstacle {
	
	private boolean isDestroyed;
	
	public JBDestructibleObstacle(Point position, JBAnimation animation) {
		
		super(position);
		this.animation = animation;
		isDestroyed = false;
		animation.start();
	}
	
	public boolean isDestroyed() {
		
		return isDestroyed;
	}
	
	public void destroy() {
		
		isDestroyed = true;
	}
	
	@Override
	public void update() {
		
		animation.update();
	}

	@Override
	public void render(Graphics2D g2d) {
		
		g2d.drawImage(animation.getSprite(), position.x, position.y, JBGameConstants.TILE_SIZE, JBGameConstants.TILE_SIZE, null);
		
		//DEBUG
//		g2d.setColor(Color.RED);
//		g2d.draw(body);
	}
}