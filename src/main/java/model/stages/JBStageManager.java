package model.stages;

import java.util.LinkedList;
import java.util.Queue;
/**
 * Gestisce gli stage del gioco ed è responsabile del corretto avanzamento
 * dei livelli
 */
public class JBStageManager {
	
	private static JBStageManager instance;
	
	private JBStage currentStage;
	
	private Queue<Byte> stages;//42
	
	private byte subStage;
	
	private JBStageManager() {
		
		stages = new LinkedList<Byte>();
		
		//Real game have 42 stages, but for now I craete only 3 stages.
		for(byte i=1; i<4; i++) {
			
			stages.add(i);
		}
		
		//Give me stage one or stage n
		createStage();
	}
	
	public static JBStageManager getInstance() {
		
		if (instance == null) instance = new JBStageManager();
		return instance;
	}
	
	public JBStage getCurrentStage() {
		
		return currentStage;
	}
	
	public boolean hasNextStage() {
		
		//If there are other stages the game is not finished yet....
		return !stages.isEmpty();
	}
		
	public void createStage() {
		
		//Ask to director for creating the new required stage
		currentStage = null;
		var stageNumber = stages.poll();
		setSubStage(stageNumber);
		JBIStageBuilder stageBuilder = selectStageBuilder(stageNumber);
		stageBuilder.setSubStage(subStage)
					.loadMap()
					.setStructuresManager()
					.setPlayerManager()
					.setEnemiesManager()
					.setItemsManager();
		currentStage = stageBuilder.build();
	}
	
	private JBIStageBuilder selectStageBuilder(byte stage) {
		
		switch(stage) {
		
			case 1 , 2 , 3 , 4 , 5 , 6 , 7 : return new JBStage1Builder();
			case 8 , 9 , 10, 11, 12, 13, 14: return null;//JBStage2Builder, not in this software release
			case 15, 16, 17, 18, 19, 20, 21: return null;//JBStage3Builder, not in this software release
			case 22, 23, 24, 25, 26, 27, 28: return null;//JBStage4Builder, not in this software release
			case 29, 30, 31, 32, 33, 34, 35: return null;//JBStage5Builder, not in this software release
			case 36, 37, 38, 39, 40, 41, 42: return null;//JBStage6Builder, not in this software release
		}
		return null;
	}
	
	private void setSubStage(byte stageNumber) {
		
		switch(stageNumber) {
		
			case 1,8:  subStage = 1; break;
			case 2,9:  subStage = 2; break;
			case 3,10: subStage = 3; break;
			case 4,11: subStage = 4; break;
			case 5,12: subStage = 5; break;
			case 6,13: subStage = 6; break;
			case 7,14: subStage = 7; break;
		}
	}
}