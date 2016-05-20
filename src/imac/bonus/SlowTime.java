package imac.bonus;
import java.util.Timer;
import java.util.TimerTask;
//Import meteor

import imac.Level;
import imac.Time;
import imac.obstacle.Meteor;

/**
 *<b> SlowTime is a bonus which slow the enemies, extends Bonus </b>
 *@see Bonus
 * @author Romain
 *@version 1.0
 */
public class SlowTime extends Bonus {
	/**
	 * time of cooldown
	 */
	protected final float cooldown = (float) 45.0;
	/**
	 * (constant) value of the decreased speed
	 */
	static private final float VALUE = 2.0f;
	
	/**
	 * Constructor of the class with parameters
	 * @param state
	 * @param duration
	 * @since 1.0
	 */
	public SlowTime(boolean state, float duration) {
		super(state, duration, "SlowTime");
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
	public void apply(Level level){
		
		if(this.isAvailable()){
			this.timer = new Timer();
			for( Meteor m :  level.getSpace().getMeteors()){
				m.setSpeed((float)(m.getSpeed() / SlowTime.VALUE));
			}
			System.out.println("Slow Time bonus Started !");
			SlowTime.this.setState(false);
			Time.startBonusTimer(SlowTime.this.type);
			this.timer.schedule(new TimerTask() {
				  @Override
				  public void run() {
					  for( Meteor m :  level.getSpace().getMeteors()){
							m.setSpeed((float)(m.getSpeed() * SlowTime.VALUE));
						}
					  SlowTime.this.setState(false);
					  System.out.println("Slow Time bonus Ended !");
				  }
				}, (long)this.duration*1000);
		}
	}
	public float getCooldown() {
		return cooldown;
	}
	
}
