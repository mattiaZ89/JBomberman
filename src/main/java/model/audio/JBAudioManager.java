package model.audio;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import model.stages.JBStageManager;

/**
 * Questa classe gestisce l'audio di tutto il gioco
 */
public class JBAudioManager {
	
	private static JBAudioManager instance;
	
	public final static Integer BOMB_EXPLOSION = 0;
	
	private Map<Integer, Clip> sounds;
	
	
	private Clip clip;
	private URL soundURL[] = new URL[30];
	

	public static JBAudioManager getInstance() {
		
		if (instance == null) instance = new JBAudioManager();
		return instance;
	}
	
	private JBAudioManager() {
		
		sounds = new HashMap<Integer, Clip>();
		loadSound();
	}
	
	/**
	 * Esegue il file audio specificato dalla costante passata come parametro
	 * @param sound
	 */
	public void play(int sound) {
		
		sounds.get(sound).start();
	}
	
	private void loadSound() {
		
		soundURL[0] = getClass().getResource("/sounds/BombExplodes.wav");
		
		try {
			
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[0]);
			clip = AudioSystem.getClip();
//			clip.open(ais);
			sounds.put(BOMB_EXPLOSION, clip);
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}