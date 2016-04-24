package imac;

import processing.core.*;


public class Keyboard {
	
	private PApplet parent; //PApplet object
	
	public Keyboard(PApplet p){
		this.parent = p;
	}
	
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
