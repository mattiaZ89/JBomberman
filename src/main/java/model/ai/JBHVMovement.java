package model.ai;

import java.awt.Point;

import model.JBCollisionChecker;
import model.game.JBGameConstants;
import model.gameObjects.entities.JBEnemy;

public class JBHVMovement extends JBMovement {
		
	private boolean isUpAndDown;
	private int changeDirectionCounter;
	private final static int MAX_CHANGE_DIR_COUNTER = JBGameConstants.MAX_CHANGE_DIR_COUNTER;
	
	private boolean collisionOn = true;
	
	public JBHVMovement() {
		
		moveUP = true;
		moveDown = false;
		moveLeft = false;
		moveRight = false;
		isUpAndDown = true;
		changeDirectionCounter = 0;
	}
	
	@Override
	public void execute(JBEnemy enemy) {
		
		if(moveUP && isUpAndDown) {
			
			enemy.setMoveDirection(JBGameConstants.MOVE_WALK_UP);
			enemy.setCurrentAnimation(enemy.getAnimation(JBGameConstants.MOVE_WALK_UP));
			collisionOn = JBCollisionChecker.getInstance().checkWall(enemy) || JBCollisionChecker.getInstance().checkBomb(enemy)|| JBCollisionChecker.getInstance().checkPlayer(enemy);
			if(collisionOn) {
				moveUP = false;
				moveDown = true;
			}
		}
		else if(moveDown && isUpAndDown) {
			enemy.setMoveDirection(JBGameConstants.MOVE_WALK_DOWN);
			enemy.setCurrentAnimation(enemy.getAnimation(JBGameConstants.MOVE_WALK_DOWN));
			collisionOn = JBCollisionChecker.getInstance().checkWall(enemy) || JBCollisionChecker.getInstance().checkBomb(enemy)|| JBCollisionChecker.getInstance().checkPlayer(enemy);
			if(collisionOn) {
				moveDown = false;
				moveUP = true;
			}
		}
		else if(moveLeft && !isUpAndDown) {
			
			enemy.setMoveDirection(JBGameConstants.MOVE_WALK_LEFT);
			enemy.setCurrentAnimation(enemy.getAnimation(JBGameConstants.MOVE_WALK_LEFT));
			collisionOn = JBCollisionChecker.getInstance().checkWall(enemy) || JBCollisionChecker.getInstance().checkBomb(enemy)|| JBCollisionChecker.getInstance().checkPlayer(enemy);
			if(collisionOn) {
				moveLeft = false;
				moveRight = true;
			}
		}
		else if(moveRight && !isUpAndDown) {
			
			enemy.setMoveDirection(JBGameConstants.MOVE_WALK_RIGHT);
			enemy.setCurrentAnimation(enemy.getAnimation(JBGameConstants.MOVE_WALK_RIGHT));
			collisionOn = JBCollisionChecker.getInstance().checkWall(enemy) || JBCollisionChecker.getInstance().checkBomb(enemy)|| JBCollisionChecker.getInstance().checkPlayer(enemy);
			if(collisionOn) {
				moveRight = false;
				moveLeft = true;
			}
		}
		
		if(!collisionOn) {
			
			var currentPosition = enemy.getPosition();
			var speed = enemy.getSpeed();

			switch(enemy.getMoveDirection()) {
			
				case JBGameConstants.MOVE_WALK_UP: enemy.setPosition(new Point(currentPosition.x, currentPosition.y -= 1 * speed)); break;
				case JBGameConstants.MOVE_WALK_DOWN: enemy.setPosition(new Point(currentPosition.x, currentPosition.y += 1 * speed)); break;
				case JBGameConstants.MOVE_WALK_LEFT: enemy.setPosition(new Point(currentPosition.x -= 1 * speed, currentPosition.y)); break;
				case JBGameConstants.MOVE_WALK_RIGHT: enemy.setPosition(new Point(currentPosition.x += 1 * speed, currentPosition.y)); break;
			}
			
			enemy.getCurrentAnimation().start();
		}
		else {
			
			changeDirectionCounter++;
		}
		
		if(changeDirectionCounter > MAX_CHANGE_DIR_COUNTER) {
			
			if(isUpAndDown) {
				
				changeDirectionCounter = 0;
				isUpAndDown = false;
				moveLeft = true;
			}
			else {
				
				changeDirectionCounter = 0;
				isUpAndDown = true;
				moveUP = true;
			}
		}
	}
}