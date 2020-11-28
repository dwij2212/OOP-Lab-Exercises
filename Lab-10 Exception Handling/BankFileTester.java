import java.io.IOException;
import java.util.Scanner;

public class BankFileTester {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		String filename = stdin.next();

		Bank bank = new Bank(10);

		while (true) {
			try {
				BankIO.readFile(filename, bank);
				break;
			} catch (IOException e) {
				System.out.println("Enter valid filename:");
				filename = stdin.next();
			}
		}
		BankIO.write("newfile.txt", bank);

		stdin.close();
	}
}
