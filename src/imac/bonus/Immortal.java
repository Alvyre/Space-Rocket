package imac.bonus;
import java.util.Timer;
import java.util.TimerTask;

import imac.Rocket;
import imac.Time;
/**
 * <b>Immortal turns the player immortal for a duration, extends Bonus</b>
 * @see Bonus
 * @author Romain
 * @version 1.0
 */
public class Immortal extends Bonus {
	/**
	 * time of cooldown
	 */
	 protected final float cooldown = (float) 80.0;
	/**
	 * Constructor of the class with parameters
	 * @param state
	 * @param duration
	 * @since 1.0
	 */
	public Immortal(boolean state, float duration) {
		super(state, duration, "Immortal");
	}
	/**
	 * Constructor of the class with a bonus
	 * @param bonus
	 * @since 1.0
	 */
	public Immortal(Immortal bonus){
		super(bonus);
	}
	/**
	 * apply the bonus to the player
	 * @param player
	 * @since 1.0
	 */
	public void apply(Rocket player){
		if(this.isAvailable()){
			this.timer = new Timer();
			player.setImmortal(true);
			System.out.println("Immortality bonus enabled !");
			Immortal.this.setState(false);
			Time.startBonusTimer(Immortal.this.type);
			this.timer.schedule(new TimerTask() {
				  @Override
				  public void run() {
					player.setImmortal(false);
					System.out.println("Immortality bonus disabled !");
					
				  }
				}, (long)this.duration*1000);
		}
	}
	public float getCooldown() {
		return cooldown;
	}
}
