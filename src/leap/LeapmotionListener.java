package leap;

import com.leapmotion.leap.*;

/**
 * <b> LeapmotionListener is an helper for the Leapmotion </b>
 * <p> This class provides informations about the leapmotion state </p>
 * <p> Extends the Listener class @see Listener </p>
 * @author Romain
 * @version 1.0
 */
public class LeapmotionListener extends Listener{
	
	/**
	 * Display a message when the leapmotion is connected
	 */
	public void onConnect(Controller controller) {
        System.out.println("*** Leapmotion Connected ***");
    }
	/**
	 * Do actions when the leapmotion captures a frame
	 */
	public void onFrame(Controller controller) {

	}
	/**
	 * Display a message when the leapmotion is disconnected
	 */
	public void onDisconnect (Controller controller){
	    System.out.println("*** Leapmotion Disconnected ***");
	}
}
