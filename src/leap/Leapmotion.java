package leap;
import com.leapmotion.leap.*;

/**
 * <b>Leapmotion is an helper tool to control the Leapmotion".</b>
 * @author Romain
 * @version 1.0
 */
public class Leapmotion {
	/**
	 * Listener for the leapmotion controller to capture every actions and states
	 * can't be modified, static.
	 */
	private static final LeapmotionListener LEAPLISTENER = new LeapmotionListener();
	/**
	 * The leapmotion controller, used to interact with the leapmotion (hardware).
	 * can't be modified, static
	 */
	private static final Controller LEAPCONTROLLER = new Controller(LEAPLISTENER);
	
	/**
	 * Detects the hand movements and tranforms hand coords into interactionBox normalized coords.
	 * Then generate a vector multiplied by the velocityCoeff.
	 * @param leap the leapmotion controller in use
	 * @return a normalized Vector (x,y,z) multiplied by the velocityCoeff
	 * @since 1.0
	 */
	public static Vector handMoves(){
		Frame currentFrame = LEAPCONTROLLER.frame();
		Vector movement;
		
		if (currentFrame.interactionBox().isValid()) { // interaction is valid ?
			Vector normMove = currentFrame.interactionBox().normalizePoint(currentFrame.hands().frontmost().palmPosition()); // get the normalized position of the hand
			if(!currentFrame.hands().isEmpty()){
				movement = new Vector( (normMove.getX()-0.5f), (-normMove.getY()+0.5f), 0.0f);
				return movement;
			}
		}
		
		movement = new Vector (0.0f, 0.0f, 0.0f);
		return movement;
	}
	
	/**
	 * isConnected returns a boolean if the leapmotion is connected and if the service is available @see Controller.isConnected()
	 * @return a boolean
	 */
	public static boolean isConnected(){
		return LEAPCONTROLLER.isConnected();
	}
}
