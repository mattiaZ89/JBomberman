package model.gameObjects.things.items;

import java.awt.Graphics2D;

import model.animations.JBAnimation;
import model.game.JBGameConstants;
import model.gameObjects.things.JBThing;
import model.interfaces.JBICollectable;

/**
 * Rappresenta un generico oggetto collezionabile
 */
public abstract class JBItem extends JBThing implements JBICollectable {
	
	protected int timerCounter = 0;
	protected int timer = 300;
	protected boolean isTimerElapsed = false;
		
	public JBItem(JBAnimation animation) {
		
		this.animation = animation;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void update() {
		
		if(!isTimerElapsed) {
			
			animation.update();
		}
		
		timerCounter++;
		
		if(timerCounter > timer && !isTimerElapsed) {
			
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
}