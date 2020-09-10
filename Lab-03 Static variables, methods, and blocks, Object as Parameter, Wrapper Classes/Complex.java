
public class Complex {
	// instance variables
	private double realPart;
	private double imgPart;
	
	// Constructors
	public Complex () {
		// pass
	}
	public Complex(double realPart) {
		super();
		this.realPart = realPart;
	}
	public Complex(double realPart, double imgPart) {
		super();
		this.realPart = realPart;
		this.imgPart = imgPart;
	}
	
	// Getters and setters
	public double getRealPart() {
		return realPart;
	}
	public void setRealPart(double realPart) {
		this.realPart = realPart;
	}
	public double getImgPart() {
		return imgPart;
	}
	public void setImgPart(double imgPart) {
		this.imgPart = imgPart;
	}
	
	// User defined methods
	public Complex add (Complex otherNumber) {
		// only add method keeps c2 as is whereas 
		// other methods change c2.
		Complex newComplex = new Complex();
		newComplex.setRealPart(otherNumber.getRealPart() + this.realPart);
		newComplex.setImgPart(otherNumber.getImgPart() + this.imgPart);
		return newComplex;
	}
	
	public Complex subtract (Complex otherNumber) {
		otherNumber.setRealPart(otherNumber.getRealPart() - this.realPart);
		otherNumber.setImgPart(otherNumber.getImgPart() - this.imgPart);
		return otherNumber;
	}
	
	public Complex multiply (Complex otherNumber) {
		// get values
		double a = otherNumber.getRealPart();
		double b = otherNumber.getImgPart();
		double c = this.realPart;
		double d = this.imgPart;
		
		// multiply
		otherNumber.setRealPart(a*c - b*d);
		otherNumber.setImgPart(b*c + a*d);
		
		return otherNumber;
	}
	
	public Complex divide (Complex otherNumber) {
		// get values
		double a = otherNumber.getRealPart();
		double b = otherNumber.getImgPart();
		double c = this.realPart;
		double d = this.imgPart;
	
		double div = a*a + b*b;
		
		otherNumber.setRealPart((a*c + b*d)/div);
		otherNumber.setImgPart((a*d - b*c)/div);
		
		return otherNumber;
	}
}
