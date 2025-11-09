package model.stages;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import model.factories.JBEnemiesFactory;
import model.factories.JBItemsFactory;
import model.factories.JBPlayerFactory;
import model.factories.JBStructuresFactory;
import model.game.JBGameConstants;
import model.gameObjects.entities.JBEnemy;
import model.gameObjects.entities.JBPlayer;
import model.gameObjects.things.items.equipment.JBBomb;
import model.gameObjects.things.obstacles.JBObstacle;
import model.managers.JBEnemiesManager;
import model.managers.JBItemsManager;
import model.managers.JBPlayerManager;
import model.managers.JBStructuresManager;
import utilities.JBFileManager;
/**
 * Costruttore concreto del primo stage
 */
public class JBStage1Builder extends JBStageBuilder {
	
	private static final String STAGE = "stage_1";
	private byte substage;
	
	@Override
	public JBIStageBuilder loadMap() {
		
		JBFileManager fileManager = new JBFileManager();
//		System.out.println(MAP);
		fileManager.loadMap(MAP);
		levelMap = fileManager.getLevelMap();
//		printMap();//debug
		return this;
	}
		
	@Override
	public JBIStageBuilder setStructuresManager() {
		
		List<JBObstacle> obstacles = new ArrayList<>();
		
		var factory = JBStructuresFactory.getInstance();
		factory.configureFactory(substage);
		
		for(int row=0; row<JBGameConstants.PLAYABLE_FIELD_ROW; row++) {
			
			for(int col=0; col<JBGameConstants.PLAYABLE_FIELD_COL; col++) {
				
				var obstacle = factory.create(levelMap[row][col], row, col);
				
				if(obstacle != null) {
					obstacles.add(obstacle);
				}
			}
		}
		
		structuresManager = new JBStructuresManager(factory.createPlayfield(), obstacles);
		
		return this;
	}
		
	@Override
	public JBIStageBuilder setPlayerManager() {
		
		JBPlayer player = null;
		
		JBPlayerFactory.getInstance().configureFactory(substage);
		
		for(int row=0; row<JBGameConstants.PLAYABLE_FIELD_ROW; row++) {
			
			for(int col=0; col<JBGameConstants.PLAYABLE_FIELD_COL; col++) {
				
				var ply = JBPlayerFactory.getInstance().create(levelMap[row][col], row, col);
				
				if(ply != null) {
					player = ply;
				}
			}
		}
		
		playerManager = new JBPlayerManager(player);
		return this;
	}
	
	@Override
	public JBIStageBuilder setEnemiesManager() {
		
		List<JBEnemy> enemies = new ArrayList<>();
		
		JBEnemiesFactory.getInstance().configureFactory(substage);
		
		for(int row=0; row<JBGameConstants.PLAYABLE_FIELD_ROW; row++) {
			
			for(int col=0; col<JBGameConstants.PLAYABLE_FIELD_COL; col++) {
				
				var enemy = JBEnemiesFactory.getInstance().create(levelMap[row][col], row, col);
				
				if(enemy != null) {
					enemies.add(enemy);
				}
			}
		}
		
		enemiesManager = new JBEnemiesManager(enemies);
		
		return this;
	}
		
	@Override
	public JBIStageBuilder setItemsManager() {
		
		Queue<JBBomb> bombsPool = new LinkedList<>();
		
		JBItemsFactory.getInstance().configureFactory(substage);
		
		for(int i=0; i<50; i++) {
			
			bombsPool.add(JBItemsFactory.getInstance().createBomb());
		}
		
		var explosionGraphics = JBItemsFactory.getInstance().getExplosionGraphics();
		
		if(explosionGraphics == null) System.out.println("MERDA");
		
		itemsManager = new JBItemsManager(bombsPool, explosionGraphics);
		return this;
	}
		
	@Override
	protected void setSubStage1Configuration() {
		
		MAP = STAGES + SEPARATOR + STAGE + SEPARATOR + "Stage_1_1_Map.txt";
				
		substage = 1;
	}
	
	@Override
	public void setSubStage2Configuration() {
		
		MAP = STAGES + SEPARATOR + STAGE + SEPARATOR + "Stage_1_2_Map.txt";
		
		substage = 2;
	}
	
	@Override
	public void setSubStage3Configuration() {
		
		MAP = STAGES + SEPARATOR + STAGE + SEPARATOR + "Stage_1_3_Map.txt";
		
		substage = 3;
	}
	
	@Override
	protected void setSubStage4Configuration() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setSubStage5Configuration() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setSubStage6Configuration() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setSubStage7Configuration() {
		// TODO Auto-generated method stub
		
	}
	
	public JBStage build() {
		
		return new JBStage(structuresManager, playerManager, enemiesManager, itemsManager);
	}
}