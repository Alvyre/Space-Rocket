package imac.obstacle;

import processing.core.PApplet;

/**
 * <b>Sphere is a child of Meteor to create obstacle with sphere shape</b>
 * @author Charlie
 * @version 1.0
 */
public class Sphere extends Meteor {
	
	/**
	 * The constructor of Sphere without parameters
	 * 
	 * @since 1.0
	 */
	public Sphere(){
		super();
	}
	
	/**
	 * The constructor of Sphere with 
	 * @param PApplet
	 * 
	 * @since 1.0
	 */	public Sphere(PApplet p){
		super(p);
	}
	 
	 /**
	  * The constructor of Sphere with position parameters
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
	 public Sphere(PApplet p, float x, float y, float z, float speed,float s){
		super(p, x, y, z, speed, s);		
	}
	 
	 
	 
	 /**
	  * Display the Sphere on PApplet sketch
	  * @since 1.0
	  */
	 public void display(){
		super.display();
		parent.pushMatrix();
		parent.translate(this.getPositionX(), this.getPositionY(), this.getPositionZ());
		translateZ(this.getSpeed());
		parent.sphere(this.getSize());
		parent.popMatrix();
	}
}
