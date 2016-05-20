package imac;

import processing.core.*;
import com.leapmotion.leap.Vector;

/**
 * <b>Object3D class is an helper tool to control a PShape model</b>
 * @author Pierre
 * @version 1.0
 */

public class Object3D{
	
	/**
	 * Reference parent PApplet of the app's sketch
	 */
	private PApplet parent;
	
	/**
	 * Datatype for storing shapes. Here, it is a 3D
	 * model load with the function loadShape()
	 */
	private PShape model;
	
	/**
	 * Path where the 3D model is located
	 * The best way is to use "./" in the beginning of
	 * your path to start from the root of the app
	 */
	private String path;
	
	/**
	 * Variables used to define the object position
	 */
	private float position_x;
	private float position_y;
	private float position_z;
	
	/**
	 * Variables used to define the object scale
	 */
	private float scale_x;
	private float scale_y;
	private float scale_z;
	
	/**
	 * Variable used to define the object rotation in X
	 */
	private float theta_x;
	/**
	 * Variable used to define the object rotation in Y
	 */
	private float theta_y;
	
	
	/**
	 * The constructor of Object3D without parameters
	 * 
	 * @since 1.0
	 */
	public Object3D(){}
	
	/**
	 * The constructor of Object3D with position parameters
	 * @param PApplet
	 * @param x_position
	 * @param y_position
	 * @param z_position
	 * 
	 * @since 1.0
	 */
	public Object3D(PApplet p, float x, float y, float z){
		this.parent = p;
		this.position_x = x;
		this.position_y = y;
		this.position_z = z;
		this.theta_x = 0.0f;
		this.theta_y = 0.0f;
	}
	
	/**
	 * The constructor of Object3D with path parameter
	 * @param PApplet
	 * @param path
	 * 
	 * @since 1.0
	 */
	public Object3D(PApplet p, String path){
		this.parent = p;
		this.path = path;
		this.model = new PShape();
		this.model = parent.loadShape(this.path);
		this.position_x = Engine.WINDOW_WIDTH / 2;
		this.position_y = Engine.WINDOW_HEIGHT / 2;
		this.position_z = 0.0f;
		this.theta_x = 0.0f;
		this.theta_y = 0.0f;
	}
	
	/**
	 * The constructor of Object3D with position and path parameters
	 * @param PApplet
	 * @param path
	 * @param x_position
	 * @param y_position
	 * @param z_position
	 * 
	 * @since 1.0
	 */
	public Object3D(PApplet p, String path, float x, float y, float z){
		this.parent = p;
		this.path = path;
		this.model = new PShape();
		this.model = parent.loadShape(this.path);
		this.position_x = x;
		this.position_y = y;
		this.position_z = z;
	}
	
	/**
	 * The constructor of Object3D with position, scale and path parameters
	 * @param PApplet
	 * @param path
	 * @param x_position
	 * @param y_position
	 * @param z_position
	 * @param x_scale
	 * @param y_scale
	 * @param z_scale
	 * 
	 * @since 1.0
	 */
	public Object3D(PApplet p, String path, float x, float y, float z, float scaleX, float scaleY, float scaleZ){
		this(p, path, x, y, z);
		this.scale_x = scaleX;
		this.scale_y = scaleY;
		this.scale_z = scaleZ;
	}
	
	/**
	 * @return the X position
	 * @since 1.0
	 */
	public float getPositionX(){
		return this.position_x;
	}
	
	/**
	 * @return the Y position
	 * @since 1.0
	 */
	public float getPositionY(){
		return this.position_y;
	}
	
	/**
	 * @return the Z position
	 * @since 1.0
	 */
	public float getPositionZ(){
		return this.position_z;
	}
	/**
	 * Getter of the position with a vector
	 * @return Vector
	 * @since 1.0
	 */
	public Vector getPositionVec(){
		Vector vec = new Vector(this.position_x, this.position_y, this.position_z);
		return vec;
	}
	
	/**
	 * @return the X scale
	 * @since 1.0
	 */
	public float getScaleX(){
		return this.scale_x;
	}
	
	/**
	 * @return the Y scale
	 * @since 1.0
	 */
	public float getScaleY(){
		return this.scale_y;
	}
	/**
	 * @return the Y scale
	 * @since 1.0
	 */
	public float getScaleZ(){
		return this.scale_z;
	}
	
	/**
	 * @return the model
	 */
	public PShape getModel() {
		return model;
	}

	/**
	 * @param the x position to set
	 * @param the y position to set
	 * @param the z position to set
	 * @since 1.0
	 */
	public void setPosition(float x, float y, float z){
		this.position_x = x;
		this.position_y = y;
		this.position_z = z;
	}
	
	/**
	 * @param the x position to set
	 * @since 1.0
	 */
	public void setPositionX(float x){
		this.position_x = x;
	}
	
	/**
	 * @param the y position to set
	 * @since 1.0
	 */
	public void setPositionY(float y){
		this.position_y = y;
	}
	
	/**
	 * @param the z position to set
	 * @since 1.0
	 */
	public void setPositionZ(float z){
		this.position_z = z;
	}
	
	/**
	 * @param the x scale to set
	 * @param the y scale to set
	 * @since 1.0
	 */
	public void setScale(float x, float y){
		this.scale_x = x;
		this.scale_y = y;
	}
	
	/**
	 * @param the x scale to set
	 * @since 1.0
	 */
	public void setScaleX(float x){
		this.scale_x = x;
	}
	
	/**
	 * @param the y scale to set
	 * @since 1.0
	 */
	public void setScaleY(float y){
		this.scale_y = y;
	}
	
	/**
	 * @param the x theta to set
	 * @param the y theta to set
	 * @since 1.0
	 */
	public void setRotation(float theta_x, float theta_y){
		this.theta_x += theta_x;
		this.theta_y += theta_y;
	}
	
	/**
	 * @param the x theta to set
	 * @since 1.0
	 */
	public void setRotationX(float theta){
		this.theta_x += theta;
	}
	
	/**
	 * @param the y theta to set
	 * @since 1.0
	 */
	public void setRotationY(float theta){
		this.theta_y += theta;
	}
	
	/**
	 * Load 3D model with path
	 * @param path
	 * @since 1.0
	 */
	public void load(String path){
		this.model = parent.loadShape(this.path);
	}

	/**
	 * Translate the model on X, Y and Z
	 * @param 3d vector
	 * @since 1.0
	 */
	public void translate(Vector vec){
		this.position_x += vec.getX();
		this.position_y += vec.getY();
		this.position_z += vec.getZ();
	}
	
	/**
	 * Translate the model on X
	 * @param translate on X
	 * @since 1.0
	 */
	public void translateX(float x){
		this.position_x += x;
	}
	
	/**
	 * Translate the model on Y
	 * @param translate on Y
	 * @since 1.0
	 */
	public void translateY(float y){
		this.position_y += y;
	}

	/**
	 * Translate the model on Z
	 * @param translate on Z
	 * @since 1.0
	 */
	public void translateZ(float z){
		this.position_z += z;
	}
	
	/**
	 * Set the fill color (RGB)
	 * @param red
	 * @param green
	 * @param blue
	 * @since 1.0
	 */
	public void setColor(float r, float g, float b){
		this.model.setFill(parent.color(r, g, b));
	}
	
	/**
	 * Display the model on PApplet sketch
	 * @since 1.0
	 */
	public void display(){
		parent.pushMatrix();
        parent.translate(this.position_x, this.position_y, this.position_z);
        parent.rotateX(30);
        parent.scale(this.scale_x, this.scale_y, this.scale_z);
        parent.shape(this.model, 0, 0);
        parent.popMatrix();
	}
	
}
