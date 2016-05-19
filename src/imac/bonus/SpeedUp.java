package imac.bonus;
import java.util.Timer;
import java.util.TimerTask;
import imac.Rocket;
import imac.Time;

/**
 * <b>SpeedUP class, extends Bonus class</b>
 * @see Bonus
 * @author Romain
 * @version 1.0
 *
 */
public class SpeedUp extends Bonus {
	/**
	 * (constant) value of the bonus effect
	 */
	static private final float VALUE = 5.0f;
	/**
	 * Constructor of the class with parameters
	 * @param state
	 * @param duration
	 * @since 1.0
	 */
	public SpeedUp(boolean state, float duration) {
		super(state, duration, "SpeedUp");
	}
	/**
	 * Costructor of the class with a SpeedUp bonus
	 * @param bonus
	 * @since 1.0
	 */
	public SpeedUp(SpeedUp bonus) {
		super(bonus);
	}
	/**
	 * Apply the bonus to a player
	 * @param player
	 * @since 1.0
	 */
	public void apply(Rocket player){
		if(this.isActive()){
			this.timer = new Timer();
			player.setSpeed(player.getSpeed() + VALUE);
			System.out.println("Speed UP bonus Started !");
			SpeedUp.this.setState(false);
			this.timer.schedule(new TimerTask() {
				  @Override
				  public void run() {
					  Time.startBonusTimer(SpeedUp.this.type);
					  player.setSpeed(player.getSpeed() - VALUE);
					  SpeedUp.this.setState(false);
					  System.out.println("Speed UP bonus Ended !");
				  }
				}, (long)this.duration*1000);
		}
	}
}
