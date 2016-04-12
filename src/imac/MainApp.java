package imac;

import processing.core.*;

public class MainApp extends PApplet {

	  public static void main(String... args){
	    String[] pArgs = {"MyPapplet "};
	    MainApp mp = new MainApp ();
	    PApplet.runSketch(pArgs, mp);
	  }

	  public void settings() {
	    size(200, 100);
	  }
	  public void draw() {
	    background(255);
	    fill(0);
	    ellipse(100, 50, 10, 10);
	  }
	}
