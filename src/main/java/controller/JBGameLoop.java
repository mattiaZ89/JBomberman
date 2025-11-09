package controller;

import java.awt.Graphics2D;
import java.util.List;

import model.game.JBGameConstants;
import model.interfaces.JBIRenderable;
import model.interfaces.JBIUpdatable;

/**
 * Questa classe è responsabile del funzionamento del gioco
 * contiene il thread che ad istanti prefissati aggiorna la
 * fisica e la grafica
 */
public class JBGameLoop implements Runnable {
	
	private Thread gameThread;
	
	private final int FPS;
	
	private List<JBIUpdatable> updatables;
	private List<JBIRenderable> renderables;
	private Graphics2D g2d;
	
	public JBGameLoop(String name, int FPS, List<JBIUpdatable> updatables, List<JBIRenderable> renderables, Graphics2D g2d) {
		
		gameThread = new Thread(this, name);
		this.FPS = FPS;
		this.updatables = updatables;
		this.renderables = renderables;
		this.g2d = g2d;
//		if(this.updatable != null)
//			System.out.println("Game Loop Created");
	}
	
	public String getName() {
		
		return gameThread.getName();
	}
	
	public void startGameLoop() {
		
		gameThread.start();
	}
	
	public void stopGameLoop() {
		
		gameThread.interrupt();
	}
	
	public void resetGameLoop() {
		
		var name = gameThread.getName();
		gameThread = new Thread(this, name);
	}
	
	public void setGraphics(Graphics2D g2d) {
		
		this.g2d = g2d;
	}

	//GAME LOOP
	@Override
	public void run() {
		
		double drawInterval = JBGameConstants.NANOSECONDS_IN_ONE_SECOND/FPS;//0.01666 seconds
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		
		while(!gameThread.isInterrupted()) {
			
			//Check the current time
			currentTime = System.nanoTime();
			
			//Subtract last time to currentTime -> basically check how much time is passed
			//Then divided it by drawInterval and add to deltaTime ->
			delta += (currentTime - lastTime) / drawInterval;
			
			//last time becomes the currentTime
			lastTime = currentTime;
			
			if(delta >= 1) {
				if(updatables != null && renderables != null) {
					
					updatables.forEach(u -> u.update());
					renderables.forEach(r -> r.render(g2d));
				}
				delta--;
			}
			
//			System.out.println("GAME LOOP IS RUNNING");
		}
	}
}