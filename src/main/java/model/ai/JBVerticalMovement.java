package model.ai;

import java.awt.Point;

import model.JBCollisionChecker;
import model.game.JBGameConstants;
import model.gameObjects.entities.JBEnemy;

public class JBVerticalMovement extends JBMovement {
	
	public JBVerticalMovement() {
		
		moveUP = true;
		moveDown = false;
	}
	
	@Override
	public void execute(JBEnemy enemy) {
		
		var collisionOn = true;
		
		if(moveUP) {
			
			enemy.setMoveDirection(JBGameConstants.MOVE_WALK_UP);
			enemy.setCurrentAnimation(enemy.getAnimation(JBGameConstants.MOVE_WALK_UP));
			collisionOn = JBCollisionChecker.getInstance().checkWall(enemy) || JBCollisionChecker.getInstance().checkBomb(enemy)|| JBCollisionChecker.getInstance().checkPlayer(enemy);
			if(collisionOn) {
				moveUP = false;
				moveDown = true;
			}
		}
		else if(moveDown) {
			enemy.setMoveDirection(JBGameConstants.MOVE_WALK_DOWN);
			enemy.setCurrentAnimation(enemy.getAnimation(JBGameConstants.MOVE_WALK_DOWN));
			collisionOn = JBCollisionChecker.getInstance().checkWall(enemy) || JBCollisionChecker.getInstance().checkBomb(enemy)|| JBCollisionChecker.getInstance().checkPlayer(enemy);
			if(collisionOn) {
				moveDown = false;
				moveUP = true;
			}
		}
		
		if(!collisionOn) {
			
			var currentPosition = enemy.getPosition();
			var speed = enemy.getSpeed();

			switch(enemy.getMoveDirection()) {
			
				case JBGameConstants.MOVE_WALK_UP: enemy.setPosition(new Point(currentPosition.x, currentPosition.y -= 1 * speed)); break;
				case JBGameConstants.MOVE_WALK_DOWN: enemy.setPosition(new Point(currentPosition.x, currentPosition.y += 1 * speed)); break;
//				case JBGameConstants.MOVE_WALK_LEFT: enemy.setPosition(new Point(currentPosition.x -= 1 * speed, currentPosition.y)); break;
//				case JBGameConstants.MOVE_WALK_RIGHT: enemy.setPosition(new Point(currentPosition.x += 1 * speed, currentPosition.y)); break;
			}
			
			enemy.getCurrentAnimation().start();
		}
	}
}