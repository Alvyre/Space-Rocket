package imac.collide;
import com.leapmotion.leap.Vector;

/**
 * <b>AABB is a simple collision system</b>
 * @author HeroesGraveDev
 * {@url http://www.java-gaming.org/index.php?topic=28059.0}
 * @version 1.0
 */
public class AABB
{
	/**
	 * pos is the center of the AABB box
	 */
	protected Vector center;
	/**
	 * size is the half size of the object (distance center to side)
	 */
	protected Vector halfsize;
	
	/**
	 * Constructor of the AABB class
	 * @param pos
	 * @param size
	 */
	public AABB(Vector center, Vector halfsize)
	{
		this.center = center;
		this.halfsize = halfsize;
	}
   /**
	 * @return the center
	 */
	public Vector getCenter() {
		return center;
	}
	/**
	 * @return the halfsize
	 */
	public Vector getHalfsize() {
		return halfsize;
	}
	/**
	 * @param center the center to set
	 */
	public void setCenter(Vector center) {
		this.center = center;
	}
	/**
	 * @param halfsize the halfsize to set
	 */
	public void setHalfsize(Vector halfsize) {
		this.halfsize = halfsize;
	}
/**
    * The method collides(), checks whether 2 AABBs are colliding
    * @param a
    * @param b
    * @return boolean
    */
	public static boolean collides(AABB a, AABB b)
	{
		if(Math.abs(a.center.getX() - b.center.getX()) < a.halfsize.getX() + b.halfsize.getX())
		{
			if(Math.abs(a.center.getY() - b.center.getY()) < a.halfsize.getY() + b.halfsize.getY())
			{
				return true;
			}
		}
      
		return false;
	}
   /**
    * inside(), checks whether a point is inside an AABB
    * @param a
    * @param b
    * @return boolean
    */
	public static boolean inside(AABB a, Vector b)
	{
		if(Math.abs(a.center.getX() - b.getX()) < a.halfsize.getX())
		{
			if(Math.abs(a.center.getY() - b.getY()) < a.halfsize.getY())
			{
				return true;
			}
		}
		return false;
	}
}