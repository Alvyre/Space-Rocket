package imac;

import processing.core.*;

public class Object3D extends PApplet{
	
	PShape object; //Object
	
	//Constructor without argument
	public Object3D(){}
	
	//Constructor with path argument
	public Object3D(String path){
		this.object = loadShape(path);
	}
	
	//Methods to load object
	public void load(String path){
		this.object = loadShape(path);
	}
}
