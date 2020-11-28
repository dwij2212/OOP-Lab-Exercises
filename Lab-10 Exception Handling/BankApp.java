import java.util.Scanner;

/**
 * A class to test the BankAccount class. Uses a menu-driven system to allow the
 * user to interactively test the BankAccount class.
 * 
 * @author cs302
 */
public class BankApp {

	private static Scanner stdin = new Scanner(System.in);

	public static void main(String[] args) {

		Bank bank = new Bank(100);

		// ************
		// * TASK 1 *
		// ************
		// TODO TASK 1: note that the account is initially null
		BankAccount account = null;
		int choice;
		double amount;
		int accountNumber;

		do {
			choice = getUserChoice();
			switch (choice) {
			case 1:
				amount = getAmount();
				accountNumber = getAccountNumber();
				try {
					account = new BankAccount(amount, accountNumber);
					bank.add(account);
					System.out.println("Account info: " + account + "\n");
				} catch (IllegalArgumentException exception) {
					System.out.println("\n*****ERROR*****: " + exception.getMessage() + "\n");
				}
				break;

			// *****************
			// * TASKS 1 & 2 *
			// *****************
			// TODO TASK 1: Note the first catch clause
			// TODO TASK 2: Note the second catch clause
			case 2:
				amount = getAmount();
				try {
					account.deposit(amount);
					System.out.println("Account info: " + account + "\n");
				} catch (NullPointerException exception) {
					System.out.println(
							"\n*****ERROR*****\n" + "No account! First find account" + " or create a new account\n");
				} catch (IllegalArgumentException exception) {
					System.out.println("\n*****ERROR*****\n" + exception.getMessage() + "\n");
				}
				break;

			// *****************
			// * TASKS 1 & 3 *
			// *****************
			// TODO TASK 1: add a similar NullPointerException catch clause below
			// TODO TASK 3: add a InsufficientFunds catch clause below
			case 3:
				amount = getAmount();
				try {
					account.withdraw(amount);
					System.out.println("Account info: " + account + "\n");
				} catch (IllegalArgumentException exception) {
					System.out.println("\n*****ERROR*****: " + exception.getMessage() + "\n");
				} catch (NullPointerException e) {
					System.out.println(
							"\n*****ERROR*****\n" + "No account! First find account" + " or create a new account\n");
				} catch (InsufficientFundsException e) {
					System.out.println("\n*****ERROR*****\n" + e.getMessage());
				}
				break;

			case 4:
				accountNumber = getAccountNumber();
				BankAccount found = bank.find(accountNumber);
				if (found != null) {
					account = found;
					System.out.println("Account info: " + account + "\n");
				} else {
					System.out.println("\n*****ERROR*****: Bank account " + accountNumber + " not found!\n");
				}
				break;

			case 5:
				System.out.print("\n\nThe accounts: \n" + bank + "\n\n");
				break;
			}
		} while (choice != 0);
		System.out.println("\n\nGoodbye!");
	}

	private static int getUserChoice() {
		int choice;
		do {
			choice = -1;
			System.out.println("Menu Options:");
			System.out.println("0) Quit");
			System.out.println("1) Create new account");
			System.out.println("2) Deposit to current account");
			System.out.println("3) Withdraw from current account");
			System.out.println("4) Find account");
			System.out.println("5) Print all accounts");

			System.out.print("Enter your choice (0 - 5): ");
			try {
				choice = Integer.parseInt(stdin.nextLine());
			} catch (NumberFormatException exception) {
			}
			if (choice < 0 || choice > 5)
				System.out.println("Invalid choice");
		} while (choice < 0 || choice > 5);
		return choice;
	}

	private static double getAmount() {
		System.out.print("Enter the amount: $ ");
		double amount = -1;
		boolean valid = false;
		do {
			try {
				amount = Double.parseDouble(stdin.nextLine());
				valid = true;
			} catch (NumberFormatException exception) {
				System.out.println("Make sure you enter a valid double!");
			}
		} while (!valid);
		return amount;
	}

	private static int getAccountNumber() {
		System.out.print("Enter the account number: ");
		int amount = -1;
		boolean valid = false;
		do {
			try {
				amount = Integer.parseInt(stdin.nextLine());
				valid = true;
			} catch (NumberFormatException exception) {
				System.out.println("Make sure you enter a valid integer!");
			}
		} while (!valid);
		return amount;
	}
}
