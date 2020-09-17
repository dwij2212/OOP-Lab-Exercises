
public class ComplexDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Complex c1 = new Complex(1.0,2.0);
		Complex c2 = new Complex(2.0, 4);
		
		// except add, Other methods change values of c2.
		Complex c3 = c1.add(c2);
		System.out.println("After Addition : " + c3.getRealPart() + "+ i" + c3.getImgPart());
		System.out.println("After Addition C2 : " + c2.getRealPart() + "+ i" + c2.getImgPart());
	}

}
