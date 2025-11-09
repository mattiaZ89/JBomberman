package model.game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.interfaces.JBIRenderable;
import model.interfaces.JBIUpdatable;
/**
 * Rappresenta lo stato dove il gioco è in caricamento di un nuovo livello
 */
public class JBLoadingState implements JBIGameState {

	@SuppressWarnings("deprecation")
	@Override
	public void execute(JBGame game) {
		
		game.gameStop();
		
		game.resetView();
		
		game.resetInterfaces();
		
		game.resetInputManager();
		
		game.getStageManager().createStage();
		
		List<JBIUpdatable>  updatables = Stream.of(game, game.getStructuresManager(), game.getPlayerManager(), game.getEnemiesManager(), game.getItemsManager()).collect(Collectors.toCollection(ArrayList::new));
		List<JBIRenderable> renderables = Stream.of(game.getStructuresManager(), game.getPlayerManager(), game.getEnemiesManager(), game.getItemsManager()).collect(Collectors.toCollection(ArrayList::new));
		
		game.setUpdatables(updatables);
		game.setRenderables(renderables);
		
		game.getItemsManager().getBombsPool().forEach(b -> b.addObserver(game));
		
		game.getStructuresManager().getEndPad().addObserver(game);
		
		game.nextStage();
		
		game.getGamePanel().addKeyListener(game.getInputsManager().getKeyHandler());
		
		game.init(game.getGamePanelGraphics());
		
		game.setGameState(new JBPlayState());
	}
}