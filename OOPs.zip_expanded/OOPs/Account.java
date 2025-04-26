package OOPs;

import java.io.Console;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import OOPs.transactions.*;


public class Account
{ 
	Console con = System.console();
	private String username;
	private long phone;
	private String email;
	private String password;
	protected int savings;
	public int IncomeNo;
	public int ExpenditureNo;
	boolean type; //tells whether account is savings or business account savings=0 and business=1
	private List<Income> incomes = new ArrayList<>();
	protected List<Expenditure> expenses = new ArrayList<>();
	private long balance;
	
	private int budget;
	public String budgetType;
	public LocalDate lastLoginDate;
	public Account()
	{
		username = new String();
		email = new String();
		password = new String();
		IncomeNo = 0;
		ExpenditureNo = 0;
		setBalance(0);
		lastLoginDate = LocalDate.now(); // or null if uninitialized
		this.setBudget(0);
		this.budgetType = "monthly";
	}
	public Account(String username)
	{
		IncomeNo = 0;
		ExpenditureNo = 0;
		System.out.println("Enter your phone: ");
		String p;
		while (true) {
		    p = con.readLine();
		    try {
		        this.phone = Long.parseLong(p);
		        break; // Exit the loop if parsing is successful
		    } catch (NumberFormatException e) {
		        System.out.println("Invalid mobile number entered.\nPlease enter a valid mobile number.");
		    }
		}
		//convert input
		System.out.println("Enter your email: ");
		this.email = con.readLine();
		System.out.println("Enter your password: ");
		char[] pass;
		pass = con.readPassword();
		this.password = String.valueOf(pass);
		System.out.println("Enter your current Balance: ");
		String b;
		//convert input
		while (true) {
		   
		    b = con.readLine();
		    try {
		        this.phone = Long.parseLong(b);
		        break; // Exit the loop if parsing is successful
		    } catch (NumberFormatException e) {
		        System.out.println("Invalid balance entered.\nPlease enter a valid balance");
		    }
		}
	}
	public String getUsername()
	{
		return this.username;
	}
	public String getPassword()
	{
		return this.password;
	}
	public boolean getType(){
		return this.type;
	}
	public String getEmail() {
		return email;
	}
	public long getPhone() {
		return phone;
	}
	public List<Income> getIncomes() {
		return incomes;
	}
	public List<Expenditure> getExpenses() {
		return expenses;
	}
	public int getBudget() {
		return budget;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}


	/*public void addIncome(String username, float value, String type) {
        Income newIncome = new Income(username, value, type);
        incomes.add(newIncome);
        balance += value; // Increase balance
        IncomeNo++;
        System.out.println("Income added: " + username + " | Amount: " + value);
    }

    // Method to Add Expenditure
    void addExpenditure(String username, float value, String type) {
        Expenditure newExpense = new Expenditure(username, value, type);
        expenses.add(newExpense);
        balance -= value; // Decrease balance
        ExpenditureNo++;
        System.out.println("Expenditure added: " + username + " | Amount: " + value);
    }*/
}
