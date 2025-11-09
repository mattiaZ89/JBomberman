package view.components;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;

import model.game.JBGameConstants;
/**
 * Rappresenta la UI del gioco.
 * Qui vengono visualizzati i punti del giocatore, le vite rimaste
 * ed il tempo rimanente
 */
public class JBUserInterface {
	
	private int lives;
	private int score;
	private int bombs;
		
	public void renderUI(Graphics2D g2d) {
		
		int baseWidth = JBGameConstants.TILE_SIZE;
		int halfBaseWidth = baseWidth/2;
		
		int x = JBGameConstants.TILE_SIZE+4;
		int offsetX = JBGameConstants.TILE_SIZE/5;
		int y = 75;
		
		
		int squareWidth = (JBGameConstants.TILE_SIZE/9)*3;
		int squareHeight = 12;
		Color timerSquareColor = Color.WHITE;
		
		g2d.setColor(new Color(255, 120, 21));
		g2d.fillRect(0, 0, JBGameConstants.UI_WIDTH, JBGameConstants.UI_HEIGHT);
		
		//PLAYER ONE
		
		//PLAYER LIVES
		g2d.setColor(Color.WHITE);
		g2d.fillRect(JBGameConstants.TILE_SIZE, 16, JBGameConstants.TILE_SIZE, JBGameConstants.TILE_SIZE);
		g2d.setColor(Color.BLACK);
		g2d.fillRect(JBGameConstants.TILE_SIZE*2+4, 16, JBGameConstants.TILE_SIZE/2, 48);
//		g2d.drawString(Integer.toString(lives), (JBGameConstants.TILE_SIZE/2)*7, 55);
		
		//PLAYER SCORE
		g2d.setColor(Color.BLACK);
		g2d.fillRect((JBGameConstants.TILE_SIZE/2)*7, 16, (JBGameConstants.TILE_SIZE/2)*8, 48);
				
		g2d.setColor(Color.WHITE);
		g2d.setFont(g2d.getFont().deriveFont(40.0f));
		g2d.drawString(Integer.toString(score), (JBGameConstants.TILE_SIZE/2)*7, 55);
		
		//TIMES SQUARE
		drawUITimerCounter(g2d);
		
		//TIMER
		g2d.setColor(Color.CYAN);
		g2d.fillRect(JBGameConstants.TILE_SIZE*8, 48, 32, 48);
		
		
//		g2d.setPaint(new GradientPaint(0,0,new Color(141, 24, 24),100, 0,new Color(151, 24, 24)));
//		g2d.setStroke(new BasicStroke(4.0f));
//		g2d.drawRect(x+1, y, squareWidth, squareHeight);
//		g2d.setColor(timerSquareColor);
//		g2d.fillRect(x+2, y+1, squareWidth-2, 10);
//				
//		g2d.setPaint(new GradientPaint(0,0,new Color(141, 24, 24),100, 0,new Color(151, 24, 24)));
//		g2d.setStroke(new BasicStroke(4.0f));
//		g2d.drawRect(x+squareWidth+offsetX, y, squareWidth, squareHeight);
//		g2d.setColor(timerSquareColor);
//		g2d.fillRect(x+squareWidth+offsetX+1, y+1, squareWidth-2, 10);
	}
	
	public void addScore(int score) {
		
		this.score += score;
	}
	
	public void setScore(int score) {
		
		this.score = score;
	}
	
	public void setBombs(int bombs) {
		
		this.bombs = bombs;
	}
	
	private void drawUIPlayer(Graphics2D g2d, int x, int y) {
		
	}
	
	private void drawUITimerCounter(Graphics2D g2d) {
		
		int x = JBGameConstants.TILE_SIZE+4;
		int offsetX = JBGameConstants.TILE_SIZE/5;
		int y = 75;
		
		int squareWidth = (JBGameConstants.TILE_SIZE/9)*3;
		int squareHeight = 12;
		Color timerSquareColor = Color.WHITE;
		
		for(int i=0; i<7; i++) {
			
			g2d.setPaint(new GradientPaint(0,0,new Color(141, 24, 24),100, 0,new Color(151, 24, 24)));
			g2d.setStroke(new BasicStroke(4.0f));
			g2d.drawRect(x+1, y, squareWidth, squareHeight);
			g2d.setColor(timerSquareColor);
			g2d.fillRect(x+2, y+1, squareWidth-2, 10);
			
			g2d.setPaint(new GradientPaint(0,0,new Color(141, 24, 24),100, 0,new Color(151, 24, 24)));
			g2d.setStroke(new BasicStroke(4.0f));
			g2d.drawRect(x+squareWidth+offsetX, y, squareWidth, squareHeight);
			g2d.setColor(timerSquareColor);
			g2d.fillRect(x+squareWidth+offsetX+1, y+1, squareWidth-2, 10);
			
			x += JBGameConstants.TILE_SIZE;
		}
	}
}