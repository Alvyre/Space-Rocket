package imac;

import processing.core.*;
import themidibus.*;

/**
 * <b>MIDIController allows to interact with a physical controller</b>
 * <p>Connect a physical controller</p>
 * <p>Get and set some informations about it</p>
 * <p>Class import @see themidibus library</>
 * <p>Optimize for a Arturia Beatstep @see Arturia website for more information</p>
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
	private MidiBus arturia;
	
	/**
	 * Arrays with knobs statements
	 */
	float knobs[] = new float[256];
	
	/**
	 * Arrays with pads statements
	 */
	int pads[] = new int[256];
	
	
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
	 * @return the Arturia MIDI Controller
	 * @since 1.0
	 */
	public MidiBus getArturia(){
		return this.arturia;
	}
	
	/**
	 * @return the state of the knob number 1
	 * @since 1.0
	 */
	public float getStateKnobNumber1(){
		return knobs[10];
	}
	
	/**
	 * @return the state of the knob number 2
	 * @since 1.0
	 */
	public float getStateKnobNumber2(){
		return knobs[74];
	}
	
	/**
	 * @return the state of the knob number 3
	 * @since 1.0
	 */
	public float getStateKnobNumber3(){
		return knobs[71];
	}
	
	/**
	 * @return the state of the knob number 4
	 * @since 1.0
	 */
	public float getStateKnobNumber4(){
		return knobs[76];
	}
	
	/**
	 * @return the state of the knob number 5
	 * @since 1.0
	 */
	public float getStateKnobNumber5(){
		return knobs[77];
	}
	
	/**
	 * @return the state of the knob number 6
	 * @since 1.0
	 */
	public float getStateKnobNumber6(){
		return knobs[93];
	}
	
	/**
	 * @return the state of the knob number 7
	 * @since 1.0
	 */
	public float getStateKnobNumber7(){
		return knobs[73];
	}
	
	/**
	 * @return the state of the knob number 8
	 * @since 1.0
	 */
	public float getStateKnobNumber8(){
		return knobs[75];
	}
	
	/**
	 * @return the state of the knob number 9
	 * @since 1.0
	 */
	public float getStateKnobNumber9(){
		return knobs[114];
	}
	
	/**
	 * @return the state of the knob number 10
	 * @since 1.0
	 */
	public float getStateKnobNumber10(){
		return knobs[18];
	}
	
	/**
	 * @return the state of the knob number 11
	 * @since 1.0
	 */
	public float getStateKnobNumber11(){
		return knobs[19];
	}
	
	/**
	 * @return the state of the knob number 12
	 * @since 1.0
	 */
	public float getStateKnobNumber12(){
		return knobs[16];
	}
	
	/**
	 * @return the state of the knob number 13
	 * @since 1.0
	 */
	public float getStateKnobNumber13(){
		return knobs[17];
	}
	
	/**
	 * @return the state of the knob number 14
	 * @since 1.0
	 */
	public float getStateKnobNumber14(){
		return knobs[91];
	}
	
	/**
	 * @return the state of the knob number 15
	 * @since 1.0
	 */
	public float getStateKnobNumber15(){
		return knobs[79];
	}
	
	/**
	 * @return the state of the knob number 16
	 * @since 1.0
	 */
	public float getStateKnobNumber16(){
		return knobs[72];
	}
	
	/**
	 * @return the state of the pad number 1
	 * @since 1.0
	 */
	public float getStatePadNumber1(){
		return pads[44];
	}
	
	/**
	 * @return the state of the pad number 2
	 * @since 1.0
	 */
	public float getStatePadNumber2(){
		return pads[45];
	}
	
	/**
	 * @return the state of the pad number 3
	 * @since 1.0
	 */
	public float getStatePadNumber3(){
		return pads[46];
	}
	
	/**
	 * @return the state of the pad number 4
	 * @since 1.0
	 */
	public float getStatePadNumber4(){
		return pads[47];
	}
	
	/**
	 * @return the state of the pad number 5
	 * @since 1.0
	 */
	public float getStatePadNumber5(){
		return pads[48];
	}
	
	/**
	 * @return the state of the pad number 6
	 * @since 1.0
	 */
	public float getStatePadNumber6(){
		return pads[49];
	}
	
	/**
	 * @return the state of the pad number 7
	 * @since 1.0
	 */
	public float getStatePadNumber7(){
		return pads[50];
	}
	
	/**
	 * @return the state of the pad number 8
	 * @since 1.0
	 */
	public float getStatePadNumber8(){
		return pads[51];
	}
	
	/**
	 * @return the state of the pad number 9
	 * @since 1.0
	 */
	public float getStatePadNumber9(){
		return pads[36];
	}
	
	/**
	 * @return the state of the pad number 10
	 * @since 1.0
	 */
	public float getStatePadNumber10(){
		return pads[37];
	}
	
	/**
	 * @return the state of the pad number 11
	 * @since 1.0
	 */
	public float getStatePadNumber11(){
		return pads[38];
	}

	/**
	 * @return the state of the pad number 12
	 * @since 1.0
	 */
	public float getStatePadNumber12(){
		return pads[39];
	}
	
	/**
	 * @return the state of the pad number 13
	 * @since 1.0
	 */
	public float getStatePadNumber13(){
		return pads[40];
	}
	
	/**
	 * @return the state of the pad number 14
	 * @since 1.0
	 */
	public float getStatePadNumber14(){
		return pads[41];
	}
	
	/**
	 * @return the state of the pad number 15
	 * @since 1.0
	 */
	public float getStatePadNumber15(){
		return pads[42];
	}
	
	/**
	 * @return the state of the pad number 16
	 * @since 1.0
	 */
	public float getStatePadNumber16(){
		return pads[43];
	}
	
	/**
	 * @return the result of the first knob state multiply by the first pad state
	 * @since 1.0
	 */
	public float getStateKnobNumber1PadNumber1(){
		return knobs[10]*pads[44];
	}
	
	/**
	 * @return the result of the ninth knob state multiply by the ninth pad state
	 * @since 1.0
	 */
	public float getStateKnobNumber9PadNumber9(){
		return knobs[114]*pads[36];
	}
	
	/**
	 * MIDIController Knobs listener
	 * @param channel
	 * @param number
	 * @param value
	 * @since 1.0
	 */
	public void controllerChange(int channel, int number, int value){
		System.out.println("Knob : [channel: " + channel + ", number: " + number + ", value: " + value + "]");
	    	
		if(number == 10) this.knobs[number] = PApplet.map(value, 0, 127, 0, 0.5f);
		if(number == 18) this.knobs[number] = PApplet.map(value, 0, 127, 0, 255);
		if(number == 19) this.knobs[number] = PApplet.map(value, 0, 127, 0, 255);
		if(number == 16) this.knobs[number] = PApplet.map(value, 0, 127, 0, 255);
		if(number == 71) this.knobs[number] = PApplet.map(value, 0, 127, 0, parent.height);
		if(number == 74) this.knobs[number] = PApplet.map(value, 0, 127, 0, parent.width);
		if(number == 114) this.knobs[number] = PApplet.map(value, 0, 127, 0, 0.5f);
	}
	
	/**
	 * MIDIController Pads listener
	 * @param channel
	 * @param pitch
	 * @param velocity
	 * @since 1.0
	 */
	public void noteOn(int channel, int pitch, int velocity) {
		System.out.print("Pad : [channel: " + channel + ", pitch: " + pitch + ", velocity: " + velocity);
	   
	    if(pitch == 44){
	    	if(pads[pitch] == 1) pads[pitch] = -1;
	    	else pads[pitch] = 1;
	    	System.out.print(", value: " + pads[pitch]);
	    }
	    	  
	    if(pitch == 36){
	    	if(pads[pitch] == 1) pads[pitch] = -1;
	    	else pads[pitch] = 1;
	    	System.out.print(", value: " + pads[pitch]);
	    }
	    
	    System.out.println("]");
	}
		
}
