
public class TestTax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TaxOnSalary t1 = new TaxOnSalary(true);
		TaxOnSalary t2 = new TaxOnSalary();
		
		t1.inputSalary();
		t2.inputSalary();
		
		t1.print();
		t2.print();
	}

}
