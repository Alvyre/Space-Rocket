package imac.hud;
import imac.Rocket;
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
	/**
	 * get the cooldown of the specified bonus
	 * @param bonus
	 * @return
	 */
	public int getBonusCD(Bonus bonus){

		 if(Time.getBonusCoolDown(bonus) != 0 && bonus.isAvailable() == false){
			 return Time.getBonusCoolDown(bonus);
		 }
		 return 0;
	}
	/**
	 * display the HUD
	 */
	public void display(Rocket player){
		
		//TODO
		//player.getScore();
		
	}
}
