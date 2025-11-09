package controller;

import model.game.JBGame;
import view.JBView;
/**
 * Questo è il controller del pattern MVC
 */
@SuppressWarnings("deprecation")
public class JBController {
		
	public JBController(JBGame game, JBView view) {
		
		game.setView(view);
		view.getTitlePanel().getNewGameBtn().addActionListener(a -> newGame(game, view));
		view.getTitlePanel().getExitGameBtn().addActionListener(a -> exitGame(game, view));
		view.getWinPanel().getMainMenuBtn().addActionListener(a -> goToTitle(game, view));
		view.getLosePanel().getMainMenuBtn().addActionListener(a -> goToTitle(game, view));
	}
	
	private void newGame(JBGame game, JBView view) {
		
		//Create JBGamePanel
		view.newGame();
		game.newGame();
		
		var gamePanel = view.getGamePanel();
		
		gamePanel.addKeyListener(game.getInputsManager().getKeyHandler());
		game.init(gamePanel.getGraphics());
		game.addObserver(gamePanel);
	}
	
	private void goToTitle(JBGame game, JBView view) {
		
		view.title();
		
//		var gamePanel = view.getGamePanel();
		
//		gamePanel.addKeyListener(game.getInputsManager().getKeyHandler());
//		game.init(gamePanel.getGraphics());
//		game.addObserver(gamePanel);
	}
	
	private void exitGame(JBGame game, JBView view) {
		
		game = null;
		view.exitGame();
	}
}