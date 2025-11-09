package model.gameObjects.things.items.equipment;

import model.gameObjects.things.JBThing;
/**
 * Rappresenta un generico equipaggiamento del giocatore
 */
public abstract class JBEquipment extends JBThing {
	
	protected JBEquipmentType type;
	
	public JBEquipment(JBEquipmentType type) {
		
		this.type = type;
	}
}