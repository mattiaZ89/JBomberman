package controller.inputsManagement;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JBInputsManager {
	
	//Menu
	public static final byte SCROLL_UP = 10;
	public static final byte SCROLL_DOWN = 11;
	
	//Game
	public static final byte MOVE_UP = 1;
	public static final byte MOVE_DOWN = 2;
	public static final byte MOVE_LEFT = 3;
	public static final byte MOVE_RIGHT = 4;
	public static final byte SET_BOMB = 5;
	public static final byte DETONATE_BOMB = 6;
	public static final byte PUSH_BOMB = 7;
	public static final byte STOP_BOMB = 8;
	
	private static final int NUM_KEY_CODES = 600;
	private JBKey[] jbKeys = new JBKey[NUM_KEY_CODES];
//	private Map<Integer, JBKey> keys = new HashMap<Integer, JBKey>();
	private JBKeyHandler keyHandler;
	
	//Menu Keys
	private JBKey scrollUp, scrollDown;
	
	//Play Keys
	private JBKey moveUp, moveDown, moveLeft, moveRight;
	private JBKey pauseContinue;
	private JBKey setBomb;
	private JBKey detonateBomb;//After obtained Remote Control Item
	private JBKey pushBomb;//After obtained Power Glove Item
	private JBKey stopBomb;//After obtained Kick Item, stops the bomb from moving after it kicked
	
//	private static InputsManager instance;
	
	public JBInputsManager() {
		
		keyHandler = new JBKeyHandler(this);
		createGameCommand();
	}
	
//	public static InputsManager getInstance() {
//		
//		if(instance == null) instance = new InputsManager();
//		return instance;
//	}
	
	public JBKeyHandler getKeyHandler() {
		
		return keyHandler;
	}
	
	public void mapToKey(JBKey keyEvent, int keyCode) {
		
		jbKeys[keyCode] = keyEvent;
	}
	
//	public void mapToJBKey(int keyCode, JBKey key) {
//		
//		keys.put(keyCode, key);
//	}
	
	public void clearMap(JBKey keyEvent) {
		
		for (int i = 0; i < jbKeys.length; i++) {
			
			if (jbKeys[i] == keyEvent) {
				jbKeys[i] = null;
		      }
		}
		keyEvent.reset();
	}
	
	public List<String> getMaps(JBKey keyEvent){
		
		ArrayList<String> list = new ArrayList<String>();

	    for (int i = 0; i < jbKeys.length; i++) {
	    	
	    	if (jbKeys[i] == keyEvent) {
	    		
	    		list.add(getKeyName(i));
	    	}
	    }
	    
	    return list;
	}
	
	public void resetAllGameActions() {
	    for (int i = 0; i < jbKeys.length; i++) {
	      if (jbKeys[i] != null) {
	    	  jbKeys[i].reset();
	      }
	    }
	  }
	
	public static String getKeyName(int keyCode) {
		
		return KeyEvent.getKeyText(keyCode);
	}
	
	private JBKey getKeyEvent(int keyCode) {
		
		if(keyCode <jbKeys.length && keyCode!= -1) {
			
			return jbKeys[keyCode];
		}
		else {
			
			return null;
		}
	}
	
	public void keyPressed(int keyCode) {
		
		JBKey key = getKeyEvent(keyCode);
		if(key != null) {
			
			key.press();
		}
	}
	
	public void keyReleased(int keyCode) {
		
		JBKey key = getKeyEvent(keyCode);
		if(key != null) {
			
			key.release();
		}
	}
	
	public JBKey getKey(int key) {
		
		switch(key) {
		
			case MOVE_UP: return moveUp;
			case MOVE_DOWN: return moveDown;
			case MOVE_LEFT: return moveLeft;
			case MOVE_RIGHT: return moveRight;
			case SET_BOMB: return setBomb;
			case DETONATE_BOMB: return detonateBomb;
			case PUSH_BOMB: return pushBomb;
			case STOP_BOMB: return stopBomb;
			case SCROLL_UP: return scrollUp;
			case SCROLL_DOWN: return scrollDown;
			default:
				return null;
		}
	}
	
	private void createGameCommand() {
		
		//Create Virtual Keys
		
		//Menu
		scrollUp = new JBKey("Scroll Up", true);
		scrollDown = new JBKey("Scroll Down", true);
		
		//Game
		moveUp = new JBKey("MoveUp");
		moveDown = new JBKey("MoveDown");
	    moveLeft = new JBKey("MoveLeft");
	    moveRight = new JBKey("MoveRight");
	    
	    setBomb = new JBKey("SetBomb", true);
	    detonateBomb = new JBKey("DetonateBomb", true);
	    pushBomb = new JBKey("PushBomb", true);
	    stopBomb = new JBKey("StopBomb", true);
	    
	    //Keyboard Controls Mapping
	    
	    //Menu
	    mapToKey(scrollUp, KeyEvent.VK_UP);//OLD
	    mapToKey(scrollDown, KeyEvent.VK_DOWN);//OLD
	    
//	    mapToJBKey(KeyEvent.VK_W, scrollUp);
//	    mapToJBKey(KeyEvent.VK_W, scrollDown);
	    
	    
	    
	    //Game
	    mapToKey(moveUp, KeyEvent.VK_W);//OLD
	    mapToKey(moveDown, KeyEvent.VK_S);//OLD
	    mapToKey(moveLeft, KeyEvent.VK_A);//OLD
	    mapToKey(moveRight, KeyEvent.VK_D);//OLD
	    
	    mapToKey(setBomb, KeyEvent.VK_E);//OLD
	    mapToKey(detonateBomb, KeyEvent.VK_R);//OLD
	    mapToKey(pushBomb, KeyEvent.VK_F);//OLD
	    mapToKey(stopBomb, KeyEvent.VK_C);//OLD
	    
//	    mapToJBKey(KeyEvent.VK_W, moveUp);
//	    mapToJBKey(KeyEvent.VK_S, moveDown);
//	    mapToJBKey(KeyEvent.VK_A, moveLeft);
//	    mapToJBKey(KeyEvent.VK_D, moveRight);
//	    mapToJBKey(KeyEvent.VK_E, setBomb);
//	    mapToJBKey(KeyEvent.VK_R, detonateBomb);
//	    mapToJBKey(KeyEvent.VK_F, pushBomb);
//	    mapToJBKey(KeyEvent.VK_C, stopBomb);
	    
	}
}