
public class Account {
	private long acctNumber;
	private double balance;
	private String name;

	/*
	 * Complete the Account class by adding proper constructor, accessor method and
	 * mutator method as required. Override toSring() method to display account
	 * details.
	 */
	// Write your code here
	public Account(long acctNumber, double balance, String name) {
		super();
		this.acctNumber = acctNumber;
		this.balance = balance;
		this.name = name;
	}

	public long getAcctNumber() {
		return acctNumber;
	}

	public double getBalance() {
		return balance;
	}

	public String getName() {
		return name;
	}

	public void setAcctNumber(long acctNumber) {
		this.acctNumber = acctNumber;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "name:" + name + "balance: " + balance + "AcctNum: " + acctNumber;
	}
}
