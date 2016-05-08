package imac;

import processing.core.*;

import java.util.ArrayList;

import imac.obstacle.*;

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
	private PApplet parent;
	
	/**
	 * Collection with all meteors
	 */
	private ArrayList<Meteor> meteors;
	
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
	Space(PApplet p, int nbMeteors, float minSpeed, float maxSpeed){
		this.parent = p;
		this.meteors = new ArrayList<Meteor>();
		this.nbMeteors = nbMeteors;
		
		float yoff = 0.0f;
		float xoff = 0.0f;
		float zoff = parent.random(-300.0f, -1200.0f);;
		
		for(int i=0; i< this.nbMeteors; i++){
			
			float y = PApplet.map(parent.noise(xoff, yoff), 0, 1, 0, Engine.WINDOW_HEIGHT);
			float speed = parent.random(minSpeed, maxSpeed);
			int randShape = (int)parent.random(1, 4);
			
			if(randShape == 1)       this.meteors.add(new Box(this.parent, xoff, y, zoff, speed, 2, 2, 2, 10));
			else if( randShape == 2) this.meteors.add(new Sphere(this.parent, xoff, y, zoff, speed, 2, 2, 2, 10));
			else                     this.meteors.add(new Pyramid(this.parent, xoff, y, zoff, speed, 2, 2, 2, 10));
			
			xoff += 10;
		    yoff += 4;
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
