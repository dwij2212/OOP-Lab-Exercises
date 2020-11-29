interface Currency {
	public String getCurrency();

	public String getSymbol();
}

class USA implements Currency {

	@Override
	public String getCurrency() {
		// TODO Auto-generated method stub
		return "DOLLAR";
	}

	@Override
	public String getSymbol() {
		// TODO Auto-generated method stub
		return "$";
	}
}

class India implements Currency {
	@Override
	public String getCurrency() {
		// TODO Auto-generated method stub
		return "Ruppee";
	}

	@Override
	public String getSymbol() {
		// TODO Auto-generated method stub
		return "RS";
	}

}

public class CurrencyFactory {
	public static Currency getCurrencyByCountry(String country) {
		if (country.equalsIgnoreCase("INDIA")) {
			return new India();
		}

		else {
			return new USA();
		}
	}

	public static void main(String[] args) {
		Currency in = getCurrencyByCountry("india");
		System.out.println(in.getCurrency());

		Currency usCurrency = getCurrencyByCountry("US");
		System.out.println(usCurrency.getCurrency());
	}
}
