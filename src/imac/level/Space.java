package imac.level;

import processing.core.*;
import java.util.ArrayList;

import imac.Engine;
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
	 * When a meteor begins to be visible 
	 */
	private static float METEOR_START = -1200.0f;
	
	/**
	 * When a meteor is not visible anymore
	 */
	private static float MARGIN_BEHIND_MODEL = 100.0f;
	
	/**
	 * When a meteor is not visible anymore
	 */
	private static float FILL_GRID = 227;
	
	/**
	 * Minimum and maximum meteor size
	 */
	private static int MIN_METEOR_SIZE = 5;
	private static int MAX_METEOR_SIZE = 15;
	
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

		float zoff = parent.random(METEOR_START + 100.0f, Space.METEOR_START);;
		
		for(int i=0; i< this.nbMeteors; i++){
			
			float y = PApplet.map(parent.noise(xoff, yoff), 0, 1, 0, Engine.WINDOW_HEIGHT);
			float x = PApplet.map(parent.noise(yoff, xoff), 0, 1, 0, Engine.WINDOW_WIDTH);
			float speed = parent.random(minSpeed, maxSpeed);
			int randShape = (int)parent.random(1, 3);
			
			if(randShape == 1)       this.meteors.add(new Box(this.parent, x, y, zoff, speed, parent.random(Space.MIN_METEOR_SIZE, Space.MAX_METEOR_SIZE)));
			else if( randShape == 2) this.meteors.add(new Sphere(this.parent, x, y, zoff, speed, parent.random(Space.MIN_METEOR_SIZE, Space.MAX_METEOR_SIZE)));
			
			xoff += 3;
		    yoff += 4;
		}
	}
	
	/**
	 * @return the meteors
	 */
	public ArrayList<Meteor> getMeteors() {
		return meteors;
	}

	/**
	 * Space grid
	 * 
	 * @param PApplet
	 * @param meteors number
	 * 
	 * @since 1.0
	 */

	private void drawGrid(int positionY, float angle){
		parent.stroke(Space.FILL_GRID);
		int gridSize = 40;
		int xoffset = Engine.WINDOW_WIDTH/2;
		int yoffset = positionY;
		int zoffset = -300;
	    for(int i = -Engine.WINDOW_WIDTH; i <Engine.WINDOW_WIDTH; i+=gridSize) {
	    for(int j = -Engine.WINDOW_HEIGHT*3; j < Engine.WINDOW_HEIGHT/2; j+=gridSize) {
	      int y = 200;
	      parent.pushMatrix();
	      parent.rotateZ(angle);
	      parent.line(xoffset + i,          yoffset + y, zoffset + j,           xoffset + i+gridSize, yoffset + y, zoffset + j          );
	      parent.line(xoffset + i+gridSize, yoffset + y, zoffset + j,           xoffset + i+gridSize, yoffset + y, zoffset + j+gridSize );
	      parent.line(xoffset + i+gridSize, yoffset + y, zoffset + j+gridSize,  xoffset + i,          yoffset + y, zoffset + j+gridSize );
	      parent.line(xoffset + i,          yoffset + y, zoffset + j,           xoffset + i,          yoffset + y, zoffset + j+gridSize );
	      parent.popMatrix();
	    }
	  }
	}
	
	/**
	 * @return METEOR_START
	 * @since 1.0
	 */
	public static float getMeteorStart(){
		return Space.METEOR_START;
	};
	
	/**
	 * @return MARGIN_BEHIND_MODEL
	 * @since 1.0
	 */
	public static float getMarginBehindModel(){
		return Space.MARGIN_BEHIND_MODEL;
	};
	/**
	 * Display the space constructor
	 * 
	 * @since 1.0
	 */
	public void display(){
		drawGrid(-150, 0);
		drawGrid(250, 0);
		for(int i = 0; i < this.meteors.size(); i++)
	    {	
			if(meteors.get(i).isVisible())
				meteors.get(i).display();
		}
	}
	
}
