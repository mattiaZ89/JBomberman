package model;

import java.awt.Point;

import model.game.JBGame;
import model.game.JBGameConstants;
import model.gameObjects.entities.JBEnemy;
import model.gameObjects.entities.JBEntity;
import model.gameObjects.entities.JBPlayer;
import model.gameObjects.things.items.equipment.JBBomb;
import model.gameObjects.things.obstacles.JBEndPad;
import model.gameObjects.things.obstacles.JBObstacle;
/**
 * Questa classe gestisce la fisica delle collisioni tra i vari oggetti
 * del gioco
 */
public class JBCollisionChecker {
	
	private static JBCollisionChecker instance;
	private JBGame game;
	
	public static JBCollisionChecker getInstance() {
		
		if (instance == null) instance = new JBCollisionChecker();
		return instance;
	}
	
	public void setGame(JBGame game) {
		
		this.game = game;
	}
	
	public boolean checkWall(JBEntity entity) {
		
		var collision = false;
		var entityBody = entity.getBody();
		var playField = game.getStructuresManager().getPlayField();
		Point currentPosition = entity.getPosition();
		int x = currentPosition.x;
		int y = currentPosition.y;
		var obstacles = game.getStructuresManager().getObstacles();
		
//		System.out.println("Current X: " + x + " Current Y: " + y);
//		System.out.println("Body X: " + entityBody.x + " Body Y: " + entityBody.y + " Body W: " + entityBody.width + " Body H: " + entityBody.height);
//		System.out.println("Field X: " + playField.x + " Field Y: " + playField.y + " Field W: " + playField.width + " Field H: " + playField.height);
		
		if(entity.getMoveDirection() == JBGameConstants.MOVE_WALK_UP) {
			
			currentPosition.y -= 1 * entity.getSpeed();
			entityBody.x = currentPosition.x + JBGameConstants.TILE_SIZE/4;
			entityBody.y = currentPosition.y + JBGameConstants.TILE_SIZE/4;
			collision = (!playField.contains(entityBody))? true : false;
			for(JBObstacle obstacle : obstacles) {
				
				if(obstacle.getBody().intersects(entityBody)) {
					
					collision = true;
//					System.out.println("COLLISION");
					break;
				}
			}
		}
		else if(entity.getMoveDirection() == JBGameConstants.MOVE_WALK_DOWN) {
			
			currentPosition.y += 1 * entity.getSpeed();
			entityBody.x = currentPosition.x + JBGameConstants.TILE_SIZE/4;
			entityBody.y = currentPosition.y + JBGameConstants.TILE_SIZE/2;
			collision = (!playField.contains(entityBody))? true : false;
			for(JBObstacle obstacle : obstacles) {
				
				if(obstacle.getBody().intersects(entityBody)) {
					
					collision = true;
//					System.out.println("COLLISION");
					break;
				}
			}
		}
		else if(entity.getMoveDirection() == JBGameConstants.MOVE_WALK_LEFT) {
			
			currentPosition.x -= 1 * entity.getSpeed();
			entityBody.x = currentPosition.x + JBGameConstants.TILE_SIZE/4;
			entityBody.y = currentPosition.y + JBGameConstants.TILE_SIZE/4;
			collision = (!playField.contains(entityBody))? true : false;
			for(JBObstacle obstacle : obstacles) {
				
				if(obstacle.getBody().intersects(entityBody)) {
					
					collision = true;
//					System.out.println("COLLISION");
					break;
				}
			}
		}
		else if(entity.getMoveDirection() == JBGameConstants.MOVE_WALK_RIGHT) {
			
			currentPosition.x += 1 * entity.getSpeed();
			entityBody.x = currentPosition.x + JBGameConstants.TILE_SIZE/4;
			entityBody.y = currentPosition.y + JBGameConstants.TILE_SIZE/4;
			collision = (!playField.contains(entityBody))? true : false;
			for(JBObstacle obstacle : obstacles) {
				
				if(obstacle.getBody().intersects(entityBody)) {
					
					collision = true;
//					System.out.println("COLLISION");
					break;
				}
			}
		}
		
		entity.setPosition(new Point(x, y));
		entity.resetBody();
		
		return collision;
	}
	
	public boolean checkPlayer(JBEntity entity) {
		
		var collision = false;
		
		var entityBody = entity.getBody();
		
		Point currentPosition = entity.getPosition();
		int x = currentPosition.x;
		int y = currentPosition.y;
		
		var playerBody = game.getPlayerManager().getPlayerOne().getBody();
		
//		System.out.println("Current X: " + x + " Current Y: " + y);
//		System.out.println("Player Body X: " + player.getBody().x + "Player Body Y: " + player.getBody().y + "Player Body W: " + player.getBody().width + "Player Body H: " + player.getBody().height);
//		System.out.println("Body X: " + entityBody.x + " Body Y: " + entityBody.y + " Body W: " + entityBody.width + " Body H: " + entityBody.height);
//		System.out.println("Field X: " + playField.x + " Field Y: " + playField.y + " Field W: " + playField.width + " Field H: " + playField.height);
		
		if(entity.getMoveDirection() == JBGameConstants.MOVE_WALK_UP) {
			
			currentPosition.y -= 1 * entity.getSpeed();
			entityBody.x = currentPosition.x + JBGameConstants.TILE_SIZE/4;
			entityBody.y = currentPosition.y + JBGameConstants.TILE_SIZE/4;
			collision = (playerBody.intersects(entityBody))? true : false;
		}
		else if(entity.getMoveDirection() == JBGameConstants.MOVE_WALK_DOWN) {
			
			currentPosition.y += 1 * entity.getSpeed();
			entityBody.x = currentPosition.x + JBGameConstants.TILE_SIZE/4;
			entityBody.y = currentPosition.y + JBGameConstants.TILE_SIZE/2;
			collision = (playerBody.intersects(entityBody))? true : false;
		}
		else if(entity.getMoveDirection() == JBGameConstants.MOVE_WALK_LEFT) {
			
			currentPosition.x -= 1 * entity.getSpeed();
			entityBody.x = currentPosition.x + JBGameConstants.TILE_SIZE/4;
			entityBody.y = currentPosition.y + JBGameConstants.TILE_SIZE/4;
			collision = (playerBody.intersects(entityBody))? true : false;
		}
		else if(entity.getMoveDirection() == JBGameConstants.MOVE_WALK_RIGHT) {
			
			currentPosition.x += 1 * entity.getSpeed();
			entityBody.x = currentPosition.x + JBGameConstants.TILE_SIZE/4;
			entityBody.y = currentPosition.y + JBGameConstants.TILE_SIZE/4;
			collision = (playerBody.intersects(entityBody))? true : false;
		}
		
//		if(collision) System.out.println("Collision With Player");DEBUG
		
		entity.setPosition(new Point(x, y));
		entity.resetBody();
		
		return collision;
	}
	
	public boolean checkBomb(JBEntity entity) {
				
		var collision = false;
		var entityBody = entity.getBody();
//		var playField = game.getStructuresManager().getPlayField();
		Point currentPosition = entity.getPosition();
		int x = currentPosition.x;
		int y = currentPosition.y;
		var bombs = game.getItemsManager().getBombs();
		
//		if (bombs == null) System.out.println("NO BOMBS");
		
		bombs.forEach(b -> b.getBody());
		
		if(entity.getMoveDirection() == JBGameConstants.MOVE_WALK_UP) {
//			System.out.println("MOVE UP");
			currentPosition.y -= 1 * entity.getSpeed();
			entityBody.x = currentPosition.x + JBGameConstants.TILE_SIZE/4;
			entityBody.y = currentPosition.y + JBGameConstants.TILE_SIZE/4;
//			collision = (!playField.contains(entityBody))? true : false;
			for(JBBomb bomb : bombs) {
				
//				if(bomb.getBody() == null) System.out.println("BODY NULL");
				if(bomb.getBody() != null && bomb.getBody().intersects(entityBody)) {
					
					collision = true;
//					System.out.println("COLLISION");
					break;
				}
			}
		}
		else if(entity.getMoveDirection() == JBGameConstants.MOVE_WALK_DOWN) {
//			System.out.println("MOVE DOWN");
			currentPosition.y += 1 * entity.getSpeed();
			entityBody.x = currentPosition.x + JBGameConstants.TILE_SIZE/4;
			entityBody.y = currentPosition.y + JBGameConstants.TILE_SIZE/2;
//			collision = (!playField.contains(entityBody))? true : false;
			for(JBBomb bomb : bombs) {
//				if(bomb.getBody() == null) System.out.println("BODY NULL");
				if(bomb.getBody() != null && bomb.getBody().intersects(entityBody)) {
					
					collision = true;
//					System.out.println("COLLISION");
					break;
				}
			}
		}
		else if(entity.getMoveDirection() == JBGameConstants.MOVE_WALK_LEFT) {
//			System.out.println("MOVE LEFT");
			currentPosition.x -= 1 * entity.getSpeed();
			entityBody.x = currentPosition.x + JBGameConstants.TILE_SIZE/4;
			entityBody.y = currentPosition.y + JBGameConstants.TILE_SIZE/4;
//			collision = (!playField.contains(entityBody))? true : false;
			for(JBBomb bomb : bombs) {
//				if(bomb.getBody() == null) System.out.println("BODY NULL");
				if(bomb.getBody() != null && bomb.getBody().intersects(entityBody)) {
					
					collision = true;
//					System.out.println("COLLISION");
					break;
				}
			}
		}
		else if(entity.getMoveDirection() == JBGameConstants.MOVE_WALK_RIGHT) {
//			System.out.println("MOVE RIGHT");
			currentPosition.x += 1 * entity.getSpeed();
			entityBody.x = currentPosition.x + JBGameConstants.TILE_SIZE/4;
			entityBody.y = currentPosition.y + JBGameConstants.TILE_SIZE/4;
//			collision = (!playField.contains(entityBody))? true : false;
			for(JBBomb bomb : bombs) {
//				if(bomb.getBody() == null) System.out.println("BODY NULL");
				if(bomb.getBody() != null && bomb.getBody().intersects(entityBody)) {
					collision = true;
//					System.out.println("COLLISION");
					break;
				}
			}
		}
		
//		if(collision) System.out.println("Collision With Bomb");
		
		entity.setPosition(new Point(x, y));
		entity.resetBody();
		
		return collision;
	}
	
	public boolean checkExplosion(JBBomb bomb, JBEnemy enemy) {
		
		return (bomb.getExplosionRange().intersects(enemy.getBody()))? true : false;
	}
	
	public boolean checkExplosion(JBBomb bomb, JBObstacle obstacle) {
		
		return (bomb.getExplosionRange().intersects(obstacle.getBody()))? true : false;
	}
	
	public boolean checkEndPad(JBPlayer player, JBEndPad endPad) {
		
		return (player.getBody().intersects(endPad.getBody()))? true : false;
	}
}