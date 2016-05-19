package imac;

import processing.core.*;

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
	private int currentLevel;
	
	/**
	 * Variable to know the selected level
	 */
	private int selectedLevel;
	
	/**
	 * Menu texture
	 */
	PImage menuTexture;
	
	public Menu(PApplet p){
		this.parent = p;
		this.currentLevel  = 1;
		this.selectedLevel = 1;
		menuTexture = parent.loadImage("./assets/models/rocket_map.png");
	}
	
	/**
	 * @return currentLevel
	 * @since 1.0
	 */
	public int getCurrentLevel(){
		return this.currentLevel;
	}
	
	/**
	 * Set the currentLevel
	 * @param the currentLevel to set
	 * @since 1.0
	 */
	public void setSelectedLevel(int level){
		this.selectedLevel = level;
	}
	
	/**
	 * @return currentLevel
	 * @since 1.0
	 */
	public int getSelectedLevel(){
		return this.selectedLevel;
	}
	
	/**
	 * Set the currentLevel
	 * @param the currentLevel to set
	 * @since 1.0
	 */
	public void setCurrentLevel(int level){
		this.currentLevel = level;
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
		parent.hint(ENABLE_DEPTH_TEST);
	}
	
}
