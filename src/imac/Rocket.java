package imac;
import com.leapmotion.leap.Vector;
/**
 * <b>Rocket describes the playable character class".</b>
 * @author Romain
 * @version 1.0
 */
public class Rocket {
	/**
	 * model is a 3D Object, used to load and display the character (.obj, etc..) @see Object3D.
	 * can't be modified.
	 */
	private final Object3D 		model;
	/**
	 * score shows the points gathered by the player (integer).
	 */
	private int 				score;
	/**
	 * speed increases the rapidity of the player, can be modified with bonuses.
	 */
	private double				speed;
	/**
	 * the name of the player, can't be modified
	 */
	private final String 		name;
	/**
	 * the bonus array of the character shows the different bonuses available for the player @see Bonus
	 */
	//private Bonus 			bonus[];
	/**
	 * the life of the player
	 */
	private int					life;
	
	
	/**
	 * The constructor of Rocket
	 * @param model
	 * @param score
	 * @param speed
	 * @param name
	 * @param life
	 * 
	 * @since 1.0
	 */
	public Rocket(Object3D model, int score, double speed, String name, int life) {
		this.model = model;
		this.score = score;
		this.speed = speed;
		this.name = name;
		this.life = life;
	}

	/**
	 * translate the player
	 * @param Vector vec is a vector (x,y,z) of translation
	 * @since 1.0
	 */
	public void move(Vector vec){
		this.model.translate(vec);
	}

	/**
	 * @return the model
	 * @since 1.0
	 */
	public Object3D getModel() {
		return model;
	}

	/**
	 * @return the position
	 * @since 1.0
	 */
	public Vector getPosition() {
		return this.model.getPositionVec();
	}

	/**
	 * @return the score
	 * @since 1.0
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @return the speed
	 * @since 1.0
	 */
	public double getSpeed() {
		return speed;
	}

	/**
	 * @return the name
	 * @since 1.0
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the life
	 * @since 1.0
	 */
	public int getLife() {
		return life;
	}
	
	/**
	 * @param score the score to set
	 * @since 1.0
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @param speed the speed to set
	 * @since 1.0
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}

	/**
	 * @param life the life to set
	 * @since 1.0
	 */
	public void setLife(int life) {
		this.life = life;
	}
}