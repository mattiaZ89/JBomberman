package model.gameObjects.things.items.collectibles;

import java.awt.Graphics2D;
import java.awt.Point;
import model.animations.JBAnimation;
import model.game.JBGameConstants;
import model.gameObjects.things.items.JBItem;
import model.interfaces.JBIPowerUpAction;
/**
 * Rappresenta un power up che fornisce un potenziamento al giocatore
 */
public class JBPowerUp extends JBItem {
	
	private final JBIPowerUpAction action;
	
	public JBPowerUp(JBIPowerUpAction action, Point position, JBAnimation animation) {
		
		super(animation);
		this.action = action;
		this.position = position;
		this.animation.start();
	}
	
	public JBPowerUp(JBIPowerUpAction action, JBAnimation animation) {
		
		super(animation);
		this.action = action;
		this.animation.start();
	}
	
	public JBIPowerUpAction getAction() {
		
		return action;
	}
	
	@Override
	public void pickUp() {
		// TODO Auto-generated method stub	
	}

	@Override
	public void update() {
		
		animation.update();
	}

	@Override
	public void render(Graphics2D g2d) {
		
		g2d.drawImage(this.animation.getSprite(), this.position.x, this.position.y, JBGameConstants.TILE_SIZE, JBGameConstants.TILE_SIZE, null);
	}
}