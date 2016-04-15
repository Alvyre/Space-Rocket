package imac;

import processing.core.*;

public class Object3D extends PApplet{
	
	PShape model;     //PShape object
	String path;      //Path object
	
	float position_x; //Position x
	float position_y; //Position y
	float position_z; //Position z
	
	float scale_x;    //Scale x
	float scale_y;    //Scale y
	
	float theta1;     //Rotation X
	float theta2;     //Rotation Y
	
	/* CONSTRUCTORS */
	
	//Constructor without argument
	public Object3D(){
		this.position_x = 0;
		this.position_y = 0;
		this.position_z = 0;
		this.theta1 = 0;
		this.theta2 = 0;
	}
	
	//Constructor with position
	public Object3D(float x, float y, float z){
		this.position_x = x;
		this.position_y = y;
		this.position_z = z;	
		this.theta1 = 0;
		this.theta2 = 0;
	}
	
	//Constructor with path argument
	public Object3D(String path){
		this.path = path;
		this.position_x = 0;
		this.position_y = 0;
		this.position_z = 0;	
		this.theta1 = 0;
		this.theta2 = 0;
	}
	
	//Constructor with position and path
	public Object3D(String path, float x, float y, float z){
		this.path = path;
		this.position_x = x;
		this.position_y = y;
		this.position_z = z;	
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
	
	public float getScaleX(){
		return this.scale_x;
	}
	public float getScaleY(){
		return this.scale_y;
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
	
	public void setScale(float x, float y){
		this.scale_x = x;
		this.scale_y = y;
	}
	
	public void setScaleX(float x){
		this.scale_x = x;
	}
	
	public void setScaleY(float y){
		this.scale_y = y;
	}
	
	/* OTHER METHODS */
	
	//Methods to load object
	@Override
	public void setup(){
		this.model = new PShape(); 
		this.model = loadShape(this.path);
	}
	
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
	
	//Methods to set the fill color
	public void setColor(float r, float g, float b){
		this.model.setFill(color(r, g, b));
	}
	
	@Override
	public void draw(){
		this.setColor(12, 12, 12);
        pushMatrix();
        translate(0, 0, 0);
        rotateY(this.theta1);
        rotateX(this.theta2);
        shape(this.model, this.scale_x, this.scale_y);
        popMatrix();
	}
	
}
