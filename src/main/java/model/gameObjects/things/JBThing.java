package model.gameObjects.things;

import model.animations.JBAnimation;
import model.gameObjects.JBGameObject;

/**
 * Rappresenta una generica cosa all'interno del gioco
 */
public abstract class JBThing extends JBGameObject {
	
	protected JBAnimation animation;
	
	public JBAnimation getAnimation() {
		
		return animation;
	}
}