package OOPs.transactions;


public class Expenditure extends Transaction

{
	public Expenditure()
	{	
		super();
		username = "NewExp";
	}
	public Expenditure(String username, float value, String type)
	{

		this.username = username;

		this.value = value;
	
		this.type = type;
	}
}
