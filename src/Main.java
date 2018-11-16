import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
//import java.util.concurrent.TimeUnit;
import java.awt.Graphics2D;

public class Main extends JPanel{
	
	/**
	 * 
	 */
	
	private static int caseNo = 2;
	private static Car car = new Car(new Pair(4, 6), 270*(Math.PI/180), 2, 0, 1, 0.5);
	private static int[][] grid;
	
	private static final long serialVersionUID = 1L;
	
	/*private static int x1=0;

	private static int y1=0;

	private static int x2=100;

	private static int y2=100;*/

	@Override
	public void paintComponent(Graphics g)
	{
		// 0.5 is the car's distance between front tyres
		
		super.paintComponent(g);
		System.out.println("ndjsn");
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawLine((int)(car.getFrontWheel().x * 100), 
				(int)(car.getFrontWheel().y * 100),
				(int)(car.getBackWheel().x * 100), 
				(int)(car.getBackWheel().y * 100));
		g2d.drawLine((int)((car.getFrontWheel().x + .5*Math.sin( car.getCarHeading()))* 100), 
				(int)((car.getFrontWheel().y + Math.abs(.5*Math.cos( car.getCarHeading())))* 100),
				(int)((car.getBackWheel().x + .5*Math.sin(car.getCarHeading()))* 100), 
				(int)((car.getBackWheel().y + Math.abs(.5*Math.cos(car.getCarHeading())))* 100));
		g2d.drawLine((int)((car.getBackWheel().x + .5*Math.sin(car.getCarHeading()))* 100), 
					(int)((car.getBackWheel().y + Math.abs(.5*Math.cos(car.getCarHeading())))* 100),
					(int)(car.getBackWheel().x * 100), 
					(int)(car.getBackWheel().y * 100));
		g2d.drawLine((int)(car.getFrontWheel().x * 100), 
					(int)(car.getFrontWheel().y * 100),
					(int)((car.getFrontWheel().x + .5*Math.sin( car.getCarHeading()))* 100), 
					(int)((car.getFrontWheel().y + Math.abs(.5*Math.cos( car.getCarHeading())))* 100));
		
		
				//(int)((Math.cos(car.getSteerAngle() - car.getCarHeading()) * 2)*100 + car.getFrontWheel().x*100),
				//(int)((Math.sin(car.getSteerAngle() - car.getCarHeading()) * 2)*100 + car.getFrontWheel().y*100));			
		
		if(caseNo == 1){
			g2d.fillRect(800,0,200,1000);	
			g2d.fillRect(0,200,200,250);	
			g2d.fillRect(0,500,200,300);	
		}
		else if(caseNo == 2){
			g2d.fillRect(800,0,200,1000);	
			g2d.fillRect(0,0,200,300);	
			g2d.fillRect(0,450,200,300);	
		}
		
	}
	
	public static void main(String[] args)
	{
		//initial coordinate of center = 0, 0
		//car initial angle with x axis = 0
		//car speed(fixed) = 2
		//car steerAngle(frontWheel) angle with axis = 0.5 radians
		//car wheelBase = 3
		System.out.println("Starting main thread");
		
		grid = new int[1000][1000];
		for(int i=0;i<1000;i++)
		{
			for(int j=0;j<1000;j++)
			{
				if(i<200 && j<800)
				{
					grid[i][j] = 1;
				}
				else
				{
					grid[i][j] = 0;
				}
			}
		}
		
		JFrame frame = new JFrame();
		frame.getContentPane().add(new Main());
		frame.setTitle("2D Car Parking Simulation");
		frame.setSize(1000, 1000);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		long start = 0;
		long end = 0;
		
		
		if(caseNo == 1) {
		start = System.currentTimeMillis();
		 end = start + 3300;
		 end = end + 2700;
		//while(car.getRunning())
		 while(System.currentTimeMillis() < end)
			{
			
				car.run();
				frame.getContentPane().repaint();
			}
			
		
		 start = System.currentTimeMillis();
		 end = start + 2900;
		 car.setSpeed(-2);
		//while(car.getRunning())
		 while(System.currentTimeMillis() < end)
			{
			
				car.run();
				frame.getContentPane().repaint();
			}
		
		
		car.setSteerAngle(270*(Math.PI/180));
		car.setSpeed(1.5);
		 start = System.currentTimeMillis();
		 end = start + 6000;
		//while(car.getRunning())
		 while(System.currentTimeMillis() < end)
			{
			
				car.run();
				frame.getContentPane().repaint();
			}
		 
		 car.setSteerAngle(0);
			
		 start = System.currentTimeMillis();
		 end = start + 2700;
		//while(car.getRunning())
		 while(System.currentTimeMillis() < end)
			{
			
				car.run();
				frame.getContentPane().repaint();
			}
		}
		
		else if(caseNo == 2){
			start = System.currentTimeMillis();
		 //end = start + 3300;
		 end = start + 2500;
		//while(car.getRunning())
		 while(System.currentTimeMillis() < end)
			{
			
				car.run();
				frame.getContentPane().repaint();
			}
			
		
		 start = System.currentTimeMillis();
		 end = start + 2800;
		 car.setSpeed(-2);
		//while(car.getRunning())
		 while(System.currentTimeMillis() < end)
			{
			
				car.run();
				frame.getContentPane().repaint();
			}
		
		
		car.setSteerAngle(270*(Math.PI/180));
		car.setSpeed(1.5);
		 start = System.currentTimeMillis();
		 end = start + 6000;
		//while(car.getRunning())
		 while(System.currentTimeMillis() < end)
			{
			
				car.run();
				frame.getContentPane().repaint();
			}
		 
		 car.setSteerAngle(0);
			
		 start = System.currentTimeMillis();
		 end = start + 2700;
		//while(car.getRunning())
		 while(System.currentTimeMillis() < end)
			{
			
				car.run();
				frame.getContentPane().repaint();
			}
		}
		
	}
}
