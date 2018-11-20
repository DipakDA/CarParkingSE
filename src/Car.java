import java.lang.Math;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class Car{
	/**
	 * 
	 */
	private static final long serialVersionUID = 780394804157555988L;
	private Pair carLocation;
	//center of car location;
	private double carHeading;
	//angle with the x axis
	private double carSpeed;
	//speed of car from back angle;
	private double steerAngle;
	//turn angle(of front wheel)
	private double wheelBase; 
	//distance between front and base wheels
	private volatile boolean running = true;
	private Pair frontWheel;
	private Pair backWheel;
	//current state of car
	
	private double carWidth;
	
	public Car(Pair carLocation, double carHeading, double carSpeed, double steerAngle, double wheelBase, double carWidth)
	{
		this.carLocation = carLocation;
		this.carHeading = carHeading;
		this.carSpeed = carSpeed;
		this.steerAngle = steerAngle;
		this.wheelBase = wheelBase;
		frontWheel = new Pair(true, carLocation, this.wheelBase, carHeading);
		//front wheel position(actual)
		backWheel = new Pair(false, carLocation, this.wheelBase, carHeading);
		//back wheel position(actual)		
		
		this.carWidth = carWidth;
		
		printData();
	}
	
	
	public void update()
	{
		final double dt = 1/100.0;
		//backWheel.x += carSpeed * dt * Math.cos(carHeading);
		//backWheel.y += carSpeed * dt * Math.sin(carHeading);
		frontWheel.x += carSpeed * dt * (Math.cos(carHeading));
		frontWheel.y += carSpeed * dt * (Math.sin(carHeading));
		
		backWheel.y = frontWheel.y - wheelBase*Math.sin(carHeading);
		backWheel.x = frontWheel.x - wheelBase*Math.cos(carHeading);
		
		carLocation.x = (frontWheel.x + backWheel.x)/2;
		carLocation.y = (frontWheel.y + backWheel.y)/2;
		
		System.out.println(Math.sqrt((backWheel.x - frontWheel.x)*(backWheel.x - frontWheel.x) + (backWheel.y - frontWheel.y)*(backWheel.y - frontWheel.y)));
		
		//carHeading = Math.atan2(frontWheel.y - backWheel.y, frontWheel.x - backWheel.x);
		//printData();
		carHeading -= steerAngle/700;
		System.out.println(System.nanoTime());
	}
	
	public void printData()
	{
	
		System.out.println(carLocation.x);
		System.out.println(carLocation.y);
		System.out.println(carHeading);
	}
	
	public void run()
	{
		//this thread is for keyboard interrupt to stop the code
		/*new Thread() {
			public void run() {
				try (Scanner scanner = new Scanner(System.in)) {
					boolean keepWaiting = true;
					while(keepWaiting) {
						String userInput = scanner.next();
						if("s".equals(userInput)) {
							stopRunning();
							keepWaiting = false;
						}
					}
				}
			}
		}.start();
		*/
				//handles all of the logic restricted time
				update();
				//repaint();
				
				try {
					TimeUnit.MILLISECONDS.sleep(25);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	/*private void render() {
		Graphics g = null;
		paint(g);
	}*/
	
	public Pair getCarLocation() {
		return this.carLocation;
	}
	
	public double getCarHeading() {
		return this.carHeading;
	}
	
	public Pair getBackWheel() {
		return this.backWheel;
	}
	
	public Pair getFrontWheel() {
		return this.frontWheel;
	}
	
	public boolean getRunning() {
		return this.running;
	}
	
	public void stopRunning() {
		running = false;
	}
	
	public void setSteerAngle(double angle) {
		this.steerAngle = angle;
	}
	
	public void setSpeed(double x)
	{
		this.carSpeed = x;
	}
	
}
