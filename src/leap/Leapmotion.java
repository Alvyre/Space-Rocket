package leap;
import com.leapmotion.leap.*;

/**
 * <b>Leapmotion is an helper to control the Leapmotion".</b>
 * @author Romain
 * @version 1.0
 */
public class Leapmotion {
	/**
	 * VelocityCoeff is a coefficient used to multiply the movement of the hand, which is applied to the rocket.
	 * It can't be modified and it is static. (called only via the class)
	 */
	private static final float velocityCoeff = 5.0f;
	
	/**
	 * Detects the hand movements and tranforms hand coords into interactionBox normalized coords.
	 * Then generate a vector multiplied by the velocityCoeff.
	 * @param leap the leapmotion controller in use
	 * @return a normalized Vector (x,y,z) multiplied by the velocityCoeff
	 * @since 1.0
	 */
	public static Vector handMoves(Controller leap){
		Frame currentFrame = leap.frame();
		Vector moves;
		
		if (currentFrame.interactionBox().isValid()) { // interaction is valid ?
			Vector normMouv = currentFrame.interactionBox().normalizePoint(currentFrame.hands().frontmost().palmPosition()); // get the normalized position of the hand
			if(!currentFrame.hands().isEmpty()){
				moves = new Vector( (normMouv.getX()-0.5f)*velocityCoeff, (-normMouv.getY()+0.5f)*velocityCoeff, 0.0f);
				return moves;
			}
		}
		
		moves = new Vector (0.0f, 0.0f, 0.0f);
		return moves;
	}
}
