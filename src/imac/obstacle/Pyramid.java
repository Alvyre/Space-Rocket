package imac.obstacle;

import processing.core.PApplet;
import processing.core.PConstants;

/**
 * <b>Pyramid is a child of Meteor to create obstacle with pyramid shape</b>
 * @author Charlie
 * @version 1.0
 */
public class Pyramid extends Meteor {

	/**
	 * The constructor of Pyramid without parameters
	 * 
	 * @since 1.0
	 */
	public Pyramid(){
		super();
	}
	
	/**
	 * The constructor of Sphere with 
	 * @param PApplet
	 * 
	 * @since 1.0
	 */	public Pyramid(PApplet p){
		super(p);
	}
	 
	 /**
	  * The constructor of Pyramid with position parameters
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
	 public Pyramid(PApplet p, float x, float y, float z, float speed, float rotate, float tx, float ty, float s){
		super(p, x, y, z, speed, rotate, tx, ty, s);		
	}
	 
	 /**
	  * Display the Pyramid on PApplet sketch
	  * @since 1.0
	  */
		public void display(){
			parent.lights();
			parent.noStroke();
	        parent.pushMatrix();

	        parent.rotateX(0.5f);
	        parent.rotateZ(-0.1f);
	        

	        parent.translate(this.getPositionX(), this.getPositionY(), this.getPositionZ());
	        translateZ(this.getSpeed());
	        
	        parent.stroke(0);
	        parent.fill(255);
	        parent.beginShape(PConstants.TRIANGLES);
	        parent.vertex(-this.getSize(), -this.getSize(), -this.getSize());
	        parent.vertex( this.getSize(), -this.getSize(), -this.getSize());
	        parent.vertex(   0,    0,  this.getSize());

	        parent.vertex( this.getSize(), -this.getSize(), -this.getSize());
	        parent.vertex( this.getSize(),  this.getSize(), -this.getSize());
	        parent.vertex(   0,    0,  this.getSize());

	        parent.vertex( this.getSize(), this.getSize(), -this.getSize());
	        parent.vertex(-this.getSize(), this.getSize(), -this.getSize());
	        parent.vertex(   0,   0,  this.getSize());

	        parent.vertex(-this.getSize(),  this.getSize(), -this.getSize());
	        parent.vertex(-this.getSize(), -this.getSize(), -this.getSize());
	        parent.vertex(   0,    0,  this.getSize());
	        parent.endShape();
	        
	        parent.popMatrix();
		}
}
