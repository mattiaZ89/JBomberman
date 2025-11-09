package model.gameObjects.things.obstacles;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import model.game.JBGameConstants;
import model.gameObjects.things.JBThing;
/**
 * Rappresenta un ostacolo generico
 */
public abstract class JBObstacle extends JBThing {
		
	public JBObstacle(Point position) {
		
		this.position = position;		
		body = new Rectangle(position.x, position.y, JBGameConstants.TILE_SIZE, JBGameConstants.TILE_SIZE);
	}
	
	public BufferedImage getImage() {
		
		return animation.getSprite();
	}
}