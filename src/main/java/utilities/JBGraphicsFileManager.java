package utilities;

import java.awt.image.BufferedImage;

import model.game.JBGameConstants;

public class JBGraphicsFileManager {
	
	private JBGraphicsBuilder gb;
	private BufferedImage singleGraphics;
	private BufferedImage[] vectorGraphics;
	private BufferedImage[][] matrixGraphics;
	
	public JBGraphicsFileManager() {
		
		gb = new JBGraphicsBuilder();
	}
	
	private void createGraphics(String path, int imageWidth, int imageHeight) {
		
		singleGraphics = gb.setFilePath(path)
						   .setImageDimension(imageWidth, imageHeight)
						   .createSingleGraphics()
						   .buildSingleGraphics();
	}
	
	private void createGraphics(String[] path, int imageWidth, int imageHeight) {
		
		vectorGraphics = gb.setFilePath(path)
							 .setImageDimension(imageWidth, imageHeight)
							 .createVectorGraphics()
							 .buildVectorGraphics();
	}
	
	private void createGraphics(String[][] path, int imageWidth, int imageHeight) {
		
		matrixGraphics = gb.setFilePath(path)
							 .setImageDimension(imageWidth, imageHeight)
							 .createMatrixGraphics()
							 .buildMatrixGraphics();
	}
	
	public BufferedImage createWallGraphics(String path, int imageWidth, int imageHeight) {
		
		createGraphics(path, imageWidth, imageHeight);
		return singleGraphics;
		
//		var wallGraphics = gb.setFilePath("/worlds/world_1/walls/Walls.png")
//							 .setImageDimension(272*3, 208*3)
//							 .buildSingleGraphics();
	}
	
	public BufferedImage[] createEndPadGraphics(String[] path, int imageWidth, int imageHeight) {
		
		createGraphics(path, imageWidth, imageHeight);
		return vectorGraphics;
	}
	
	public BufferedImage[][] createPlayFieldGraphics(String path, int imageWidth, int imageHeight) {
		
		createGraphics(path, imageWidth, imageHeight);
		
//		var img = gb.setFilePath("/worlds/world_1/ground/Ground_1.png")
//				 	.setImageDimension(JBGameConstants.TILE_SIZE, JBGameConstants.TILE_SIZE)
//				 	.buildSingleGraphics();
		
//		var playFieldGraphics = new BufferedImage[JBGameConstants.PLAYABLE_FIELD_ROW][JBGameConstants.PLAYABLE_FIELD_COL];
		
		matrixGraphics = new BufferedImage[JBGameConstants.PLAYABLE_FIELD_ROW][JBGameConstants.PLAYABLE_FIELD_COL];
		
		for(int row=0; row<JBGameConstants.PLAYABLE_FIELD_ROW; row++) {
			
			for(int col=0; col<JBGameConstants.PLAYABLE_FIELD_COL; col++) {
				
				matrixGraphics[row][col] = singleGraphics;
			}
		}
		
		return matrixGraphics;
	}
	
	public BufferedImage[] createIndistructiblesObstaclesGraphics(String path, int imageWidth, int imageHeight) {
		
		createGraphics(path, imageWidth, imageHeight);
		
		vectorGraphics = new BufferedImage[] {singleGraphics};
		
		return vectorGraphics;
	}
	
	public BufferedImage[] createDistructiblesObstaclesGraphics(String[] path, int imageWidth, int imageHeight) {
		
		createGraphics(path, imageWidth, imageHeight);
		return vectorGraphics;
	}
	
	public void createObstaclesGraphics() {
		
		var indObstacle1 = gb.setFilePath("/worlds/world_1/obstacles/undestroyable/Obstacle_1.png")
			 				 .setImageDimension(JBGameConstants.TILE_SIZE, JBGameConstants.TILE_SIZE)
			 				 .buildSingleGraphics();
		
		
		var desObstacle = gb.setFilePath(new String[] {"/worlds/world_1/obstacles/destroyable/Obstacle_5.png",
													   "/worlds/world_1/obstacles/destroyable/Obstacle_6.png",
													   "/worlds/world_1/obstacles/destroyable/Obstacle_7.png",
													   "/worlds/world_1/obstacles/destroyable/Obstacle_8.png"})
							.setImageDimension(JBGameConstants.TILE_SIZE, JBGameConstants.TILE_SIZE)
							.buildVectorGraphics();
	}
	
	public BufferedImage[][] createEnemiesGraphics(String[][] path, int imageWidth, int imageHeight) {
		
		
		createGraphics(path, imageWidth, imageHeight);
		
//		var enemy = gb.setFilePath(new String[][]{new String[] {"/worlds/world_1/enemies/Enemy_1/Enemy_Up_1.png","/worlds/world_1/enemies/Enemy_1/Enemy_Up_2.png","/worlds/world_1/enemies/Enemy_1/Enemy_Up_3.png","/worlds/world_1/enemies/Enemy_1/Enemy_Up_4.png"},
//												new String[] {"/worlds/world_1/enemies/Enemy_1/Enemy_Down_1.png","/worlds/world_1/enemies/Enemy_1/Enemy_Down_2.png","/worlds/world_1/enemies/Enemy_1/Enemy_Down_3.png","/worlds/world_1/enemies/Enemy_1/Enemy_Down_4.png"},
//												new String[] {"/worlds/world_1/enemies/Enemy_1/Enemy_Left_1.png","/worlds/world_1/enemies/Enemy_1/Enemy_Left_2.png","/worlds/world_1/enemies/Enemy_1/Enemy_Left_3.png","/worlds/world_1/enemies/Enemy_1/Enemy_Left_4.png"},
//												new String[] {"/worlds/world_1/enemies/Enemy_1/Enemy_Right_1.png","/worlds/world_1/enemies/Enemy_1/Enemy_Right_2.png","/worlds/world_1/enemies/Enemy_1/Enemy_Right_3.png","/worlds/world_1/enemies/Enemy_1/Enemy_Right_4.png"}})
//					  .setImageDimension(JBGameConstants.TILE_SIZE, JBGameConstants.TILE_SIZE)
//					  .buildMatrixGraphics();
		
		return matrixGraphics;
	}
	
	public BufferedImage[][] createItemsGraphics(String[][] path, int imageWidth, int imageHeight) {
		
		
		createGraphics(path, imageWidth, imageHeight);
		
		return matrixGraphics;
	}
	
	public BufferedImage[][] createJBomberMansGraphics(String[][] path, int imageWidth, int imageHeight) {
		
		createGraphics(path, imageWidth, imageHeight);
		
//		var player = gb.setFilePath(new String[][]{new String[] {"/worlds/world_1/jbombermans/jbm_1/Up_Idle.png","/worlds/world_1/jbombermans/jbm_1/Up_1.png","/worlds/world_1/jbombermans/jbm_1/Up_2.png"},
//												   new String[] {"/worlds/world_1/jbombermans/jbm_1/Down_Idle.png","/worlds/world_1/jbombermans/jbm_1/Down_1.png","/worlds/world_1/jbombermans/jbm_1/Down_2.png"},
//												   new String[] {"/worlds/world_1/jbombermans/jbm_1/Left_Idle.png","/worlds/world_1/jbombermans/jbm_1/Left_1.png","/worlds/world_1/jbombermans/jbm_1/Left_2.png"},
//												   new String[] {"/worlds/world_1/jbombermans/jbm_1/Right_Idle.png","/worlds/world_1/jbombermans/jbm_1/Right_1.png","/worlds/world_1/jbombermans/jbm_1/Right_2.png"}})
//					   .setImageDimension(JBGameConstants.TILE_SIZE, JBGameConstants.TILE_SIZE)
//					   .buildMatrixGraphics();
		
		return matrixGraphics;
	}
	
	public BufferedImage[] createBombsGraphics(String[] path, int imageWidth, int imageHeight) {
		
//		var bomb = gb.setFilePath(new String[] {"/worlds/world_1/items/equipment/Bomb_1.png",
//												"/worlds/world_1/items/equipment/Bomb_2.png",
//												"/worlds/world_1/items/equipment/Bomb_3.png"})
//					 .setImageDimension(JBGameConstants.TILE_SIZE, JBGameConstants.TILE_SIZE)
//					 .buildVectorGraphics();
		
		createGraphics(path, imageWidth, imageHeight);
		return vectorGraphics;
		
//		var bombsExplosion = gb.setFilePath(new String[] {"/specialFX/Explosion_1.png",
//														  "/specialFX/Explosion_2.png",
//														  "/specialFX/Explosion_3.png",
//														  "/specialFX/Explosion_4.png",
//														  "/specialFX/Explosion_5.png",
//														  "/specialFX/Explosion_4.png",
//														  "/specialFX/Explosion_3.png",
//														  "/specialFX/Explosion_2.png",
//														  "/specialFX/Explosion_1.png"})
//							   .setImageDimension(JBGameConstants.TILE_SIZE, JBGameConstants.TILE_SIZE)
//							   .buildVectorGraphics();
	}
	
	public BufferedImage[] createExplosionGraphics(String[] path, int imageWidth, int imageHeight) {
		
//		var bomb = gb.setFilePath(new String[] {"/worlds/world_1/items/equipment/Bomb_1.png",
//												"/worlds/world_1/items/equipment/Bomb_2.png",
//												"/worlds/world_1/items/equipment/Bomb_3.png"})
//					 .setImageDimension(JBGameConstants.TILE_SIZE, JBGameConstants.TILE_SIZE)
//					 .buildVectorGraphics();
		
		createGraphics(path, imageWidth, imageHeight);
		return vectorGraphics;
		
//		var bombsExplosion = gb.setFilePath(new String[] {"/specialFX/Explosion_1.png",
//														  "/specialFX/Explosion_2.png",
//														  "/specialFX/Explosion_3.png",
//														  "/specialFX/Explosion_4.png",
//														  "/specialFX/Explosion_5.png",
//														  "/specialFX/Explosion_4.png",
//														  "/specialFX/Explosion_3.png",
//														  "/specialFX/Explosion_2.png",
//														  "/specialFX/Explosion_1.png"})
//							   .setImageDimension(JBGameConstants.TILE_SIZE, JBGameConstants.TILE_SIZE)
//							   .buildVectorGraphics();
	}
	
	public BufferedImage[][] createCollectiblesGraphics(String[][] path, int imageWidth, int imageHeight) {
		
		createGraphics(path, imageWidth, imageHeight);
		return matrixGraphics;
	}
}