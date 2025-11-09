package model.gameObjects.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import model.animations.JBAnimation;
import model.game.JBGameConstants;
import model.gameObjects.JBGameObject;

/**
 * Rappresenta una generica entità, come personaggio o nemico
 */
public abstract class JBEntity extends JBGameObject {
	
	protected int SPEED;
	protected int ENERGY;
	protected boolean isAlive;
	
	public static final byte ANIM_WALK_UP = 0;
	public static final byte ANIM_WALK_DOWN = 1;
	public static final byte ANIM_WALK_LEFT = 2;
	public static final byte ANIM_WALK_RIGHT = 3;
	
	protected JBAnimation walkUp;
	protected JBAnimation walkDown;
	protected JBAnimation walkLeft;
	protected JBAnimation walkRight;
	
	protected byte moveDirection;
	
	protected JBAnimation currentAnimation;
	
	
	public JBEntity() {
		super();
	}
	
	public void resetBody() {
		
		body = new Rectangle(position.x + JBGameConstants.TILE_SIZE/4, position.y + JBGameConstants.TILE_SIZE/4, JBGameConstants.TILE_SIZE/2, (JBGameConstants.TILE_SIZE/2));
	}
	
	public void setCurrentAnimation(JBAnimation animation) {
		
		this.currentAnimation = animation;
	}
	
	public JBAnimation getCurrentAnimation() {
		
		return currentAnimation;
	}
	
	public JBAnimation getAnimation(byte animation) {
		
		switch(animation) {
			case JBGameConstants.MOVE_WALK_UP: return walkUp;
			case JBGameConstants.MOVE_WALK_DOWN: return walkDown;
			case JBGameConstants.MOVE_WALK_LEFT: return walkLeft;
			case JBGameConstants.MOVE_WALK_RIGHT: return walkRight;
		}
		return null;
	}
	
	/**
	 * Fornisce la direzione di movimento corrente
	 * @return
	 */
	public byte getMoveDirection() {
		
		return moveDirection;
	}
	
	public void setMoveDirection(byte moveDirection) {
		this.moveDirection = moveDirection;
	}
	
	public int getSpeed() {
		
		return SPEED;
	}
	
	/**
	 * Riceve danno
	 */
	public abstract void getDamage();
	
	@Override
	public void render(Graphics2D g2d) {
		
		g2d.drawImage(this.currentAnimation.getSprite(), this.position.x, this.position.y, 48, 48, null);
		
		//DEBUG
		g2d.setColor(Color.YELLOW);
		g2d.draw(body);
	}
}