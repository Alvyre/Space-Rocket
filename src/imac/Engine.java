package imac;

import processing.core.*;
import ddf.minim.*;
import com.leapmotion.leap.*;

import imac.collide.AABB3D;
import imac.obstacle.Meteor;
import leap.*;
import glitchP5.*;

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
	private static int BACKGROUND_COLOR  = 257;
	
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
	
	GlitchP5 glitchP5;
	
	/**
	 * Image of the information board
	 */
	private PImage board;
	
	/**
	 * Sound of this amazing game
	 */
	private AudioPlayer music;
	
	/**
	 * Instance of music player
	 */
	private Minim minim;
	
	/**
	 * Setup function to init Engine
	 * The setup function corresponds
	 * to the constructor in Processing
	 * 
	 * @since 1.0
	 */
	@Override
	public void setup(){
		this.keyboard = new Keyboard(this);
		this.level = new Level(this, 1);
		this.camera = new Camera(this, this.level.getPlayer());
		this.arturia = new MIDIController(this, this.level.getPlayer(), this.level);
        board = loadImage("./assets/textures/board.png");
        minim = new Minim(this);
        
        // this loads mysong.wav from the data folder
        music = minim.loadFile("./assets/sounds/zik.mp3");
        music.play();
		glitchP5 = new GlitchP5(this);

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
		
		for(Meteor m : this.level.getSpace().getMeteors()){
			//System.out.println(m.getAABB3D().getCenter());
			if( this.level.getPlayer().isImmortal() == false
					&& AABB3D.collides(m.getAABB3D(), this.level.getPlayer().getAABB3D())){
				/*glitchP5.run();
				glitchP5.glitch((int)this.level.getPlayer().getPosition().getX(), 				// position X on screen
								(int)this.level.getPlayer().getPosition().getY(), 				// position Y on screen
				  		  800,    				// max. position offset (posJitterX)
				  		  800,    				// max. position offset (posJitterY)
				  		  Engine.WINDOW_WIDTH,  // sizeX
				  		  Engine.WINDOW_HEIGHT, // sizeY
				  		  3,					// numberOfGlitches, number of individual glitches (int)
				  		  1.0f,					// randomness, this is a jitter for size (float)
				  		  10,					// attack, max time (in frames) until indiv. glitch appears (int)
				  		  40);	
				System.out.println("COLLISION PEDRO");
				
				filter(GRAY);*/
			}
		}
		//System.out.println(level.getPlayer().getAABB3D().getSize());
		
		textSize(20);
		textAlign(RIGHT);
		fill(255);
		String info = new String (this.level.getPlayer().getName() + "\n" +
								  "Score : " + this.level.getPlayer().getScore() );
		text(info, camera.getEyeX() + Engine.WINDOW_WIDTH / 2, camera.getEyeY() - Engine.WINDOW_HEIGHT /2 - 20, -500);
		camera();
		hint(DISABLE_DEPTH_TEST);
		image(board, 0, 0, Engine.WINDOW_WIDTH, Engine.WINDOW_HEIGHT);
		hint(ENABLE_DEPTH_TEST);
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
