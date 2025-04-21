package OOPs.options;

public class Expenditure extends Option
{
	public String username;
	public float value;
	String type;
	public Expenditure()
	{	
		username = "NewInc";
		value = 0;
		type = "Monthly";
	}
	public Expenditure(String username, float value, String type)
	{
		System.out.println("Enter expenditure name: ");
		//take input
		this.username = username;
		System.out.println("Enter how much expenditure: ");
		//take input
		this.value = value;
		System.out.println("Enter the type of expenditure i.e: monthly, quarterly or annually: ");
		//take input
		this.type = type;
	}
}
