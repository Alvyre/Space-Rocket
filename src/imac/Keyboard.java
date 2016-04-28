package imac;

import processing.core.*;

/**
 * <b>Keyboard class is an helper tool to listen keyboard events</b>
 * @author Pierre
 * @version 1.0
 */

public class Keyboard {
	
	/**
	 * Reference parent PApplet of the app's sketch
	 */
	private PApplet parent;
	
	/**
	 * The constructor of Keyboard with PApplet parameter
	 * @param PApplet
	 * 
	 * @since 1.0
	 */
	public Keyboard(PApplet p){
		this.parent = p;
	}
	
	/**
	 * Up and Down keys listener
	 * @return -1 (if UP key is pressed) or 1  (if DOWN key is pressed)
	 * @since 1.0
	 */
	public int EventUpDown(){
		if (parent.keyPressed == true) {
			if (parent.key == PConstants.CODED) {
				if (parent.keyCode == PConstants.UP) {
					return -1;
				}
				else if (parent.keyCode == PConstants.DOWN) {
					return 1;
				}
			}
		}
		return 0;
	}
	
	/**
	 * Left and Right keys listener
	 * @return -1 (if LEFT key is pressed) or 1  (if RIGHT key is pressed)
	 * @since 1.0
	 */
	public int EventLeftRight(){
		if (parent.keyPressed == true) {
			if (parent.key == PConstants.CODED) {
				if (parent.keyCode == PConstants.LEFT) {
					return -1;
				}
				else if (parent.keyCode == PConstants.RIGHT) {
					return 1;
				}
			}
		}
		return 0;
	}
}
