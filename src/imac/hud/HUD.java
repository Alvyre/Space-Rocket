package imac.hud;
import imac.Engine;
import imac.Rocket;
import imac.Time;
import imac.bonus.Bonus;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

/**
 * <b> The HUD class describe the way to display the different informations on the screen of the game </b>
 * @author Romain & Charlie
 * @version 1.0
 */
public class HUD {
	
	/**
	 * Constructor of the class
	 */
	
	/**
	 * Reference parent PApplet of the app's sketch
	 */
	private PApplet parent;
		
	/**
	 * Image of the information board
	 */
	private PImage board;
	
	/**
	 * Image of the bonus on HUD
	 */
	private PImage speed;
	
	/**
	 * Image of the bonus on HUD
	 */
	private PImage slow;
	
	/**
	 * Image of the bonus on HUD
	 */
	private PImage lessMeteor;
	
	/**
	 * Image of the bonus on HUD
	 */
	private PImage multiplier;
	
	/**
	 * Image of the bonus on HUD
	 */
	private PImage immortal;
	
	public HUD(PApplet p) {
		
		//TODO
		this.parent = p; 
        board = parent.loadImage("./assets/textures/board.png");
        speed = parent.loadImage("./assets/textures/speed.png");
        slow = parent.loadImage("./assets/textures/slow.png");
        lessMeteor = parent.loadImage("./assets/textures/less.png");
        immortal = parent.loadImage("./assets/textures/immortal.png");
        multiplier = parent.loadImage("./assets/textures/multiplier.png");
	}
	/**
	 * get the cooldown of the specified bonus
	 * @param bonus
	 * @return
	 */
	public int getBonusCD(Bonus bonus){
		if(bonus.isAvailable()) return 0;
		else{
			if(Time.getBonusCoolDown(bonus) > 0) return Time.getBonusCoolDown(bonus);
			else{
				 bonus.setState(true);
				 return 0;
			 }
		}
	}
	/**
	 * display the HUD
	 */
	public void display(Rocket player){
		
		//TODO
		parent.camera();
		parent.hint(PConstants.DISABLE_DEPTH_TEST);
		parent.image(board, 0, 0);
		parent.hint(PConstants.ENABLE_DEPTH_TEST);
		
		getBonusCD(player.getBonus("SpeedUp"));
		if(player.getBonus("SpeedUp").isAvailable()){
			parent.camera();
			parent.hint(PConstants.DISABLE_DEPTH_TEST);
			parent.image(speed, 0, 0);
			parent.hint(PConstants.ENABLE_DEPTH_TEST);
		}

		getBonusCD(player.getBonus("SlowTime"));
		if(player.getBonus("SlowTime").isAvailable()){
			parent.camera();
			parent.hint(PConstants.DISABLE_DEPTH_TEST);
			parent.image(slow, 0, 0);
			parent.hint(PConstants.ENABLE_DEPTH_TEST);
		}
		
		getBonusCD(player.getBonus("LessMeteors"));
		if(player.getBonus("LessMeteors").isAvailable()){
			parent.camera();
			parent.hint(PConstants.DISABLE_DEPTH_TEST);
			parent.image(lessMeteor, 0, 0);
			parent.hint(PConstants.ENABLE_DEPTH_TEST);
		}
		
		getBonusCD(player.getBonus("Immortal"));
		if(player.getBonus("Immortal").isAvailable()){
			parent.camera();
			parent.hint(PConstants.DISABLE_DEPTH_TEST);
			parent.image(immortal, 0, 0);
			parent.hint(PConstants.ENABLE_DEPTH_TEST);
		}
		
		getBonusCD(player.getBonus("PointMultiplier"));
		if(player.getBonus("PointMultiplier").isAvailable()){
			parent.camera();
			parent.hint(PConstants.DISABLE_DEPTH_TEST);
			parent.image(multiplier, 0, 0);
			parent.hint(PConstants.ENABLE_DEPTH_TEST);
		}
		
		parent.hint(PConstants.DISABLE_DEPTH_TEST);
		parent.textSize(20);
		parent.textAlign(PConstants.CENTER);
		parent.fill(0);
		String name = new String (player.getName());
		parent.text(name, Engine.WINDOW_WIDTH / 2, Engine.WINDOW_HEIGHT - 30);
		
		parent.textAlign(PConstants.LEFT);
		String score = new String ("Score : " + player.getScore() );
		parent.text(score, Engine.WINDOW_WIDTH - 240, Engine.WINDOW_HEIGHT - 80);
		parent.hint(PConstants.ENABLE_DEPTH_TEST);

	}
}
