package utilities;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class JBGraphicsBuilder {
	
	private String filePath;
	private String[] filePathVector;
	private String[][] filePathMatrix;
	private int imageWidth, imageHeight;
	private BufferedImage singleGraphics;
	private BufferedImage[] vectorGraphics;
	private BufferedImage[][] matrixGraphics;
	
	public JBGraphicsBuilder setFilePath(String filePath) {
		
		this.filePath = filePath;
		return this;
	}
	
	public JBGraphicsBuilder setFilePath(String[] filePathVector) {
		
		this.filePathVector = filePathVector;
		return this;
	}
	
	public JBGraphicsBuilder setFilePath(String[][] filePathMatrix) {
		
		this.filePathMatrix = filePathMatrix;
		return this;
	}
	
	public JBGraphicsBuilder setImageDimension(int imageWidth, int imageHeight) {
		
		this.imageWidth = imageWidth;
		this.imageHeight = imageHeight;
		return this;
	}
	
	public JBGraphicsBuilder createSingleGraphics() {
		
		singleGraphics = setUp(filePath, imageWidth, imageHeight);
		return this;
	}
	
	public JBGraphicsBuilder createVectorGraphics() {
		
		vectorGraphics = new BufferedImage[filePathVector.length];
		
		for(int i=0; i<filePathVector.length; i++) {
			
			vectorGraphics[i] = setUp(filePathVector[i], imageWidth, imageHeight);
		}
				
		return this;
	}
	
	public JBGraphicsBuilder createMatrixGraphics() {
		
		matrixGraphics = new BufferedImage[filePathMatrix.length][filePathMatrix[0].length];
		
		for(int i=0; i<filePathMatrix.length; i++) {
			
			for(int j=0; j<filePathMatrix[i].length; j++) {
				
				matrixGraphics[i][j] = setUp(filePathMatrix[i][j], imageWidth, imageHeight);
			}
		}
		
		return this;
	}
	
	public BufferedImage buildSingleGraphics() {
		
		return singleGraphics;
	}
	
	public BufferedImage[] buildVectorGraphics() {
		
		return vectorGraphics;
	}
	
	public BufferedImage[][] buildMatrixGraphics(){
		
//		for(int i=0; i<filePathMatrix.length; i++) {
//			
//			for(int j=0; j<filePathMatrix[i].length; j++) {
//				
//				System.out.println(matrixGraphics[i][j]);
//			}
//		}
		
		return matrixGraphics;
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
}