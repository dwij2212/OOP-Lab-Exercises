import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BankIO {
	private BankIO() {
		// Non instanstiable
	}

	public static void readFile(String filename, Bank bank) throws IOException {
		Scanner in;

		try {
			in = new Scanner(new File(filename));
			while (in.hasNextInt()) {
				try {
					bank.add(readAccount(in));
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("INVALID INPUT!");
					throw new IOException("Input should be of type: accountNumber, accountBalance");
				}

			}
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void write(String filename, Bank bank) {
		PrintWriter out;

		try {
			out = new PrintWriter(filename);
			for (BankAccount account : bank.getAccounts()) {
				try {
					out.write(account.getAccountNumber() + ", " + account.getBalance() + "\n");
					out.flush();
				} catch (NullPointerException e) {
					// TODO: handle exception
					System.out.println("Completed Writing");
					break;
				}

			}

			out.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("Invalid output filename.");
		}

	}

	public static BankAccount readAccount(Scanner in) {
		int accountNumber = in.nextInt();
		double initialBalance = in.nextDouble();

		System.out.println(accountNumber + " ," + initialBalance);

		return new BankAccount(initialBalance, accountNumber);
	}
}
