package OOPs.transactions; 


public class Income extends Transaction
{
	public Income()
	{	
		super();
		username = "NewInc";
	}
	public Income(String username, float value, String type)
	{

		this.username = username;

		this.value = value;
	
		this.type = type;
	}
}

