package lab6;

class Employer {
	private String name;
	private double salary;
	
	public Employer () {
		
	}
	
	public Employer(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employer [name=" + name + ", salary=" + salary + "]";
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

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}

public class Manager extends Employer {
	// Manager is also the driver class here
	private String dept;

	@Override
	public String toString() {
		return "Manager [dept=" + dept + ", Name=" + getName() + ", Salary=" + getSalary() + "]";
	}
	
	public static void main(String[] args) {
		Manager m = new Manager();
		Employer e = new Employer("XAE12", 20000);
		
		m.dept = "CSE";
		m.setName("Dwij");
		m.setSalary(15000000);
		
		Manager m2 = (Manager) e;
		System.out.println(m2.toString());
//		System.out.println(poly.toString());
	}

	
	
}
