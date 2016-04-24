package imac;

import processing.core.*;
import com.leapmotion.leap.*;

public class Engine extends PApplet {
	
	static int WINDOW_WIDTH  = 800;
	static int WINDOW_HEIGHT = 800;
	
	MIDIController arturia;
	Keyboard keyboard;
	Object3D spider; //Object
	
	
	@Override
	public void setup(){
		this.arturia = new MIDIController(this);
		this.keyboard = new Keyboard(this);
	    this.spider = new Object3D(this, "./assets/models/spider.obj");
	}
	
	@Override
	public void draw() {
		background(220);
		
		this.spider.setRotation(arturia.getRotationX(), arturia.getRotationY());
		this.spider.setPosition(arturia.getPositionX(), arturia.getPositionY(), arturia.getPositionZ());
		
		//To use keyboard, comment the previous line and uncomment the next line
		//this.spider.translate(keyboard.EventLeftRight(), keyboard.EventUpDown(), 0);
		
		this.spider.display();
    }
	   
	public void settings() {  size(WINDOW_WIDTH, WINDOW_HEIGHT, P3D); }
}
