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
		
		float yoff = 0.0f; // 2nd dimension of perlin noise
		float xoff = 0.0f;
		float zoff = -400.0f;

		for(int i=0; i< this.nbMeteors; i++){
			
			float y = PApplet.map(parent.noise(xoff, yoff), 0, 1, 0, Engine.WINDOW_HEIGHT); // Option #1: 2D Noise
			
			System.out.println("x:" + xoff + ", y:" + y + ", z:" + zoff);
			
			float speed = parent.random(minSpeed, maxSpeed);
			
			int randShape = (int)parent.random(1, 4);
			
			if(randShape == 1) this.meteors.add(new Box(this.parent, xoff, y, zoff, speed, 2, 2, 2, 10));
			else if( randShape == 2) this.meteors.add(new Sphere(this.parent, xoff, y, zoff, speed, 2, 2, 2, 10));
			else this.meteors.add(new Pyramid(this.parent, xoff, y, zoff, speed, 2, 2, 2, 10));
			
			// Increment x dimension for noise
		    xoff += 10;
		    yoff += 4;
		}
	}
	
	void drawGrid(){
		int gridSize = 40;
		int xoffset = 0;
		int yoffset = 250; // drawn at y = 250 ("below" the red grid)
		int zoffset = -600; // drawn at z = 100 ("father away from us" that the red grid)
	    for(int i = -Engine.WINDOW_WIDTH/2; i <Engine.WINDOW_WIDTH/2; i+=gridSize) {
	    for(int j = -Engine.WINDOW_HEIGHT/2; j < Engine.WINDOW_HEIGHT/2; j+=gridSize) {
	      int y = 200;
	      parent.line(xoffset + i,          yoffset + y, zoffset + j,           xoffset + i+gridSize, yoffset + y, zoffset + j          );
	      parent.line(xoffset + i+gridSize, yoffset + y, zoffset + j,           xoffset + i+gridSize, yoffset + y, zoffset + j+gridSize );
	      parent.line(xoffset + i+gridSize, yoffset + y, zoffset + j+gridSize,  xoffset + i,          yoffset + y, zoffset + j+gridSize );
	      parent.line(xoffset + i,          yoffset + y, zoffset + j,           xoffset + i,          yoffset + y, zoffset + j+gridSize );
	    }
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
			parent.pushMatrix();
			drawGrid();
			//parent.camera();
			meteors.get(i).display();
			parent.popMatrix();
			System.out.println("x:" + meteors.get(0).getPositionX() + ", y:" + meteors.get(0).getPositionY() + ", z:" + meteors.get(0).getPositionZ());
	    }
	}
	
}
