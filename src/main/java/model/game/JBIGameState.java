package model.game;

/**
 * Interfaccia per specificare il comportamento durante
 * un particolare stato del gioco
 */
public interface JBIGameState {
	
	void execute(JBGame game);
}