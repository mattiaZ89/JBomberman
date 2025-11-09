package model.factories;

import model.gameObjects.JBGameObject;

/**
 * Classe generica che rappresenta una factory.
 * Tutte le factory concrete estendono questa classe e implementano i metodi
 * 
 * @param <T> Si impone la condizione che il tipo sia un GameObject
 */
public abstract class JBGameObjectFactory<T extends JBGameObject> implements JBIGameObjectFactory<T> {
	
	public void configureFactory(byte stage) {
		
		switch(stage) {
			
			case 1: setUpSubStage1(); break;
			case 2: setUpSubStage2(); break;
			case 3: setUpSubStage3(); break;
			case 4: setUpSubStage4(); break;
			case 5: setUpSubStage5(); break;
			case 6: setUpSubStage6(); break;
			case 7: setUpSubStage7(); break;
		}
	}
	
	/**
	 * Configura gli elementi per il Sub Stage 1
	 */
	protected abstract void setUpSubStage1();
	
	/**
	 * Configura gli elementi per il Sub Stage 2
	 */
	protected abstract void setUpSubStage2();
	
	/**
	 * Configura gli elementi per il Sub Stage 3
	 */
	protected abstract void setUpSubStage3();
	
	/**
	 * Configura gli elementi per il Sub Stage 4
	 */
	protected abstract void setUpSubStage4();
	
	/**
	 * Configura gli elementi per il Sub Stage 5
	 */
	protected abstract void setUpSubStage5();
	
	/**
	 * Configura gli elementi per il Sub Stage 6
	 */
	protected abstract void setUpSubStage6();
	
	/**
	 * Configura gli elementi per il Sub Stage 7
	 */
	protected abstract void setUpSubStage7();
	
	//SPECIAL FX
	String EXPLOSION_1 = "/specialFX/Explosion_1.png";
	String EXPLOSION_2 = "/specialFX/Explosion_2.png";
	String EXPLOSION_3 = "/specialFX/Explosion_3.png";
	String EXPLOSION_4 = "/specialFX/Explosion_4.png";
	String EXPLOSION_5 = "/specialFX/Explosion_5.png";

	//EQUIPMENT
	String BOMB_1 = "/worlds/world_1/items/equipment/Bomb_1.png";
	String BOMB_2 = "/worlds/world_1/items/equipment/Bomb_2.png";
	String BOMB_3 = "/worlds/world_1/items/equipment/Bomb_3.png";

}