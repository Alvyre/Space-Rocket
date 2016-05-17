package imac.bonus;
import java.util.Timer;
import imac.Rocket;
/**
 * <b>Bonus describes bonuses applied to the player or the environment".</b>
 * @author Romain
 * version 1.0
 */
public class Bonus {
	/**
	 * state is a boolean to know is the bonus is available.
	 */
	protected boolean state;
	/**
	 * the duration of the bonus.
	 */
	protected float duration;
	/**
	 * the timer to count the duration of the bonus.
	 */
	protected Timer timer;
	/**
	 * type describes the type of the bonuses, (5 possible types).
	 */
	protected String type;
	
	/**
	 * Constructor of the bonus class
	 * @param state
	 * @param duration
	 * @param type
	 * @since 1.0
	 */
	public Bonus(boolean state, float duration, String type) {
		this.state = state;
		this.duration = duration;
		this.type = type;
	}
	/**
	 * Constructor of the bonus class with a Bonus
	 * @param bonus
	 * @since 1.0
	 */
	public Bonus(Bonus bonus){
		this.state = bonus.isActive();
		this.duration = bonus.getDuration();
		this.type = bonus.getType();
	}
	/**
	 * Getter to know if the bonus is active
	 * @return boolean
	 */
	public boolean isActive(){
		return state;
	}
	
	/**
	 * Getter of the duration
	 * @return float (duration)
	 * @sine 1.0
	 */
	public float getDuration() {
		return duration;
	}
	/**
	 * Getter of the type
	 * @return String
	 * @since 1.0
	 */
	public String getType() {
		return type;
	}
/**
 * set the state of the bonus (true/false).
 * @param state
 */
	public void setState(boolean state) {
		this.state = state;
	}
	public void apply(){}
	public void apply(Rocket player){}
	
}