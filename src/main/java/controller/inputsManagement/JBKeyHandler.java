package controller.inputsManagement;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * Questa classe è usata per gestire gli input da tastiera
 * 
 *
 */
public class JBKeyHandler implements KeyListener {
		
	public boolean upPressed, downPressed, leftPressed, rightPressed;
	public boolean checkDrawTime = false;
	
	private JBInputsManager inputsManager;
	private int keyCode;
	
	public JBKeyHandler(JBInputsManager inputsManager) {
		
		this.inputsManager = inputsManager;
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		
		e.consume();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		inputsManager.keyPressed(e.getKeyCode());
		e.consume();
//		System.out.println("Released Key: " + e.getKeyChar() + " " + e.getKeyCode());
	}
		
	@Override
	public void keyReleased(KeyEvent e) {
		
		inputsManager.keyReleased(e.getKeyCode());
		e.consume();
//		System.out.println("Released Key: " + e.getKeyChar() + " " + e.getKeyCode());
	}
	
	public int getKey() {
		
		var key = keyCode;
		keyCode = -1;
		
		return key;
	}
}