/**
 * 
 * @author Tyler Benjamin
 * 10/24/18
 * CPSC 2800-45180 - Introduction to Operating Systems
 *
 */
import java.util.concurrent.Semaphore;

public class BridgeCrossing {
	
	//mutual exclusion is just a semaphore with the access count restricted to 1 at a time
	static Semaphore semaphore = new Semaphore(1);

	
	//class for simulating/creating the cars
	static class Vehicle extends Thread {
		
		//naming each car allows for tracking of which car is doing what in the console
		String nameOfCar = "";
		
		Vehicle(String nameOfCar) {
			this.nameOfCar = nameOfCar;
		}
			
	
		//method that handles the crossing of the bridge as well as announcing when
		//each thread/car approaches the bridge
		public void run() {
			try {
				
				//car approaches the bridge and waits.
				System.out.println(nameOfCar +  " is approaching the bridge.");
				Thread.sleep(5000);
				//allows one car to pass and the semaphore locks
				semaphore.acquire();
				System.out.println(nameOfCar + " can now cross the bridge.");
				
				
				try {
						//car crosses the bridge, and "sleeps" for how long it takes to cross
						System.out.println(nameOfCar + " is driving across the bridge.");
						Thread.sleep(5000);
					
					
			}
			
			finally {
				
				//the car has crossed the bridge, so the semaphore lock is released
				System.out.println(nameOfCar + " has finished crossing the bridge.");
				semaphore.release();
			}
			}
			
			catch (InterruptedException ex) { }
		}
	}
		
		//throwing InterruptedException in order to space out how long it takes a car
		//to approach the bridge
		public static void main(String[] args) throws InterruptedException {
	
		//initializing 10 cars that need to cross.
		Vehicle v1 = new Vehicle("Car 1");
		Vehicle v2 = new Vehicle("Car 2");
		Vehicle v3 = new Vehicle("Car 3");
		Vehicle v4 = new Vehicle("Car 4");
		Vehicle v5 = new Vehicle("Car 5");
		Vehicle v6 = new Vehicle("Car 6");
		Vehicle v7 = new Vehicle("Car 7");
		Vehicle v8 = new Vehicle("Car 8");
		Vehicle v9 = new Vehicle("Car 9");
		Vehicle v10 = new Vehicle("Car 10");

		//each car takes a certain amount of time before it approaches the bridge
		v1.start();
		
		Thread.sleep(2000);
		v2.start();
		
		Thread.sleep(2000);
		v3.start();
		
		Thread.sleep(2000);
		v4.start();
	
		Thread.sleep(2000);
		v5.start();
		
		Thread.sleep(2000);
		v6.start();
		
		Thread.sleep(2000);
		v7.start();
		
		Thread.sleep(2000);
		v8.start();
		
		Thread.sleep(2000);
		v9.start();
		
		Thread.sleep(2000);
		v10.start();
		
		
	}
}

