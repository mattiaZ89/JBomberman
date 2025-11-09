package model.gameObjects.entities;

import java.awt.Point;
import java.awt.Rectangle;
import model.animations.JBAnimation;
import model.game.JBGameConstants;

/**
 * Rappresenta un nemico semplice
 */
public class JBLowerEnemy extends JBEnemy {

	public JBLowerEnemy(byte behaviorType, Point position, JBAnimation[] animation) {
		super(behaviorType);
		this.position = position;
		body = new Rectangle(position.x + JBGameConstants.TILE_SIZE/4, position.y + JBGameConstants.TILE_SIZE/4, JBGameConstants.TILE_SIZE/2, (JBGameConstants.TILE_SIZE/2));
		walkUp = animation[0];
		walkDown = animation[1];
		walkLeft = animation[2];
		walkRight = animation[3];
		ENERGY = 1;
	}
	
	@Override
	public void update() {
		
		behavior.execute(this);
		currentAnimation.update();
//		System.out.println("Enemy position: " + this.position);
	}
}