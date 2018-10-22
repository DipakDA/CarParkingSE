import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
//import java.util.concurrent.TimeUnit;

public class Main extends JPanel{
	
	/**
	 * 
	 */
	
	private static Car car = new Car(new Pair(8, 4), 0, 2, 0.5, 2);
	
	private static final long serialVersionUID = 1L;
	
	/*private static int x1=0;

	private static int y1=0;

	private static int x2=100;

	private static int y2=100;*/

	public void paint(Graphics g)
	{
		super.paintComponent(g);
		System.out.println("ndjsn");
		g.drawLine((int)(car.getFrontWheel().x * 1000), 
				(int)(car.getFrontWheel().y * 1000),
				(int)(car.getBackWheel().x * 1000), 
				(int)(car.getBackWheel().y * 1000));
		
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
		frame.setSize(10000, 10000);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		while(car.getRunning())
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
