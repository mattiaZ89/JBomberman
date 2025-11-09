package utilities;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import model.game.JBGameConstants;

public class JBFileManager {
	
	/**
	 * 10 = Ground
	 * 11 = Indestructible Obstacles
	 * 12 = Destructible Obstacles
	 * 13 = Destructible Obstacles with Collectible
	 * 14 = Destructible Obstacles with PowerUp
	 * 15 = Player 1 (Starting Point 1)
	 * 16 = Player 2 (Starting Point 2)
	 * 17 = Enemy
	 * 18 = Enemy with Collectible
	 * 19 = Enemy with PowerUp
	 * 99 = Exit (End Level)
	 */
	
	private int levelMap[][];
	
	//TODO JBFileManager Class's Improvement
	private String filePath;
	private int imageWidth, imageHeight;
	private BufferedImage singleGraphics;
	private BufferedImage[] vectorGraphics;
	private BufferedImage[][] matrixGraphics;
	
	public void loadMap(String filePath) {
		
		int maxRow = JBGameConstants.PLAYABLE_FIELD_ROW;
		int maxCol = JBGameConstants.PLAYABLE_FIELD_COL;
		
		levelMap = new int[maxRow][maxCol];
		
		try {
			
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			for(int row=0; row<maxRow; row++) {
				
				String line = br.readLine();
				String numbers[] = line.split(" ");
				
				for(int col=0; col<maxCol; col++) {
					
//					for(String num : numbers)
//						System.out.print(num + " ");
					
//					System.out.println("PAUSE");
					
					int num = Integer.parseInt(numbers[col]);
					
					levelMap[row][col] = num;
				}
			}
			br.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//DEBUG
//		for(int row=0; row<maxRow; row++)
//			for(int col=0; col<maxCol;col++) {
//				
//				if(col < maxCol-1)
//					System.out.print(levelMap[row][col]);
//				else
//					System.out.println(levelMap[row][col]);
//			}
				
	}
	
	//****************************************************************************************
	//TODO JBFileManager Class's Improvement
	public JBFileManager setFilePath(String filePath) {
		
		this.filePath = filePath;
		return this;
	}
	
	public JBFileManager setImageDimension(int imageWidth, int imageHeight) {
		
		this.imageWidth = imageWidth;
		this.imageHeight = imageHeight;
		return this;
	}
	
	public JBFileManager createSingleGraphics() {
		
		singleGraphics = setUp(filePath, imageWidth, imageHeight);
		
		return this;
	}
	
	public JBFileManager createVectorGraphics() {
				
		var image1 = setUp(filePath, imageWidth, imageHeight);
		var image2 = setUp(filePath, imageWidth, imageHeight);
		var image3 = setUp(filePath, imageWidth, imageHeight);
		var image4 = setUp(filePath, imageWidth, imageHeight);
		
		vectorGraphics = new BufferedImage[]{image1, image2, image3, image4};
		
		return this;
	}
	
	public JBFileManager createMatrixGraphics() {
		
		var vector0 = getVectorGraphics();
		var vector1 = getVectorGraphics();
		var vector2 = getVectorGraphics();
		var vector3 = getVectorGraphics();
		
		matrixGraphics[0] = vector0;
		matrixGraphics[1] = vector1;
		matrixGraphics[2] = vector2;
		matrixGraphics[3] = vector3;
		
		return this;
	}
	
	public BufferedImage getSingleGraphics() {
		
		return singleGraphics;
	}
	
	public BufferedImage[] getVectorGraphics() {
		
		return vectorGraphics;
	}
	
	public BufferedImage[][] getMatrixGraphics(){
		
		return matrixGraphics;
	}
	

	

	
	public int[][] getLevelMap(){
		
		return levelMap;
	}
	
	private BufferedImage setUp(String imagePath, int width, int height) {
		
		BufferedImage image = null;
		
		try {
			
			image = ImageIO.read(getClass().getResourceAsStream(imagePath));
			image = scaleImage(image, width, height);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return image;
	}
	
	private BufferedImage scaleImage(BufferedImage original, int width, int height) {
		
		BufferedImage scaledImage = new BufferedImage(width, height, original.getType());
		Graphics2D g2d = scaledImage.createGraphics();
		g2d.drawImage(original, 0, 0, width, height, null);
		g2d.dispose();
		
		return scaledImage;
	}
	
	//DEBUG TO DELETE
	public void printLevel() {
		
		int maxRow = JBGameConstants.PLAYABLE_FIELD_ROW;
		int maxCol = JBGameConstants.PLAYABLE_FIELD_COL;
		
		for(int row=0; row<maxRow; row++) {
			
			for(int col=0; col<maxCol; col++) {
				
				if(col < maxCol-1) {
					
					System.out.print(levelMap[row][col] + " ");
				}
					
				else {
					
					System.out.println(levelMap[row][col]);
				}
			}
		}
	}
}