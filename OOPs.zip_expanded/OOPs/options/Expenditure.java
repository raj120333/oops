package OOPs.options;

public class Expenditure extends Transaction
{
	public Expenditure()
	{	
		super();
		username = "NewInc";
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
