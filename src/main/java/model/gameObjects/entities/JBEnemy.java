package model.gameObjects.entities;

import model.ai.JBIBehaveable;
import model.ai.JBVerticalMovement;
import model.ai.JBHVMovement;
import model.ai.JBHorizontalMovement;
import model.game.JBGameConstants;

/**
 * Rappresenta un generico nemico
 */
public abstract class JBEnemy extends JBEntity {
	
	protected final JBIBehaveable behavior;
	
	public JBEnemy(byte behaviorType) {
		
		super();
		SPEED = JBGameConstants.ENEMY_SPEED;
		moveDirection = JBGameConstants.MOVE_WALK_DOWN;
		currentAnimation = walkDown;
		behavior = setBehavior(behaviorType);
		isAlive = true;
	}
	
	public boolean isAlive() {
		
		return isAlive;
	}
	
	@Override
	public void getDamage() {
		
		ENERGY--;
		isAlive = false;
	}
	
	protected JBIBehaveable setBehavior(byte behaviorType) {
		
		switch(behaviorType) {
			case 0: return new JBHorizontalMovement();
			case 1: return new JBVerticalMovement();
			case 2: return new JBHVMovement();
		}
		
		return null;
	}
}