package imac;
import imac.collide.*;
import java.util.HashMap;
import java.util.Map;
import com.leapmotion.leap.Vector;
import imac.bonus.*;

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
	private AABB3D aabb3d;
	private int 				score;
	/**
	 * speed increases the rapidity of the player, can be modified with bonuses.
	 */
	private float				speed;
	/**
	 * the name of the player, can't be modified
	 */
	private final String 		name;
	/**
	 * The bonus map (associative) of the character shows the different bonuses available for the player @see Bonus
	 */
	private Map<String,Bonus> bonus = new HashMap<String,Bonus>();
	/**
	 * the life of the player
	 */
	private int					life;
	/**
	 * boolean to know is the player is immortal or not
	 */
	private boolean 			immortal = false;
	/**
	 * the Point multiplier coefficient, can be modified with a bonus @see pointMultiplier
	 */
	static private float POINT_MULTIPLIER = 1.0f;
	
	/**
	 * The constructor of Rocket
	 * @param m
	 * @param score
	 * @param speed
	 * @param name
	 * @param life
	 * 
	 * @since 1.0
	 */
	public Rocket(Object3D m, int score, float speed, String name, int life) {
		aabb3d = new AABB3D(m.getPositionVec(), new Vector(m.getModel().getWidth() * m.getScaleX(), m.getModel().getHeight() * m.getScaleY(), m.getModel().getDepth() * m.getScaleZ() ) );
		this.model = m;
		this.score = score;
		this.speed = speed;
		this.name = name;
		this.life = life;
		this.bonus.put("SpeedUp", 			new SpeedUp(			true, 	10.0f));
		this.bonus.put("SlowTime", 			new SlowTime(			true, 	10.0f));
		this.bonus.put("Immortal", 			new Immortal(			true, 	5.0f));
		this.bonus.put("LessMeteors", 		new LessMeteors(		true, 	10.0f));
		this.bonus.put("PointMultiplier", 	new PointMultiplier(	true, 	0.0f));
	}

	/**
	 * translate the player
	 * @param Vector vec is a vector (x,y,z) of translation
	 * @since 1.0
	 */
	public void move(Vector vec){
		this.model.translate(vec.times(speed));
		this.aabb3d.setCenter(this.model.getPositionVec());
	}
	/**
	 * Apply the bonus to the player
	 * @param bonus
	 */
	public void applyBonus(Bonus bonus, Level level){
		if(bonus.isActive()){
			switch(bonus.getType()){
			case "SpeedUp":
				bonus.apply(this);
				break;
			case "SlowTime":
				bonus.apply(level);
				break;
			case "Immortal":
				bonus.apply(this);
				break;
			case "LessMeteors":
				bonus.apply(level);
				break;
			case "PointMultiplier":
				bonus.apply(this);
				break;
			default:
				System.out.println(bonus.getType());
				break;
			
			}
		}
	}
	public boolean isImmortal() {
		return immortal;
	}
	/**
	 * @return the model
	 * @since 1.0
	 */
	public Object3D getModel() {
		return model;
	}
	/**
	 * @return the aabb3d
	 */
	public AABB3D getAABB3D() {
		return aabb3d;
	}

	/**
	 * @return the position
	 * @since 1.0
	 */
	public Vector getPosition() {
		return this.aabb3d.getCenter();
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
	public float getSpeed() {
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
	 * @return the point multiplier
	 * @since 1.0
	 */
	public float getMultiplier() {
		return Rocket.POINT_MULTIPLIER;
	}
	/**
	 * @return the bonus by type
	 * @since 1.0
	 */
	public Bonus getBonus(String type) {
		return bonus.get(type);
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
	public void setSpeed(float speed) {
		this.speed = speed;
	}

	/**
	 * @param life the life to set
	 * @since 1.0
	 */
	public void setLife(int life) {
		this.life = life;
	}
	/**
	 * @param immortal  set state immortal to true/false
	 * @since 1.0
	 */
	public void setImmortal(boolean immortal) {
		this.immortal = immortal;
	}
	/**
	 * 
	 * @param multiplier set the point multiplier
	 * @since 1.0
	 */
	public void setMultiplier(float multiplier){
		Rocket.POINT_MULTIPLIER = multiplier;
	}
	/**
	 * @param bonus the bonus to set
	 * @since 1.0
	 */
	public void setBonus(Bonus bonus) {
		this.bonus.put(bonus.getType(), bonus);
	}
}