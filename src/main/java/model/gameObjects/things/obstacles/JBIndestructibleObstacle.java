package model.gameObjects.things.obstacles;

import java.awt.Graphics2D;
import java.awt.Point;
import model.animations.JBAnimation;
import model.game.JBGameConstants;

public class JBIndestructibleObstacle extends JBObstacle {
	
	public JBIndestructibleObstacle(Point position, JBAnimation animation) {
		
		super(position);
		this.animation = animation;
	}
		
	@Override
	public void update() {
		
		return;
	}

	@Override
	public void render(Graphics2D g2d) {
		
		g2d.drawImage(animation.getSprite(), position.x, position.y, JBGameConstants.TILE_SIZE, JBGameConstants.TILE_SIZE, null);
	}
}