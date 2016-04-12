package testProcessing;

import processing.core.*;
import themidibus.*; //Import the library


public class MainApp extends PApplet{

	float theta1 = 0;
	float theta2 = 0;
	
	PShape spider;
	MidiBus arturia;
	
	float cc[] = new float[256];
	
	int tn[] = new int[256];

    public void setup() {
        size(640, 480, P3D);
        MidiBus.list(); // List all available Midi devices on STDOUT. This will show each device's index and name.
        arturia = new MidiBus(this, "Arturia BeatStep", "Arturia BeatStep");
        spider = loadShape("spider.obj");
    }
    
    public void controllerChange(int channel, int number, int value){
    	System.out.println("Parameter button :");
    	System.out.println(channel);
    	System.out.println(number);
    	System.out.println(value);
    	System.out.println("------");
    	
    	if(number == 10){
    		cc[number] = map(value, 0, 127, 0, 0.5f);
    	}
    	
    	if(number == 18){
    		cc[number] = map(value, 0, 127, 0, 255);
    	}
    	
    	if(number == 19){
    		cc[number] = map(value, 0, 127, 0, 255);
    	}
    	
    	if(number == 16){
    		cc[number] = map(value, 0, 127, 0, 255);
    	}
    	
    	if(number == 71){
    		cc[number] = map(value, 0, 127, 0, height);
    	}
    	
    	if(number == 74){
    		cc[number] = map(value, 0, 127, 0, width);
    	}
    	
    	if(number == 114){
    		cc[number] = map(value, 0, 127, 0, 0.5f);
    	}
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
	    	  if(tn[pitch] == 1){
	    		  tn[pitch] = -1;
	    	  }
	    	  else tn[pitch] = 1;
	    	  
	    	  println("Value:"+tn[pitch]);
    	  }
    	  
    	  if(pitch == 36){
	    	  if(tn[pitch] == 1){
	    		  tn[pitch] = -1;
	    	  }
	    	  else tn[pitch] = 1;
	    	  
	    	  println("Value:"+tn[pitch]);
    	  }
    	}

    public void draw() {
        background(220);

        theta1 += cc[10]*tn[44];
        theta2 += cc[114]*tn[36];
        
        spider.setFill(color(cc[18], cc[19], cc[16]));

        pushMatrix();
        translate(cc[74], cc[71], 0);
        rotateY(theta1);
        rotateX(theta2);
        
        //fill(255,0,0,63);
        //box(100);
        
        shape(spider, 10, 10);
        popMatrix();
    }
	
}
