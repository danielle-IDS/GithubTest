package sandbox;

/**
 * a class that creates a complex number with real and imaginary doubles
 */
public class Complex {

	private double _realPart;
	private double _imaginaryPart;
	
	public Complex()
	{
		this._realPart = 0.0;
		this._imaginaryPart = 0.0;
	}
	
	public Complex(double initialReal, double initialImaginary)
	{
		this._realPart = initialReal;
		this._imaginaryPart = initialImaginary;
	}
	
	/**
	 * this method returns the real number in a Complex object
	 */
	public double getRealPart()
	{
		return this._realPart;
	}
	
	/**
	 * this method returns the real number in a Complex object
	 */
	public double getImaginaryPart()
	{
		return this._imaginaryPart;
	}
	
	/**
	 * this method takes in a Complex number and adds that object's real and imaginary parts to
	 * the objects real and imaginary parts
	 * 
	 * @param a Complex number
	 */	
	public void add(Complex anotherNum)
	{
		_realPart += anotherNum.getRealPart();
		_imaginaryPart += anotherNum.getImaginaryPart();		
	}
	
	/**
	 * this method takes in a Complex number and subtracts that object's real and imaginary parts to
	 * the objects real and imaginary parts
	 * 
	 * @param a Complex number
	 */	
	public void subtract(Complex anotherNum)
	{
		_realPart -= anotherNum.getRealPart();
		_imaginaryPart -= anotherNum.getImaginaryPart();
	}
	
	/**
	 * this method takes in a Complex number and multiplies that object's real and imaginary parts to
	 * the objects real and imaginary parts
	 * 
	 * @param a Complex number
	 */	
	public void multiply(Complex anotherNum)
	{
		_realPart = (this._realPart * anotherNum.getRealPart()) - (this._imaginaryPart * anotherNum.getImaginaryPart());
		_imaginaryPart = (this._imaginaryPart * anotherNum.getRealPart()) + (this._realPart * anotherNum.getImaginaryPart());
	}
	
	/**
	 * this method takes in a Complex number and divides that object's real and imaginary parts to
	 * the objects real and imaginary parts
	 * 
	 * @param a Complex number
	 */	
	public void divide(Complex anotherNum)
	{
		_realPart = ((anotherNum.getRealPart() * this._realPart) + (this._imaginaryPart * anotherNum.getImaginaryPart())) / ((Math.pow(anotherNum.getRealPart(), 2) + (Math.pow(anotherNum.getImaginaryPart(), 2))));
		_imaginaryPart = ((this._imaginaryPart * anotherNum.getRealPart()) + (this._realPart * anotherNum.getImaginaryPart())) / ((Math.pow(anotherNum.getRealPart(), 2) + (Math.pow(anotherNum.getImaginaryPart(), 2))));
	}
	
	/**
	 * this method creates a string with each component of a Complex number, formats it
	 * and then prints it
	 */	
	public String toString()
	{
		String realPart = String.format("%1$.1f", this._realPart);
		String imaginaryPart = String.format("%1$.1f", this._imaginaryPart);
		String toString = "(" + realPart + " + " + imaginaryPart + "i)";
		return toString;
	}
	
	/**
	 * this method takes in a Complex number and test it for equality
	 * 
	 * @param a Complex number
	 */	
	public boolean equals(Complex anotherNum)
	{
		boolean realPart = this._realPart == anotherNum.getRealPart();
		boolean imaginaryPart = this._imaginaryPart == anotherNum.getImaginaryPart();
		return realPart && imaginaryPart;		
	}
}
