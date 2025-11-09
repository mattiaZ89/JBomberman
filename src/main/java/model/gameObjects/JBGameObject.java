package model.gameObjects;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Observable;

import model.interfaces.JBIRenderable;
import model.interfaces.JBIUpdatable;

/**
 * Rappresenta un generico oggetto di gioco
 */
@SuppressWarnings("deprecation")
public abstract class JBGameObject extends Observable implements JBIUpdatable, JBIRenderable {
	
	//The Upper Left Corner of the Image
	protected Point position;
		
	//The area where check if there is a collision
	protected Rectangle body;
	
	public Rectangle getBody() {
		
		return body;
	}
	
	public void setPosition(Point position) {
		
		this.position = position;
	}
	
	public Point getPosition() {
		
		return position;
	}
		
	@Override
	public String toString() {
		
		return "Position(" + position.x + ", " + position.y + ")";
	}
}