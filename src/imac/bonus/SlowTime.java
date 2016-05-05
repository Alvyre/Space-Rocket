package imac.bonus;
import java.util.Timer;
import java.util.TimerTask;
//Import meteor

/**
 *<b> SlowTime is a bonus which slow the enemies, extends Bonus </b>
 *@see Bonus
 * @author Romain
 *@version 1.0
 */
public class SlowTime extends Bonus {
	/**
	 * (constant) value of the decreased speed
	 */
	static private final float VALUE = 5.0f;
	
	/**
	 * Constructor of the class with parameters
	 * @param state
	 * @param duration
	 * @since 1.0
	 */
	public SlowTime(boolean state, float duration) {
		super(state, duration, "slowTime");
	}
	/**
	 * Constructor of the class with Bonus
	 * @param bonus
	 * @since 1.0
	 */
	public SlowTime(SlowTime bonus){
		super(bonus);
	}
	/**
	 * Apply the bonus to the environment (enemies)
	 * @since 1.0
	 */
	public void apply(/*  */){
		this.timer = new Timer();
		if(this.isActive()){
			// TODO SET SPEED DOWN OF METEOR
			//System.out.println("Slow Time bonus Started !");
			this.timer.schedule(new TimerTask() {
				  @Override
				  public void run() {
					  // TODO RESET SPEED OF METEOR
					  SlowTime.this.setState(false);
					  //System.out.println("Slow Time bonus Ended !");
				  }
				}, (long)this.duration*1000);
		}
	}
	
}
