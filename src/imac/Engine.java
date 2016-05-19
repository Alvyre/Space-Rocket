package imac;

import processing.core.*;
import com.leapmotion.leap.*;

import imac.collide.AABB3D;

import leap.*;

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
	static int WINDOW_HEIGHT = 600;
	
	/**
	 * Background RGB color of the app (255 to 0)
	 */
	private static int BACKGROUND_COLOR  = 255;
	
	/**
	 * Midi Controller retrieves the states of each button and knob
	 */
	private MIDIController arturia;
	
	/**
	 * Keyboard retrieves the states of some key pressed or not
	 */
	private Keyboard keyboard;

	/**
	 * Current level of the app (with main character and space level)
	 */
	private Level level;
	
	/**
	 * Camera of the app
	 */
	private Camera camera;
	
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
		this.level = new Level(this, 1);
		this.camera = new Camera(this, this.level.getPlayer());
	}
	
	/**
	 * Draw function to display
	 * the App at each frame
	 * 
	 * @since 1.0
	 */
	@Override
	public void draw() {
		background(Engine.BACKGROUND_COLOR);
		this.camera.look();
		
		Vector movements = new Vector(0.0f, 0.0f, 0.0f);
		
		this.level.getPlayer().getModel().setRotation(arturia.getStateKnobNumber1PadNumber1(), arturia.getStateKnobNumber9PadNumber9());
		
		if(Leapmotion.isConnected()) movements = new Vector(Leapmotion.handMoves());
		else                         movements = new Vector(keyboard.LeftRightEvent(), keyboard.UpDownEvent(), 0.0f);

		this.level.getPlayer().move(movements);
		this.level.display();
		
		textSize(20);
		textAlign(RIGHT);
		fill(0);
		String info = new String (this.level.getPlayer().getName() + "\n" +
								  "Score : " + this.level.getPlayer().getScore() );
		text(info, camera.getEyeX() + Engine.WINDOW_WIDTH / 2, camera.getEyeY() - Engine.WINDOW_HEIGHT /2 - 20, -500);
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
		keyboard.eventKeyPressed(level.getPlayer(), level);
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
