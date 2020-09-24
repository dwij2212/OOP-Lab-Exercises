package lab5;

import java.io.IOException;
import java.util.Scanner;

public class Test {
	public static Student readstudent() throws IOException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name: ");
		String name = sc.nextLine();
		
		// so enter key doesnt give error
//		sc.nextLine();
		System.out.println("Enter Age: ");
		int age = sc.nextInt();
		
		Name n = new Name(name);
		Student s = new Student(n, age);
		return s;
	}
	
	public static void main(String[] args) throws IOException {
		
		for (int i = 0; i < 10; i++) {
			StudentList.addStudent(readstudent());
		}
		
		Student[] test1 = StudentList.getStudentsWithAge(20);
		
		for (int i = 0; test1[i] != null; i++) {
			test1[i].printInfo();
		}
		
	Student[] test2 = StudentList.getStudentsInRange(16, 20);
			
		for (int i = 0; test2[i] != null; i++) {
			test2[i].printInfo();
		}
		
		Student[] test3 = StudentList.getStudentsWithLastName("Sharma");
		
		for (int i = 0; test3[i] != null; i++) {
			test3[i].printInfo();
		}
		
		
	}
}
