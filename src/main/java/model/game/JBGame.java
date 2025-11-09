package model.game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import controller.JBGameLoop;
import controller.inputsManagement.JBInputsManager;
import model.JBCollisionChecker;
import model.audio.JBAudioManager;
import model.gameObjects.entities.*;
import model.gameObjects.things.items.equipment.JBBomb;
import model.gameObjects.things.obstacles.JBDestructibleObstacle;
import model.gameObjects.things.obstacles.JBEndPad;
import model.interfaces.JBIRenderable;
import model.interfaces.JBIUpdatable;
import model.managers.JBEnemiesManager;
import model.managers.JBItemsManager;
import model.managers.JBPlayerManager;
import model.managers.JBStructuresManager;
import model.stages.JBStageManager;
import view.JBView;
import view.jbpanel.JBGamePanel;

/**
 * Classe che rappresenta il gioco.
 */
@SuppressWarnings("deprecation")
public class JBGame extends Observable implements Observer, JBIUpdatable {
	
	private JBGameLoop gameLoop;
	private List<JBIUpdatable> updatables;
	private List<JBIRenderable> renderables;
	private JBIGameState gameState;
	private JBInputsManager inputsManager;
	private JBStageManager stageManager;
	private JBAudioManager audioManager;
	
	private boolean isNextStage = false;
	private boolean isWin = false;
	private boolean isLose = false;
	
	private JBView view;
	
	/**
	 * Crea una nuova partita
	 */
	public void newGame() {
		
		inputsManager = new JBInputsManager();
		JBCollisionChecker.getInstance().setGame(this);
		
		stageManager = JBStageManager.getInstance();
		
		audioManager = JBAudioManager.getInstance();
		
		updatables = Stream.of(this, getStructuresManager(), getPlayerManager(), getEnemiesManager(), getItemsManager()).collect(Collectors.toCollection(ArrayList::new));
		renderables = Stream.of(getStructuresManager(), getPlayerManager(), getEnemiesManager(), getItemsManager()).collect(Collectors.toCollection(ArrayList::new));
		
		getItemsManager().getBombsPool().forEach(b -> b.addObserver(this));
		
		getStructuresManager().getEndPad().addObserver(this);
		
		gameState = new JBPlayState();
	}
	
	/**
	 * Inizializza il game loop principale fornendo la grafica
	 * del pannello di gioco
	 * @param g Grafica del JGGamePanel
	 */
	public void init(Graphics g) {
		
		gameLoop = new JBGameLoop("Main Loop", JBGameConstants.FPS, updatables, renderables, (Graphics2D)g);
		gameStart();
	}
	
	/**
	 * Avvia il game loop per far funzionare la "fisica" e il rendering
	 */
	public void gameStart() {
		
		gameLoop.startGameLoop();
	}
	
	/**
	 * Ferma il game loop interrompendo i vari aggiornamenti
	 */
	public void gameStop() {
		
		gameLoop.stopGameLoop();
	}
	
	/**
	 * Fornisce lo Structure Manager dallo stage corrente
	 * @return JBStructuresManager
	 */
	public JBStructuresManager getStructuresManager() {
		
		return JBStageManager.getInstance().getCurrentStage().getStructureManager();
	}
	
	/**
	 * Fornisce il Player Manager dallo stage corrente
	 * @return JBPlayerManager
	 */
	public JBPlayerManager getPlayerManager() {
		
		return JBStageManager.getInstance().getCurrentStage().getPlayerManager();
	}
	
	/**
	 * Fornisce l'Enemies Manager dallo stage corrente
	 * @return JBEnemiesManager
	 */
	public JBEnemiesManager getEnemiesManager() {
		
		return JBStageManager.getInstance().getCurrentStage().getEnemiesManager();
	}
	
	/**
	 * Fornisce l'Input Manager
	 * @return JBStructuresManager
	 */
	public JBInputsManager getInputsManager() {
		
		return inputsManager;
	}
	
	/**
	 * Fornisce l'Items Manager dallo stage corrente
	 * @return JBItemsManager
	 */
	public JBItemsManager getItemsManager() {
		
		return JBStageManager.getInstance().getCurrentStage().getItemsManager();
	}
	
	/**
	 * Setta un nuovo game state per il gioco
	 * @param gameState
	 */
	public void setGameState(JBIGameState gameState) {
		
		this.gameState = gameState;
	}
	
	/**
	 * Forniscce il game state attuale
	 * @return JGIGameState
	 */
	public JBIGameState getGameState() {
		
		return gameState;
	}
	
	/**
	 * Fornisce il game loop attuale
	 * @return JBGameLoop
	 */
	public JBGameLoop getGameLoop() {
		
		return gameLoop;
	}
	
	/**
	 * Fornisce l'audio manager attuale
	 * @return JBAudioManager
	 */
	public JBAudioManager getAudioManager() {
		
		return audioManager;
	}
	
	/**
	 * Verifica che ci sia un altro stage
	 * @return vero se ci sono altri stage, falso se il gico è finito
	 */
	public boolean isNextStage() {
		
		return isNextStage;
	}
	
	/**
	 * Fornisce lo stage manager attuale
	 * @return JBStageManager
	 */
	public JBStageManager getStageManager() {
		
		return stageManager;
	}
	
	/**
	 * Setta la lista degli oggetti aggiornabili
	 * @param updatables
	 */
	public void setUpdatables(List<JBIUpdatable> updatables) {
		
		this.updatables = updatables;
	}
	
	/**
	 * Setta la lista degli oggetti renderizzabili
	 * @param updatables
	 */
	public void setRenderables(List<JBIRenderable> renderables) {
		
		this.renderables = renderables;
	}
	
	/**
	 * Resetta gli oggetti aggiornabili e renderizzabili
	 * per la creazione di un nuovo livello
	 */
	public void resetInterfaces() {
		
		updatables = null;
		renderables = null;
	}
	
	/**
	 * Setta un riferimento all'interfaccia grafica
	 * @param view
	 */
	public void setView(JBView view) {
		
		this.view = view;
	}
	
	/**
	 * Resetta l'interfaccia grafica
	 * per la creazione di un nuovo livello
	 */
	public void resetView() {
		
		view.nextStage();
	}
	
	/**
	 * Ritorna la grafica del Game Panel
	 * @return Graphics
	 */
	public Graphics getGamePanelGraphics() {
		
		return view.getGamePanel().getGraphics();
	}
	
	/**
	 * Ritorna il Game Panel
	 * @return JBGamePanel
	 */
	public JBGamePanel getGamePanel() {
		
		return view.getGamePanel();
	}
	
	/**
	 * Resetta l'Input Manager
	 * per la creazione di un nuovo livello
	 */
	public void resetInputManager() {
		
		inputsManager = null;
		inputsManager = new JBInputsManager();
	}
	
	/**
	 * Resetta l'interfaccia grafica
	 * per la creazione di un nuovo stage
	 */
	public void nextStage() {
		
		view.nextStage();
	}
	
	/**
	 * Resetta l'interfaccia grafica
	 * per la creazione di un nuovo stage
	 */
	public void winMng() {
		
		view.winGame();
	}
	
	@Override
	public void update() {
		
		if(isNextStage) {
			
			isNextStage = false;
			gameState = new JBLoadingState();
		}
		
		if(isWin) {
			
			isWin = false;
			gameState = new JBWinState();
		}
		
		if(isLose) {
			
			isLose = false;
			gameState = new JBLoseState();
		}
		
		gameState.execute(this);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		
		if(o instanceof JBBomb) {
			
			var bomb = (JBBomb)o;
			var enemies = stageManager.getCurrentStage().getEnemiesManager().getEnemies();
			var obstacles = stageManager.getCurrentStage().getStructureManager().getDestructibleObstacles();
			
			for(JBEnemy enemy : enemies) {
				
				if(JBCollisionChecker.getInstance().checkExplosion(bomb, enemy)) {
					
					enemy.getDamage();
//					audioManager.play(JBAudioManager.BOMB_EXPLOSION);
					setChanged();
					notifyObservers(enemy);
				}
			}
			
			for(JBDestructibleObstacle obstacle : obstacles) {
				
				if(JBCollisionChecker.getInstance().checkExplosion(bomb, obstacle)) {
					
					obstacle.destroy();
					setChanged();
					notifyObservers(obstacle);
				}
			}
		}
		
		if(o instanceof JBEndPad) {
			
			//Next Level
			if(stageManager.hasNextStage()) {
				
				isNextStage = true;
			}
			else {
				
				isWin = true;
			}
		}
	}
}