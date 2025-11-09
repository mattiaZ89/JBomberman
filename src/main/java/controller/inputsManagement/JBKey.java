package controller.inputsManagement;
/**
 * Rappresenta un generico tasto
 */
public class JBKey {
	
	private static final int STATE_RELEASED = 0;
	private static final int STATE_PRESSED = 1;
	private static final int STATE_WAITING_FOR_RELEASE = 2;
	
	private final String name;
	private final boolean isTriggered;
	private int amount;
	private int state;
	
	/**
	 * Costruisce un tasto con un nome
	 * @param name
	 */
	public JBKey(String name) {
		
		this(name, false);
	}
	
	/**
	 * Costruisce un tasto con un nome e lo rende triggerabile
	 * Si preme una sola volta. Non risulta mantenuto premuto
	 * @param name
	 * @param isTriggered
	 */
	public JBKey(String name, boolean isTriggered) {
		
		this.name = name;
	    this.isTriggered = isTriggered;
	    reset();
	}
	
	public String getName() {
		
		return name;
	}
	
	public void reset() {
		
		state = STATE_RELEASED;
	    amount = 0;
	}
	
	public void tap() {
		
		press();
		release();
	}
	

	public synchronized void press() {
		
		press(1);
	}
	
	public synchronized void press(int amount) {
		
		if (state != STATE_WAITING_FOR_RELEASE) {
			
			this.amount += amount;
			state = STATE_PRESSED;
		}
	}
	
	public synchronized void release() {
		
		state = STATE_RELEASED;
	}
	
	public synchronized boolean isPressed() {
		
		return (getAmount() != 0);
	}
	
	public synchronized int getAmount() {
		
		int retVal = amount;
	    if (retVal != 0) {
	      if (state == STATE_RELEASED) {
	        amount = 0;
	      } else if (isTriggered) {
	        state = STATE_WAITING_FOR_RELEASE;
	        amount = 0;
	      }
	    }
	    return retVal;
	}
}