package model.stages;
/**
 * Interfaccia per la creazione degli stage
 */
public interface JBIStageBuilder {
		
	JBIStageBuilder setSubStage(byte subStage);
	JBIStageBuilder loadMap();
	JBIStageBuilder setStructuresManager();
	JBIStageBuilder setPlayerManager();
	JBIStageBuilder setEnemiesManager();
	JBIStageBuilder setItemsManager();
	JBStage build();
}