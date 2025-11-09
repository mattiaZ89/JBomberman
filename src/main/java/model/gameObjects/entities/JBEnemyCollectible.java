package model.gameObjects.entities;

import model.gameObjects.things.items.JBItem;

/**
 * Rappresenta l'astrazione di un nemico semplice che contiene un oggetto
 * collezionabile
 */
public abstract class JBEnemyCollectible extends JBEnemy {

	protected final JBItem collectible;
	
	public JBEnemyCollectible(byte behaviorType, JBItem collectible) {
		super(behaviorType);
		this.collectible = collectible;
	}
}
