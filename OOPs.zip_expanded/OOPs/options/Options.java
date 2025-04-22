package OOPs.options;
import java.time.LocalDate;

import OOPs.*;

import OOPs.transactions.*;
public class Options extends Account{
	
	Options()
	{
		int i = 0;
		System.out.println("Choose:/n 1.Income /n 2.Expenditure /n 3.Budget /n 4.Savings/n Enter 0 to exit");
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
			Options O = new Options();
		}
	}
	public class IncomeOption implements option
	{
		
		IncomeOption()
		{
			for(int i = 0;i<incomes.size();i++)
			{
				System.out.println((i+1)+". "+this.toString(incomes.get(i)));
			}
			System.out.println("Press 0 to add an income, Press the nth income to edit it, Press any other key to go to options");
			int i =0;
			//Take Input
			if(i==0)
			{
				add();
			}
			else if(1<=i && i<=incomes.size()+1)
			{
				String username ="";
				float value =0;
				String type = "";
				System.out.println("Enter income name: ");
				//take input
				System.out.println("Enter how much income: ");
				//take input
				System.out.println("Enter the type of income i.e: one time, monthly, quarterly or annually: ");
				//take input
				incomes.set(i-1, new Income(username, value, type));
			}
			else
			{
				Options o = new Options();
			}
		}
		public void add()
		{
			Income I = new Income();
			incomes.add(I);
	        IncomeNo++;
	        System.out.println("Income added: " + I.username + " | Amount: " + I.value);
		}

		public void displayBalance()
		{
			
			
		}

		public String toString(Transaction t)
		{
			Income I = (Income) t;
			return ""+I.username+" : Rs."+I.value+" : "+ I.type;		
	    }  
	}
	public class ExpenditureOption implements option
	{
		ExpenditureOption()
		{
			for(int i = 0;i<expenses.size();i++)
			{
				System.out.println("\n"+this.toString(expenses.get(i)));
			}
			System.out.println("Press 0 to add an expense, Press the nth expense to edit it, Press any other key to go to options");
			int i =0;
			//Take Input
			if(i==0)
			{
				add();
			}
			else if(1<=i && i<=expenses.size()+1)
			{
				String username ="";
				float value =0;
				String type = "";
				System.out.println("Enter expense name: ");
				//take input
				System.out.println("Enter how much expense: ");
				//take input
				System.out.println("Enter the type of expense i.e: one time, monthly, quarterly or annually: ");
				//take input
				expenses.set(i-1, new Expenditure(username, value, type));
			}
			else
			{
				Options o = new Options();
			}
		}
		public void add()
		{
			
		}

		public void displayBalance()
		{
			
			
		}

		public String toString(Transaction t) 
		{
			Expenditure I = (Expenditure) t;
			return ""+I.username+" : Rs."+I.value+" : "+ I.type;
		}
		
	}
	public class Budget
	{
		Budget()
		{
			System.out.println(this.toString());
			System.out.println("Type 0 to edit the Budget and anything else to go back to options menu");
			String s = "";
			//take input
			if(s.equals("0"))
			{
				System.out.println("Enter new budget");
				//take input
				System.out.println("Enter period");
				//take input
				System.out.println(this.toString());
			}
			else
			{
				Options o = new Options();
			}
		}
        public String toString() 
        {
        	int totInc = 0,totExpen = 0;
        	for(Income i:incomes)
        	{
        		if(i.type.equals("monthly")) totInc += i.value;
        		else if(i.type.equals("annually")) totInc += i.value/12;
        		else if(i.type.equals("quartely")) totInc += i.value/3;
        	}
        	for(Expenditure e:expenses)
        	{
        		if(e.type.equals("monthly")) totExpen += e.value;
        		else if(e.type.equals("annually")) totExpen += e.value/12;
        		else if(e.type.equals("quartely")) totExpen += e.value/3;
        	}
        	String s1,s2;
        	s2 = "Budget: "+ budget+"; Budget Type: "+ budgetType;
        	if(totInc>totExpen)
        	{
        		s1 = "You are under-budget by "+(totInc - totExpen);
        	}
        	else if(totExpen>totInc)
        	{
        		s1 = "You are over-budget by "+(totExpen - totInc);
        	}
        	else
        	{
        		s1 = "Your income and expenditure match, consider saving you money";
        	}
			return s2+"\n"+s1;			
		}
	}
	public class Savings
	{
		Savings()
		{
			
		}	
		public String toString()
		{
			
			return null;
		}
		
	}
	public void updation() {
		LocalDate currentLoginDate = LocalDate.now();
	    if (lastLoginDate == null) {
	        lastLoginDate = currentLoginDate;
	        return;
	    }

	    int yearDiff = currentLoginDate.getYear() - lastLoginDate.getYear();
	    int monthDiff = currentLoginDate.getMonthValue() - lastLoginDate.getMonthValue();
	    int totalMonths = yearDiff * 12 + monthDiff;

	    int totalYears = totalMonths / 12;
	    int totalQuarters = totalMonths / 3;

	    for (Income income : incomes) {
	        if (income.type.equals("monthly")) 
	        {
	            balance += income.value * totalMonths;
	        } 
	        else if (income.type.equals("quarterly")) 
	        {
	            balance += income.value * totalQuarters;
	        } 
	        else if (income.type.equals("annually")) 
	        {
	            balance += income.value * totalYears;
	        }
	    }

	    for (Expenditure expense : expenses) {
	        if (expense.type.equals("monthly")) 
	        {
	            balance -= expense.value * totalMonths;
	        } 
	        else if (expense.type.equals("quarterly")) 
	        {
	            balance -= expense.value * totalQuarters;
	        } 
	        else if (expense.type.equals("annually")) 
	        {
	            balance -= expense.value * totalYears;
	        }
	    }

	    lastLoginDate = currentLoginDate;
	}
}
