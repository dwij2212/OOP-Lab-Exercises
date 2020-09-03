import java.util.Scanner;
public class TaxOnSalary {
	private double salary;
	private Boolean isPANsubmitted;
	
	// Overloaded Constructors
	public TaxOnSalary(Boolean issub) {
		this.isPANsubmitted = issub;
		this.salary = 1000;
	}
	
	public TaxOnSalary() {
		this.salary = 0;
		this.isPANsubmitted = false;
	}
	
	// Accessor methods
	public double getSalary() {
		return salary;
	}

	public Boolean getIsPANsubmitted() {
		return isPANsubmitted;
	}
	
	public double calculateTax() {
		double salary = this.getSalary();
		if (salary < 180000 & this.getIsPANsubmitted() == true) {
			System.out.println("No tax payable");
			return 0;
		}
		
		else if (salary < 180000 & this.getIsPANsubmitted() == false) {
			return salary * 0.05;
		}
		
		else if (salary > 180000 & salary < 500000) {
			return salary * 0.1;
		}
		
		else if (salary > 500000 & salary < 1000000) {
			return salary * 0.2;
		}
		
		else if (salary > 1000000) {
			return salary * 0.3;
		}
		return salary;
		
	}
	
	public void inputSalary() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter salary :");
		
		this.salary = in.nextDouble();
		
		// this is giving an error
		// in.close();

	}
	
	public void print() {
		double taxpayable = calculateTax();
		System.out.println("Tax payable is :" + taxpayable);
	}
		
}
