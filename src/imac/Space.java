package imac;

import processing.core.*;

import java.util.ArrayList;

/**
 * <b>Space class contains all meteor obstacle.</b>
 * <p>She generates random position for each metero</p>
 * <p>She use Perlin Noise<p>
 * @author Pierre
 * @version 1.0
 */

public class Space {
	
	PApplet parent;
	
	ArrayList<Meteor> meteors;
	
	int nbMeteors;
	
	Space(PApplet p, int nbMeteors){
		this.parent = p;
		this.meteors = new ArrayList<Meteor>();
		this.nbMeteors = nbMeteors;
		
		float yoff = 0.0f; // 2nd dimension of perlin noise
		float xoff = 0.0f;
		float zoff = 0.0f;
		
		for(int i=0; i< this.nbMeteors; i++){
			
			float y = PApplet.map(parent.noise(xoff, yoff), 0, 1, 100, 800); // Option #1: 2D Noise
			
			System.out.println("x:" + xoff + ", y:" + y + ", z:" + zoff);
			
			this.meteors.add(new Meteor(this.parent, xoff, y, zoff));
			
			// Increment x dimension for noise
		    xoff += 100;
		}
	}
	
	public void display(){
		for(int i = 0; i < this.meteors.size(); i++)
	    {
	      meteors.get(i).display();
	    }
	}
	
}
