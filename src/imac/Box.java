package imac;

import processing.core.PApplet;

/**
 * <b>Box is a child of Meteor to create obstacle with box shape</b>
 * @author Charlie
 * @version 1.0
 */
public class Box extends Meteor {
	
	/**
	 * The constructor of Box without parameters
	 * 
	 * @since 1.0
	 */
	public Box(){
		super();
	}
	
	/**
	 * The constructor of Sphere with 
	 * @param PApplet
	 * 
	 * @since 1.0
	 */	public Box(PApplet p){
		super(p);
	}
	 
	 /**
	  * The constructor of Box with position parameters
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
	 public Box(PApplet p, float x, float y, float z, float speed, float rotate, float tx, float ty, float s){
		super(p, x, y, z, speed, rotate, tx, ty, s);		
	}
	 
	 /**
	  * Display the Sphere on PApplet sketch
	  * @since 1.0
	  */
	 public void display(){
		parent.lights();
		parent.fill(255);
		parent.pushMatrix();
		parent.translate(this.position_x, this.position_y, this.position_z);
		parent.box(this.size);
		parent.popMatrix();
	}
}
