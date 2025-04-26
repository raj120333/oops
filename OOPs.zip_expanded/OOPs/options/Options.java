package OOPs.options;

import java.time.LocalDate;

import OOPs.*;

import OOPs.transactions.*;
import java.io.*;
public class Options{
	Console con = System.console();
	Account a;
	public Options(Account a)
	{
		this.a = a;
		updation();
		display();
		System.out.println("Your budget is "+a.budgetType);
		int i = 0;
		while (true) {
			String t;
			System.out.println("Choose:/n 1.Income /n 2.Expenditure /n 3.Budget /n 4.Savings/n Enter 0 to exit");
		    t = con.readLine();
		    try {
		        i = Integer.parseInt(t);
		        break; // Exit the loop if parsing is successful
		    } catch (NumberFormatException e) {
		        System.out.println("Choose a valid option: ");
		    }
		}
		switch(i)
		{
		case 0:
			System.exit(0);
			break;
		case 1:
			IncomeOption o = new IncomeOption();
			break;
		case 2:
			ExpenditureOption p = new ExpenditureOption();
			break;
		case 3:
			Budget b = new Budget();
			break;
		case 4:
			Savings s = new Savings();
			break;
		default:
			Options O = new Options(a);
		}
	}
	public class IncomeOption implements option
	{
		IncomeOption()
		{
			for(int i = 0;i<a.getIncomes().size();i++)
			{
				System.out.println((i+1)+". "+this.toString(a.getIncomes().get(i)));
			}
			int i;
			while (true) {
				System.out.println("Press 0 to add an income, Press the nth income to edit it, Press any other key to go to options");
			    String t = con.readLine();
			    try {
			        i = Integer.parseInt(t);
			        break; // Exit the loop if parsing is successful
			    } catch (NumberFormatException e) {
			        System.out.println("Choose a valid option: ");
			    }
			}
			if(i==0)
			{
				add();
			}
			else if(1<=i && i<=a.getIncomes().size()+1)
			{
				int j;
				while (true) {
					System.out.println("Do you want to edit or delete the income? Press 1 to edit and 0 to delete and any other key to go to options");
				    String k = con.readLine();
				    try {
				        j = Integer.parseInt(k);
				        break; // Exit the loop if parsing is successful
				    } catch (NumberFormatException e) {
				        System.out.println("Choose a valid option: ");
				    }
				}
				if(j==1) {
				String username;
				float value;
				String type;
				System.out.println("Enter income name: ");
				username = con.readLine();
				
				while (true) {
					System.out.println("Enter how much income: ");
				    String s = con.readLine();
				    try {
				        value = Float.parseFloat(s);
				        break; // Exit the loop if parsing is successful
				    } catch (NumberFormatException e) {
				        System.out.println("Choose a valid income: ");
				    }
				}
				int l;
				while (true) {
					System.out.println("Enter the type of income default: monthly; Type: \n1. one-time \n2. quarterly \n3.annually");
				    String s = con.readLine();
				    try {
				        l = Integer.parseInt(s);
				        break; // Exit the loop if parsing is successful
				    } catch (NumberFormatException e) {
				        System.out.println("Choose a valid option: ");
				    }
				}
				switch(l)
				{
				case 1:
					type = "one-time";
					break;
				case 2:
					type = "quarterly";
					break;
				case 3:
					type = "annually";
					break;
				default:
					type = "monthly";
				}
				a.getIncomes().set(i-1, new Income(username, value, type));
				IncomeOption o = new IncomeOption();
				}
				else if(j==0)
				{
					delete(i);
					display();
					IncomeOption o = new IncomeOption();
				}
				else
				{
					display();
					Options o = new Options(a);
				}
			}
			else
			{
				display();
				Options o = new Options(a);
			}
		}
		public void add()
		{
			Income I = new Income();
			a.getIncomes().add(I);
	        a.IncomeNo++;
	        System.out.println("Income added: " + I.username + " | Amount: " + I.value);
	        display();
	        IncomeOption o = new IncomeOption();
		}
		public String toString(Transaction t)
		{
			Income I = (Income) t;
			display();
			return ""+I.username+" : Rs."+I.value+" : "+ I.type;	
	    }
		public void delete(int i) 
		{
			a.getIncomes().remove(i-1);
			a.IncomeNo--;
			display();
			IncomeOption o = new IncomeOption(); 
		}  
	}
	public class ExpenditureOption implements option
	{
		ExpenditureOption()
		{
			for(int i = 0;i<a.getExpenses().size();i++)
			{
				System.out.println((i+1)+". "+this.toString(a.getExpenses().get(i)));
			}
			System.out.println("Press 0 to add an expense, Press the nth expense to edit it, Press any other key to go to options");
			int i;
			String t = con.readLine();
			while (true) {
			    t = con.readLine();
			    try {
			        i = Integer.parseInt(t);
			        break; // Exit the loop if parsing is successful
			    } catch (NumberFormatException e) {
			        System.out.println("Choose a valid option: ");
			    }
			}
			if(i==0)
			{
				add();
			}
			else if(1<=i && i<=a.getExpenses().size()+1)
			{
				String username;
				float value;
				String type;
				System.out.println("Enter expense name: ");
				username = con.readLine();
				System.out.println("Enter how much expense: ");
				String s;
				while (true) {
				    s = con.readLine();
				    try {
				        value = Float.parseFloat(s);
				        break; // Exit the loop if parsing is successful
				    } catch (NumberFormatException e) {
				        System.out.println("Enter a valid number: ");
				    }
				}
				System.out.println("Enter the type of expense default: monthly; Type: \n1. one-time \n2. quarterly \n3.annually");
				int l;
				while (true) {
				    s = con.readLine();
				    try {
				        l = Integer.parseInt(s);
				        break; // Exit the loop if parsing is successful
				    } catch (NumberFormatException e) {
				        System.out.println("Choose a valid option: ");
				    }
				}
				switch(l)
				{
				case 1:
					type = "one-time";
					break;
				case 2:
					type = "quarterly";
					break;
				case 3:
					type = "annually";
					break;
				default:
					type = "monthly";
				}
				a.getExpenses().set(i-1, new Expenditure(username, value, type));
				display();
				ExpenditureOption o = new ExpenditureOption();
			}
			else
			{
				display();
				Options o = new Options(a);
			}
		}
		public void add()
		{			Expenditure E = new Expenditure();
			a.getExpenses().add(E);
	        a.ExpenditureNo++;
	        System.out.println("Expense added: " + E.username + " | Amount: " + E.value);
	        display();
	        ExpenditureOption o = new ExpenditureOption();
		}

		public String toString(Transaction t) 
		{
			Expenditure I = (Expenditure) t;
			return ""+I.username+" : Rs."+I.value+" : "+ I.type;
		}
		
		public void delete(int i)
		{
			a.getExpenses().remove(i-1);
			a.ExpenditureNo--;
			display();
			ExpenditureOption o = new ExpenditureOption();
		}
	}
	public class Budget
	{
		Budget()
		{
			System.out.println(this.toString());
			int i;
			while (true) {
				System.out.println("Type 0 to edit the Budget and anything else to go back to options menu");
			    String t = con.readLine();
			    try {
			        i = Integer.parseInt(t);
			        break; // Exit the loop if parsing is successful
			    } catch (NumberFormatException e) {
			        System.out.println("Choose a valid option: ");
			    }
			}
			if(i==0)
			{
				System.out.println("Enter new budget");
				String s = con.readLine();
				a.setBudget(Integer.parseInt(s));
				System.out.println(this.toString());
			}
			else
			{
				display();
				Options o = new Options(a);
			}
		}
        public String toString() 
        {
        	int totInc = 0,totExpen = 0;
        	for(Income i:a.getIncomes())
        	{
        		if(i.type.equals("monthly")) totInc += i.value;
        		else if(i.type.equals("annually")) totInc += i.value/12;
        		else if(i.type.equals("quartely")) totInc += i.value/3;
        	}
        	for(Expenditure e:a.getExpenses())
        	{
        		if(e.type.equals("monthly")) totExpen += e.value;
        		else if(e.type.equals("annually")) totExpen += e.value/12;
        		else if(e.type.equals("quartely")) totExpen += e.value/3;
        	}
        	String s2;
        	s2 = "Budget: "+ a.getBudget()+"; Budget Type: "+ a.budgetType;
        	String s1;
        	if(totInc<a.getBudget())
        	{
        		s1 = "/nYour budget exceeds your income this month by "+(a.getBudget()-totInc);
        	}
        	else if(totExpen>a.getBudget())
        	{
        		s1 = "/nYour expenditure exceeds your budget this month by "+(totExpen - a.getBudget());
        	}
        	else if(totExpen==totInc)
        	{
        		s1 = "/nYour income and expenditure match, consider saving you money";
        	}
        	else
        	{
        		s1 = "You are within your budget";
        	}
			return s2 + s1;			
		}
	}
	public class Savings
	{
		int totInc = 0,totExpen = 0;
		Savings()
		{
			for(Income i:a.getIncomes())
        	{
        		if(i.type.equals("monthly")) totInc += i.value;
        		else if(i.type.equals("annually")) totInc += i.value/12;
        		else if(i.type.equals("quartely")) totInc += i.value/3;
        	}
        	for(Expenditure e:a.getExpenses())
        	{
        		if(e.type.equals("monthly")) totExpen += e.value;
        		else if(e.type.equals("annually")) totExpen += e.value/12;
        		else if(e.type.equals("quartely")) totExpen += e.value/3;
        	}
        	toString();
        	display();
        	Options o = new Options(a);
		}	
		public String toString()
		{		
        	String s1;
        	if(totInc>totExpen)
        	{
        		s1 = "You are saving "+(totInc - totExpen)+" this month";
        	}
        	else if(totExpen>totInc)
        	{
        		s1 = "You will be in debt of "+(totExpen - totInc)+ " this month";
        	}
        	else
        	{
        		s1 = "Your income and expenditure match, consider saving you money";
        	}
			return "\n"+s1;
		}
		
	}
	public void updation() {
		LocalDate currentLoginDate = LocalDate.now();
	    if (a.lastLoginDate == null) {
	        a.lastLoginDate = currentLoginDate;
	        return;
	    }

	    int yearDiff = currentLoginDate.getYear() - a.lastLoginDate.getYear();
	    int monthDiff = currentLoginDate.getMonthValue() - a.lastLoginDate.getMonthValue();
	    int totalMonths = yearDiff * 12 + monthDiff;

	    int totalYears = totalMonths / 12;
	    int totalQuarters = totalMonths / 3;

	    for (Income income : a.getIncomes()) {
	        if (income.type.equals("monthly")) 
	        {
	            a.setBalance(a.getBalance() + (long)income.value * totalMonths);
	        } 
	        else if (income.type.equals("quarterly")) 
	        {
	            a.setBalance(a.getBalance() + (long)income.value * totalQuarters);
	        } 
	        else if (income.type.equals("annually")) 
	        {
	           a.setBalance(a.getBalance() + (long)income.value * totalYears);
	        }
	    }

	    for (Expenditure expense : a.getExpenses()) {
	        if (expense.type.equals("monthly")) 
	        {
	        	a.setBalance(a.getBalance() - (long)expense.value * totalMonths);
	        } 
	        else if (expense.type.equals("quarterly")) 
	        {
	        	a.setBalance(a.getBalance() - (long)expense.value * totalQuarters);
	        } 
	        else if (expense.type.equals("annually")) 
	        {
	        	a.setBalance(a.getBalance() - (long)expense.value * totalYears);
	        }
	    }

	    a.lastLoginDate = currentLoginDate;
	}
	
	public void display()
	{
		System.out.println("Your balance is: "+a.getBalance());	
		int totInc = 0,totExpen = 0;
    	for(Income i:a.getIncomes())
    	{
    		if(i.type.equals("monthly")) totInc += i.value;
    		else if(i.type.equals("annually")) totInc += i.value/12;
    		else if(i.type.equals("quartely")) totInc += i.value/3;
    	}
    	for(Expenditure e:a.getExpenses())
    	{
    		if(e.type.equals("monthly")) totExpen += e.value;
    		else if(e.type.equals("annually")) totExpen += e.value/12;
    		else if(e.type.equals("quartely")) totExpen += e.value/3;
    	}
    	System.out.println("Your net income is: "+totInc);
    	System.out.println("Your net expenditure is: "+totExpen);
	}
}
