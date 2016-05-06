package imac;

import processing.core.*;

import java.util.ArrayList;

import imac.obstacle.Meteor;

/**
 * <b>Space class contains all meteor obstacle.</b>
 * <p>It generates random position for each meteor</p>
 * <p>It use Perlin Noise<p>
 * @author Pierre
 * @author Charlie
 * @version 1.0
 */

public class Space {
	
	/**
	 * Reference parent PApplet of the app's sketch
	 */
	PApplet parent;
	
	/**
	 * Collection with all meteors
	 */
	ArrayList<Meteor> meteors;
	
	/**
	 * Number of meteors
	 */
	int nbMeteors;
	
	/**
	 * Space constructor
	 * It initialize the meteors ArrayList with Perlin Noise
	 * 
	 * @param PApplet
	 * @param meteors number
	 * 
	 * @since 1.0
	 */
	Space(PApplet p, int nbMeteors){
		this.parent = p;
		this.meteors = new ArrayList<Meteor>();
		this.nbMeteors = nbMeteors;
		
		float yoff = 0.0f; // 2nd dimension of perlin noise
		float xoff = 0.0f;
		float zoff = 0.0f;
		
		for(int i=0; i< this.nbMeteors; i++){
			
			float y = PApplet.map(parent.noise(xoff, yoff), 0, 1, 100, 800); // Option #1: 2D Noise
			
			//this.meteors.add(new Meteor(this.parent, xoff, y, zoff));
			
			// Increment x dimension for noise
		    xoff += 100;
		}
	}
	
	/**
	 * Display the space constructor
	 * 
	 * @since 1.0
	 */
	public void display(){
		for(int i = 0; i < this.meteors.size(); i++)
	    {
	      meteors.get(i).display();
	    }
	}
	
}
