import java.util.Scanner;
public class Example2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* instantiate scanner class by passing System.in to its constructor */
		Scanner in = new Scanner(System.in);
		System.out.println("Enter 10 numbers :");
		
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += in.nextInt();
		}
		
		System.out.println("The sum is : " + sum);
	}

}
