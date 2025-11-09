package model.factories;

import java.awt.Point;
import model.animations.JBAnimation;
import model.game.JBGameConstants;
import model.gameObjects.JBPlayfield;
import model.gameObjects.things.obstacles.JBDestructibleObstacle;
import model.gameObjects.things.obstacles.JBEndPad;
import model.gameObjects.things.obstacles.JBIndestructibleObstacle;
import model.gameObjects.things.obstacles.JBObstacle;
import utilities.JBGraphicsFileManager;
/**
 * Factory responsabile della creazione delle strutture
 */
public class JBStructuresFactory extends JBGameObjectFactory<JBObstacle> {
	
	private static JBStructuresFactory instance;
	private JBAnimation[][] structureAnimations = new JBAnimation[1000][4];
	
	private String WALL;
	private String PLAYFIELD;
	
	public static JBStructuresFactory getInstance() {
		
		if(instance == null) instance = new JBStructuresFactory();
		return instance;
	}
	
	@Override
	public JBObstacle create(int objCode, int row, int col) {
		
		var position = new Point(col * JBGameConstants.TILE_SIZE + JBGameConstants.PLAYABLE_OFFSET_X, row * JBGameConstants.TILE_SIZE + JBGameConstants.PLAYABLE_OFFSET_Y);

		switch(objCode) {
		
			case 110: return new JBIndestructibleObstacle(position, structureAnimations[0][0]);
			case 200: return new JBDestructibleObstacle(position, structureAnimations[1][0]);
			case 999: return new JBEndPad(position, structureAnimations[2][0]);
		}

		return null;
	}
	
	public JBPlayfield createPlayfield() {
		
		//Create Graphics file manager
		var gfm = new JBGraphicsFileManager();
		
		//Create the walls of the arena
		var wallGraphics = gfm.createWallGraphics(WALL, JBGameConstants.WALL_WIDTH, JBGameConstants.WALL_HEIGHT);
		
		//Create the playfield of the arena
		var playfieldGraphics = gfm.createPlayFieldGraphics(PLAYFIELD, JBGameConstants.TILE_SIZE, JBGameConstants.TILE_SIZE);
		
		return new JBPlayfield(wallGraphics, playfieldGraphics);
	}

	@Override
	protected void setUpSubStage1() {
		
		//Create Graphics file manager
		var gfm = new JBGraphicsFileManager();
		
		//Set Wall FilePath
		WALL = WORLD_1 + SEPARATOR + WALLS + SEPARATOR + WALL_1;
		
		//Set Playfield FilePath
		PLAYFIELD = WORLD_1 + SEPARATOR + PLAYFIELDS + SEPARATOR + PLAYFIELD_1;
		
		//Create JBIndestructibleObstacle animations
		var indObst = WORLD_1 + SEPARATOR + IND_OBSTACLE_1 + SEPARATOR + OBSTACLE_1;
		var indObstFilePath = new String(indObst);
		var indObstGraphics = gfm.createIndistructiblesObstaclesGraphics(indObstFilePath, JBGameConstants.TILE_SIZE, JBGameConstants.TILE_SIZE);
		
		
		//Create JBDestructibleObstacle animations
		var disObst1 = WORLD_1 + SEPARATOR + DIS_OBSTACLE_1 + SEPARATOR + OBSTACLE_1;
		var disObst2 = WORLD_1 + SEPARATOR + DIS_OBSTACLE_1 + SEPARATOR + OBSTACLE_2;
		var disObst3 = WORLD_1 + SEPARATOR + DIS_OBSTACLE_1 + SEPARATOR + OBSTACLE_3;
		var disObst4 = WORLD_1 + SEPARATOR + DIS_OBSTACLE_1 + SEPARATOR + OBSTACLE_4;
		
		var disObstFilePath = new String[] {disObst1, disObst2, disObst3, disObst4};
		
		var disObstGraphics = gfm.createDistructiblesObstaclesGraphics(disObstFilePath, JBGameConstants.TILE_SIZE, JBGameConstants.TILE_SIZE);
		
		//Create JBEndPad animations
		var endPad1 = WORLD_1 + SEPARATOR + END_PADS + SEPARATOR + END_PAD_1;
		var endPad2 = WORLD_1 + SEPARATOR + END_PADS + SEPARATOR + END_PAD_2;
		
		var endPadFilePath = new String[] {endPad1, endPad2};
		
		var endPadGraphics = gfm.createEndPadGraphics(endPadFilePath, JBGameConstants.TILE_SIZE, JBGameConstants.TILE_SIZE);
		
		structureAnimations[0][0] = new JBAnimation(indObstGraphics, 6, "Indestructible Obstacle");
		structureAnimations[1][0] = new JBAnimation(disObstGraphics, 6, "Destructible Obstacle");
		structureAnimations[2][0] = new JBAnimation(endPadGraphics, 6, "End Pad");
	}

	@Override
	protected void setUpSubStage2() {
		
		setUpSubStage1();
	}

	@Override
	protected void setUpSubStage3() {
		
		//Create Graphics file manager
		var gfm = new JBGraphicsFileManager();
				
		//Set Wall FilePath
		WALL = WORLD_1 + SEPARATOR + WALLS + SEPARATOR + WALL_2;
		
		//Set Playfield FilePath
		PLAYFIELD = WORLD_1 + SEPARATOR + PLAYFIELDS + SEPARATOR + PLAYFIELD_2;
		
		//Create JBIndestructibleObstacle animations
		var indObst = WORLD_1 + SEPARATOR + IND_OBSTACLE_2 + SEPARATOR + OBSTACLE_1;
		var indObstFilePath = new String(indObst);
		var indObstGraphics = gfm.createIndistructiblesObstaclesGraphics(indObstFilePath, JBGameConstants.TILE_SIZE, JBGameConstants.TILE_SIZE);
		
		//Create JBDestructibleObstacle animations
		var disObst1 = WORLD_1 + SEPARATOR + DIS_OBSTACLE_2 + SEPARATOR + OBSTACLE_1;
		var disObst2 = WORLD_1 + SEPARATOR + DIS_OBSTACLE_2 + SEPARATOR + OBSTACLE_2;
		
		var disObstFilePath = new String[] {disObst1, disObst2};
		
		var disObstGraphics = gfm.createDistructiblesObstaclesGraphics(disObstFilePath, JBGameConstants.TILE_SIZE, JBGameConstants.TILE_SIZE);
		
		//Create JBEndPad animations
		var endPad1 = WORLD_1 + SEPARATOR + END_PADS + SEPARATOR + END_PAD_1;
		var endPad2 = WORLD_1 + SEPARATOR + END_PADS + SEPARATOR + END_PAD_2;
		
		var endPadFilePath = new String[] {endPad1, endPad2};
		
		var endPadGraphics = gfm.createEndPadGraphics(endPadFilePath, JBGameConstants.TILE_SIZE, JBGameConstants.TILE_SIZE);
		
		structureAnimations[0][0] = new JBAnimation(indObstGraphics, 6, "Indestructible Obstacle");
		structureAnimations[1][0] = new JBAnimation(disObstGraphics, 6, "Destructible Obstacle");
		structureAnimations[2][0] = new JBAnimation(endPadGraphics, 6, "End Pad");
	}

	@Override
	protected void setUpSubStage4() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void setUpSubStage5() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void setUpSubStage6() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void setUpSubStage7() {
		// TODO Auto-generated method stub
	}
}