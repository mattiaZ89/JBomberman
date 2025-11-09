package view.jbpanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

import model.game.JBGame;
import model.game.JBGameConstants;
import model.gameObjects.entities.JBEnemy;
import view.components.JBUserInterface;
/**
 * Rappresenta lo schermo di gioco
 */
@SuppressWarnings({ "serial", "deprecation" })
public class JBGamePanel extends JPanel implements Observer {
		
	//UI
	private JBUserInterface ui;
	
	public JBGamePanel() {
		
		ui = new JBUserInterface();
		setPreferredSize(new Dimension(JBGameConstants.SCREEN_WIDTH, JBGameConstants.SCREEN_HEIGHT));
		setBackground(Color.WHITE);
		setDoubleBuffered(true);//Better rendering performance
		setFocusable(true);//With this, this GamePanel can be "focused" to receive key input
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);//means the parent class of this class (JPanel in this case) will be update
		Graphics2D g2d = (Graphics2D)g;
		
		ui.renderUI(g2d);
	}

	@Override
	public void update(Observable o, Object arg) {
		
		if(o instanceof JBGame) {
			
			//TIPO DI NEMICO
			if(arg instanceof JBEnemy) {
				
				ui.addScore(50);
			}
		}
		repaint();
	}
}