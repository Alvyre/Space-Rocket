package imac;

import processing.core.*;
import com.leapmotion.leap.*;

/**
 * <b>Engine class controls the entire application.</b>
 * <p>Extends the PApplet class @see PApplet </p>
 * @author Pierre
 * @version 1.0
 */

public class Engine extends PApplet {
	
	/**
	 * Variables used to define the window's size of the app
	 */
	static int WINDOW_WIDTH  = 800;
	static int WINDOW_HEIGHT = 800;
	
	/**
	 * Midi Controller retrieves the states of each button and knob
	 */
	MIDIController arturia;
	
	/**
	 * Keyboard retrieves the states of some key pressed or not
	 */
	Keyboard keyboard;
	
	/**
	 * Main character of the app
	 */
	Object3D spider;
	
	
	/**
	 * Setup function to init Engine
	 * The setup function corresponds
	 * to the constructor in Processing
	 * 
	 * @since 1.0
	 */
	@Override
	public void setup(){
		this.arturia = new MIDIController(this);
		this.keyboard = new Keyboard(this);
	    this.spider = new Object3D(this, "./assets/models/spider.obj");
	}
	
	/**
	 * Draw function to display
	 * the App at each frame
	 * 
	 * @since 1.0
	 */
	@Override
	public void draw() {
		background(220);
		
		this.spider.setRotation(arturia.getRotationX(), arturia.getRotationY());
		this.spider.setPosition(arturia.getPositionX(), arturia.getPositionY(), arturia.getPositionZ());
		
		//To use keyboard, comment the previous line and uncomment the next line
		//this.spider.translate(keyboard.EventLeftRight(), keyboard.EventUpDown(), 0);
		
		this.spider.display();
    }
	
	/**
	 * Settings function to init
	 * window's size
	 * 
	 * @since 1.0
	 */
	public void settings() {  size(WINDOW_WIDTH, WINDOW_HEIGHT, P3D); }
}
