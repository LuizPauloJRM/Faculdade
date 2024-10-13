package Prova02;

public class Questao01_Car {
	private int speed;
	
	// Method to accelerate the car
	void accelerate(int value) {
		speed += value;
	}
	
	// Method to get the current speed of the car
	int getSpeed() {
		return speed;
	}
	
	// Inner class RaceCar
	class RaceCar extends Questao01_Car {
		
		// Method to boost the speed by a fixed value
		void boost() {
			accelerate(40);
		}
	}
	
	// Main method to test the functionality
	public static void main(String[] args) {
		Questao01_Car car = new Questao01_Car();
		RaceCar rc = car.new RaceCar(); // Creating an instance of the inner class
		
		rc.boost();       // Boosting the speed by 40
		rc.accelerate(10); // Further accelerating by 10
		int result = rc.getSpeed(); // Getting the current speed
		
		System.out.println("Speed: " + result); // Outputting the result
	}
}
