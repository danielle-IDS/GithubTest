package sandbox;

public class JavaTest {

	public static void main(String[] args) {
		
		/*
		Complex a = new Complex(4.0, 2.0);
		System.out.println(a.toString());
		
		System.out.println();
		
		Complex b = new Complex(2.0, 12.4);
		a.add(b);
		b.subtract(a);
		
		System.out.println(a.toString());
		System.out.println(b.toString());
		
		System.out.println();
		
		a.multiply(b);
		b.divide(a);
		
		System.out.println(a.toString());
		System.out.println(b.toString());
		*/

		Complex a = new Complex(4.0, 2.0);
		Complex b = new Complex(2.0, 2.0);
		
		a.multiply(b);
		// b.divide(a);
		
		System.out.println(a.toString());
		System.out.println(b.toString());
		
	}

}
