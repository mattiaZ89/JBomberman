
package model.stages;

import model.managers.JBEnemiesManager;
import model.managers.JBItemsManager;
import model.managers.JBPlayerManager;
import model.managers.JBStructuresManager;

/**
 * Rappresenta un generico costruttore per gli stage.
 * Contiene i vari manager degli elementi che devono essere di volta
 * in volta creati
 */
public abstract class JBStageBuilder implements JBIStageBuilder {
	
	protected static final String SEPARATOR = "/";
	
	protected JBStructuresManager structuresManager;
	protected JBPlayerManager playerManager;
	protected JBEnemiesManager enemiesManager;
	protected JBItemsManager itemsManager;
	protected int[][] levelMap;
	protected static final String STAGES = SEPARATOR + "stages";
	protected static String MAP;
	
	public JBIStageBuilder setSubStage(byte subStage) {
				
		switch(subStage) {
		
			case 1: setSubStage1Configuration(); break;
			case 2: setSubStage2Configuration(); break;
			case 3: setSubStage3Configuration(); break;
			case 4: setSubStage4Configuration(); break;
			case 5: setSubStage5Configuration(); break;
			case 6: setSubStage6Configuration(); break;
			case 7: setSubStage7Configuration(); break;
		}
		return this;
	}
		
	protected abstract void setSubStage1Configuration();
	protected abstract void setSubStage2Configuration();
	protected abstract void setSubStage3Configuration();
	protected abstract void setSubStage4Configuration();
	protected abstract void setSubStage5Configuration();
	protected abstract void setSubStage6Configuration();
	protected abstract void setSubStage7Configuration();
	
	//DEBUG
	protected void printMap() {
		
		for(int i=0; i<levelMap.length; i++) {
			
			for(int j=0; j<levelMap[i].length; j++) {
				
				if(j==levelMap[i].length -1) {
					
					System.out.println(levelMap[i][j]);
				}
				else {
					
					System.out.print(levelMap[i][j] + " ");
				}
				
				
			}
		}
	}
}