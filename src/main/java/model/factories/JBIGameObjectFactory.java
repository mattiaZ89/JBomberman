package model.factories;

import model.gameObjects.JBGameObject;

/**
 * Interfaccia generica per le factory del programma.
 * Tutte le factory responsabili di creare parti del gioco la implementano.
 * @param <T> Si impone la condizione che il tipo sia un GameObject
 */
public interface JBIGameObjectFactory<T extends JBGameObject> {
		
	T create(int objCode, int row, int col);
	
//	protected static final String SEPARATOR = FileSystems.getDefault().getSeparator();
	static final String SEPARATOR = "/";
	
	
	//DIRECTORIES
	
	//Stages
	static final String STAGES = SEPARATOR + "stages";
//	static String MAP = "";
	
	//Worlds
	static final String WORLDS = SEPARATOR + "worlds";
	static final String WORLD_1 = WORLDS + SEPARATOR + "world_1";
	static final String WORLD_2 = WORLDS + SEPARATOR + "world_2";
	static final String WORLD_3 = WORLDS + SEPARATOR + "world_3";
	static final String WORLD_4 = WORLDS + SEPARATOR + "world_4";
	
	//Enemies	
	static final String ENEMIES = "enemies";
	static final String ENEMY_1 = ENEMIES + SEPARATOR + "Enemy_1";
	static final String ENEMY_2 = ENEMIES + SEPARATOR + "Enemy_2";
	static final String ENEMY_3 = ENEMIES + SEPARATOR + "Enemy_3";
	static final String ENEMY_4 = ENEMIES + SEPARATOR + "Enemy_4";
	
	//Items
	static final String ITEMS = "items";
	static final String COLLECTIBLES = ITEMS + SEPARATOR + "collectibles";
	static final String EQUIPMENT = ITEMS + SEPARATOR + "equipment";
	static final String POWER_UPS = ITEMS + SEPARATOR + "powerups";
	
	//JBombermans
	static final String JBOMBERMANS = "jbombermans";
	static final String JBM_1 = JBOMBERMANS + SEPARATOR + "jbm_1";
	static final String JBM_2 = JBOMBERMANS + SEPARATOR + "jbm_2";
	static final String JBM_3 = JBOMBERMANS + SEPARATOR + "jbm_3";
	static final String JBM_4 = JBOMBERMANS + SEPARATOR + "jbm_4";
	
	//Obstacles
	static final String OBSTACLES = "obstacles";
	static final String DIS_OBSTACLES = OBSTACLES + SEPARATOR + "distructibles";
	static final String IND_OBSTACLES = OBSTACLES + SEPARATOR + "indistructibles";
	static final String END_PADS = OBSTACLES + SEPARATOR + "endpads";
	static final String DIS_OBSTACLE_1 = DIS_OBSTACLES + SEPARATOR + "Obstacle_1";
	static final String DIS_OBSTACLE_2 = DIS_OBSTACLES + SEPARATOR + "Obstacle_2";
	static final String IND_OBSTACLE_1 = IND_OBSTACLES + SEPARATOR + "Obstacle_1";
	static final String IND_OBSTACLE_2 = IND_OBSTACLES + SEPARATOR + "Obstacle_2";
	
	//Playfields
	static final String PLAYFIELDS = "playfields";
	
	//Walls
	static final String WALLS = "walls";
	
	//Special Effects
	static final String SPECIAL_FX = "specialFX";
	
	//Sounds
	static final String SOUNDS = "sounds";
	
	//FILES
	static final String UP = "Up";
	static final String DOWN = "Down";
	static final String LEFT = "Left";
	static final String RIGHT = "Right";
	static final String IDLE = "Idle";
	static final String UP1 = "Up_1.png";
	static final String UP2 = "Up_2.png";
	static final String UP3 = "Up_3.png";
	static final String UP4 = "Up_4.png";
	static final String UP5 = "Up_4.png";
	static final String UP6 = "Up_4.png";
	static final String UP7 = "Up_4.png";
	static final String UP8 = "Up_4.png";
	static final String UP9 = "Up_4.png";
	static final String UP10 = "Up_4.png";
	static final String DOWN1 = "Down_1.png";
	static final String DOWN2 = "Down_2.png";
	static final String DOWN3 = "Down_3.png";
	static final String DOWN4 = "Down_4.png";
	static final String DOWN5 = "Down_4.png";
	static final String DOWN6 = "Down_4.png";
	static final String DOWN7 = "Down_4.png";
	static final String DOWN8 = "Down_4.png";
	static final String DOWN9 = "Down_4.png";
	static final String DOWN10 = "Down_4.png";
	static final String LEFT1 = "Left_1.png";
	static final String LEFT2 = "Left_2.png";
	static final String LEFT3 = "Left_3.png";
	static final String LEFT4 = "Left_4.png";
	static final String LEFT5 = "Left_4.png";
	static final String LEFT6 = "Left_4.png";
	static final String LEFT7 = "Left_4.png";
	static final String LEFT8 = "Left_4.png";
	static final String LEFT9 = "Left_4.png";
	static final String LEFT10 = "Left_4.png";
	static final String RIGHT1 = "Right_1.png";
	static final String RIGHT2 = "Right_2.png";
	static final String RIGHT3 = "Right_3.png";
	static final String RIGHT4 = "Right_4.png";
	static final String RIGHT5 = "Right_4.png";
	static final String RIGHT6 = "Right_4.png";
	static final String RIGHT7 = "Right_4.png";
	static final String RIGHT8 = "Right_4.png";
	static final String RIGHT9 = "Right_4.png";
	static final String RIGHT10 = "Right_4.png";
	static final String MOVE1 = "Move_1.png";
	static final String MOVE2 = "Move_2.png";
	static final String MOVE3 = "Move_3.png";
	static final String MOVE4 = "Move_4.png";
	static final String MOVE5 = "Move_5.png";
	static final String MOVE6 = "Move_6.png";
	static final String ATTACK = "Attack.png";
	static final String PNG = ".png";
	
	static final String OBSTACLE_1 = "Obstacle_1.png";
	static final String OBSTACLE_2 = "Obstacle_2.png";
	static final String OBSTACLE_3 = "Obstacle_3.png";
	static final String OBSTACLE_4 = "Obstacle_4.png";
	static final String END_PAD_1 = "EndPad_1.png";
	static final String END_PAD_2 = "EndPad_2.png";
	
	static final String WALL_1 = "Wall_1.png";
	static final String WALL_2 = "Wall_2.png";
	
	static final String PLAYFIELD_0 = "Ground_0.png";
	static final String PLAYFIELD_1 = "Ground_1.png";
	static final String PLAYFIELD_2 = "Ground_2.png";
	
	static final String APPLE_1 = "Apple_1.png";
	static final String APPLE_2 = "Apple_2.png";
	static final String CAKE_1 = "Cake_1.png";
	static final String CAKE_2 = "Cake_2.png";
	static final String CUP_AND_BALL_1 = "CupAndBall_1.png";
	static final String CUP_AND_BALL_2 = "CupAndBall_2.png";
	static final String FROZEN_POP_1 = "FrozenPop_1.png";
	static final String FROZEN_POP_2 = "FrozenPop_2.png";
	static final String ICE_CREAM_CONE_1 = "IceCreamCone_1.png";
	static final String ICE_CREAM_CONE_2 = "IceCreamCone_2.png";
	static final String RICE_BALL_1 = "RiceBall_1.png";
	static final String RICE_BALL_2 = "RiceBall_2.png";
	
	static final String ACCELERATOR_1 = "Accelerator_1.png";
	static final String ACCELERATOR_2 = "Accelerator_2.png";
	static final String EXPLOSION_EXPANDER_1 = "ExplosionExpander_1.png";
	static final String EXPLOSION_EXPANDER_2 = "ExplosionExpander_2.png";
	static final String EXTRA_BOMB_1 = "ExtraBomb_1.png";
	static final String EXTRA_BOMB_2 = "ExtraBomb_2.png";
	static final String HEART_1 = "Heart_1.png";
	static final String HEART_2 = "Heart_2.png";
	static final String INDESTRUCTIBLE_ARMOR_1 = "IndestructibleArmor_1.png";
	static final String INDESTRUCTIBLE_ARMOR_2 = "IndestructibleArmor_2.png";
	static final String REMOTE_CONTROL_1 = "RemoteControl_1.png";
	static final String REMOTE_CONTROL_2 = "RemoteControl_2.png";
}