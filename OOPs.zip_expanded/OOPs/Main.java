package OOPs;

import OOPs.access.Access;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private static List<Account> accounts = new ArrayList<>();
    public static void main(String args[])
    {
        System.out.println("Welcome to FinBits");
        System.out.println("Enter 1 for login, 0 for signup and anything else for exiting up");
        String i = "";
        //take input into check input
        Access a = new Access(check(i),accounts);
        if(check(i))
        {
        	Account current = a.login();
        	
        }
        else
        {
        	Account current = a.signup();
		System.out.println("Press 1->Income
				   	  2->Expenditure
				   	  3->Savings
				   	  4->Budget")
		int option;
		//input option
		if(option == 1){
			System.out.println("Enter Income to be added");
			float value;
			//input value
			income.addIncome(current.getUsername(),value, current.getType());
		}
		else if(option == 2){
			Expenditure(current.getUsername(), float value, current.getType());
		}
		else if(option == 3){
			
		}
		else if(option == 4){
		}

        }
    }
    
    static boolean check(String i)
    {
    	boolean b = true;
    	while(b)
    	{
    		if(i.equals("1")) return true;
    		else if (i.equals("0")) return false;
    		else
    		{
    			System.out.println("Exiting");
    			System.exit(0);
    			return false;
    			//accept input into i
    		}
    	}
		return false;
    }
}
