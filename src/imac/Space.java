package imac;

import processing.core.*;

import java.util.ArrayList;

import imac.obstacle.Meteor;

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
		float xoff = Engine.WINDOW_HEIGHT / 2;
		float zoff = 300.0f;
		
		for(int i=0; i< this.nbMeteors; i++){
			
			float y = PApplet.map(parent.noise(xoff, yoff), 0, 1, 100, 800); // Option #1: 2D Noise
			
			System.out.println("x:" + xoff + ", y:" + y + ", z:" + zoff);
			
			this.meteors.add(new Meteor(this.parent, xoff, y, zoff, 2, 2, 2, 2, 10));
			
			// Increment x dimension for noise
		    xoff += 10;
		    yoff += 4;
		}
	}
	
	public void display(){
		for(int i = 0; i < this.meteors.size(); i++)
	    {
			parent.pushMatrix();
			parent.camera();
			meteors.get(i).display();
			parent.popMatrix();
			System.out.println("x:" + meteors.get(0).getPositionX() + ", y:" + meteors.get(0).getPositionY() + ", z:" + meteors.get(0).getPositionZ());
	    }
	}
	
}
