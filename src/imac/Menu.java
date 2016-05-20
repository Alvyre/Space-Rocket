package imac;

import processing.core.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import json.JSONObject;

/**
 * <b>Menu class displays the menu of the application</b>
 * <p>It allows to navigate between each level.</p>
 * @author Pierre
 * @version 1.0
 */

public class Menu extends PApplet {
	
	/**
	 * Reference parent PApplet of the app's sketch
	 */
	private PApplet parent;
	
	/**
	 * Variable to know if menu is active or not
	 */
	private static boolean isActive = true;
	
	/**
	 * Variable to know the current level
	 */
	private int numberOfLevel;
	
	/**
	 * Current Level active
	 */
	private Level level;
	
	/**
	 * Variable to know the current level
	 */
	private int currentLevelNumber;
	
	/**
	 * Variable to know the selected level
	 */
	private int selectedLevelNumber;
	
	/**
	 * Menu texture
	 */
	PImage menuTexture;
	
	public Menu(PApplet p, Level l){
		this.parent = p;
		this.level = l;
		this.currentLevelNumber  = 1;
		this.selectedLevelNumber = 1;
		
        try{
        	File f = new File("./assets/conf/init.json");
        	if (f.exists()){
        		InputStream is = new FileInputStream("./assets/conf/init.json");
            	String jsonTxt = IOUtils.toString(is);
            	JSONObject initJSON     = new JSONObject(jsonTxt); 
	        	this.numberOfLevel      = (int)initJSON.getInt("numberOfLevel");
        	}
        }catch (IOException e) {
			e.printStackTrace();
		}
		
		menuTexture = parent.loadImage("./assets/textures/menu-background.png");
	}
	
	/**
	 * @return currentLevel
	 * @since 1.0
	 */
	public int getCurrentLevel(){
		return this.currentLevelNumber;
	}
	
	/**
	 * Set the currentLevel
	 * @param the currentLevel to set
	 * @since 1.0
	 */
	public void setSelectedLevel(int level){
		this.selectedLevelNumber = level;
	}
	
	/**
	 * @return currentLevel
	 * @since 1.0
	 */
	public int getSelectedLevel(){
		return this.selectedLevelNumber;
	}
	
	/**
	 * Set the currentLevel
	 * @param the currentLevel to set
	 * @since 1.0
	 */
	public void setCurrentLevel(int level){
		this.currentLevelNumber = level;
	}
	
	/**
	 * @return isActive (true/false)
	 * @since 1.0
	 */
	public boolean isActive(){
		if(Menu.isActive) return true;
		return false;
	}
	
	/**
	 * Set the isActive value to false
	 * @since 1.0
	 */
	public void desactive(){
		Menu.isActive = false;
	}
	
	/**
	 * Set the isActive value to true
	 * @since 1.0
	 */
	public void active(){
		Menu.isActive = true;
	}
	
	public void display(){
		parent.camera();
		parent.hint(DISABLE_DEPTH_TEST);
		parent.image(this.menuTexture, 0, 0, Engine.WINDOW_WIDTH, Engine.WINDOW_HEIGHT);
		
		parent.textSize(20);
		parent.textAlign(CENTER);
		parent.fill(255);
		
		for(int i = 1; i <= this.numberOfLevel; i++){
			String info = new String ("Level " + i);
			parent.text(info, Engine.WINDOW_WIDTH / 2, Engine.WINDOW_HEIGHT /2 + (i * 40) + 40);
		}
		
		for(int i = 1; i<= this.numberOfLevel; i++){
			if(i == this.selectedLevelNumber){
				parent.noStroke();
				parent.rect(Engine.WINDOW_WIDTH / 2 - 70, Engine.WINDOW_HEIGHT /2 + (i * 40) + 40 - 16, 15, 15);
			}
		}
		
		parent.hint(ENABLE_DEPTH_TEST);
	}
	
	/**
	 * Function called on Engine keyPressed function
	 * Change values of variables UP and DOWN
	 * 
	 * @since 1.0
	 */
	public void eventKeyPressed(){
		if (parent.keyCode == PConstants.DOWN){
			if(this.selectedLevelNumber != this.numberOfLevel) this.selectedLevelNumber++;
			else this.selectedLevelNumber = 1;
		}
		if (parent.keyCode == PConstants.UP){
			if(this.selectedLevelNumber != 1) this.selectedLevelNumber--;
			else this.selectedLevelNumber = this.numberOfLevel;
		}
		if (parent.keyCode == PConstants.ENTER){
			this.loadLevel();
		}
		if (parent.key == 'A' || parent.key == 'a'){
			if(Menu.isActive){
				this.desactive();
			}
			else{
				this.active();
			}
		}
	}
	
	/**
	 * Function called on Engine keyReleased function
	 * Change values of variables UP, DOWN, LEFT and RIGHT
	 * 
	 * @since 1.0
	 */
	public void eventKeyReleased(){
		
	}
	
	public void loadLevel(){
		if(this.selectedLevelNumber != this.currentLevelNumber){
			this.currentLevelNumber = this.selectedLevelNumber;
			this.level.loadLevel(2);
		}
		this.desactive();
	}
	
}
