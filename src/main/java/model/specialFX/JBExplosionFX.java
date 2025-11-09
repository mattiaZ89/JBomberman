package model.specialFX;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

import model.animations.JBAnimationOneShot;
import model.game.JBGameConstants;
import model.interfaces.JBIRenderable;
import model.interfaces.JBIUpdatable;

public class JBExplosionFX implements JBIUpdatable, JBIRenderable {
	
	private final JBAnimationOneShot explosionAnimation;
	private Point position;
	private static final int SIZE = JBGameConstants.TILE_SIZE*5;
	private static final int OFFSET = JBGameConstants.TILE_SIZE*2;
	
	
	public JBExplosionFX(Point position, BufferedImage[] explosionGraphics) {
		
		this.position = position;
		if(explosionGraphics == null) System.out.println("CAZZO");
		explosionAnimation = new JBAnimationOneShot(explosionGraphics, 3, "EXPLOSION");
	}
	
	public JBExplosionFX(JBAnimationOneShot explosionAnimation) {
			
		this.explosionAnimation = explosionAnimation;
	}
	
	public void setPosition(Point position) {
		
		this.position = position;
	}
	
	public boolean isFinished() {
		
		return explosionAnimation.isFinished();
	}
	
	public BufferedImage getGraphics() {
		
		return explosionAnimation.getSprite();
	}
	
	public JBAnimationOneShot getAnimation() {
		
		return explosionAnimation;
	}
	
	public Point getPosition() {
		
		return position;
	}
	
	@Override
	public void update() {
		
		explosionAnimation.update();
	}
	
	@Override
	public void render(Graphics2D g2d) {
		
		g2d.drawImage(explosionAnimation.getSprite(), position.x, position.y, JBGameConstants.TILE_SIZE, JBGameConstants.TILE_SIZE, null);
		
		g2d.drawImage(explosionAnimation.getSprite(), position.x-OFFSET, position.y-OFFSET, SIZE, SIZE, null);
	}
}