package model.gameObjects.things.items.collectibles;

import java.awt.Graphics2D;
import java.awt.Point;
import model.animations.JBAnimation;
import model.game.JBGameConstants;
import model.gameObjects.things.items.JBItem;

/**
 * Rappresenta un Collezionabile che fornisce punteggio
 */
public class JBCollectible extends JBItem {
	
	private final int value;
	private boolean isCollected;
	
	public JBCollectible(int value, Point position, JBAnimation animation) {
		
		super(animation);
		this.value = value;
		this.position = position;
		animation.start();
	}
	
	public JBCollectible(int value, JBAnimation animation) {
		
		super(animation);
		this.value = value;
		animation.start();
	}
	
	public int getValue() {
		
		return value;
	}
	
	public boolean isCollected() {
		
		return isCollected;
	}
	
	@Override
	public void pickUp() {
		
		isCollected = true;
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