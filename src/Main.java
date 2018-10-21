
public class Main {
	public static void main(String[] args)
	{
		//initial coordinate of center = 0, 0
		//car initial angle with x axis = 0
		//car speed(fixed) = 2
		//car steerAngle(frontWheel) angle with axis = 0.5 radians
		//car wheelBase = 3
		System.out.println("Starting main thread");
		Car car = new Car(new Pair(0, 0), 0, 2, 0.5, 3);
		Thread t = new Thread(car);
		t.start();
	}
}
