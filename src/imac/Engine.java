package imac;

import processing.core.*;
import themidibus.*;
import com.leapmotion.leap.*;

public class Engine extends PApplet {
	
	static int WINDOW_WIDTH  = 800;
	static int WINDOW_HEIGHT = 800;
	
	MidiBus arturia; 			 //MIDI Controller
	float cc[] = new float[256]; //Knob arrays
	int tn[] = new int[256];	 //Pad array
	
	Object3D spider; //Object
	
	
	@Override
	public void setup(){
		
		//fullScreen(P3D);
		
		MidiBus.list(); // List all available Midi devices on STDOUT. This will show each device's index and name.
	    this.arturia = new MidiBus(this, "Arturia BeatStep", "Arturia BeatStep");
	    
	    this.spider = new Object3D("./assets/models/spider.obj");
	    
	}
	
	@Override
	public void draw() {
		background(220);
		//this.theta1 += cc[10]*tn[44];
        //this.theta2 += cc[114]*tn[36];
		this.spider.draw();
    }
	
	public void controllerChange(int channel, int number, int value){
		System.out.println("Parameter button :");
		System.out.println(channel);
		System.out.println(number);
		System.out.println(value);
		System.out.println("------");
	    	
		if(number == 10) this.cc[number] = map(value, 0, 127, 0, 0.5f);
		if(number == 18) this.cc[number] = map(value, 0, 127, 0, 255);
		if(number == 19) this.cc[number] = map(value, 0, 127, 0, 255);
		if(number == 16) this.cc[number] = map(value, 0, 127, 0, 255);
		if(number == 71) this.cc[number] = map(value, 0, 127, 0, height);
		if(number == 74) this.cc[number] = map(value, 0, 127, 0, width);
		if(number == 114) this.cc[number] = map(value, 0, 127, 0, 0.5f);
	}
	
	public void noteOn(int channel, int pitch, int velocity) {
		// Receive a noteOn
	    println();
	    println("Note On:");
	    println("Channel:"+channel);
	    println("Pitch:"+pitch);
	    println("Velocity:"+velocity);
	    println("--------");
	   
	    if(pitch == 44){
	    	if(tn[pitch] == 1) tn[pitch] = -1;
	    	else tn[pitch] = 1;
		    println("Value:"+tn[pitch]);
	    }
	    	  
	    if(pitch == 36){
	    	if(tn[pitch] == 1) tn[pitch] = -1;
	    	else tn[pitch] = 1;
	    	println("Value:"+tn[pitch]);
	    }
	}

	public void keyPressed() {
		if (key == CODED) {
			if (keyCode == UP) {
				//fillVal = 255;
			}
			else if (keyCode == DOWN) {
				//fillVal = 0;
			} 
		}
		else {
			//fillVal = 126;
		}
	}
	   
	public void settings() {  size(WINDOW_WIDTH, WINDOW_HEIGHT, P3D); }
}
