public class Outer{
	
	int i = 5;
	Inner i1 = new Inner();
	
	private String s = "Outer string"; //Outer instance variable
	
	void getS(){
		System.out.println(s);
	}
	void getInnerS(){
		System.out.println(i1.s);
	}
	
	void getI() {
		System.out.println(i);
	}
	
	class Inner{
		int i = 100;
		//Inner instance variable, uninitialized
		private String s = "Inner string";
		
		void getS(){
		System.out.println(s);
		}
	
		void getOuterS(){
		System.out.println(Outer.this.s);
		}
		
		void updateI(int x) {
			Outer.this.i = x;
		}
		
		void getI() {
			System.out.println(i);
		}
		
	}
	
	public static void main(String[]args){
		Outer o = new Outer();
		//can also be new Outer().new Inner();
//		Both these declarations work
//		Outer.Inner oi = o.new Inner();
//		Outer.Inner oi = o.i1;
		
		
//		o.getS();
//		oi.getS();
//		o.getInnerS();
//		oi.getOuterS();
		
		Outer.Inner o1 = o.new Inner();
		Outer.Inner o2 = o.i1;
		
		o1.updateI(55);
		o2.getI();
	}
}