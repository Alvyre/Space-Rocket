package imac.hud;
import imac.Time;
import imac.bonus.Bonus;

/**
 * <b> The HUD class describe the way to display the different informations on the screen of the game </b>
 * @author Romain & Charlie
 * @version 1.0
 */
public class HUD {
	
	/**
	 * Constructor of the class
	 */
	public HUD() {
		
		//TODO
		
	}
	
	public void displayCD(Bonus bonus){

		 if(Time.getBonusCoolDown(bonus) != 0 && bonus.isAvailable() == false){
		 
			 //TODO display le bonus   :   Time.getBonusCoolDown(bonus)
		 
		 }
	}
	public void display(){
		
		//TODO
		
	}
}
