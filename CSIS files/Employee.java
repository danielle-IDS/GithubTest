
public class Employee extends Person
{
	
	private String _employeeID;
	
	public Employee(String name, String phone, String email, String empID)
	{
		super(name, phone, email);
		_employeeID = empID;
	}
	
	public String getEmployeeID()
	{
		return _employeeID;
	}
	
	public void setEmployeeID(String newID)
	{
		_employeeID = newID;
	}
	
	public String toString()
	{
		return super.toString() + _employeeID + "\n";
	}

}
