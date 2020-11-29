abstract class Ticket {
	float price;

	public Ticket(float price) {
		// TODO Auto-generated constructor stub
		this.price = price;
	}

	abstract public void addAmenity();
}

class Economy extends Ticket {

	public Economy() {
		// TODO Auto-generated constructor stub
		super(2500);
		System.out.println("Economy class ticket booked.");
	}

	@Override
	public void addAmenity() {
		// TODO Auto-generated method stub
		System.out.println("Adding Amenity");
	}
}

class PremiumEconomy extends Ticket {
	public PremiumEconomy() {
		super(3500);
		System.out.println("Premium economy class ticket booked.");
	}

	@Override
	public void addAmenity() {
		// TODO Auto-generated method stub
		System.out.println("Adding Amenity");
	}
}

class Business extends Ticket {
	public Business() {
		super(4500);
		System.out.println("Business class ticket booked.");
	}

	@Override
	public void addAmenity() {
		// TODO Auto-generated method stub
		System.out.println("Adding Amenity");
	}
}

class FirstClass extends Ticket {
	public FirstClass() {
		super(5500);
		System.out.println("FirstClass ticket booked.");
	}

	@Override
	public void addAmenity() {
		// TODO Auto-generated method stub
		System.out.println("Adding Amenity");
	}
}

public class DecoratorTicket extends Ticket {
	Ticket ticket;

	public DecoratorTicket(Ticket ticket) {
		// TODO Auto-generated constructor stub
		super(ticket.price);
		this.ticket = ticket;
	}

	public static void main(String[] args) {
		Ticket t1 = new Wifi(new LiveTv((new DecoratorTicket(new Economy()))));
		System.out.println(t1.price);

		t1 = new Wine(new LiveTv(new Wifi(new DecoratorTicket(new Business()))));
		System.out.println(t1.price);
	}

	@Override
	public void addAmenity() {
		ticket.addAmenity();
	}
}

class Wifi extends DecoratorTicket {
	public Wifi(Ticket ticket) {
		super(ticket);
		System.out.println("Adding wifi");
		addAmenity();
	}

	@Override
	public void addAmenity() {
		this.price += 10;
	}
}

class LiveTv extends DecoratorTicket {
	public LiveTv(Ticket ticket) {
		super(ticket);
		System.out.println("Adding LiveTv");
		addAmenity();
	}

	@Override
	public void addAmenity() {
		this.price += 50;
	}
}

class Wine extends DecoratorTicket {
	public Wine(Ticket ticket) {
		super(ticket);
		System.out.println("Adding Wine");
		addAmenity();
	}

	@Override
	public void addAmenity() {
		// TODO Auto-generated method stub
		this.price += 30;
	}
}
