public class StaticOuter{
	String a = "Static Outer string";
	static String b = "Static Outer static string";
	void seeStaticInner(){
		//cannot find symbol
//		System.out.println(nonstatic);
		//nonstatic is not static to access like this!
		//2. System.out.println(StaticInner.nonstatic);
		
		System.out.println(new StaticInner().nonstatic);//OK
		System.out.println(StaticInner.s);//OK, s is static
	}
	public static void main(String[]args){
		//Doesn't compiles without writing the exact location of s
		//3. System.out.println(s);
		System.out.println(StaticInner.s);
		StaticOuter so = new StaticOuter();
		so.seeStaticInner();
	}
	
		static class StaticInner{
			String nonstatic = "StaticInner nonstatic string";
			static String s = "StaticInner static string";
			public static void main(String[]args){
				//cannot be referenced from a static context
				//4. System.out.println(nonstatic);
				System.out.println(s);
				//OK, b is a static string. But not 'a' which is non-static!
				System.out.println(b);
			}
		}
	}
	
	class SomeOther{
		public static void main(String[]args){
			//Write the exact location of s
			System.out.println(StaticOuter.StaticInner.s);
			//To access nonstatic members we need an object or 'this'
			StaticOuter.StaticInner si = new StaticOuter.StaticInner();
			//No 'this' exists in static context!
			System.out.println(si.nonstatic);
//			System.out.println(si.s);
	}
}