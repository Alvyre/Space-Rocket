package imac;

import processing.core.*;
import ddf.minim.*;
import java.util.Timer;
import java.util.TimerTask;
import com.leapmotion.leap.*;
import imac.collide.AABB3D;
import imac.leap.*;
import imac.level.Level;
import imac.obstacle.Meteor;
import imac.tools.Keyboard;
import imac.tools.Time;
import glitchP5.*;

/**
 * <b>Engine class controls the entire application.</b>
 * <p>Extends the PApplet class @see PApplet </p>
 * @author Pierre
 * @version 1.0
 */

public class Engine extends PApplet {
	
	/**
	 * static constant value to define the width of the window
	 */
	static public final int WINDOW_WIDTH  = 800;
	/**
	 * static constant value to define the height of the window
	 */
	static public final int WINDOW_HEIGHT = 600;
	/**
	 * static constant value to define the damage of the collision. When the player hit a meteor, he will lost 200 HP
	 */
	private static final int DAMAGE_COLLISION = -200;
	/**
	 * Background RGB color of the app (255 to 0)
	 */
	private static int BACKGROUND_COLOR  = 51;
	
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
	 * Menu of the app
	 */
	private Menu menu;
	
	/**
	 * Camera of the app
	 */
	private Camera camera;
	
	/**
	 * structure to create the glitch when the player dies @see GlitchP5
	 */
	GlitchP5 glitchP5;
	
	/**
	 * the the music during the game
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
		Time.start();
		this.keyboard = new Keyboard(this);
		this.level = new Level(this, 1);
		this.camera = new Camera(this, this.level.getPlayer());
		this.menu = new Menu(this, this.level);
		this.arturia = new MIDIController(this, this.level.getPlayer(), this.level, this.menu);
        minim = new Minim(this);
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
		
		if(this.menu.isActive()){	// display of the menu
			this.menu.display();
		}
		else{ 						// display of the game
			this.camera.look();
			Vector movements = new Vector(0.0f, 0.0f, 0.0f);
			
			this.level.getPlayer().getModel().setRotation(arturia.getStateKnobNumber1PadNumber1(), arturia.getStateKnobNumber9PadNumber9());
			
			if(Leapmotion.isConnected()) movements = new Vector(Leapmotion.handMoves());
			else                         movements = new Vector(keyboard.LeftRightEvent(), keyboard.UpDownEvent(), 0.0f);
			
			this.level.getPlayer().move(movements);
			
			// Collision Detection
			for(Meteor m : this.level.getSpace().getMeteors()){
				if( this.level.getPlayer().isImmortal() == false
						&& AABB3D.collides(m.getAABB3D(), this.level.getPlayer().getAABB3D())){
					this.level.getPlayer().addToScore(DAMAGE_COLLISION);
					this.level.getPlayer().addToLife(DAMAGE_COLLISION);
				}
			}
			
			this.level.display();
			if(this.level.getPlayer().getLife() < 0){ // GameOver
				level.saveScore();

				Timer timer = new Timer();
				float duration = 4;
				if(glitchP5 != null){
				glitchP5.run();
				glitchP5.glitch((int) level.getPlayer().getPosition().getX(), 				// position X on screen
								(int) level.getPlayer().getPosition().getY(), 				// position Y on screen
				  		  800,    				// max. position offset (posJitterX)
				  		  800,    				// max. position offset (posJitterY)
				  		  Engine.WINDOW_WIDTH,  // sizeX
				  		  Engine.WINDOW_HEIGHT, // sizeY
				  		  3,					// numberOfGlitches, number of individual glitches (int)
				  		  1.0f,					// randomness, this is a jitter for size (float)
				  		  1,					// attack, max time (in frames) until indiv. glitch appears (int)
				  		  10);	

				
				filter(GRAY);
				timer.schedule(new TimerTask() {
					  @Override
					  public void run() {
						level.getPlayer().setScore(0);
						menu.active();
						level.loadLevel(menu.getCurrentLevel());
					  }
					}, (long)duration*1000);
			
					
				}	
			}
		}
		
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
		menu.eventKeyPressed();
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
		menu.eventKeyReleased();
	}
}
