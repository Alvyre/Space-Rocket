package imac;
import imac.collide.*;
import imac.level.Level;

import java.util.HashMap;
import java.util.Iterator;
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
	private int 				score;
	/**
	 * This is the collision box, using a AABB collision (Axe collision) @see imac.collide
	 */
	private AABB3D aabb3d;
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
		this.bonus.put("SpeedUp", 			new SpeedUp(			true, 	15.0f));
		this.bonus.put("SlowTime", 			new SlowTime(			true, 	15.0f));
		this.bonus.put("Immortal", 			new Immortal(			true, 	10.0f));
		this.bonus.put("LessMeteors", 		new LessMeteors(		true, 	10.0f));
		this.bonus.put("PointMultiplier", 	new PointMultiplier(	true, 	12.0f));
	}

	/**
	 * translate the player
	 * @param Vector vec is a vector (x,y,z) of translation
	 * @since 1.0
	 */
	public void move(Vector vec){
		Vector mappedVec = new Vector(vec.getX(), vec.getY(), vec.getZ());
		
		//MARGIN_X_LEFT
		if( (this.model.getPositionX() - Camera.getXMargin() + 50.0f < 0.0f)){
			mappedVec.setX(0.0f);
			this.model.setPositionX(this.model.getPositionX() + 1.0f);
		}
		
		//MARGIN_X_RIGHT
		if((this.model.getPositionX() + Camera.getXMargin() - 50 > Engine.WINDOW_WIDTH)){
			mappedVec.setX(0.0f);
			this.model.setPositionX(this.model.getPositionX() - 1.0f);
		}
		
		//MARGIN_Y_UP
		if( (this.model.getPositionY() - Camera.getYMargin() + 50.0f < 0.0f)){
			mappedVec.setY(0.0f);
			this.model.setPositionY(this.model.getPositionY() + 1.0f);
		}
		
		//MARGIN_Y_DOWN
		if( (this.model.getPositionY() + Camera.getYMargin() + 20.0f > Engine.WINDOW_HEIGHT)){
			mappedVec.setY(0.0f);
			this.model.setPositionY(this.model.getPositionY() - 1.0f);
		}
		
		
		this.model.translate(mappedVec.times(speed));
		this.aabb3d.setCenter(this.model.getPositionVec());
	}
	/**
	 * Apply the bonus to the player
	 * @param bonus
	 */
	public void applyBonus(Bonus bonus, Level level){
		if(bonus.isAvailable()){
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
	/**
	 * Getter to know if the player is using the immortal bonus
	 * @return
	 */
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
	/**
	 * Method to add or substract point to the player
	 * @param points
	 */
	public void addToScore(int points){
		this.score += points;
	}
	/**
	 * Method to add or substract life to the player
	 * @param points
	 */
	public void addToLife(int points){
		this.life += points;
	}
	
	/**
	 * Method to reset all bonuses, used when the player changes the level Ingame
	 */
	public void resetAllBonuses(){
		Iterator<String> it = bonus.keySet().iterator();
		while (it.hasNext()){
			   bonus.get(it.next()).setState(true);
		}
	}
}