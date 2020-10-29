
public class TestBank {
	public static void main(String[] args) {
		Bank bank = new Bank();

		System.out.println(bank.addAccount(new Account(1, 5000, "munna")));
		bank.addAccount(new Account(2, 3000, "guddu"));
		bank.addAccount(new Account(3, 6000, "dadda"));

		bank.withdraw(2, 100);
		bank.deposit(1, 2500);

		bank.toString();
	}
}
