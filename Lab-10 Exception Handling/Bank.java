/**
 * A Bank can hold up to a fixed number of BankAccounts.
 * 
 * @author cs302
 */
public class Bank {

	/** The array of BankAccount objects. */
	private BankAccount[] accounts;

	/** The first available account index. */
	private int firstAvailableAcc;

	/**
	 * Creates a bank that can have up to numAccounts accounts.
	 */
	public Bank(int numAccounts) {
		this.accounts = new BankAccount[numAccounts];
		this.firstAvailableAcc = 0;
	}

	/**
	 * Adds the given BankAccount to the bank. If the bank is full an error message
	 * is printed and the bank is unchanged.
	 * 
	 * @param account The account to add
	 */
	public void add(BankAccount account) {
		if (firstAvailableAcc == accounts.length) {
			System.out.println("Bank is full. No account added.");
			return;
		}
		this.accounts[firstAvailableAcc] = account;
		firstAvailableAcc++;
	}

	/**
	 * Returns the bank account with the given account number. If no such account
	 * exists, null is returned.
	 * 
	 * @param acctNumber The account number
	 * @return The account
	 */
	public BankAccount find(int acctNumber) {
		for (int i = 0; i < firstAvailableAcc; i++) {
			if (accounts[i].getAccountNumber() == acctNumber) {
				return accounts[i];
			}
		}

		return null;
	}

	/**
	 * Returns a string representation of the bank. The format is one account per
	 * line.
	 */
	public String toString() {
		if (firstAvailableAcc == 0)
			return "NONE";

		String result = "";
		for (int i = 0; i < firstAvailableAcc; i++) {
			result += accounts[i].getAccountNumber() + " ";
			result += accounts[i].getBalance() + "\n";
			// Note that we don't make use of BankAccount's toString because
			// we don't want to have dollar signs ($) as part of the String
			// representation for the Bank.
		}

		return result;
	}

	public BankAccount[] getAccounts() {
		return this.accounts;
	}
}
