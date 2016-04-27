package imac;

import processing.core.*;
import themidibus.*;
import com.leapmotion.leap.*;

import leap.*;

public class Engine extends PApplet {
	
	static int WINDOW_WIDTH  = 800;
	static int WINDOW_HEIGHT = 800;
	
	MidiBus arturia; 			 //MIDI Controller
	float cc[] = new float[256]; //Knob arrays
	int tn[] = new int[256];	 //Pad array
	
	Rocket player;
	
	@Override
	public void setup(){
		
		MidiBus.list(); // List all available Midi devices on STDOUT. This will show each device's index and name.
	    this.arturia = new MidiBus(this, "Arturia BeatStep", "Arturia BeatStep");
	    //leapController.addListener(leapListener);
	    this.player = new Rocket(new Object3D(this, "assets/models/rocket.obj"), 0, 10.0f, "Rocket name", 1);
	    
	    
	}
	
	@Override
	public void draw() {
		background(220);
		
		//this.rocket.setRotation(cc[10]*tn[44], cc[114]*tn[36]);
		//this.spider.setPosition(cc[74], cc[71], 0);
		Vector movements = new Vector(Leapmotion.handMoves());
		this.player.move(movements);
		this.player.getModel().display();
		
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
		
		// disable the keyboard control if the leap is connected
		if(!Leapmotion.isConnected()){
				
				if (key == CODED) {
					switch(keyCode){
					case UP:
						this.player.move(new Vector(0,-1,0));
						break;
					case DOWN:
						this.player.move(new Vector(0,1,0));
						break;
					case LEFT:
						this.player.move(new Vector(-1,0,0));
						break;
					case RIGHT:
						this.player.move(new Vector(1,0,0));
						break;
					default:
						break;
						
					}
				}
		}
		
	}
	   
	public void settings() {  size(WINDOW_WIDTH, WINDOW_HEIGHT, P3D); }
}
