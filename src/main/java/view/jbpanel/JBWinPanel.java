package view.jbpanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.game.JBGameConstants;
import utilities.JBGraphicsFileManager;
import view.components.JBButton;
/**
 * Rappresenta la schermata di vittoria
 */
@SuppressWarnings("serial")
public class JBWinPanel extends JPanel {
	
	private String winBackgroundPath = "/WinLoseScreen.png";
	private BufferedImage winScreenBackgroundImg;
	private JBButton mainMenuBtn;
	
	private Color background = new Color(204, 255, 229);
	
	public JBWinPanel() {
		
		setPreferredSize(new Dimension(JBGameConstants.SCREEN_WIDTH, JBGameConstants.SCREEN_HEIGHT));
		setBackground(background.darker());
		setDoubleBuffered(true);//Better rendering performance
		setFocusable(true);//With this, this GamePanel can be "focused" to receive key input
		setLayout(null);
		
		var gfm = new JBGraphicsFileManager();
		winScreenBackgroundImg = gfm.createWallGraphics(winBackgroundPath, JBGameConstants.SCREEN_WIDTH/2, JBGameConstants.SCREEN_HEIGHT/2);
		
		mainMenuBtn = new JBButton("MAIN MENU");
		mainMenuBtn.setBackground(background);
		mainMenuBtn.setColors(background, background);
		mainMenuBtn.setBounds(300, 550, 200, 30);
		
		add(mainMenuBtn);
	}
	
	public JButton getMainMenuBtn() {
		
		return mainMenuBtn;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		Map<TextAttribute, Object> attributes = new HashMap<TextAttribute, Object>();
        attributes.put(TextAttribute.TRACKING, 0.35);
        
		
		g2d.drawImage(winScreenBackgroundImg, 0, 50, JBGameConstants.SCREEN_WIDTH, (JBGameConstants.SCREEN_HEIGHT/3)*2, null);
		g2d.setColor(Color.YELLOW.darker());
		
		g2d.setFont(new Font("arial", Font.BOLD, 12));
		g2d.setFont(g2d.getFont().deriveFont(attributes));
		g2d.drawString("*****************************************************************", 110, 135);
		g2d.drawString("*****************************************************************", 110, 141);
		g2d.drawString("*****************************************************************", 110, 146);
		
		g2d.setFont(new Font("arial", Font.BOLD, 40));
		g2d.setFont(g2d.getFont().deriveFont(attributes));
		g2d.drawString("CONGRATULATION", 125, 230);
		g2d.drawString("YOU WIN", 280, 350);
		
		g2d.setFont(null);
		g2d.setFont(new Font("arial", Font.BOLD, 12));
		g2d.setFont(g2d.getFont().deriveFont(attributes));
		g2d.drawString("*****************************************************************", 110, 436);
		g2d.drawString("*****************************************************************", 110, 442);
		g2d.drawString("*****************************************************************", 110, 447);
	}
}