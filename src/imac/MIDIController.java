package imac;

import processing.core.*;
import themidibus.*;

public class MIDIController {
	
	private PApplet parent; //PApplet object
	
	MidiBus arturia; 			 //MIDI Controller
	float cc[] = new float[256]; //Knob arrays
	int tn[] = new int[256];	 //Pad array
	
	/* CONSTRUCTOR */
	
	public MIDIController(PApplet p){
		this.parent = p;     //PApplet parent
		MidiBus.list(); // List all available Midi devices on STDOUT. This will show each device's index and name.
	    this.arturia = new MidiBus(this, "Arturia BeatStep", "Arturia BeatStep");
	}
	
	/* GETTERS AND SETTERS */
	
	public float getPositionX(){
		return cc[74];
	}
	
	public float getPositionY(){
		return cc[71];
	}
	
	public float getPositionZ(){
		return 0;
	}
	
	public float getRotationX(){
		return cc[10]*tn[44];
	}
	
	public float getRotationY(){
		return cc[114]*tn[36];
	}
	
	/* OTHER METHODS */
	
	public void controllerChange(int channel, int number, int value){
		System.out.println("Parameter button :");
		System.out.println(channel);
		System.out.println(number);
		System.out.println(value);
		System.out.println("------");
	    	
		if(number == 10) this.cc[number] = PApplet.map(value, 0, 127, 0, 0.5f);
		if(number == 18) this.cc[number] = PApplet.map(value, 0, 127, 0, 255);
		if(number == 19) this.cc[number] = PApplet.map(value, 0, 127, 0, 255);
		if(number == 16) this.cc[number] = PApplet.map(value, 0, 127, 0, 255);
		if(number == 71) this.cc[number] = PApplet.map(value, 0, 127, 0, parent.height);
		if(number == 74) this.cc[number] = PApplet.map(value, 0, 127, 0, parent.width);
		if(number == 114) this.cc[number] = PApplet.map(value, 0, 127, 0, 0.5f);
	}
	
	public void noteOn(int channel, int pitch, int velocity) {
		// Receive a noteOn
		PApplet.println();
		PApplet.println("Note On:");
		PApplet.println("Channel:"+channel);
		PApplet.println("Pitch:"+pitch);
		PApplet.println("Velocity:"+velocity);
		PApplet.println("--------");
	   
	    if(pitch == 44){
	    	if(tn[pitch] == 1) tn[pitch] = -1;
	    	else tn[pitch] = 1;
	    	PApplet.println("Value:"+tn[pitch]);
	    }
	    	  
	    if(pitch == 36){
	    	if(tn[pitch] == 1) tn[pitch] = -1;
	    	else tn[pitch] = 1;
	    	PApplet.println("Value:"+tn[pitch]);
	    }
	}
		
}
