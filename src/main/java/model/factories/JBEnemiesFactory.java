package model.factories;

import java.awt.Point;
import java.util.Random;

import model.animations.JBAnimation;
import model.game.JBGameConstants;
import model.gameObjects.entities.JBEnemy;
import model.gameObjects.entities.JBLowerEnemy;
import model.gameObjects.entities.JBLowerEnemyCollectible;
import model.gameObjects.things.items.collectibles.JBCollectible;
import model.gameObjects.things.items.collectibles.JBPowerUp;
import utilities.JBGraphicsFileManager;

/**
 * Factory responsabile della creazione dei nemici
 */
public class JBEnemiesFactory extends JBGameObjectFactory<JBEnemy> {
		
	private static JBEnemiesFactory instance;
	private static final Random RND = new Random();
	private JBAnimation[][] enemiesAnimations = new JBAnimation[1000][4];
	private JBAnimation[] collectiblesAnimations = new JBAnimation[10];
	private JBAnimation[] powerUpsAnimations = new JBAnimation[20];
	
	public static JBEnemiesFactory getInstance() {
		
		if(instance == null) instance = new JBEnemiesFactory();
		return instance;
	}
	
	public void configureFactory(byte stage) {
		
		switch(stage) {
			case 1: setUpSubStage1(); break;
			case 2: setUpSubStage2(); break;
			case 3: setUpSubStage3(); break;
			case 4: setUpSubStage4(); break;
			case 5: setUpSubStage5(); break;
			case 6: setUpSubStage6(); break;
			case 7: setUpSubStage7(); break;
		}
	}
	
	@Override
	public JBEnemy create(int enemyCode, int row, int col) {
		
		var position = new Point(col * JBGameConstants.TILE_SIZE + JBGameConstants.PLAYABLE_OFFSET_X, row * JBGameConstants.TILE_SIZE + JBGameConstants.PLAYABLE_OFFSET_Y);

		switch(enemyCode) {
		
			case 300: return new JBLowerEnemy(choseEnemyBehavior(), position, enemiesAnimations[0]);//Enemy Type 1
			case 301: return new JBLowerEnemy(choseEnemyBehavior(), position, enemiesAnimations[1]);//Enemy Type 2
			case 302: return new JBLowerEnemy(choseEnemyBehavior(), position, enemiesAnimations[2]);//Enemy Type 3
			case 304: return new JBLowerEnemy(choseEnemyBehavior(), position, enemiesAnimations[3]);//Enemy Type 4

			case 311: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[0], new JBCollectible(10, collectiblesAnimations[0]));//Enemy Type 1 with Collectible Type 1
			case 312: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[0], new JBCollectible(20, collectiblesAnimations[1]));//Enemy Type 1 with Collectible Type 2
			case 313: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[0], new JBCollectible(30, collectiblesAnimations[2]));//Enemy Type 1 with Collectible Type 3
			case 314: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[0], new JBCollectible(40, collectiblesAnimations[3]));//Enemy Type 1 with Collectible Type 4
			case 315: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[0], new JBCollectible(50, collectiblesAnimations[4]));//Enemy Type 1 with Collectible Type 5
			case 316: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[0], new JBCollectible(60, collectiblesAnimations[5]));//Enemy Type 1 with Collectible Type 6

			case 321: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[1], new JBCollectible(10, collectiblesAnimations[0]));//Enemy Type 2 with Collectible Type 1
			case 322: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[1], new JBCollectible(20, collectiblesAnimations[1]));//Enemy Type 2 with Collectible Type 2
			case 323: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[1], new JBCollectible(30, collectiblesAnimations[2]));//Enemy Type 2 with Collectible Type 3
			case 324: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[1], new JBCollectible(40, collectiblesAnimations[3]));//Enemy Type 2 with Collectible Type 4
			case 325: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[1], new JBCollectible(50, collectiblesAnimations[4]));//Enemy Type 2 with Collectible Type 5
			case 326: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[1], new JBCollectible(60, collectiblesAnimations[5]));//Enemy Type 2 with Collectible Type 6

			case 331: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[2], new JBCollectible(10, collectiblesAnimations[0]));//Enemy Type 3 with Collectible Type 1
			case 332: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[2], new JBCollectible(20, collectiblesAnimations[1]));//Enemy Type 3 with Collectible Type 2
			case 333: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[2], new JBCollectible(30, collectiblesAnimations[2]));//Enemy Type 3 with Collectible Type 3
			case 334: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[2], new JBCollectible(40, collectiblesAnimations[3]));//Enemy Type 3 with Collectible Type 4
			case 335: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[2], new JBCollectible(50, collectiblesAnimations[4]));//Enemy Type 3 with Collectible Type 5
			case 336: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[2], new JBCollectible(60, collectiblesAnimations[5]));//Enemy Type 3 with Collectible Type 6
			
			case 341: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[3], new JBCollectible(10, collectiblesAnimations[0]));//Enemy Type 4 with Collectible Type 1
			case 342: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[3], new JBCollectible(20, collectiblesAnimations[1]));//Enemy Type 4 with Collectible Type 2
			case 343: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[3], new JBCollectible(30, collectiblesAnimations[2]));//Enemy Type 4 with Collectible Type 3
			case 344: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[3], new JBCollectible(40, collectiblesAnimations[3]));//Enemy Type 4 with Collectible Type 4
			case 345: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[3], new JBCollectible(50, collectiblesAnimations[4]));//Enemy Type 4 with Collectible Type 5
			case 346: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[3], new JBCollectible(60, collectiblesAnimations[5]));//Enemy Type 4 with Collectible Type 6
			
			
			case 700: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[0], new JBPowerUp(null, null));//Enemy Type 1 with PowerUp Type 1
			case 701: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[0], new JBPowerUp(null, null));//Enemy Type 1 with PowerUp Type 2
			case 702: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[0], new JBPowerUp(null, null));//Enemy Type 1 with PowerUp Type 3
			case 703: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[0], new JBPowerUp(null, null));//Enemy Type 1 with PowerUp Type 4
			case 704: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[0], new JBPowerUp(null, null));//Enemy Type 1 with PowerUp Type 5
			case 705: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[0], new JBPowerUp(null, null));//Enemy Type 1 with PowerUp Type 6

			case 720: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[1], new JBPowerUp(null, null));//Enemy Type 2 with PowerUp Type 1
			case 721: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[1], new JBPowerUp(null, null));//Enemy Type 2 with PowerUp Type 2
			case 722: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[1], new JBPowerUp(null, null));//Enemy Type 2 with PowerUp Type 3
			case 723: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[1], new JBPowerUp(null, null));//Enemy Type 2 with PowerUp Type 4
			case 724: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[1], new JBPowerUp(null, null));//Enemy Type 2 with PowerUp Type 5
			case 725: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[1], new JBPowerUp(null, null));//Enemy Type 2 with PowerUp Type 6

			case 740: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[2], new JBPowerUp(null, null));//Enemy Type 3 with PowerUp Type 1
			case 741: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[2], new JBPowerUp(null, null));//Enemy Type 3 with PowerUp Type 2
			case 742: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[2], new JBPowerUp(null, null));//Enemy Type 3 with PowerUp Type 3
			case 743: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[2], new JBPowerUp(null, null));//Enemy Type 3 with PowerUp Type 4
			case 744: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[2], new JBPowerUp(null, null));//Enemy Type 3 with PowerUp Type 5
			case 745: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[2], new JBPowerUp(null, null));//Enemy Type 3 with PowerUp Type 6
			
			case 760: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[3], new JBPowerUp(null, null));//Enemy Type 4 with PowerUp Type 1
			case 761: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[3], new JBPowerUp(null, null));//Enemy Type 4 with PowerUp Type 2
			case 762: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[3], new JBPowerUp(null, null));//Enemy Type 4 with PowerUp Type 3
			case 763: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[3], new JBPowerUp(null, null));//Enemy Type 4 with PowerUp Type 4
			case 764: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[3], new JBPowerUp(null, null));//Enemy Type 4 with PowerUp Type 5
			case 765: return new JBLowerEnemyCollectible(choseEnemyBehavior(), position, enemiesAnimations[3], new JBPowerUp(null, null));//Enemy Type 4 with PowerUp Type 6
		}

		return null;
	}
			
	private byte choseEnemyBehavior() {
		
		return (byte)RND.nextInt(3);
	}
	
	@Override
	protected void setUpSubStage1() {
		
		var ENEMY_1_UP_1 = WORLD_1 + SEPARATOR + ENEMY_1 + SEPARATOR + UP1;
		var ENEMY_1_UP_2 = WORLD_1 + SEPARATOR + ENEMY_1 + SEPARATOR + UP2;
		var ENEMY_1_UP_3 = WORLD_1 + SEPARATOR + ENEMY_1 + SEPARATOR + UP3;
		var ENEMY_1_UP_4 = WORLD_1 + SEPARATOR + ENEMY_1 + SEPARATOR + UP4;
		var ENEMY_1_DOWN_1 = WORLD_1 + SEPARATOR + ENEMY_1 + SEPARATOR + DOWN1;
		var ENEMY_1_DOWN_2 = WORLD_1 + SEPARATOR + ENEMY_1 + SEPARATOR + DOWN2;
		var ENEMY_1_DOWN_3 = WORLD_1 + SEPARATOR + ENEMY_1 + SEPARATOR + DOWN3;
		var ENEMY_1_DOWN_4 = WORLD_1 + SEPARATOR + ENEMY_1 + SEPARATOR + DOWN4;
		var ENEMY_1_LEFT_1 = WORLD_1 + SEPARATOR + ENEMY_1 + SEPARATOR + LEFT1;
		var ENEMY_1_LEFT_2 = WORLD_1 + SEPARATOR + ENEMY_1 + SEPARATOR + LEFT2;
		var ENEMY_1_LEFT_3 = WORLD_1 + SEPARATOR + ENEMY_1 + SEPARATOR + LEFT3;
		var ENEMY_1_LEFT_4 = WORLD_1 + SEPARATOR + ENEMY_1 + SEPARATOR + LEFT4;
		var ENEMY_1_RIGHT_1 = WORLD_1 + SEPARATOR + ENEMY_1 + SEPARATOR + RIGHT1;
		var ENEMY_1_RIGHT_2 = WORLD_1 + SEPARATOR + ENEMY_1 + SEPARATOR + RIGHT2;
		var ENEMY_1_RIGHT_3 = WORLD_1 + SEPARATOR + ENEMY_1 + SEPARATOR + RIGHT3;
		var ENEMY_1_RIGHT_4 = WORLD_1 + SEPARATOR + ENEMY_1 + SEPARATOR + RIGHT4;
		
		var files1 = new String[][] {new String[] {ENEMY_1_UP_1, ENEMY_1_UP_2, ENEMY_1_UP_3, ENEMY_1_UP_4},
		new String[] {ENEMY_1_DOWN_1, ENEMY_1_DOWN_2, ENEMY_1_DOWN_3, ENEMY_1_DOWN_4},
		new String[] {ENEMY_1_LEFT_1, ENEMY_1_LEFT_2, ENEMY_1_LEFT_3, ENEMY_1_LEFT_4},
		new String[] {ENEMY_1_RIGHT_1, ENEMY_1_RIGHT_2, ENEMY_1_RIGHT_3, ENEMY_1_RIGHT_4}};
		
		var gfm = new JBGraphicsFileManager();
		
		var enemy1Graphics = gfm.createEnemiesGraphics(files1, JBGameConstants.TILE_SIZE, JBGameConstants.TILE_SIZE);
		
		enemiesAnimations[0][0] = new JBAnimation(enemy1Graphics[0], 6, "");
		enemiesAnimations[0][1] = new JBAnimation(enemy1Graphics[1], 6, "");
		enemiesAnimations[0][2] = new JBAnimation(enemy1Graphics[2], 6, "");
		enemiesAnimations[0][3] = new JBAnimation(enemy1Graphics[3], 6, "");
		
		setItems();
	}
	
	@Override
	protected void setUpSubStage2() {
		
		var ENEMY_1_UP_1 = WORLD_1 + SEPARATOR + ENEMY_1 + SEPARATOR + UP1;
		var ENEMY_1_UP_2 = WORLD_1 + SEPARATOR + ENEMY_1 + SEPARATOR + UP2;
		var ENEMY_1_UP_3 = WORLD_1 + SEPARATOR + ENEMY_1 + SEPARATOR + UP3;
		var ENEMY_1_UP_4 = WORLD_1 + SEPARATOR + ENEMY_1 + SEPARATOR + UP4;
		var ENEMY_1_DOWN_1 = WORLD_1 + SEPARATOR + ENEMY_1 + SEPARATOR + DOWN1;
		var ENEMY_1_DOWN_2 = WORLD_1 + SEPARATOR + ENEMY_1 + SEPARATOR + DOWN2;
		var ENEMY_1_DOWN_3 = WORLD_1 + SEPARATOR + ENEMY_1 + SEPARATOR + DOWN3;
		var ENEMY_1_DOWN_4 = WORLD_1 + SEPARATOR + ENEMY_1 + SEPARATOR + DOWN4;
		var ENEMY_1_LEFT_1 = WORLD_1 + SEPARATOR + ENEMY_1 + SEPARATOR + LEFT1;
		var ENEMY_1_LEFT_2 = WORLD_1 + SEPARATOR + ENEMY_1 + SEPARATOR + LEFT2;
		var ENEMY_1_LEFT_3 = WORLD_1 + SEPARATOR + ENEMY_1 + SEPARATOR + LEFT3;
		var ENEMY_1_LEFT_4 = WORLD_1 + SEPARATOR + ENEMY_1 + SEPARATOR + LEFT4;
		var ENEMY_1_RIGHT_1 = WORLD_1 + SEPARATOR + ENEMY_1 + SEPARATOR + RIGHT1;
		var ENEMY_1_RIGHT_2 = WORLD_1 + SEPARATOR + ENEMY_1 + SEPARATOR + RIGHT2;
		var ENEMY_1_RIGHT_3 = WORLD_1 + SEPARATOR + ENEMY_1 + SEPARATOR + RIGHT3;
		var ENEMY_1_RIGHT_4 = WORLD_1 + SEPARATOR + ENEMY_1 + SEPARATOR + RIGHT4;
		
		var files = new String[][] {new String[] {ENEMY_1_UP_1, ENEMY_1_UP_2, ENEMY_1_UP_3, ENEMY_1_UP_4},
									new String[] {ENEMY_1_DOWN_1, ENEMY_1_DOWN_2, ENEMY_1_DOWN_3, ENEMY_1_DOWN_4},
									new String[] {ENEMY_1_LEFT_1, ENEMY_1_LEFT_2, ENEMY_1_LEFT_3, ENEMY_1_LEFT_4},
									new String[] {ENEMY_1_RIGHT_1, ENEMY_1_RIGHT_2, ENEMY_1_RIGHT_3, ENEMY_1_RIGHT_4}};
		
		var gfm = new JBGraphicsFileManager();
		
		var enemyGraphics = gfm.createEnemiesGraphics(files, JBGameConstants.TILE_SIZE, JBGameConstants.TILE_SIZE);
		
		enemiesAnimations[0][0] = new JBAnimation(enemyGraphics[0], 6, "");
		enemiesAnimations[0][1] = new JBAnimation(enemyGraphics[1], 6, "");
		enemiesAnimations[0][2] = new JBAnimation(enemyGraphics[2], 6, "");
		enemiesAnimations[0][3] = new JBAnimation(enemyGraphics[3], 6, "");
		
		var ENEMY_MOVE_1 = WORLD_1 + SEPARATOR + ENEMY_3 + SEPARATOR + MOVE1;
		var ENEMY_MOVE_2 = WORLD_1 + SEPARATOR + ENEMY_3 + SEPARATOR + MOVE2;
		var ENEMY_MOVE_3 = WORLD_1 + SEPARATOR + ENEMY_3 + SEPARATOR + MOVE3;
		var ENEMY_MOVE_4 = WORLD_1 + SEPARATOR + ENEMY_3 + SEPARATOR + MOVE4;
		var ENEMY_MOVE_5 = WORLD_1 + SEPARATOR + ENEMY_3 + SEPARATOR + MOVE5;
		var ENEMY_MOVE_6 = WORLD_1 + SEPARATOR + ENEMY_3 + SEPARATOR + MOVE6;
		
		files = new String[][] {new String[] {ENEMY_MOVE_1, ENEMY_MOVE_2, ENEMY_MOVE_3, ENEMY_MOVE_4, ENEMY_MOVE_5, ENEMY_MOVE_6},
								new String[] {ENEMY_MOVE_1, ENEMY_MOVE_2, ENEMY_MOVE_3, ENEMY_MOVE_4, ENEMY_MOVE_5, ENEMY_MOVE_6},
								new String[] {ENEMY_MOVE_1, ENEMY_MOVE_2, ENEMY_MOVE_3, ENEMY_MOVE_4, ENEMY_MOVE_5, ENEMY_MOVE_6},
								new String[] {ENEMY_MOVE_1, ENEMY_MOVE_2, ENEMY_MOVE_3, ENEMY_MOVE_4, ENEMY_MOVE_5, ENEMY_MOVE_6}};
								
		enemyGraphics = gfm.createEnemiesGraphics(files, JBGameConstants.TILE_SIZE, JBGameConstants.TILE_SIZE);
		
		enemiesAnimations[1][0] = new JBAnimation(enemyGraphics[0], 6, "");
		enemiesAnimations[1][1] = new JBAnimation(enemyGraphics[1], 6, "");
		enemiesAnimations[1][2] = new JBAnimation(enemyGraphics[2], 6, "");
		enemiesAnimations[1][3] = new JBAnimation(enemyGraphics[3], 6, "");
		
		setItems();
	}
	
	@Override
	protected void setUpSubStage3() {
				
		var ENEMY_UP_1 = WORLD_1 + SEPARATOR + ENEMY_4 + SEPARATOR + UP1;
		var ENEMY_UP_2 = WORLD_1 + SEPARATOR + ENEMY_4 + SEPARATOR + UP2;
		var ENEMY_UP_3 = WORLD_1 + SEPARATOR + ENEMY_4 + SEPARATOR + UP3;
		var ENEMY_UP_4 = WORLD_1 + SEPARATOR + ENEMY_4 + SEPARATOR + UP4;
		var ENEMY_UP_5 = WORLD_1 + SEPARATOR + ENEMY_4 + SEPARATOR + UP5;
		var ENEMY_UP_6 = WORLD_1 + SEPARATOR + ENEMY_4 + SEPARATOR + UP6;
		var ENEMY_UP_7 = WORLD_1 + SEPARATOR + ENEMY_4 + SEPARATOR + UP7;
		var ENEMY_UP_8 = WORLD_1 + SEPARATOR + ENEMY_4 + SEPARATOR + UP8;
		var ENEMY_UP_9 = WORLD_1 + SEPARATOR + ENEMY_4 + SEPARATOR + UP9;
		
		var ENEMY_DOWN_1 = WORLD_1 + SEPARATOR + ENEMY_4 + SEPARATOR + DOWN1;
		var ENEMY_DOWN_2 = WORLD_1 + SEPARATOR + ENEMY_4 + SEPARATOR + DOWN2;
		var ENEMY_DOWN_3 = WORLD_1 + SEPARATOR + ENEMY_4 + SEPARATOR + DOWN3;
		var ENEMY_DOWN_4 = WORLD_1 + SEPARATOR + ENEMY_4 + SEPARATOR + DOWN4;
		var ENEMY_DOWN_5 = WORLD_1 + SEPARATOR + ENEMY_4 + SEPARATOR + DOWN5;
		var ENEMY_DOWN_6 = WORLD_1 + SEPARATOR + ENEMY_4 + SEPARATOR + DOWN6;
		var ENEMY_DOWN_7 = WORLD_1 + SEPARATOR + ENEMY_4 + SEPARATOR + DOWN7;
		var ENEMY_DOWN_8 = WORLD_1 + SEPARATOR + ENEMY_4 + SEPARATOR + DOWN8;
		var ENEMY_DOWN_9 = WORLD_1 + SEPARATOR + ENEMY_4 + SEPARATOR + DOWN9;
		
		var ENEMY_LEFT_1 = WORLD_1 + SEPARATOR + ENEMY_4 + SEPARATOR + LEFT1;
		var ENEMY_LEFT_2 = WORLD_1 + SEPARATOR + ENEMY_4 + SEPARATOR + LEFT2;
		var ENEMY_LEFT_3 = WORLD_1 + SEPARATOR + ENEMY_4 + SEPARATOR + LEFT3;
		var ENEMY_LEFT_4 = WORLD_1 + SEPARATOR + ENEMY_4 + SEPARATOR + LEFT4;
		var ENEMY_LEFT_5 = WORLD_1 + SEPARATOR + ENEMY_4 + SEPARATOR + LEFT5;
		var ENEMY_LEFT_6 = WORLD_1 + SEPARATOR + ENEMY_4 + SEPARATOR + LEFT6;
		var ENEMY_LEFT_7 = WORLD_1 + SEPARATOR + ENEMY_4 + SEPARATOR + LEFT7;
		
		var ENEMY_RIGHT_1 = WORLD_1 + SEPARATOR + ENEMY_4 + SEPARATOR + RIGHT1;
		var ENEMY_RIGHT_2 = WORLD_1 + SEPARATOR + ENEMY_4 + SEPARATOR + RIGHT2;
		var ENEMY_RIGHT_3 = WORLD_1 + SEPARATOR + ENEMY_4 + SEPARATOR + RIGHT3;
		var ENEMY_RIGHT_4 = WORLD_1 + SEPARATOR + ENEMY_4 + SEPARATOR + RIGHT4;
		var ENEMY_RIGHT_5 = WORLD_1 + SEPARATOR + ENEMY_4 + SEPARATOR + RIGHT5;
		var ENEMY_RIGHT_6 = WORLD_1 + SEPARATOR + ENEMY_4 + SEPARATOR + RIGHT6;
		var ENEMY_RIGHT_7 = WORLD_1 + SEPARATOR + ENEMY_4 + SEPARATOR + RIGHT7;
		
		
		
		var files = new String[][] {new String[] {ENEMY_UP_1, ENEMY_UP_2, ENEMY_UP_3, ENEMY_UP_4, ENEMY_UP_5, ENEMY_UP_6, ENEMY_UP_7, ENEMY_UP_8, ENEMY_UP_9},
									new String[] {ENEMY_DOWN_1, ENEMY_DOWN_2, ENEMY_DOWN_3, ENEMY_DOWN_4, ENEMY_DOWN_5, ENEMY_DOWN_6, ENEMY_DOWN_7, ENEMY_DOWN_8, ENEMY_DOWN_9},
									new String[] {ENEMY_LEFT_1, ENEMY_LEFT_2, ENEMY_LEFT_3, ENEMY_LEFT_4, ENEMY_LEFT_5, ENEMY_LEFT_6, ENEMY_LEFT_7},
									new String[] {ENEMY_RIGHT_1, ENEMY_RIGHT_2, ENEMY_RIGHT_3, ENEMY_RIGHT_4, ENEMY_RIGHT_5, ENEMY_RIGHT_6, ENEMY_RIGHT_7}};
		
		var gfm = new JBGraphicsFileManager();
		
		var enemy1Graphics = gfm.createEnemiesGraphics(files, JBGameConstants.TILE_SIZE, JBGameConstants.TILE_SIZE);
		
		enemiesAnimations[2][0] = new JBAnimation(enemy1Graphics[0], 6, "");
		enemiesAnimations[2][1] = new JBAnimation(enemy1Graphics[1], 6, "");
		enemiesAnimations[2][2] = new JBAnimation(enemy1Graphics[2], 6, "");
		enemiesAnimations[2][3] = new JBAnimation(enemy1Graphics[3], 6, "");
		
		setItems();
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
	
	private void setItems() {
		
		//Collectibles
		var apple_1 = WORLD_1 + SEPARATOR + COLLECTIBLES + SEPARATOR + APPLE_1;
		var apple_2 = WORLD_1 + SEPARATOR + COLLECTIBLES + SEPARATOR + APPLE_2;
		var cake_1 = WORLD_1 + SEPARATOR + COLLECTIBLES + SEPARATOR + CAKE_1;
		var cake_2 = WORLD_1 + SEPARATOR + COLLECTIBLES + SEPARATOR + CAKE_2;
		var cupAndBall_1 = WORLD_1 + SEPARATOR + COLLECTIBLES + SEPARATOR + CUP_AND_BALL_1;
		var cupAndBall_2 = WORLD_1 + SEPARATOR + COLLECTIBLES + SEPARATOR + CUP_AND_BALL_2;
		var frozenPop_1 = WORLD_1 + SEPARATOR + COLLECTIBLES + SEPARATOR + FROZEN_POP_1;
		var frozenPop_2 = WORLD_1 + SEPARATOR + COLLECTIBLES + SEPARATOR + FROZEN_POP_2;
		var iceCreamCone_1 = WORLD_1 + SEPARATOR + COLLECTIBLES + SEPARATOR + ICE_CREAM_CONE_1;
		var iceCreamCone_2 = WORLD_1 + SEPARATOR + COLLECTIBLES + SEPARATOR + ICE_CREAM_CONE_2;
		var riceBall_1 = WORLD_1 + SEPARATOR + COLLECTIBLES + SEPARATOR + RICE_BALL_1;
		var riceBall_2 = WORLD_1 + SEPARATOR + COLLECTIBLES + SEPARATOR + RICE_BALL_2;
		
		//PowerUps
		var accelerator_1 = WORLD_1 + SEPARATOR + POWER_UPS + SEPARATOR + ACCELERATOR_1;
		var accelerator_2 = WORLD_1 + SEPARATOR + POWER_UPS + SEPARATOR + ACCELERATOR_2;
		var explosionExpander_1 = WORLD_1 + SEPARATOR + POWER_UPS + SEPARATOR + ACCELERATOR_1;
		var explosionExpander_2 = WORLD_1 + SEPARATOR + POWER_UPS + SEPARATOR + ACCELERATOR_2;
		var extraBomb_1 = WORLD_1 + SEPARATOR + POWER_UPS + SEPARATOR + ACCELERATOR_1;
		var extraBomb_2 = WORLD_1 + SEPARATOR + POWER_UPS + SEPARATOR + ACCELERATOR_2;
		var heart_1 = WORLD_1 + SEPARATOR + POWER_UPS + SEPARATOR + ACCELERATOR_1;
		var heart_2 = WORLD_1 + SEPARATOR + POWER_UPS + SEPARATOR + ACCELERATOR_2;
		var indestructibleArmor_1 = WORLD_1 + SEPARATOR + POWER_UPS + SEPARATOR + ACCELERATOR_1;
		var indestructibleArmor_2 = WORLD_1 + SEPARATOR + POWER_UPS + SEPARATOR + ACCELERATOR_2;
		var remoteControl_1 = WORLD_1 + SEPARATOR + POWER_UPS + SEPARATOR + ACCELERATOR_1;
		var remoteControl_2 = WORLD_1 + SEPARATOR + POWER_UPS + SEPARATOR + ACCELERATOR_2;
		
		var files = new String[][] {new String[] {apple_1, apple_2},
									new String[] {cake_1, cake_2},
									new String[] {cupAndBall_1, cupAndBall_2},
									new String[] {frozenPop_1, frozenPop_2},
									new String[] {iceCreamCone_1, iceCreamCone_2},
									new String[] {riceBall_1, riceBall_2},
									new String[] {accelerator_1, accelerator_2},
									new String[] {explosionExpander_1, explosionExpander_2},
									new String[] {extraBomb_1, extraBomb_2},
									new String[] {heart_1, heart_2},
									new String[] {indestructibleArmor_1, indestructibleArmor_2},
									new String[] {remoteControl_1, remoteControl_2}};
									
		var gfm = new JBGraphicsFileManager();
		
		System.out.println(apple_1);
		System.out.println(apple_2);
		
		var itemsGraphics = gfm.createItemsGraphics(files, JBGameConstants.TILE_SIZE, JBGameConstants.TILE_SIZE);
		
		
		collectiblesAnimations[0] = new JBAnimation(itemsGraphics[0], 6, "Apple");
		collectiblesAnimations[1] = new JBAnimation(itemsGraphics[1], 6, "Cake");
		collectiblesAnimations[2] = new JBAnimation(itemsGraphics[2], 6, "Cup & Ball");
		collectiblesAnimations[3] = new JBAnimation(itemsGraphics[3], 6, "Frozen Pop");
		collectiblesAnimations[4] = new JBAnimation(itemsGraphics[4], 6, "Ice Cream Cone");
		collectiblesAnimations[5] = new JBAnimation(itemsGraphics[5], 6, "Rice Ball");
		
		powerUpsAnimations[0] = new JBAnimation(itemsGraphics[6], 6, "Accelerator");
		powerUpsAnimations[1] = new JBAnimation(itemsGraphics[7], 6, "Explosion Expander");
		powerUpsAnimations[2] = new JBAnimation(itemsGraphics[8], 6, "Extra Bomb");
		powerUpsAnimations[3] = new JBAnimation(itemsGraphics[9], 6, "Heart");
		powerUpsAnimations[4] = new JBAnimation(itemsGraphics[10], 6, "Indestructible Armor");
		powerUpsAnimations[5] = new JBAnimation(itemsGraphics[11], 6, "Remote Control");
	}
}