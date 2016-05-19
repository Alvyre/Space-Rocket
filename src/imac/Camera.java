package imac;

import processing.core.PApplet;

/**
 * <b>Camera class refers to the camera of the application</b>
 * <p>It moves according to the player position</p>
 * @author Pierre
 * @version 1.0
 */

public class Camera {
	
	/**
	 * Reference parent PApplet of the app's sketch
	 */
	private PApplet parent;
	
	/**
	 * Reference parent PApplet of the app's sketch
	 */
	private Rocket player;
	
	/**
	 * XYZ coordinates for the eye
	 */
	private float eyeX, eyeY, eyeZ;
	
	/**
	 * XYZ coordinates for the center of the scene
	 */
	private float centerX, centerY, centerZ;
	
	/**
	 * Usually 0.0, 1.0, or -1.0
	 */
	private float upX, upY, upZ;
	
	/**
	 * Interval for camera and player in Y and Z axes
	 */
	private static float Y_INTERVAL = 20.0f;
	private static float Z_INTERVAL = 100.0f;
	
	/**
	 * Margin between camera and window app
	 */
	private static float X_MARGIN = 250.0f;
	private static float Y_MARGIN = 150.0f;
	
	/**
	 * The constructor of Camera with player position
	 * 
	 * @param PApplet
	 * @param Rocket player
	 * 
	 * @since 1.0
	 */
	public Camera(PApplet p, Rocket player){
		this.parent = p;
		this.player = player;
		this.eyeX = player.getPosition().getX();
		this.eyeY = player.getPosition().getY();
		this.eyeZ = player.getPosition().getZ();
		this.centerX = player.getPosition().getX();
		this.centerY = player.getPosition().getY();
		this.centerZ = 0.0f;
		this.upX = 0.0f;
		this.upY = 1.0f;
		this.upZ = 0.0f;
	}
	
	/**
	 * Method to look the scene with the camera
	 * 
	 * @param Rocket player
	 * 
	 * @since 1.0
	 */
	public void look(){
		if( (player.getPosition().getX() - Camera.X_MARGIN > 0.0f) && (player.getPosition().getX() + Camera.X_MARGIN < Engine.WINDOW_WIDTH))   this.updatePositionX();
		if( (player.getPosition().getY() - Camera.Y_MARGIN > 0.0f) && (player.getPosition().getY() + Camera.Y_MARGIN + Camera.Y_INTERVAL < Engine.WINDOW_HEIGHT))  this.updatePositionY();
		parent.camera(this.eyeX, this.eyeY - Y_INTERVAL, this.eyeZ + Z_INTERVAL,  this.centerX, this.centerY - Y_INTERVAL, this.centerZ, this.upX, this.upY, this.upZ);
	}
	
	
	/**
	 * Method to update x camera position
	 * 
	 * @since 1.0
	 */
	private void updatePositionX(){
		this.eyeX = player.getPosition().getX();
		this.centerX = player.getPosition().getX();
	}
	
	/**
	 * Method to update camera position
	 * 
	 * @since 1.0
	 */
	private void updatePositionY(){
		this.eyeY = player.getPosition().getY();
		this.centerY = player.getPosition().getY();
	}
	
	/**
	 * @return eyeX
	 * @since 1.0
	 */
	public float getEyeX(){
		return this.eyeX;
	}
	
	/**
	 * @return eyeY
	 * @since 1.0
	 */
	public float getEyeY(){
		return this.eyeY;
	}
	
	/**
	 * @return eyeZ
	 * @since 1.0
	 */
	public float getEyeZ(){
		return this.eyeZ;
	}
	
	/**
	 * @return X_MARGIN
	 * @since 1.0
	 */
	public static float getXMargin(){
		return Camera.X_MARGIN;
	}
	
	/**
	 * @return Y_MARGIN
	 * @since 1.0
	 */
	public static float getYMargin(){
		return Camera.Y_MARGIN;
	}
	
	
}
