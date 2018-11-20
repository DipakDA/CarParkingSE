import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.Scanner;

import java.awt.Graphics;
//import java.util.concurrent.TimeUnit;
import java.awt.Graphics2D;

public class Main extends JPanel{
	
	/**
	 * 
	 */
	
	private static int caseNo;
	private static Car car = new Car(new Pair(4, 9), 270*(Math.PI/180), 2, 0, 1, 0.5);
	private static int[][] grid;
	public static int slot1 = -1, slot2 = -1, slot3 = -1;
	
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
		
		//DEFAULT RIGHT SIDE
		g2d.fillRect(600,0,400,1000);
		
		if(caseNo == 1){
			
			//MAP WITH 3 GAPS	
			g2d.fillRect(0,125,200,205);	
			g2d.fillRect(0,475,200, 150);
			g2d.fillRect(0,500,200, 100);
			g2d.fillRect(0,750,200, 250);
			
			if(slot1 == 1) {
				g2d.fillRect(0,0,200,150);
			}
			if(slot2 == 1) {
				g2d.fillRect(0,300,200,200);
			}
			if(slot3 == 1) {
				g2d.fillRect(0, 500, 200, 500);
			}
		}
		else if(caseNo == 2){	
			//MAP WITH 2 GAPS	
			g2d.fillRect(0,150,200,150);
			g2d.fillRect(0,350,200,250);
			g2d.fillRect(0,750,200,250);
			
			if(slot1 == 1) {
				g2d.fillRect(0, 0, 200, 150);
			}
			if(slot2 == 1) {
				g2d.fillRect(0, 500, 200, 500);
			}
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
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter which map you want to use");
		caseNo = scan.nextInt();
		if(caseNo == 1){
			System.out.println("You have selected MAP 1");
			System.out.println("There are 3 slots available. Type 1 for having that slot and 0 for leaving it blank. First, Second, Third in that order");
			slot1 = scan.nextInt();
			slot2 = scan.nextInt();
			slot3 = scan.nextInt();
			
			if(slot1 == 1 && slot2 == 1 && slot3 == 1)
			{
				System.out.println("You have selected all the three slots to be filled");
			}
			else if(slot1 == 1 && slot2 == 1)
			{
				System.out.println("You have selected Slot 1 and slot 2");
			}
			else if(slot2 == 1 && slot3 == 1)
			{
				System.out.println("You have selected Slot 2 and slot 3");
			}
			else if(slot1 == 1 && slot3 == 1)
			{
				System.out.println("You have selected Slot 1 and slot 3");
			}
			else if(slot1 == 1)
			{
				System.out.println("You have selected Slot 1");			
			}
			else if(slot1 == 2)
			{
				System.out.println("You have selected Slot 2");			
			}
			else if(slot1 == 3)
			{
				System.out.println("You have selected Slot 3");			
			}
			else
			{
				System.out.println("All the slots are free");
			}
			//MAP WITH 3 GAPS	
		}
		else if(caseNo == 2){	
			System.out.println("You have selected MAP 2");
			System.out.println("There are 2 slots available. Type 1 for having that slot and 0 for leaving it blank. First, Second in that order");
			slot1 = scan.nextInt();
			slot2 = scan.nextInt();
			
			scan.close();
			
			if(slot1 == 1 && slot2 == 1)
			{
				System.out.println("You have selected all the two slots to be filled");
			}
			else if(slot1 == 1)
			{
				System.out.println("You have selected Slot 1");			
			}
			else if(slot1 == 2)
			{
				System.out.println("You have selected Slot 2");			
			}
			else
			{
				System.out.println("All the slots are free");
			}//MAP WITH 2 GAPS	
		}
		scan.close();
		
		
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
			if(slot3 == 0) {
				start = System.currentTimeMillis();
				 end = start + 0;
				 end = end + 2500;
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
			else if(slot2 == 0) {
				start = System.currentTimeMillis();
				 end = start + 3500;
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
			else if(slot1 == 0) {
				start = System.currentTimeMillis();
				 end = start + 8000;
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
			else {
				start = System.currentTimeMillis();
				 end = start + 8150;
				 end = end + 2700;
				//while(car.getRunning())
				 while(System.currentTimeMillis() < end)
					{
					
						car.run();
						frame.getContentPane().repaint();
					}
			}
		}
		
		else if(caseNo == 2){
			if(slot2 == 0) {
				start = System.currentTimeMillis();
				 end = start + 0;
				 end = end + 2500;
				//while(car.getRunning())
				 while(System.currentTimeMillis() < end)
					{
					
						car.run();
						frame.getContentPane().repaint();
					}
					
				
				 start = System.currentTimeMillis();
				 end = start + 2700;
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
			else if(slot1 == 0) {
				start = System.currentTimeMillis();
				 end = start + 8000;
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
			else {
				start = System.currentTimeMillis();
				 end = start + 8300;
				 end = end + 2700;
				//while(car.getRunning())
				 while(System.currentTimeMillis() < end)
					{
					
						car.run();
						frame.getContentPane().repaint();
					}
			}
		}
		
	}
}
