package model.gameObjects.entities;

import java.awt.Point;
import java.awt.Rectangle;
import model.JBCollisionChecker;
import model.animations.JBAnimation;
import model.game.JBGameConstants;

/*
 * Rappresenta il giocatore
 */
public class JBPlayer extends JBEntity {
	
	private int numBombs = JBGameConstants.PLAYER_BOMBS;
	private int lives;
	private boolean isArmored;
	
	public JBPlayer(Point position, JBAnimation[] animations) {
		super();
		this.position = position;
		body = new Rectangle(position.x + JBGameConstants.TILE_SIZE/4, position.y + JBGameConstants.TILE_SIZE/4, JBGameConstants.TILE_SIZE/2, (JBGameConstants.TILE_SIZE/2));
		walkUp = animations[0];
		walkDown = animations[1];
		walkLeft = animations[2];
		walkRight = animations[3];
		
		SPEED = JBGameConstants.PLAYER_SPEED;
		moveDirection = JBGameConstants.MOVE_WALK_DOWN;
		currentAnimation = walkDown;
		
		ENERGY = 1;
		lives = 3;
		isAlive = true;
		isArmored = false;
	}
	
	public void switchAnimation(int a) {
		
		switch(a) {
		
			case ANIM_WALK_UP: currentAnimation = walkUp; break;
			case ANIM_WALK_DOWN: currentAnimation = walkDown; break; 
			case ANIM_WALK_LEFT: currentAnimation = walkLeft; break; 
			case ANIM_WALK_RIGHT: currentAnimation = walkRight; break; 
		}
	}
	
	@Override
	public void update() {
		
		currentAnimation.update();
	}
	
	public void moveUp() {
		
		moveDirection = JBGameConstants.MOVE_WALK_UP;
		currentAnimation = walkUp;
		if(!JBCollisionChecker.getInstance().checkWall(this)) {
			
			position.y -= 1 * SPEED;
			currentAnimation.start();
		}
	}
	
	public void moveDown() {
		
		moveDirection = JBGameConstants.MOVE_WALK_DOWN;
		currentAnimation = walkDown;
		if(!JBCollisionChecker.getInstance().checkWall(this)) {
			
			position.y += 1 * SPEED;
			currentAnimation.start();
		}
	}
	
	public void moveLeft() {
		
		moveDirection = JBGameConstants.MOVE_WALK_LEFT;
		currentAnimation = walkLeft;
		if(!JBCollisionChecker.getInstance().checkWall(this)) {
			
			position.x -= 1 * SPEED;
			currentAnimation.start();
		}
	}
	
	public void moveRight() {
		
		moveDirection = JBGameConstants.MOVE_WALK_RIGHT;
		currentAnimation = walkRight;
		if(!JBCollisionChecker.getInstance().checkWall(this)) {
			
			position.x += 1 * SPEED;
			currentAnimation.start();
		}
	}
	
	public boolean canSetBomb() {
		
		return numBombs > 0;
	}
	
	public void throwBomb() {
		
		numBombs--;
	}
	
	public void addBomb() {
		
		numBombs++;
	}
	
	public void detonateBomb() {
		
		
	}
	
	public void pushBomb() {
		
	}
	
	public void stopBomb() {
		
		
	}
	
	@Override
	public void getDamage() {
		
		ENERGY--;
		if(lives <= 0) {
			
			isAlive = false;
		}
		else {
			
			lives--;
			ENERGY++;
		}
	}
	
	public void stop() {
		
		currentAnimation.stop();
		currentAnimation.reset();
	}
	
	public boolean isArmored() {
		
		return isArmored;
	}
	
	//DEBUG
	public void printPlayer() {
		
		System.out.println("Player UPDATE");
		System.out.println("Position X: " + position.x);
		System.out.println("Position Y: " + position.y);
		System.out.println("Current Animation: " + currentAnimation.getName());
		
	}
}