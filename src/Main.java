import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
//import java.util.concurrent.TimeUnit;
import java.awt.Graphics2D;

public class Main extends JPanel{
	
	/**
	 * 
	 */
	
	private static Car car = new Car(new Pair(4, 6), 270*(Math.PI/180), 2, 0, 2);
	
	private static final long serialVersionUID = 1L;
	
	/*private static int x1=0;

	private static int y1=0;

	private static int x2=100;

	private static int y2=100;*/

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		System.out.println("ndjsn");
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawLine((int)(car.getFrontWheel().x * 100), 
				(int)(car.getFrontWheel().y * 100),
				(int)(car.getBackWheel().x * 100), 
				(int)(car.getBackWheel().y * 100));
				//(int)((Math.cos(car.getSteerAngle() - car.getCarHeading()) * 2)*100 + car.getFrontWheel().x*100),
				//(int)((Math.sin(car.getSteerAngle() - car.getCarHeading()) * 2)*100 + car.getFrontWheel().y*100));			
		
		g2d.fillRect(800,0,200,1000);	
		g2d.fillRect(0,200,200,800);	
		
		//For the car
		//AffineTransform old = g2d.getTransform();
		/*g2d.rotate(Math.toRadians(00));
		g2d.fillRect(500,400, ((int)car.getWheelBase() ) * 100, 50);
		
		g2d.rotate(30.0 * Math.PI / 180.0);
		g2d.fillRect(500,400, ((int)car.getWheelBase() ) * 100, 50);
		
		g2d.rotate(Math.toRadians(10));
		g2d.fillRect(400,400, ((int)car.getWheelBase() ) * 100, 50);
		
		g2d.rotate(Math.toRadians(30));
		g2d.fillRect(400,400, ((int)car.getWheelBase() ) * 100, 50);
		
		g2d.rotate(Math.toRadians(40));
		g2d.fillRect(400,400, ((int)car.getWheelBase() ) * 100, 50);*/
		//g2d.setTransform(old);
		//g2d.fillRect(800,0,200,1000);	
		//g2d.fillRect(0,200,200,800);	
		//g.drawLine(x1, y1, x2, y2);
	}
	
	public static void main(String[] args)
	{
		//initial coordinate of center = 0, 0
		//car initial angle with x axis = 0
		//car speed(fixed) = 2
		//car steerAngle(frontWheel) angle with axis = 0.5 radians
		//car wheelBase = 3
		System.out.println("Starting main thread");
		
		JFrame frame = new JFrame();
		frame.getContentPane().add(new Main());
		frame.setTitle("2D Car Parking Simulation");
		frame.setSize(1000, 1000);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		long start = System.currentTimeMillis();
		long end = start + 6*1000;
		//while(car.getRunning())
			while(System.currentTimeMillis() < end)
			{
			
				car.run();
				frame.getContentPane().repaint();
			}
		
		
		car.setSteerAngle(270*(Math.PI/180));
		
		 start = System.currentTimeMillis();
		 end = start + 3*1000;
		//while(car.getRunning())
		 while(System.currentTimeMillis() < end)
			{
			
				car.run();
				frame.getContentPane().repaint();
			}
		/*
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Rinal");
		x1 = 100;
		x2 = 200;
		y1 = 100;
		y2 = 200;
		frame.getContentPane().repaint();
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		x1 = 200;
		x2 = 300;
		y1 = 200;
		y2 = 300;
		frame.getContentPane().repaint();
		*/
	}
}
