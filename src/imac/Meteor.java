package imac;

import com.leapmotion.leap.Vector;

import processing.core.*;

/**
 * <b>Meteor is the parent class to create geometric obstacles</b>
 * @author Charlie
 * @version 1.0
 */

public class Meteor {
	
	/**
	 * Reference parent PApplet of the app's sketch
	 */
	protected PApplet parent;
	
	/**
	 * Variables used to define the speed of translation and rotation of the obstacle
	 */
	float speed;
	float rotate;
	
	/**
	 * Variables used to define the obstacle position
	 */
	float position_x;
	float position_y;
	float position_z;
	
	/**
	 * Variables used to define the obstacle rotation
	 */
	float theta_x;
	float theta_y;
	
	/**
	 * Variables used to define the size of the obstacle
	 */
	float size;
		
	/* CONSTRUCTORS */
	
	/**
	 * The constructor of Meteor without parameters
	 * 
	 * @since 1.0
	 */
	public Meteor(){}
	
	/**
	 * The constructor of Meteor with 
	 * @param PApplet
	 * 
	 * @since 1.0
	 */	public Meteor(PApplet p){
		this.parent = p;
	}
	
	 /**
	  * The constructor of Meteor with position parameters
	  * @param PApplet
	  * @param x_position
	  * @param y_position
	  * @param z_position
	  * @param speed
	  * @param rotate
	  * @param theta_x
	  * @param theta_y
	  * @param size
	  * 
	  * @since 1.0
	  */
	 public Meteor(PApplet p, float x, float y, float z, float speed, float rotate, float tx, float ty, float s){
		this.parent = p;
		this.position_x = x;
		this.position_y = y;
		this.position_z = z;
		this.speed = speed;
		this.rotate= rotate;
		this.theta_x = tx;
		this.theta_y = ty;
		this.size = s;
	}
		
	/* GETTERS AND SETTERS */
	
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
	 * @return the position (X, Y, Z)
	 * @since 1.0
	 */
	public Vector getPositionVec(){
		Vector vec = new Vector(this.position_x, this.position_y, this.position_z);
		return vec;
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
	
	/* OTHER METHODS */
	
	/**
	 * Translate the obstacle on X, Y and Z
	 * @param translate on X
	 * @param translate on Y
	 * @param translate on Z
	 * @since 1.0
	 */
	public void translate(float x, float y, float z){
		this.position_x += x;
		this.position_y += y;
		this.position_z += z;
	}
	
	/**
	 * Translate the obstacle on X
	 * @param translate on X
	 * @since 1.0
	 */
	public void translateX(float x){
		this.position_x += x;
	}
	
	/**
	 * Translate the obstacle on Y
	 * @param translate on Y
	 * @since 1.0
	 */
	public void translateY(float y){
		this.position_y += y;
	}

	/**
	 * Translate the obstacle on Z
	 * @param translate on Z
	 * @since 1.0
	 */
	public void translateZ(float z){
		this.position_z += z;
	}
	
	/**
	 * Display the Meteor on PApplet sketch
	 * @since 1.0
	 */
	public void display(){
		parent.lights();
        parent.pushMatrix();
        parent.translate(this.position_x, this.position_y, this.position_z);
        setRotationX(0.01f);
        translateZ(1.0f);
        parent.rotateX(this.theta_x);
        parent.rotateY(this.theta_y);
        parent.noStroke();
        parent.box(100);
        parent.popMatrix();
	}
}
