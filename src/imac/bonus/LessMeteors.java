package imac.bonus;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import imac.Level;
import imac.Space;
import imac.Time;

/**
 * <b>LessMeteors Decreased the numbers of meteors for a duration, extends Bonus </b>
 * @see Bonus
 * @author Romain
 * @version 1.0
 */
public class LessMeteors extends Bonus {
	/**
	 * time of cooldown
	 */
	protected final float cooldown = (float) 50.0;
	/**
	 * (constant) the value of the enemies reduced
	 */
	static private final float VALUE = 0.45f;
	/**
	 * Constructor of the class with parameters
	 * @param state
	 * @param duration
	 * @since 1.0
	 */
	public LessMeteors(boolean state, float duration) {
		super(state, duration, "LessMeteors");
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
	public void apply(Level level){
		if(this.isAvailable()){
			this.timer = new Timer();
			Random rand = new Random();
			for(int i=0 ; i< (int)(level.getSpace().getMeteors().size()*LessMeteors.VALUE)-1 ; i++){
				int index = rand.nextInt(level.getSpace().getMeteors().size());
				//System.out.println(index);
				while(level.getSpace().getMeteors().get(index).isVisible() == false)
					index = rand.nextInt(level.getSpace().getMeteors().size() + 1);
				level.getSpace().getMeteors().get(index).setVisible(false);
				level.getSpace().getMeteors().get(index).setPositionZ(Space.getMeteorStart());
			}
			//System.out.println("Less Meteors bonus Started !");
			LessMeteors.this.setState(false);
			Time.startBonusTimer(LessMeteors.this.type);
			this.timer.schedule(new TimerTask() {
				  @Override
				  public void run() {
					  for(int i=0 ; i< level.getSpace().getMeteors().size() ; i++){
						  level.getSpace().getMeteors().get(i).setVisible(true);
						}
					  LessMeteors.this.setState(false);
					  //System.out.println("Less Meteors bonus Ended !");
				  }
				}, (long)this.duration*1000);
		}
	}
	public float getCooldown() {
		return cooldown;
	}
}
