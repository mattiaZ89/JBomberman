package model.stages;

import model.interfaces.JBIUpdatable;
import model.managers.JBEnemiesManager;
import model.managers.JBItemsManager;
import model.managers.JBPlayerManager;
import model.managers.JBStructuresManager;
/***
 * Rappresenta lo stage da giocare
 */
public class JBStage implements JBIUpdatable {
		
	private JBStructuresManager structuresManager;
	private JBPlayerManager playerManager;
	private JBEnemiesManager enemiesManager;
	private JBItemsManager itemsManager;
	private boolean isFinished;
	
	public JBStage(JBStructuresManager structuresManager, JBPlayerManager playerManager, JBEnemiesManager enemiesManager, JBItemsManager itemsManager) {
		
		this.structuresManager = structuresManager;
		this.playerManager = playerManager;
		this.enemiesManager = enemiesManager;
		this.itemsManager = itemsManager;
		this.isFinished = false;
	}
	
	public JBStructuresManager getStructureManager() {
		
		return structuresManager;
	}
	
	public JBEnemiesManager getEnemiesManager() {
		
		return enemiesManager;
	}
	
	public JBItemsManager getItemsManager() {
		
		return itemsManager;
	}
	
	public JBPlayerManager getPlayerManager() {
		
		return playerManager;
	}
	
	public void finishStage() {
		
		isFinished = true;
	}
	
	public boolean isFinished() {
		
		return isFinished;
	}

	@Override
	public void update() {
		
		structuresManager.update();
		enemiesManager.update();
		playerManager.update();
		itemsManager.update();
	}
}