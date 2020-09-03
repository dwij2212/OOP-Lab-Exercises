
public class Customer {
	private String name, idNo;
	private double balance = 5000;
	private Item item = new Item();
	
	public Customer(String name, String idNo, double balance) {
		super();
		this.name = name;
		this.idNo = idNo;
		this.balance = balance;
	}
	
	public Customer(String name, String idNo) {
		super();
		this.name = name;
		this.idNo = idNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public double getBalance() {
		return balance;
	}

	public Item getItem() {
		return item;
	}
	
	public void print() {
		System.out.println("Item purchased: " + item.getItemName() + "\n");
		System.out.println("Item ID: " + item.getItemidNo() + "\n");
		System.out.println("Item Quantity: " + item.getItemQuantity() + "\n");
		System.out.println("Item Price : " + item.getItemPrice() + "\n");
		System.out.println("Balance left: " + getBalance() + "\n");
	}
	
	public void buyItem(Item item) {
		// Check if sufficient balance
		if (this.balance - item.getItemPrice()*item.getItemQuantity() < 0 ) {
			System.out.println("Not enough balance.");
			return;
		}
		
		// If sufficient then assign item to customer.
		this.item = item;
		this.balance -= item.getItemPrice()*item.getItemQuantity();
		this.print();
	}
	
}
