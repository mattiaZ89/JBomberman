package model.gameObjects.things.items.equipment;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;

import model.animations.JBAnimation;
import model.game.JBGameConstants;

public class JBBomb extends JBEquipment {
	
	private Shape explosionRange;
	
	private int timerCounter = 0;
	private boolean isTimerElapsed = false;
	private final int BOMB_TIMER = 150;

	public JBBomb(BufferedImage[] graphics, JBEquipmentType type) {
		
		super(type);
		animation = new JBAnimation(graphics, 1, "BOMB");
		body = new Rectangle(position.x + JBGameConstants.TILE_SIZE/4, position.y + JBGameConstants.TILE_SIZE/4, JBGameConstants.TILE_SIZE/2, (JBGameConstants.TILE_SIZE/2));
	}
	
	public JBBomb(JBAnimation animation, JBEquipmentType type) {
		
		super(type);
		this.animation = animation;
	}
	
	@Override
	public void setPosition(Point position) {
		
		this.position = position;
		Area area1 = new Area(new Rectangle(position.x-JBGameConstants.TILE_SIZE, position.y, JBGameConstants.TILE_SIZE*3, JBGameConstants.TILE_SIZE));
		Area area2 = new Area(new Rectangle(position.x, position.y-JBGameConstants.TILE_SIZE, JBGameConstants.TILE_SIZE, JBGameConstants.TILE_SIZE*3));
		area1.add(area2);
		explosionRange = area1;
		body = new Rectangle(position.x + JBGameConstants.TILE_SIZE/4, position.y + JBGameConstants.TILE_SIZE/4, JBGameConstants.TILE_SIZE/2, (JBGameConstants.TILE_SIZE/2));
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void update() {
		
		if(!isTimerElapsed) {
			
			animation.update();
		}
		
		timerCounter++;
		
		if(timerCounter > BOMB_TIMER && !isTimerElapsed) {
			
			animation.stop();
			isTimerElapsed = true;
			setChanged();
			notifyObservers();
		}
	}

	@Override
	public void render(Graphics2D g2d) {
		
		if(animation != null && position != null) {
			
			g2d.drawImage(animation.getSprite(), position.x, position.y, JBGameConstants.TILE_SIZE, JBGameConstants.TILE_SIZE, null);
			
			//DEBUG (to see bomb body or range explosion)
//			g2d.setColor(Color.RED);
//			g2d.draw(body);
		}
	}
	
	public BufferedImage getGraphics() {
		
		return animation.getSprite();
	}
	
	public boolean isExploded() {
		
		return isTimerElapsed;
	}
		
	public Shape getExplosionRange() {
		
		return explosionRange;
	}
}