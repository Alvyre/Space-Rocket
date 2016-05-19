package imac.bonus;

import java.util.Timer;
import java.util.TimerTask;
import imac.Rocket;
import imac.Time;
/**
 * Multiply the points the player gets for the limited time
 * @author Romain
 * @version 1.0
 */
public class PointMultiplier extends Bonus {
	/**
	 * (constant) the multiplier
	 */
	static private final float MULTIPLIER = 1.5f;
	/**
	 * The constructor of the class using parameters
	 * @param state
	 * @param duration
	 * @since 1.0
	 */
	public PointMultiplier(boolean state, float duration) {
		super(state, duration, "PointMultiplier");
	}
	/**
	 * The constructor of the class using a Bonus
	 * @param bonus
	 * @since 1.0
	 */
	public PointMultiplier(PointMultiplier bonus){
		super(bonus);
	}
	/**
	 * Apply the bonus to the player
	 * @param player
	 * @since 1.0
	 */
	public void apply(Rocket player){
		if(this.isActive()){
			this.timer = new Timer();
			player.setMultiplier(PointMultiplier.MULTIPLIER);
			//System.out.println("x" + pointMultiplier.MULTIPLIER + " points bonus activated !");
			PointMultiplier.this.setState(false);
			this.timer.schedule(new TimerTask() {
				  @Override
				  public void run() {
					  Time.startBonusTimer(PointMultiplier.this.type);
					  player.setMultiplier(1.0f);
					//System.out.println("x" + pointMultiplier.MULTIPLIER + " points bonus ended !");
				  }
				}, (long)this.duration*1000);
		}
	}
}
