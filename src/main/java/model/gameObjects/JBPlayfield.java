package model.gameObjects;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import model.game.JBGameConstants;
import model.interfaces.JBIRenderable;

public class JBPlayfield implements JBIRenderable {
	
	private BufferedImage wallGraphics;
	private BufferedImage[][] playFieldGraphics;
	
	private Rectangle unplayableField;
	private Rectangle playableField;
	private Rectangle playfield;
	
	public JBPlayfield(BufferedImage wallGraphics, BufferedImage[][] playFieldGraphics) {
		
		this.wallGraphics = wallGraphics;
		this.playFieldGraphics = playFieldGraphics;
		
		unplayableField = new Rectangle(JBGameConstants.UNPLAYABLE_OFFSET_X, JBGameConstants.UNPLAYABLE_OFFSET_Y, JBGameConstants.UNPLAYABLE_FIELD_WIDTH, JBGameConstants.UNPLAYABLE_FIELD_HEIGHT);
		
		playableField = new Rectangle(JBGameConstants.PLAYABLE_OFFSET_X, JBGameConstants.PLAYABLE_OFFSET_Y, JBGameConstants.PLAYABLE_FIELD_WIDTH, JBGameConstants.PLAYABLE_FIELD_HEIGHT);
			
		playfield = (Rectangle) playableField.createIntersection(unplayableField);
	}
	
	public Rectangle getUnplayableField() {
		
		return unplayableField;
	}

	public Rectangle getPlayableField() {
		
		return playableField;
	}
	
	public Rectangle getPlayfield() {
		
		return playfield;
	}
		
	@Override
	public void render(Graphics2D g2d) {
		
		//Draw level's "borders"
		g2d.drawImage(wallGraphics, JBGameConstants.UNPLAYABLE_OFFSET_X, JBGameConstants.UNPLAYABLE_OFFSET_Y, null);
		
		//Draw level's play field
		for(int row=0; row<JBGameConstants.PLAYABLE_FIELD_ROW; row++) {
			
			for(int col=0; col<JBGameConstants.PLAYABLE_FIELD_COL; col++) {
				
				int worldX = JBGameConstants.PLAYABLE_OFFSET_X + col * JBGameConstants.TILE_SIZE;
				int worldY = JBGameConstants.PLAYABLE_OFFSET_Y + row * JBGameConstants.TILE_SIZE;
				
				g2d.drawImage(playFieldGraphics[row][col], worldX, worldY, null);
			}
		}
	}
	//DEBUG	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Unplayable Field Data:" + '\n');
		sb.append("Offset X: " + unplayableField.x + '\n');
		sb.append("Offset Y: " + unplayableField.y + '\n');
		sb.append("Width: " + unplayableField.width + '\n');
		sb.append("Heigth: " + unplayableField.height + '\n');
		
		sb.append("Playable Field Data:" + '\n');
		sb.append("Offset X: " + playableField.x + '\n');
		sb.append("Offset Y: " + playableField.y + '\n');
		sb.append("Width: " + playableField.width + '\n');
		sb.append("Heigth: " + playableField.height + '\n');
		
		sb.append("Play Field Data:" + '\n');
		sb.append("Offset X: " + playfield.x + '\n');
		sb.append("Offset Y: " + playfield.y + '\n');
		sb.append("Width: " + playfield.width + '\n');
		sb.append("Heigth: " + playfield.height + '\n');
		
		sb.append("Wall Graphics: " + '\n');
		sb.append("Image: " + wallGraphics +  " Width: " + wallGraphics.getWidth() + " Height: " + wallGraphics.getHeight());
		return sb.toString();
	}
}