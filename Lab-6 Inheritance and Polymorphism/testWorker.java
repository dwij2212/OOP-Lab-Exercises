package lab6;

abstract class Worker {
	
	String name;
	double salary;
	
	Worker(){
		
	}
	Worker(String n, double amt) {
		name = n;
		salary = amt;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	abstract public double computePay();	
	
}

class FullTimeWorker extends Worker {
	// static since hours worked by each fulltime worker will be the same
	static int hours_worked;
	
	FullTimeWorker(String n, double amt, int hours) {
		super();
		name = n;
		salary = amt;
		hours_worked = hours;
	}
	
	public double computePay() {
		return salary*hours_worked;
	}
}

class HourlyWorker extends Worker {
	// may be different for each worker
	int hours_worked;
	
	HourlyWorker(String n, double amt, int hours) {
		super();
		name = n;
		salary = amt;
		hours_worked = hours;
	}
	
	public double computePay() {
		return salary*hours_worked;
	}
}

public class testWorker {

	public static void main(String[] args) {
		FullTimeWorker f1 = new FullTimeWorker("GG", 150, 125);
		@SuppressWarnings("unused")
		HourlyWorker h1 = new HourlyWorker("WP", 110, 15);
		
		// This demonstrates for late binding.
		// Worker w = h1;
		Worker w = f1;
		
		System.out.println(w.computePay());
//		System.out.println(f1.computePay());

	}

}
