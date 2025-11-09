package model.game;

public final class JBGameConstants {
	
	/*
	 *	Map dimensions:
	 *	SNES uses resolution between 256x224 and 512x448
	 *	Resolution 256x224 --> Grid(30, 28) Tile 8x8px
	 *	Resolution 512x448 --> Grid(30, 28) Tile 16x16px
	 *
	 *	Searching on the Internet I've found that the Bomberman Game has a
	 *	play field dimension of 13x11 matrix (13 rows and 11 columns) while
	 *	the total game dimension (play field plus border and user interface panel)
	 *	is a 17x17 matrix.
	 *
	 *	For this game I choose:
	 *	 - a tile dimension of 16pixel and scale it at 48pixel
	 *	 - a screen size of Dimension(816x816) pixel
	 *	 - a 17x17 matrix for entire game window
	 *	 - a 4x17  matrix for user interface panel
	 *	 - a 13x11 matrix for play field
	 *	
	 *
	 */
	
	//IMAGE DIMENSION
	public final static int ORIGINAL_TILE_SIZE = 16; //16x16 is a kind of standard size for many retrò 2D game style -> player character, NPC
	public final static int SCALE = 3;
	public final static int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE;//48x48 tile
	
	//SCREEN SETTINGS
	public final static int MAX_SCREEN_COL = 17;
	public final static int MAX_SCREEN_ROW = 15;
	public final static int SCREEN_WIDTH = TILE_SIZE * MAX_SCREEN_COL;//816 pixels
	public final static int SCREEN_HEIGHT = TILE_SIZE * MAX_SCREEN_ROW;//720 pixels
	
	//UI SETTINGS
	public final static int MAX_UI_COL = 17;
	public final static int MAX_UI_ROW = 2;
	public final static int UI_WIDTH = TILE_SIZE * MAX_UI_COL;
	public final static int UI_HEIGHT = TILE_SIZE * MAX_UI_ROW;
	public final static int UI_CELL_WIDTH = TILE_SIZE/2;
		
	//WORLD SETTINGS
	public final static int WALL_WIDTH = 272*3;
	public final static int WALL_HEIGHT = 208*3;
	
	public final static int UNPLAYABLE_FIELD_COL = 17;
	public final static int UNPLAYABLE_FIELD_ROW = 13;
	public final static int UNPLAYABLE_OFFSET_X = 0;
	public final static int UNPLAYABLE_OFFSET_Y = TILE_SIZE * 2;
	public final static int UNPLAYABLE_FIELD_WIDTH = TILE_SIZE * UNPLAYABLE_FIELD_COL;
	public final static int UNPLAYABLE_FIELD_HEIGHT = TILE_SIZE * UNPLAYABLE_FIELD_ROW;
		
	public final static int PLAYABLE_FIELD_COL = 13;
	public final static int PLAYABLE_FIELD_ROW = 11;
	public final static int PLAYABLE_OFFSET_X = TILE_SIZE * 2;
	public final static int PLAYABLE_OFFSET_Y = TILE_SIZE * 3;
	public final static int PLAYABLE_FIELD_WIDTH = TILE_SIZE * PLAYABLE_FIELD_COL;
	public final static int PLAYABLE_FIELD_HEIGHT = TILE_SIZE * PLAYABLE_FIELD_ROW;
		
	//FPS
	public final static int FPS = 60;
	public final static int NANOSECONDS_IN_ONE_SECOND = 1_000_000_000;
	
	//ENTITY SETTINGS
	public final static byte MOVE_WALK_UP = 0;
	public final static byte MOVE_WALK_DOWN = 1;
	public final static byte MOVE_WALK_LEFT = 2;
	public final static byte MOVE_WALK_RIGHT = 3;
	
	//PLAYER SETTINGS
	public final static int PLAYER_SPEED = 3;
	public final static int PLAYER_BOMBS = 25;
	
	//ENEMY
	public final static int ENEMY_SPEED = 2;
	
	//ENEMY AI
	public final static int MAX_CHANGE_DIR_COUNTER = 2;
	
	//POOLS SETTINGS
	public final static int BOMBS_POOL_SIZE = 20;
}