package view.jbpanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.game.JBGameConstants;
import utilities.JBGraphicsFileManager;
import view.components.JBButton;
/**
 * Rappresenta la schermata iniziale del menu del gioco
 */
@SuppressWarnings("serial")
public class JBTitlePanel extends JPanel {
	
	private String titleBackgroundPath = "/TitleScreen.png";
	private BufferedImage titleScreenBackgroundImg;
	private JBButton newGameBtn;
	private JBButton exitGameBtn;
	
	public JBTitlePanel() {
		
		setPreferredSize(new Dimension(JBGameConstants.SCREEN_WIDTH, JBGameConstants.SCREEN_HEIGHT));
		setBackground(Color.BLACK);
		setDoubleBuffered(true);//Better rendering performance
		setFocusable(true);//With this, this GamePanel can be "focused" to receive key input
		setLayout(null);
		
		var gfm = new JBGraphicsFileManager();
		titleScreenBackgroundImg = gfm.createWallGraphics(titleBackgroundPath, 400, 400);
		
		newGameBtn = new JBButton("New Game");
		newGameBtn.setColors(Color.BLUE, Color.BLUE);
		newGameBtn.setBounds(300, 480, 200, 30);
		
		exitGameBtn = new JBButton("Exit Game");
		exitGameBtn.setColors(Color.BLUE, Color.BLUE);
		exitGameBtn.setBounds(300, 520, 200, 30);
		
		add(newGameBtn);
		add(exitGameBtn);
	}
	
	public JButton getNewGameBtn() {
		
		return newGameBtn;
	}
	
	public JButton getExitGameBtn() {
		
		return exitGameBtn;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.drawImage(titleScreenBackgroundImg, 0, 0, JBGameConstants.SCREEN_WIDTH, JBGameConstants.SCREEN_HEIGHT, null);
	}
}