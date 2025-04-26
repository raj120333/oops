package OOPs.access;

import OOPs.*;

import java.io.Console;
import java.util.List;
public class Access {
	Console con = System.console();
	boolean type;//type if true means login and if false sign up
	List<Account> accounts;
	String username;
	public Access(boolean type,List<Account> accounts){
		this.type = type;
		this.accounts = accounts;
		
	}
	public Account login()
	{
		System.out.println("Enter username");
		username = con.readLine();
		Account c = this.trav_array(accounts, username);
		int j =0;
		while(c == null && j<3)
		{
			System.out.println("Account does not exist!!");
			System.out.println("Enter username");
			username = con.readLine();
			c = this.trav_array(accounts, username);
			j++;
		}
		if(j == 3 && c == null)
		{
			System.exit(0);
		}
		String password;
		int i =0;
		while(i<3)
		{
			System.out.println("Enter password or enter 0 to get OTP");
			char[] p;
			p = con.readPassword();
			password = String.valueOf(p);
			if(c.getPassword().equals(password)) return c;
			else if(i>=1 && password.equals("0"))
			{
				OTP otp = new OTP();
				if(otp.verify(c.getPhone(),c.getEmail())) return c;
				System.out.println("Wrong OTP");
			}
			else
			{
				System.out.println("Wrong password");
			}
			i++;
		}
		System.exit(0);
		return null;
	}
	public Account signup()
	{
		System.out.println("Enter your preferred username");
		username = con.readLine();
		Account a = this.trav_array(accounts, username);
		if(a == null)
		{
			a = new Account(username);
			return a;
		}
		int j =0;
		while(a != null && j<3)
		{
			System.out.println("Account already exists!!");
			System.out.println("Enter your preferred username");
			username = con.readLine();
			a = this.trav_array(accounts, username);
			j++;
		}
		if(j == 3 && a != null)
		{
			System.exit(0);
			return null;
		}
		else
		{
			a = new Account(username);
			OTP otp = new OTP();
			boolean v = otp.verify(a.getPhone(),a.getEmail());
			if(v)
			{
				accounts.add(a);
			}
			int k = 0;
			while(!v & k<3)
			{
				System.out.println("Wrong OTP");
				otp = new OTP();
				v = otp.verify(a.getPhone(),a.getEmail());
				if(v)
				{
					accounts.add(a);
					return a;
				}
			}
			System.exit(0);
			return a;
		}
	}
	Account trav_array(List<Account> accounts, String username) {
		for(int i = 0; i < accounts.size();i++)
		{
			if(accounts.get(i).getUsername().equals(username) ) {
				return accounts.get(i);
			}
		}
		return null;
	}
}//hello
