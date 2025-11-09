package model.managers;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import model.gameObjects.things.items.JBItem;
import model.gameObjects.things.items.collectibles.JBCollectible;
import model.gameObjects.things.items.collectibles.JBPowerUp;
import model.gameObjects.things.items.equipment.JBBomb;
import model.interfaces.JBIRenderable;
import model.interfaces.JBIUpdatable;
import model.specialFX.JBExplosionFX;
/**
 * Questa classe è responsabile di gestire gli oggetti durante la
 * partita
 */
public class JBItemsManager implements JBIUpdatable, JBIRenderable {
	
	private BufferedImage[] explosionGraphics;
	
	private Queue<JBBomb> bombsPool;
	private Queue<JBBomb> bombs;
	private List<JBCollectible> collectibles;
	private List<JBPowerUp> powerups;
	
	private Queue<JBExplosionFX> explosionsPool;
	private Queue<JBExplosionFX> explosions;
//	private final int INIT_BOMBS_NUMBER = 50;//TODO Use Game Constants
		
	public JBItemsManager(BufferedImage[] bombsGraphics, BufferedImage[] explosionGraphics) {
		
//		this.bombsGraphics = bombsGraphics;
		this.explosionGraphics = explosionGraphics;
		bombs = new LinkedList<>();
		bombsPool = new LinkedList<>();
		explosions = new LinkedList<>();
	}
	
	public JBItemsManager(Queue<JBBomb> bombsPool, List<JBCollectible> collectibles, List<JBPowerUp> powerups) {
		
		this.bombsPool = bombsPool;
		this.collectibles = collectibles;
		this.powerups = powerups;
	}
	
	public JBItemsManager(Queue<JBBomb> bombsPool,  BufferedImage[] explosionGraphics) {
		
		this.bombsPool = bombsPool;
		this.explosionGraphics = explosionGraphics;
		bombs = new LinkedList<>();
		explosions = new LinkedList<>();
		collectibles = new ArrayList<JBCollectible>();
		powerups = new ArrayList<JBPowerUp>();
	}
	
	public JBItemsManager(Queue<JBBomb> bombsPool, Queue<JBExplosionFX> explosionsPool) {
		
		this.bombsPool = bombsPool;
		this.explosionsPool = explosionsPool;
		bombs = new LinkedList<>();
		explosions = new LinkedList<>();
		collectibles = new ArrayList<JBCollectible>();
		powerups = new ArrayList<JBPowerUp>();
	}
	
	public void setBomb(Point position) {
		
		var bomb = bombsPool.poll();
		bomb.setPosition(position);
		bomb.getAnimation().start();
		bombs.add(bomb);
	}
	
	public Queue<JBBomb> getBombs(){
		return bombs;
	}

	public Queue<JBBomb> getBombsPool(){
		return bombsPool;
	}
	
	public void addCollectibles(JBItem item) {
		
		if(item instanceof JBCollectible) {
			
			collectibles.add((JBCollectible)item);
		}
		else if(item instanceof JBPowerUp) {
			
			powerups.add((JBPowerUp)item);
		}
	}
	
	@Override
	public void update() {
		
		if(bombs != null && !bombs.isEmpty()) {
			bombs.forEach(b->b.update());
			
			for(JBBomb bomb : bombs) {
				
				if(bomb.isExploded()) {
					
					bomb.getAnimation().reset();
					explosions.add(new JBExplosionFX(bomb.getPosition(), explosionGraphics));
				}
			}
			
			bombs.removeIf(e -> e.isExploded());
		}
		
		if(explosions != null && !explosions.isEmpty()) {
			
			explosions.forEach(e -> e.update());
			explosions.removeIf(e -> e.isFinished());
		}
	}

	@Override
	public void render(Graphics2D g2d) {
				
		if(bombs != null && !bombs.isEmpty()) {
			
			bombs.forEach(b -> b.render(g2d));
		}
		
		if(explosions != null && !explosions.isEmpty()) {
			
			explosions.forEach(e -> e.render(g2d));
		}
	}
}