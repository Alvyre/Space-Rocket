package imac;

import java.util.HashMap;
import java.util.Map;

import imac.bonus.Bonus;

/**
 * <b>Time is a static class which count the time from the beginnning</b>
 * @author Romain
 * @version 1.0
 */
public class Time {
	
	/**
	 * Start describe the moment when you start the timer.
	 */
	static private long start;
	/**
	 * the elapsed time in miliseconds
	 */
	static  private long elapsedTimeMillis;
	/**
	 * the elapsed time in seconds
	 */
	static private float elapsedTimeSec;
	/**
	 * the elapsed time in minutes
	 */
	static private float elapsedTimeMin;
	/**
	 * the elapsed time in hours
	 */
	static private float elapsedTimeHour;
	
	static private Map<String,Long> bonusTimers = new HashMap<String,Long>();
	
	/**
	 * Constructor of the class, launch the timer
	 */
	static{
		Time.bonusTimers.put("SpeedUp", 0L);
		Time.bonusTimers.put("Immortal", 0L);
		Time.bonusTimers.put("LessMeteors", 0L);
		Time.bonusTimers.put("PointMultiplier", 0L);
		Time.bonusTimers.put("SlowTime", 0L);
	}
	
	static public void start(){
		Time.start = System.currentTimeMillis();
	}
	

	/**
	 * @return the start
	 */
	public static long getStart() {
		return start;
	}

	/**
	 * @return the elapsedTimeMillis
	 */
	public static long getElapsedTimeMillis() {
		return elapsedTimeMillis;
	}

	/**
	 * @return the elapsedTimeSec
	 */
	public static float getElapsedTimeSec() {
		return elapsedTimeSec;
	}

	/**
	 * @return the elapsedTimeMin
	 */
	public static float getElapsedTimeMin() {
		return elapsedTimeMin;
	}

	/**
	 * @return the elapsedTimeHour
	 */
	public static float getElapsedTimeHour() {
		return elapsedTimeHour;
	}
	
	/**
	 * Save the time elapsed from the beginning
	 * @return void
	 * @since 1.0
	 */
	public static void save(){
		Time.elapsedTimeMillis	= System.currentTimeMillis()-start;
		Time.elapsedTimeSec		= elapsedTimeMillis/1000F;
		Time.elapsedTimeMin		= elapsedTimeMillis/(60*1000F);
		Time.elapsedTimeHour	= elapsedTimeMillis/(60*60*1000F);
	}
	
	public static void startBonusTimer(String type ){
		Time.bonusTimers.put(type,(Long)System.currentTimeMillis());
	}
	public static int getBonusCoolDown(Bonus bonus){
		Long timeMili = (Long)System.currentTimeMillis() - Time.bonusTimers.get(bonus.getType());
		int timeSec = (int)(timeMili/1000F);
		return ((int)bonus.getCooldown() - timeSec >0?(int)bonus.getCooldown()- timeSec:0);
	}
}
