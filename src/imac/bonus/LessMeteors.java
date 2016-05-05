package imac.bonus;

import java.util.Timer;
import java.util.TimerTask;

/**
 * <b>LessMeteors Decreased the numbers of meteors for a duration, extends Bonus </b>
 * @see Bonus
 * @author Romain
 * @version 1.0
 */
public class LessMeteors extends Bonus {
	/**
	 * (constant) the value of the enemies reduced
	 */
	static private final int VALUE = 5;
	/**
	 * Constructor of the class with parameters
	 * @param state
	 * @param duration
	 * @since 1.0
	 */
	public LessMeteors(boolean state, float duration) {
		super(state, duration, "lessMeteors");
	}
	/**
	 * Constructor of the class with Bonus
	 * @param bonus
	 * @since 1.0
	 */
	public LessMeteors(LessMeteors bonus){
		super(bonus);
	}
	/**
	 * apply the bonus to the environment
	 * @param Level
	 * @since 1.0
	 */
	public void apply(/*  */){
		this.timer = new Timer();
		if(this.isActive()){
			// TODO SET NUMBER OF METEOR
			//System.out.println("Less Meteors bonus Started !");
			this.timer.schedule(new TimerTask() {
				  @Override
				  public void run() {
					  // TODO RESET NUMBER OF METEORS
					  LessMeteors.this.setState(false);
					  //System.out.println("Less Meteors bonus Ended !");
				  }
				}, (long)this.duration*1000);
		}
	}
}
