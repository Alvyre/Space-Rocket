package imac;

/**
 * <b>Menu class displays the menu of the application</b>
 * <p>It allows to navigate between each level.</p>
 * @author Pierre
 * @version 1.0
 */

public class Menu {
	
	/**
	 * Variable to know if menu is active or not
	 */
	private static boolean isActive = true;
	
	/**
	 * Variable to know the current level
	 */
	private int currentLevel;
	
	public Menu(){
		this.currentLevel = 1;
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
	 * Set the isActive value
	 * @param the state to set
	 * @since 1.0
	 */
	public void setIsActive(boolean state){
		Menu.isActive = state;
	}
	
}
