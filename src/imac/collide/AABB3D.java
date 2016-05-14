package imac.collide;
import com.leapmotion.leap.Vector;

/**
 * <b>AABB3D is a simple collision system</b>
 * @author HeroesGraveDev
 * {@url http://www.java-gaming.org/index.php?topic=28059.0}
 * @version 1.0
 */
public class AABB3D
{
	/**
	 * center is the center of the AABB3D box
	 */
	protected Vector center;
	/**
	 * size is the of the object
	 */
	protected Vector size;
	
	/**
	 * Constructor of the AABB3D class using vectors
	 * @param center
	 * @param size
	 */
	public AABB3D(Vector center, Vector size)
	{
		this.center = center;
		this.size = size;
	}
	/**
	 * Constructor of the AABB3D class using floats
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @param h
	 * @param d
	 */
	public AABB3D(float x, float y, float z, float w, float h, float d){
		this.center = new Vector(x, y, z);
		this.size = new Vector(w, h, d);
	}
   /**
	 * @return the center
	 */
	public Vector getCenter() {
		return center;
	}
	/**
	 * @return the size (w,h,d)
	 */
	public Vector getSize() {
		return size;
	}
	/**
	 * @param center the center to set
	 */
	public void setCenter(Vector center) {
		this.center = center;
	}
	/**
	 * the center to set
	 * @param x
	 * @param y
	 * @param z
	 */
	public void setCenter(float x, float y, float z){
		this.center = new Vector(x, y ,z);
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(Vector size) {
		this.size = size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(float w, float h, float d) {
		this.size = new Vector(w, h, d);
	}
/**
    * The method collides(), checks whether 2 AABBs are colliding
    * @param a
    * @param b
    * @return boolean
    */
	public static boolean collides(AABB3D a, AABB3D b)
	{
		if((b.getCenter().getX() >= a.getCenter().getX() + a.getSize().getX())
				|| (b.getCenter().getX() + b.getSize().getX() <= a.getCenter().getX())
				|| (b.getCenter().getY() >= a.getCenter().getY() + a.getSize().getY())
				|| (b.getCenter().getY() + b.getSize().getY() <= a.getCenter().getY())
					|| (b.getCenter().getZ() >= a.getCenter().getZ() + a.getSize().getZ())
				|| (b.getCenter().getZ() + b.getSize().getZ() <= a.getCenter().getZ() ))
					return false;
		else
			return true;
	}
   /**
    * inside(), checks whether a point is inside an AABB3D
    * @param a
    * @param b
    * @return boolean
    */
	public static boolean inside(AABB3D a, Vector b)
	{
		if(b.getX() >= a.getCenter().getX()
				&& b.getX() < a.getCenter().getX() + a.getSize().getX()
				&& b.getY() >= a.getCenter().getY()
				&& b.getY() < a.getCenter().getY() + a.getSize().getY()
				&& b.getZ() >= a.getCenter().getZ()
				&& b.getZ() > a.getCenter().getZ() + a.getSize().getZ())
				return true;
		else
			return false;
	}
}