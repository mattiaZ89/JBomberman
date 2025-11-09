package main;

import javax.swing.SwingUtilities;

import controller.JBController;
import model.game.JBGame;
import view.JBView;

public class JBomberMan {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() -> new JBController(new JBGame(), new JBView()));
	}
}