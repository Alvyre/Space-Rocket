package imac;

import processing.core.*;
import com.leapmotion.leap.*;
import leap.*;
import osValidator.*;
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
	Rocket player;
	
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
		if(OSValidator.isWindows())
			this.player = new Rocket(new Object3D(this, "../assets/models/rocket.obj"), 0, 10.0f, "Rocket name", 1);
		else
			this.player = new Rocket(new Object3D(this, "./assets/models/rocket.obj"), 0, 10.0f, "Rocket name", 1);

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
		Vector movements = new Vector(0.0f, 0.0f, 0.0f);

		this.player.getModel().setRotation(arturia.getStateKnobNumber1PadNumber1(), arturia.getStateKnobNumber9PadNumber9());
		//this.player.getModel().setPosition(arturia.getStateKnobNumber2(), arturia.getStateKnobNumber3(), arturia.getStateKnobNumber4());
				
		//To use keyboard, comment the previous line and uncomment the next line
		//this.player.getModel().translate(keyboard.EventLeftRight(), keyboard.EventUpDown(), 0);
		if(Leapmotion.isConnected())
			movements = new Vector(Leapmotion.handMoves());
		else
			movements = new Vector(keyboard.LeftRightEvent(), keyboard.UpDownEvent(), 0.0f);
		this.player.move(movements);
		this.player.getModel().display();
    }
	
	/**
	 * Settings function to init
	 * the window's size
	 * 
	 * @since 1.0
	 */
	@Override
	public void settings() {  size(WINDOW_WIDTH, WINDOW_HEIGHT, P3D); }
	
	/**
	 * Keyboard listener 
	 * on key pressed 
	 * 
	 * @since 1.0
	 */
	@Override
	public void keyPressed() {
		keyboard.eventKeyPressed();
	}
	
	/**
	 * Keyboard listener 
	 * on key released 
	 * 
	 * @since 1.0
	 */
	@Override
	public void keyReleased() {
		keyboard.eventKeyReleased();
	}

	
}
