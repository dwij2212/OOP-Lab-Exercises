import java.util.ArrayList;
import java.util.Iterator;

public class Bank {
	private ArrayList<Account> accts;
	int maxActive;

	public Bank() {
		// TODO Auto-generated constructor stub
		accts = new ArrayList<Account>();
	}

	public boolean addAccount(Account newone) {
		/*
		 * Write the code for adding new account, return false if account can’t be
		 * created
		 */
		try {
			accts.add(newone);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

	}

	public boolean removeAccount(long acctnum) {
		/*
		 * Write the code for removing the account, return false if account does not
		 * exist
		 */
		try {
			Iterator it = accts.iterator();
			while (it.hasNext()) {
				Account object = (Account) it.next();
				if (object.getAcctNumber() == acctnum) {
					it.remove();
				}
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public double deposit(long acctnum, double amount) {
		/*
		 * Write the code for depositing specified amount to the account,return -1 if
		 * account does not exist
		 */
		try {
			Iterator it = accts.iterator();
			while (it.hasNext()) {
				Account object = (Account) it.next();
				if (object.getAcctNumber() == acctnum) {
					object.setBalance(object.getBalance() - amount);
				}
			}
			return 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return -1;
		}
	}

	public double withdraw(long acctnum, double amount) {
		/*
		 * Write the code for withdrawing specified amount from the account,return -1 if
		 * insufficient balance or account does not exist
		 */
		try {
			Iterator it = accts.iterator();
			while (it.hasNext()) {
				Account object = (Account) it.next();
				if (object.getAcctNumber() == acctnum) {
					object.setBalance(object.getBalance() - amount);
				}
			}
			return 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return -1;
		}
	}
	// override toString

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		Iterator iterator = accts.iterator();

		while (iterator.hasNext()) {
			Account account = (Account) iterator.next();
			System.out.println(account.toString());
		}
		return "";
	}

}
