package imac;

import processing.core.*;
import themidibus.*;

/**
 * <b>MIDIController allows to interact with a physical controller</b>
 * <p>Connect a physical controller</p>
 * <p>Get and set some informations about it</p>
 * <p>Class import @see themidibus library</>
 * @author Pierre
 * @version 1.0
 */

public class MIDIController {
	
	/**
	 * Reference parent PApplet of the app's sketch
	 */
	private PApplet parent;
	
	/**
	 * Datatype for a MIDI Controller
	 */
	MidiBus arturia;
	
	/**
	 * Arrays with knobs statements
	 */
	float cc[] = new float[256];
	
	/**
	 * Arrays with pads statements
	 */
	int tn[] = new int[256];
	
	
	/**
	 * The constructor of MIDIController with PApplet parameter
	 * @param PApplet
	 * 
	 * @since 1.0
	 */
	public MIDIController(PApplet p){
		this.parent = p;
		MidiBus.list();
	    this.arturia = new MidiBus(this, "Arturia BeatStep", "Arturia BeatStep");
	}
	
	/**
	 * @return the state of first knob
	 * @since 1.0
	 */
	public float getPositionX(){
		return cc[74];
	}
	
	/**
	 * @return the state of second knob
	 * @since 1.0
	 */
	public float getPositionY(){
		return cc[71];
	}
	
	/**
	 * @return the state of third knob
	 * @since 1.0
	 */
	public float getPositionZ(){
		return 0;
	}
	
	/**
	 * @return the states of first knob and of first pad
	 * @since 1.0
	 */
	public float getRotationX(){
		return cc[10]*tn[44];
	}
	
	/**
	 * @return the states of second knob and of first pad
	 * @since 1.0
	 */
	public float getRotationY(){
		return cc[114]*tn[36];
	}
	
	/**
	 * MIDIController listener
	 * @param channel
	 * @param number
	 * @param value
	 * @since 1.0
	 */
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
	
	/**
	 * MIDIController noteOn
	 * @param channel
	 * @param pitch
	 * @param velocity
	 * @since 1.0
	 */
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
