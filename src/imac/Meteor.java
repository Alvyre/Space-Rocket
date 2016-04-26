package imac;

import processing.core.*;

public class Meteor {
	
	private PApplet parent; //PApplet object
	
	float position_x;       //Position x
	float position_y;       //Position y
	float position_z;       //Position z
	
	float theta_x;          //Rotation x
	float theta_y;          //Rotation y
	
/* CONSTRUCTORS */
	
	//Constructor without argument
	public Meteor(){}
	
	//Constructor with PApplet
	public Meteor(PApplet p){
		this.parent = p;
	}
	
	/* GETTERS AND SETTERS */
	
	public float getPositionX(){
		return this.position_x;
	}
	
	public float getPositionY(){
		return this.position_y;
	}
	
	public float getPositionZ(){
		return this.position_z;
	}
		
	public void setPosition(float x, float y, float z){
		this.position_x = x;
		this.position_y = y;
		this.position_z = z;
	}
	
	public void setPositionX(float x){
		this.position_x = x;
	}
	
	public void setPositionY(float y){
		this.position_y = y;
	}
	
	public void setPositionZ(float z){
		this.position_z = z;
	}
		
	public void setRotation(float theta_x, float theta_y){
		this.theta_x += theta_x;
		this.theta_y += theta_y;
	}
	
	public void setRotationX(float theta){
		this.theta_x += theta;
	}
	
	public void setRotationY(float theta){
		this.theta_y += theta;
	}
	
	/* OTHER METHODS */
	
	
	//Methods to translate object position
	public void translate(float x, float y, float z){
		this.position_x += x;
		this.position_y += y;
		this.position_z += z;
	}
	
	//Methods to translate object position on X axe
	public void translateX(float x){
		this.position_x += x;
	}
	
	//Methods to translate object position on Y axe
	public void translateY(float y){
		this.position_y += y;
	}

	//Methods to translate object position on Z axe
	public void translateZ(float z){
		this.position_z += z;
	}
	
	public void display(){
		parent.lights();
        parent.pushMatrix();
        parent.translate(130, 600/2, 0);
        parent.rotateY(1.25f);
        parent.rotateX(-0.4f);
        parent.noStroke();
        parent.box(100);
        parent.popMatrix();
	}
}
