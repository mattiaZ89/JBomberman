package model.game;

import controller.inputsManagement.JBInputsManager;
import model.JBCollisionChecker;
/**
 * Rappresenta lo stato dove il gioco è in esecuzione
 */
public class JBPlayState implements JBIGameState {

	@Override
	public void execute(JBGame game) {
		
		var inputsManager = game.getInputsManager();
		var player = game.getPlayerManager().getPlayerOne();
		var endPad = game.getStructuresManager().getEndPad();
		
		if(inputsManager.getKey(JBInputsManager.MOVE_UP).isPressed()) {
			
			player.moveUp();
		}
		else if(inputsManager.getKey(JBInputsManager.MOVE_DOWN).isPressed()) {
			
			player.moveDown();
		}
		else if(inputsManager.getKey(JBInputsManager.MOVE_LEFT).isPressed()) {
			
			player.moveLeft();
		}
		else if(inputsManager.getKey(JBInputsManager.MOVE_RIGHT).isPressed()) {
			
			player.moveRight();
		}
		else if(!inputsManager.getKey(JBInputsManager.MOVE_UP).isPressed() ||
				!inputsManager.getKey(JBInputsManager.MOVE_DOWN).isPressed() ||
				!inputsManager.getKey(JBInputsManager.MOVE_LEFT).isPressed() ||
				!inputsManager.getKey(JBInputsManager.MOVE_RIGHT).isPressed()) {
			
			player.stop();
		}
		
		if(inputsManager.getKey(JBInputsManager.SET_BOMB).isPressed()) {
			
			if(player.canSetBomb()) {
				
				game.getItemsManager().setBomb(player.getPosition());
				player.throwBomb();
			}
		}
		
		if(JBCollisionChecker.getInstance().checkEndPad(player, endPad)) {
			
			endPad.reached();
		}
	}
}