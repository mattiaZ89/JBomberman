package model.managers;

import java.awt.Graphics2D;
import model.gameObjects.entities.JBPlayer;
import model.interfaces.JBIRenderable;
import model.interfaces.JBIUpdatable;
/**
 * Questa classe è responsabile di gestire i giocatori durante la
 * partita
 */
public class JBPlayerManager implements JBIUpdatable, JBIRenderable {
		
	private JBPlayer playerOne;
	private JBPlayer playerTwo;
	
	public JBPlayerManager(JBPlayer playerOne) {
		
		this.playerOne = playerOne;
	}
		
	public JBPlayer getPlayerOne() {
		
		return playerOne;
	}
	
	public JBPlayer getPlayerTwo() {
		
		return playerTwo;
	}
	
	@Override
	public void update() {
		
		playerOne.update();
	}
	
	@Override
	public void render(Graphics2D g2d) {
		
		playerOne.render(g2d);
	}
}