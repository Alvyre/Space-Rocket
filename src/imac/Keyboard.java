package imac;

import processing.core.*;

/**
 * <b>Keyboard class is an helper tool to listen keyboard events</b>
 * @author Pierre
 * @version 1.0
 */

public class Keyboard {
	
	/**
	 * Static variables storing the status of
	 * the up, down, left and right keys
	 */
	private static boolean UP, DOWN, LEFT, RIGHT = false;
	
	/**
	 * Static variable referring to graphic displacement
	 */
	private static float MOVE = 1.0f;
	
	/**
	 * Static variable referring to graphic no displacement
	 */
	private static float DONT_MOVE = 0.0f;
	
	/**
	 * Static variable referring to acceleration or velocity speed
	 */
	private static float VELOCITY_UP_DOWN    = 0.0f;
	private static float VELOCITY_LEFT_RIGHT = 0.0f;
	
	/**
	 * Static variable referring to last UP or Down keys pressed
	 * 0 : null
	 * 1 : UP
	 * 2 : DOWN
	 */
	private static int LAST_KEY_UP_DOWN = 0;
	
	/**
	 * Static variable referring to last UP or Down keys pressed
	 * 0 : null
	 * 1 : LEFT
	 * 2 : RIGHT
	 */
	private static int LAST_KEY_LEFT_RIGHT = 0;
	
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
	 * Function called on Engine keyPressed function
	 * Change values of variables UP, DOWN, LEFT and RIGHT
	 * 
	 * @since 1.0
	 */
	public void eventKeyPressed(Rocket player, Level level){
		
		if (parent.keyCode == PConstants.UP) Keyboard.UP = true;
		if (parent.keyCode == PConstants.DOWN) Keyboard.DOWN = true;
		if (parent.keyCode == PConstants.LEFT) Keyboard.LEFT = true;
		if (parent.keyCode == PConstants.RIGHT) Keyboard.RIGHT = true;
		if (parent.keyCode == 49) player.applyBonus(player.getBonus("SpeedUp"), level);
		if (parent.keyCode == 50) player.applyBonus(player.getBonus("SlowTime"), level);
		if (parent.keyCode == 51) player.applyBonus(player.getBonus("LessMeteors"), level);
		if (parent.keyCode == 52) player.applyBonus(player.getBonus("Immortal"), level);
		if (parent.keyCode == 53) player.applyBonus(player.getBonus("PointMultiplier"), level);
		//if (parent.keyCode == 53) // menu
		
	}
	
	/**
	 * Function called on Engine keyReleased function
	 * Change values of variables UP, DOWN, LEFT and RIGHT
	 * 
	 * @since 1.0
	 */
	public void eventKeyReleased(){
		if (parent.keyCode == PConstants.UP) Keyboard.UP = false;
		if (parent.keyCode == PConstants.DOWN) Keyboard.DOWN = false;
		if (parent.keyCode == PConstants.LEFT) Keyboard.LEFT = false;
		if (parent.keyCode == PConstants.RIGHT) Keyboard.RIGHT = false;
	}
	
	/**
	 * @return x MOVE
	 * @since 1.0
	 */
	public float LeftRightEvent(){
		updateLastKeys();
		updateVelocity();
		if(Keyboard.LEFT && Keyboard.RIGHT) return   Keyboard.DONT_MOVE;
		else if(Keyboard.LEFT){
			Keyboard.LAST_KEY_LEFT_RIGHT = 1;
			return - Keyboard.MOVE * Keyboard.VELOCITY_LEFT_RIGHT;
		}
		else if(Keyboard.RIGHT){
			Keyboard.LAST_KEY_LEFT_RIGHT = 2;
			return   Keyboard.MOVE * Keyboard.VELOCITY_LEFT_RIGHT;
		}
		else{
			if(Keyboard.LAST_KEY_LEFT_RIGHT == 1)      return - Keyboard.VELOCITY_LEFT_RIGHT;
			else if(Keyboard.LAST_KEY_LEFT_RIGHT == 2) return   Keyboard.VELOCITY_LEFT_RIGHT;
			return Keyboard.DONT_MOVE;
		}
	}
	
	/**
	 * @return y MOVE
	 * @since 1.0
	 */
	public float UpDownEvent(){
		updateLastKeys();
		updateVelocity();
		if(Keyboard.UP && Keyboard.DOWN) return   Keyboard.DONT_MOVE;
		else if(Keyboard.UP){
			Keyboard.LAST_KEY_UP_DOWN = 1;
			return - Keyboard.MOVE * Keyboard.VELOCITY_UP_DOWN;
		}
		else if(Keyboard.DOWN){
			Keyboard.LAST_KEY_UP_DOWN = 2;
			return   Keyboard.MOVE * Keyboard.VELOCITY_UP_DOWN;
		}
		else{
			if(Keyboard.LAST_KEY_UP_DOWN == 1)      return - Keyboard.VELOCITY_UP_DOWN;
			else if(Keyboard.LAST_KEY_UP_DOWN == 2) return   Keyboard.VELOCITY_UP_DOWN;
			return Keyboard.DONT_MOVE;
		}
	}
	
	/**
	 * Update velocity if UP, DOWN, LEFT or RIGHT keys are pressed
	 * Calls updateVelocityUpDown() and updateVelocityLeftRight()
	 * 
	 * @since 1.0
	 */
	public void updateVelocity(){
		updateVelocityUpDown();
		updateVelocityLeftRight();
	}
	
	/**
	 * Update velocity if UP or DOWN keys are pressed
	 * 
	 * @since 1.0
	 */
	public void updateVelocityUpDown(){
		if(Keyboard.UP || Keyboard.DOWN){
			if(Keyboard.VELOCITY_UP_DOWN < 1){
				Keyboard.VELOCITY_UP_DOWN += 0.1f;
			}
			else Keyboard.VELOCITY_UP_DOWN = 1;
		}
		else{
			if(Keyboard.VELOCITY_UP_DOWN > 0){
				Keyboard.VELOCITY_UP_DOWN -= 0.1f;
			}
			else {
				Keyboard.VELOCITY_UP_DOWN = 0;
			}
		}
	}
	
	/**
	 * Update velocity if LEFT or RIGHT keys are pressed
	 * 
	 * @since 1.0
	 */
	public void updateVelocityLeftRight(){
		if(Keyboard.LEFT || Keyboard.RIGHT){
			if(Keyboard.VELOCITY_LEFT_RIGHT < 1){
				Keyboard.VELOCITY_LEFT_RIGHT += 0.1f;
			}
			else Keyboard.VELOCITY_LEFT_RIGHT = 1;
		}
		else{
			if(Keyboard.VELOCITY_LEFT_RIGHT > 0){
				Keyboard.VELOCITY_LEFT_RIGHT -= 0.1f;
			}
			else {
				Keyboard.VELOCITY_LEFT_RIGHT = 0;
			}
		}
	}
	
	/**
	 * Update last keys pressed
	 * 
	 * @since 1.0
	 */
	public void updateLastKeys(){
		if(Keyboard.VELOCITY_UP_DOWN == 0.0f){
			Keyboard.LAST_KEY_UP_DOWN    = 0;
		}
		if(Keyboard.VELOCITY_LEFT_RIGHT == 0.0f){
			Keyboard.LAST_KEY_LEFT_RIGHT = 0;
		}
	}
}
