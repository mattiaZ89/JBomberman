package model.factories;

import java.awt.Point;
import java.awt.image.BufferedImage;

import model.animations.JBAnimation;
import model.animations.JBAnimationOneShot;
import model.game.JBGameConstants;
import model.gameObjects.things.items.equipment.JBBomb;
import model.gameObjects.things.items.equipment.JBEquipment;
import model.gameObjects.things.items.equipment.JBEquipmentType;
import utilities.JBGraphicsFileManager;
import model.specialFX.JBExplosionFX;
/**
 * Factory responsabile della creazione degli oggetti
 */
public class JBItemsFactory extends JBGameObjectFactory<JBEquipment> {
	
	private static JBItemsFactory instance;
	
	private JBAnimation[] bombsAnimations = new JBAnimation[1];
	private JBAnimationOneShot[] explosionAnimations = new JBAnimationOneShot[1];
	
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
		
		setBombsPath();
	}
	
	public static JBItemsFactory getInstance() {
		
		if(instance == null) instance = new JBItemsFactory();
		return instance;
	}
	
	public JBBomb createBomb() {
		
		return new JBBomb(bombsAnimations[0], JBEquipmentType.BOMB);
	}
	
	public JBExplosionFX createExplosion() {
		
		return new JBExplosionFX(explosionAnimations[0]);
	}
	
	@Override
	public JBEquipment create(int objCode, int row, int col) {
		
		var position = new Point(col * JBGameConstants.TILE_SIZE + JBGameConstants.PLAYABLE_OFFSET_X, row * JBGameConstants.TILE_SIZE + JBGameConstants.PLAYABLE_OFFSET_Y);
		
		switch(objCode) {
		
			//Equipment
			case 0, 1, 2, 3, 4, 5, 6, 7, 8, 9: return new JBBomb(bombsAnimations[0], JBEquipmentType.BOMB);
			//Collectibles
//			case 10: return new JBCollectible(10, position, collectiblesAnimations[0]);
//			case 11: return new JBCollectible(20, position, collectiblesAnimations[1]);
//			case 12: return new JBCollectible(30, position, collectiblesAnimations[2]);
//			case 13: return new JBCollectible(40, position, collectiblesAnimations[3]);
//			case 14: return new JBCollectible(50, position, collectiblesAnimations[4]);
//			case 15: return new JBCollectible(60, position, collectiblesAnimations[5]);
			case 16:
			case 17:
			case 18:
			case 19:
			//Powerups
//			case 20: return new JBPowerUp(null, position, powerUpsAnimations[0]);
//			case 21: return new JBPowerUp(null, position, powerUpsAnimations[1]);
//			case 22: return new JBPowerUp(null, position, powerUpsAnimations[2]);
//			case 23: return new JBPowerUp(null, position, powerUpsAnimations[3]);
//			case 24: return new JBPowerUp(null, position, powerUpsAnimations[4]);
//			case 25: return new JBPowerUp(null, position, powerUpsAnimations[5]);
			case 26:
			case 27:
			case 28:
			case 29:
			case 30:
			case 31:
			case 32:
			case 33:
			case 34:
			case 35:
			case 36:
			case 37:
			case 38:
			case 39:
			case 40:
		}
		
		return null;
	}
	
	private void setBombsPath() {
		
		var files = new String[] {BOMB_1, BOMB_2, BOMB_3};
		
		var bombsGraphics = new JBGraphicsFileManager().createBombsGraphics(files, JBGameConstants.TILE_SIZE, JBGameConstants.TILE_SIZE);
		
		bombsAnimations[0] = new JBAnimation(bombsGraphics, 6, "BOMB");
		
		files = new String[]{EXPLOSION_1, EXPLOSION_2, EXPLOSION_3, EXPLOSION_4, EXPLOSION_5, EXPLOSION_4, EXPLOSION_3, EXPLOSION_2, EXPLOSION_1};
		
		var explosionGraphics = new JBGraphicsFileManager().createExplosionGraphics(files, JBGameConstants.TILE_SIZE, JBGameConstants.TILE_SIZE);
		
		explosionAnimations[0] = new JBAnimationOneShot(explosionGraphics, 6, "EXPLOSION");
	}
	
	public BufferedImage[] getExplosionGraphics() {
		
		var files = new String[]{EXPLOSION_1, EXPLOSION_2, EXPLOSION_3, EXPLOSION_4, EXPLOSION_5, EXPLOSION_4, EXPLOSION_3, EXPLOSION_2, EXPLOSION_1};
		return new JBGraphicsFileManager().createExplosionGraphics(files, JBGameConstants.TILE_SIZE, JBGameConstants.TILE_SIZE);
	}

	@Override
	protected void setUpSubStage1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setUpSubStage2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setUpSubStage3() {
		// TODO Auto-generated method stub
		
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