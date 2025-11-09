package model.managers;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.gameObjects.JBPlayfield;
import model.gameObjects.things.obstacles.JBDestructibleObstacle;
import model.gameObjects.things.obstacles.JBEndPad;
import model.gameObjects.things.obstacles.JBIndestructibleObstacle;
import model.gameObjects.things.obstacles.JBObstacle;
import model.interfaces.JBIRenderable;
import model.interfaces.JBIUpdatable;
/**
 * Questa classe è responsabile di gestire le strutture durante la
 * partita
 */
public class JBStructuresManager implements JBIUpdatable, JBIRenderable {
	
	private JBPlayfield playfield;
	private List<JBIndestructibleObstacle> indestructibleObstacles;
	private List<JBDestructibleObstacle> destructibleObstacles;
	private JBEndPad endPad;
	
	public JBStructuresManager(JBPlayfield playfield, List<JBObstacle> obstacles) {
		
		indestructibleObstacles = new ArrayList<>();
		destructibleObstacles = new ArrayList<>();
		
		for(JBObstacle obstacle : obstacles) {
			
			if(obstacle instanceof JBIndestructibleObstacle)indestructibleObstacles.add((JBIndestructibleObstacle) obstacle);
			else if(obstacle instanceof JBDestructibleObstacle) destructibleObstacles.add((JBDestructibleObstacle) obstacle);
			else if (obstacle instanceof JBEndPad) endPad = (JBEndPad)obstacle;
		}
		
		this.playfield = playfield;
	}
	
	public Rectangle getUnplayableField() {
		
		return playfield.getUnplayableField();
	}
	
	public Rectangle getPlayableField() {
		
		return playfield.getPlayableField();
	}
	
	public Rectangle getPlayField() {
		
		return playfield.getPlayfield();
	}
	
	
	
	public List<JBObstacle> getObstacles() {
	
	return Stream.of(indestructibleObstacles, destructibleObstacles)
			.flatMap(x -> x.stream())
			.collect(Collectors.toList());
	}
	
	public List<JBDestructibleObstacle> getDestructibleObstacles() {
		
		return destructibleObstacles;
	}
	
	public JBEndPad getEndPad() {
		
		return endPad;
	}
	
	@Override
	public void update() {
		
		if(destructibleObstacles != null) {
			
			destructibleObstacles.forEach(u -> u.update());
			destructibleObstacles.removeIf(d -> d.isDestroyed());
		}
		
		endPad.update();
	}

	@Override
	public void render(Graphics2D g2d) {
				
		//Draw stage's playfield and wall
		playfield.render(g2d);
		
		//Draw stage's indestructible obstacles
		indestructibleObstacles.forEach(r -> r.render(g2d));
		
		//Draw stage's destructible obstacles
		destructibleObstacles.forEach(r -> r.render(g2d));
		
		//Draw stage's end pad
		endPad.render(g2d);
		
		//DEBUG
//		g2d.setColor(Color.RED);
//		g2d.draw(playField);
	}
}