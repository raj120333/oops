package OOPs.options; 


public class Income extends Transaction
{
	public Income()
	{	
		super();
		username = "NewInc";
	}
	public Income(String username, float value, String type)
	{
		System.out.println("Enter income name: ");
		//take input
		this.username = username;
		System.out.println("Enter how much income: ");
		//take input
		this.value = value;
		System.out.println("Enter the type of income i.e: one time,monthly, quarterly or annually: ");
		//take input
		this.type = type;
	}
}

