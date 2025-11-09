package model.managers;

import java.awt.Graphics2D;
import java.util.List;
import model.gameObjects.entities.JBEnemy;
import model.interfaces.JBIRenderable;
import model.interfaces.JBIUpdatable;
/**
 * Questa classe è responsabile di gestire i nemici durante la
 * partita
 */
public class JBEnemiesManager implements JBIUpdatable, JBIRenderable {
	
	private List<JBEnemy> enemies;
	
	public JBEnemiesManager(List<JBEnemy> enemies) {
		
		this.enemies = enemies;
	}
	
	public List<JBEnemy> getEnemies(){
		return enemies;
	}

	@Override
	public void update() {
		
		if(enemies != null && !enemies.isEmpty()) {
			enemies.forEach(e->e.update());
			enemies.removeIf(e -> !e.isAlive());
		}
	}

	@Override
	public void render(Graphics2D g2d) {
		
		if(enemies != null && !enemies.isEmpty()) {
			
			enemies.forEach(r -> r.render(g2d));
		}
	}
}