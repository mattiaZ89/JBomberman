package model.ai;

import model.gameObjects.entities.JBEnemy;

/***
 * Interfaccia che rappresenta il comportamento del nemico.
 */
@FunctionalInterface
public interface JBIBehaveable {
	
	/**
	 * 
	 * @param Il nemico sul quale eseguire il comportamento specifico
	 */
	void execute(JBEnemy enemy);
}