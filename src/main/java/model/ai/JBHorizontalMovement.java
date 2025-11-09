package model.ai;

import java.awt.Point;

import model.JBCollisionChecker;
import model.game.JBGameConstants;
import model.gameObjects.entities.JBEnemy;

public class JBHorizontalMovement extends JBMovement {
		
	public JBHorizontalMovement() {
		
		moveLeft = true;
		moveRight = false;
	}
	
	@Override
	public void execute(JBEnemy enemy) {
		
		var collisionOn = true;
		
		if(moveLeft) {
			
			enemy.setMoveDirection(JBGameConstants.MOVE_WALK_LEFT);
			enemy.setCurrentAnimation(enemy.getAnimation(JBGameConstants.MOVE_WALK_LEFT));
			collisionOn = JBCollisionChecker.getInstance().checkWall(enemy) || JBCollisionChecker.getInstance().checkBomb(enemy) || JBCollisionChecker.getInstance().checkPlayer(enemy);
			if(collisionOn) {
				moveLeft = false;
				moveRight = true;
			}
		}
		else if(moveRight) {
			
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
			
//				case JBGameConstants.MOVE_WALK_UP: enemy.setPosition(new Point(currentPosition.x, currentPosition.y -= 1 * speed)); break;
//				case JBGameConstants.MOVE_WALK_DOWN: enemy.setPosition(new Point(currentPosition.x, currentPosition.y += 1 * speed)); break;
				case JBGameConstants.MOVE_WALK_LEFT: enemy.setPosition(new Point(currentPosition.x -= 1 * speed, currentPosition.y)); break;
				case JBGameConstants.MOVE_WALK_RIGHT: enemy.setPosition(new Point(currentPosition.x += 1 * speed, currentPosition.y)); break;
			}
			
			enemy.getCurrentAnimation().start();
		}
	}
}