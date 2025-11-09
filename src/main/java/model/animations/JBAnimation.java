package model.animations;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe che rappresenta un'animazione. Contiene diverse immagini che
 * vengono fatte scorrere
 */
public class JBAnimation {
	
	private final String name;
	private int frameCount;                 // Counts ticks for change
    private int frameDelay;                 // frame delay 1-12 (You will have to play around with this)
    private int currentFrame;               // animations current frame
    private int totalFrames;                // total amount of frames for your animation

    private boolean stopped;                // has animations stopped

    private List<JBFrame> frames = new ArrayList<JBFrame>();    // Arraylist of frames 
    
    /**
     * Costruisce l'animazione a partire dai frame (immagini) e la durata dello stesso
     * @param frames
     * @param frameDelay
     * @param name
     */
    public JBAnimation(BufferedImage[] frames, int frameDelay, String name) {
        
        for (int i = 0; i < frames.length; i++) {
            addFrame(frames[i], frameDelay);
        }
        
        this.frameDelay = frameDelay;
        this.name = name;
        
        this.stopped = true;
        this.frameCount = 0;
        this.currentFrame = 0;
        this.totalFrames = this.frames.size();
    }

    public void start() {
        if (!stopped) {
            return;
        }

        if (frames.size() == 0) {
            return;
        }

        stopped = false;
    }

    public void stop() {
        if (frames.size() == 0) {
            return;
        }

        stopped = true;
    }

    public void restart() {
        if (frames.size() == 0) {
            return;
        }

        stopped = false;
        currentFrame = 0;
    }

    public void reset() {
        this.stopped = true;
        this.frameCount = 0;
        this.currentFrame = 0;
    }

    private void addFrame(BufferedImage frame, int duration) {
        if (duration <= 0) {
            System.err.println("Invalid duration: " + duration);
            throw new RuntimeException("Invalid duration: " + duration);
        }

        frames.add(new JBFrame(frame, duration));
        currentFrame = 0;
    }

    public BufferedImage getSprite() {
        return frames.get(currentFrame).getFrame();
    }

    public void update() {
        if (!stopped) {
            frameCount++;

            if (frameCount > frameDelay) {
                frameCount = 0;
                currentFrame++;
                
                if (currentFrame > totalFrames - 1) {
                    currentFrame = 0;
                }
                else if (currentFrame < 0) {
                    currentFrame = totalFrames - 1;
                }
            }
        }
//        System.out.println("Current Frame: " + currentFrame);
    }
    
    public String getName() {
    	return name;
    }
}