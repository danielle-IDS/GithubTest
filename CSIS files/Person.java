
public class Person 
{

	private String _name;
	private String _phone;
	private String _email;
	
	public Person(String name, String phone, String email)
	{
		_name = name;
		_phone = phone;
		_email = email;
	}
	
	public String getName()
	{
		return _name;
	}
	
	public String getPhone()
	{
		return _phone;
	}
	
	public String getEmail()
	{
		return _email;
	}
	
	public void setName(String newName)
	{
		_name = newName;
	}
	
	public void setPhone(String newPhone)
	{
		_phone = newPhone;
	}
	
	public void setEmail(String newEmail)
	{
		_email = newEmail;
	}
	
	public String toString()
	{
		return _name + "\n"
			+ _phone + "\n"
			+ _email + "\n";
	}
}
