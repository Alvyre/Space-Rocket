package imac;

import processing.core.*;
import com.leapmotion.leap.*;

public class Engine extends PApplet {
	
	static int WINDOW_WIDTH  = 800;
	static int WINDOW_HEIGHT = 800;
	
	MIDIController arturia;
	Object3D spider; //Object
	
	
	@Override
	public void setup(){
		this.arturia = new MIDIController(this);
	    this.spider = new Object3D(this, "./assets/models/spider.obj");
	}
	
	@Override
	public void draw() {
		background(220);
		this.spider.setRotation(arturia.getRotationX(), arturia.getRotationY());
		this.spider.setPosition(arturia.getPositionX(), arturia.getPositionY(), arturia.getPositionZ());
		this.spider.display();
    }
	


	public void keyPressed() {
		if (key == CODED) {
			if (keyCode == UP) {
				this.spider.translateY(-1);
			}
			else if (keyCode == DOWN) {
				this.spider.translateY(1);
			} 
		}
		else {
			//fillVal = 126;
		}
	}
	   
	public void settings() {  size(WINDOW_WIDTH, WINDOW_HEIGHT, P3D); }
}
