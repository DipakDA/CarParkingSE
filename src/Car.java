import java.lang.Math;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.*;

public class Car extends JFrame implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 780394804157555988L;
	private Pair carLocation;
	//center of car location;
	private double carHeading;
	//angle with the x axis
	private final double carSpeed;
	//speed of car from back angle;
	private double steerAngle;
	//turn angle(of front wheel)
	private double wheelBase; 
	//distance between front and base wheels
	private volatile boolean running = true;
	private Pair frontWheel;
	private Pair backWheel;
	//current state of car
	private PrintWriter out;
	
	
	public Car(Pair carLocation, double carHeading, double carSpeed, double steerAngle, double wheelBase)
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
		
		setTitle("2D Car rendering");
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		printData();
	}
	
	
	public void update()
	{
		final double dt = 1/60.0;
		backWheel.x += carSpeed * dt * Math.cos(carHeading);
		backWheel.y += carSpeed * dt * Math.sin(carHeading);
		frontWheel.x += carSpeed * dt * (Math.cos(carHeading + steerAngle));
		frontWheel.y += carSpeed * dt * (Math.sin(carHeading + steerAngle));
		
		carLocation.x = (frontWheel.x + backWheel.x)/2;
		carLocation.y = (frontWheel.y + backWheel.y)/2;
		
		carHeading = Math.atan2(frontWheel.y - backWheel.y, frontWheel.x - backWheel.x);
		printData();
	}
	
	public void printData()
	{
		try {
			FileWriter fw = new FileWriter("OUTPUT.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			out = new PrintWriter(bw);
			out.println(carLocation.x);
			out.println(carLocation.y);
			out.println(carHeading);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void run()
	{
		new Thread() {
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
		
		long lastTime = System.nanoTime();
		final double ns = 1000000000.0 / 60.0;//60 times per second
		double delta = 0;
		while(running) {
			long now = System.nanoTime();
			delta = delta + ((now-lastTime) / ns);
			lastTime = now;
			while (delta >= 1)//Make sure update is only happening 60 times a second
			{
				//handles all of the logic restricted time
				update();
				delta--;
				
			}
			
		}
	}
	
	/*private void render() {
		Graphics g = null;
		paint(g);
	}*/
	
	public synchronized void stopRunning() {
		running = false;
	}
	
}
