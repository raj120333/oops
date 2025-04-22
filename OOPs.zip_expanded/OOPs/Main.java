package OOPs;

import OOPs.access.Access;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import OOPs.options.*;

public class Main {
	private static List<Account> accounts = new ArrayList<>();
    public static void main(String args[])
    {
    	Console con = System.console();
        System.out.println("Welcome to FinBits");
        System.out.println("Enter 1 for login, 0 for signup and anything else for exiting");
        String i = con.readLine();
        //take input into check input
        Access a = new Access(check(i),accounts);
        Account current = a.login();
        if(check(i))
        {
        	current = a.login();
        }
        else
        {
        	current = a.signup();
        }
        Options o = new Options(current);
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
    		}
    	}
		return false;
    }
}
