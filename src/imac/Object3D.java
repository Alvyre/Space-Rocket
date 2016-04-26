package imac;

import processing.core.*;
import com.leapmotion.leap.Vector;
public class Object3D{
	
	private PApplet parent; //PApplet object

	PShape model;           //PShape object
	String path;            //Path object
	
	float position_x;       //Position x
	float position_y;       //Position y
	float position_z;       //Position z
	
	float scale_x;          //Scale x
	float scale_y;          //Scale y
	
	float theta_x;          //Rotation x
	float theta_y;          //Rotation y
	
	/* CONSTRUCTORS */
	
	//Constructor without argument
	public Object3D(){}
	
	//Constructor with position
	public Object3D(PApplet p, float x, float y, float z){
		this.parent = p;     //PApplet parent
		this.position_x = x; //Init position x
		this.position_y = y; //Init position y
		this.position_z = z; //Init position z
		this.theta_x = 0;    //Init rotation x
		this.theta_y = 0;    //Init rotation y
	}
	
	//Constructor with path argument
	public Object3D(PApplet p, String path){
		this.parent = p;  //PApplet parent
		this.path = path; //Model path
		this.model = new PShape(); //New PShape model
		this.model = parent.loadShape(this.path); //Load object
		this.position_x = 0; //Init position x
		this.position_y = 0; //Init position y
		this.position_z = 0; //Init position z
		this.theta_x = 0;    //Init rotation x
		this.theta_y = 0;    //Init rotation y
	}
	
	//Constructor with position and path
	public Object3D(PApplet p, String path, float x, float y, float z){
		this.parent = p; //PApplet parent
		this.path = path; //Model path
		this.model = new PShape(); //New PShape model
		this.model = parent.loadShape(this.path); //Load object
		this.position_x = x; //Init position x
		this.position_y = y; //Init position y
		this.position_z = z; //Init position z	
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
	public Vector getPositionVec(){
		Vector vec = new Vector(this.position_x, this.position_y, this.position_z);
		return vec;
	}
	
	public float getScaleX(){
		return this.scale_x;
	}
	public float getScaleY(){
		return this.scale_y;
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
	
	public void translate(Vector vec){
		this.position_x += vec.getX();
		this.position_y += vec.getY();
		this.position_z += vec.getZ();
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
		this.model.setFill(parent.color(r, g, b));
	}
	
	public void display(){
		this.setColor(12, 12, 12);
        parent.pushMatrix();
        parent.translate(this.position_x, this.position_y, this.position_z);
        parent.rotateY(this.theta_x);
        parent.rotateX(this.theta_y);
        parent.shape(this.model, 0, 0);
        parent.popMatrix();
	}
	
}
