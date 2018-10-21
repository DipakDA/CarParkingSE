import java.lang.Math;

public class Pair {
	public double x = 1;
	public double y = 1;
	
	public Pair(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	public Pair(boolean fORb, Pair carLocation, double wheelBase, double carHeading)
	{
		if(fORb) {
			
			x = carLocation.x + wheelBase/2 * Math.cos(carHeading);
			y = carLocation.y + wheelBase/2 * Math.sin(carHeading);
		}
		else {
			this.x = carLocation.getX() - wheelBase/2 * Math.cos(carHeading);
			this.y = carLocation.getY() - wheelBase/2 * Math.sin(carHeading);
		}
	}
	
	public double getX()
	{
		return this.x;
	}
	
	public double getY()
	{
		return this.y;
	}
};

