package view;

import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import view.jbpanel.JBGamePanel;
import view.jbpanel.JBLosePanel;
import view.jbpanel.JBTitlePanel;
import view.jbpanel.JBWinPanel;
/**
 * Rappresenta la finestra principale dell'applicazione
 */
@SuppressWarnings("serial")
public class JBView extends JFrame {
	
	private JBGamePanel gamePanel;
	private JBTitlePanel titlePanel;
	private JBWinPanel winPanel;
	private JBLosePanel losePanel;
	
	public JBView() {
		
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("JBomberman");
		
		gamePanel = new JBGamePanel();
		titlePanel = new JBTitlePanel();
		winPanel = new JBWinPanel();
		losePanel = new JBLosePanel();
		
		add(titlePanel);
		
		pack();
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void newGame() {
		
		setVisible(false);
		remove(titlePanel);
		gamePanel = new JBGamePanel();
		add(gamePanel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void nextStage() {
		
		setVisible(false);
		remove(gamePanel);
		gamePanel = new JBGamePanel();
		add(gamePanel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void exitGame() {
		
		remove(titlePanel);
		dispose();
		dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
	
	public void winGame() {
		
		setVisible(false);
		remove(gamePanel);
//		winPanel = new JBWinPanel();
		add(winPanel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void loseGame() {
		
		setVisible(false);
		remove(gamePanel);
//		losePanel = new JBLosePanel();
		add(losePanel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void title() {
		
		setVisible(false);
		remove(winPanel);//Or WinPanel?
//		titlePanel = new JBTitlePanel();
		add(titlePanel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public JBGamePanel getGamePanel() {
		return gamePanel;
	}
	
	public JBTitlePanel getTitlePanel() {
		
		return titlePanel;
	}
	
	public JBWinPanel getWinPanel() {
		
		return winPanel;
	}
	
	public JBLosePanel getLosePanel() {
		
		return losePanel;
	}
}