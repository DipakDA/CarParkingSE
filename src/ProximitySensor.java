
public class ProximitySensor {
	private int[][] grid;
	private boolean found;
	private int currWidth;
	private int requiredLength;
	private int requiredWidth;
	//length is the wheelbase
	//width is the slot distance that sensor will give
	
	public ProximitySensor(int wheelBase, int carWidth, int[][] GRID)
	{
		this.requiredLength = wheelBase;
		this.requiredWidth = carWidth;
		this.grid = new int[1000][1000];
		for(int i=0;i<1000;i++)
		{
			for(int j=0;j<1000;j++)
			{
				grid[i][j] = GRID[i][j];
			}
		}
		this.found = false;
		this.currWidth = 0;
	}
	
	public boolean findSlot(Pair backWheel)
	{
		//proximity sensor location x = bW.x - 0.25
		//                          y = bW.y
		//backWheel is passed as an integer
		//NEED TO MAKE NECESSARY CHANGE IN THE CALLING FUNCTION IN MAIN
		//EDIT THIS AFTER THE CHANGE IS DONE
		
		for(int j = backWheel.y; )
		
		return false;
	}
	
	
}
