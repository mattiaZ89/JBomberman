package model.game;
/**
 * Rappresenta lo stato dove il giocatore ha perso il gioco
 */
public class JBWinState implements JBIGameState {

	@Override
	public void execute(JBGame game) {
		
		game.gameStop();
		
//		game.resetView();
		
		game.resetInterfaces();
		
//		game.resetInputManager();
		
		game.init(game.getGamePanelGraphics());
		
		game.winMng();
		
		game.setGameState(null);
		
		game = null;
	}
}