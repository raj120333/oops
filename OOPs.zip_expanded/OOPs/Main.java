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
        Account current = a.login();
        if(check(i))
        {
        	current = a.login();
        }
        else
        {
        	
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
