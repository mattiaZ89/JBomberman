package model.animations;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe che rappresenta un'animazione. Contiene diverse immagini che
 * vengono fatte scorrere. In questo caso però viene eseguito un solo ciclo
 * Usato per gli effetti speciali
 */
public class JBAnimationOneShot {
	
	private final String name;
	private int frameCount;                 // Counts ticks for change
    private int frameDelay;                 // frame delay 1-12 (You will have to play around with this)
    private int currentFrame;               // animations current frame
    private int totalFrames;                // total amount of frames for your animation

    private boolean isFinished;                // has animations stopped

    private List<JBFrame> frames = new ArrayList<JBFrame>();    // Arraylist of frames 
    
    /**
     * Costruisce l'animazione a partire dai frame (immagini) e la durata dello stesso
     * @param frames
     * @param frameDelay
     * @param name
     */
    public JBAnimationOneShot(BufferedImage[] frames, int frameDelay, String name) {
        
        for (int i = 0; i < frames.length; i++) {
            addFrame(frames[i], frameDelay);
        }
        
        this.frameDelay = frameDelay;
        this.name = name;
        
        this.isFinished = false;
        this.frameCount = 0;
        this.currentFrame = 0;
        this.totalFrames = this.frames.size();
    }
    
    private void addFrame(BufferedImage frame, int duration) {
        if (duration <= 0) {
            System.err.println("Invalid duration: " + duration);
            throw new RuntimeException("Invalid duration: " + duration);
        }

        frames.add(new JBFrame(frame, duration));
        currentFrame = 0;
    }
    
    public boolean isFinished() {
    	
    	return isFinished;
    }

    public BufferedImage getSprite() {
    	if(frames != null)
    		return frames.get(currentFrame).getFrame();
		return null;
    }

    public void update() {
        if (!isFinished) {
            frameCount++;

            if (frameCount > frameDelay) {
                frameCount = 0;
                currentFrame++;
                
                if (currentFrame > totalFrames - 1) {
                	isFinished = true;
                	frames = null;
                }
//                else if (currentFrame < 0) {
//                    currentFrame = totalFrames - 1;
//                }
            }
        }
//        System.out.println("Current Frame: " + currentFrame);
    }
    
    public String getName() {
    	return name;
    }
}