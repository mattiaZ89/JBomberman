package model.factories;

import java.awt.Point;

import model.animations.JBAnimation;
import model.game.JBGameConstants;
import model.gameObjects.entities.JBPlayer;
import utilities.JBGraphicsFileManager;
/**
 * Factory responsabile della creazione del giocatore (bomberman)
 */
public class JBPlayerFactory extends JBGameObjectFactory<JBPlayer> {
	
	private static JBPlayerFactory instance;
	private JBAnimation[][] playerAnimations = new JBAnimation[1000][4];
	
	public static JBPlayerFactory getInstance() {
		
		if(instance == null) instance = new JBPlayerFactory();
		return instance;
	}
	
	@Override
	public JBPlayer create(int objCode, int row, int col) {
		
		var position = new Point(col * JBGameConstants.TILE_SIZE + JBGameConstants.PLAYABLE_OFFSET_X, row * JBGameConstants.TILE_SIZE + JBGameConstants.PLAYABLE_OFFSET_Y);

		switch(objCode) {
		
			case 150: return new JBPlayer(position, playerAnimations[0]);//Player One
			case 151: return new JBPlayer(position, playerAnimations[1]);//Player Two (not implemented)
		}

		return null;
	}

	@Override
	protected void setUpSubStage1() {
		
		var JBM_1_UP_IDLE = WORLD_1 + SEPARATOR + JBM_1 + SEPARATOR + UP + "_Idle.png";
		var JBM_1_UP_1 = WORLD_1 + SEPARATOR + JBM_1 + SEPARATOR + UP + "_1.png";
		var JBM_1_UP_2 = WORLD_1 + SEPARATOR + JBM_1 + SEPARATOR + UP + "_2.png";
		var JBM_1_DOWN_IDLE = WORLD_1 + SEPARATOR + JBM_1 + SEPARATOR + DOWN + "_Idle.png";
		var JBM_1_DOWN_1 = WORLD_1 + SEPARATOR + JBM_1 + SEPARATOR + DOWN + "_1.png";
		var JBM_1_DOWN_2 = WORLD_1 + SEPARATOR + JBM_1 + SEPARATOR + DOWN + "_2.png";
		var JBM_1_LEFT_IDLE = WORLD_1 + SEPARATOR + JBM_1 + SEPARATOR + LEFT + "_Idle.png";
		var JBM_1_LEFT_1 = WORLD_1 + SEPARATOR + JBM_1 + SEPARATOR + LEFT + "_1.png";
		var JBM_1_LEFT_2 = WORLD_1 + SEPARATOR + JBM_1 + SEPARATOR + LEFT + "_2.png";
		var JBM_1_RIGHT_IDLE = WORLD_1 + SEPARATOR + JBM_1 + SEPARATOR + RIGHT + "_Idle.png";
		var JBM_1_RIGHT_1 = WORLD_1 + SEPARATOR + JBM_1 + SEPARATOR + RIGHT + "_1.png";
		var JBM_1_RIGHT_2 = WORLD_1 + SEPARATOR + JBM_1 + SEPARATOR + RIGHT + "_2.png";
		
		var files1 = new String[][] {new String[] {JBM_1_UP_IDLE, JBM_1_UP_1, JBM_1_UP_2},
									 new String[] {JBM_1_DOWN_IDLE, JBM_1_DOWN_1, JBM_1_DOWN_2},
									 new String[] {JBM_1_LEFT_IDLE, JBM_1_LEFT_1, JBM_1_LEFT_2},
									 new String[] {JBM_1_RIGHT_IDLE, JBM_1_RIGHT_1, JBM_1_RIGHT_2}};
			
		var gfm = new JBGraphicsFileManager();
			
		var playerGraphics = gfm.createJBomberMansGraphics(files1, JBGameConstants.TILE_SIZE, JBGameConstants.TILE_SIZE);
			
		playerAnimations[0][0] = new JBAnimation(playerGraphics[0], 6, "Player Up");
		playerAnimations[0][1] = new JBAnimation(playerGraphics[1], 6, "Player Down");
		playerAnimations[0][2] = new JBAnimation(playerGraphics[2], 6, "Player Left");
		playerAnimations[0][3] = new JBAnimation(playerGraphics[3], 6, "Player Right");
	}

	@Override
	protected void setUpSubStage2() {
		
		setUpSubStage1();
	}

	@Override
	protected void setUpSubStage3() {
		
		setUpSubStage1();
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