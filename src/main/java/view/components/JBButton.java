package view.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Point;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
/**
 * Rappresenta un bottone specifico per l'applicazione
 */
@SuppressWarnings("serial")
public class JBButton extends JButton {
	
	private Color one, two;
	
	public JBButton(String text) {
		
		super(text);
		Map<TextAttribute, Object> attributes = new HashMap<TextAttribute, Object>();
        attributes.put(TextAttribute.TRACKING, 0.25);
        setFont(new Font("arial", Font.BOLD, 20));
        setFont(getFont().deriveFont(attributes));
		setForeground(Color.YELLOW);
		setMargin(new Insets(0, 0, 0, 0));
		setContentAreaFilled(false);
		setFocusPainted(false);
	}
	
	public void setColors(Color one, Color two) {
		
		this.one = one;
		this.two = two;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		final Graphics2D g2d = (Graphics2D)g.create();
		g2d.setPaint(new GradientPaint(new Point(0, 0), one.darker(), new Point(0, getHeight()), two.brighter()));
		g2d.fillRect(0, 0, getWidth(), getHeight());
		g2d.dispose();
		super.paintComponent(g);
	}
}