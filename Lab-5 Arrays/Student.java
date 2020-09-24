package lab5;

public class Student {
	private Name name;
	private int age;
	
	Student(Name name, int age) {
		this.name = name;
		this.age = age;
	}

	/**
	 * @return the name
	 */
	public Name getName() {
		return name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	
	public void printInfo() {
		System.out.println("Full name: " + name.fullname);
		System.out.println("Age: " + age);
	}
	
	
	
}
