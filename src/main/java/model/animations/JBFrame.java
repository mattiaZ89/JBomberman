package model.animations;

import java.awt.image.BufferedImage;

/**
 * Rappresenta un frame dell'animazione
 */
public class JBFrame {
	
	private BufferedImage frame;
    private int duration;
    
    /**
     * Costruisce un frame con immagine e durata
     * @param frame
     * @param duration
     */
    public JBFrame(BufferedImage frame, int duration) {
        this.frame = frame;
        this.duration = duration;
    }

    /**
     * Setta l'immagine del frame
     * @param frame
     */
    public void setFrame(BufferedImage frame) {
        this.frame = frame;
    }
    
    /**
     * Fornisce l'immagine del frame
     * @return l'immagine
     */
    public BufferedImage getFrame() {
        return frame;
    }
    
    /**
     * Setta la durata del frame
     * @param duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    /**
     * Fornisce la durata del frame
     * @return la durata
     */
    public int getDuration() {
        return duration;
    }
}