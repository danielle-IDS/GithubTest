
public class Student extends Person
{
	private String _major;
	private double _gpa;
	
	public Student(String name, String phone, String email, String major, double gpa)
	{
		super(name, phone, email);
		_major = major;
		_gpa = gpa;
	}
	
	public String getMajor()
	{
		return _major;
	}
	
	public double getGPA()
	{
		return _gpa;
	}
	
	public void setMajor(String newMajor)
	{
		_major = newMajor;
	}
	
	public void setGPA(double gpa)
	{
		_gpa = gpa;
	}
	
	public String toString()
	{
		return super.toString() + _major + "\n" + _gpa+ "\n";
	}

}
