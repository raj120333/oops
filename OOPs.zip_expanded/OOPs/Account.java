package OOPs;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import OOPs.options.*;
import OOPs.transactions.*;


public class Account
{ 
	private String username;
	private long phone;
	private String email;
	private String password;
	protected int savings;
	protected int IncomeNo;
	protected int ExpenditureNo;
	boolean type; //tells whether account is savings or business account savings=0 and business=1
	protected List<Income> incomes = new ArrayList<>();
	protected List<Expenditure> expenses = new ArrayList<>();
	protected long balance;
	
	protected int budget;
	protected String budgetType;
	protected LocalDate lastLoginDate;
	public Account()
	{
		username = new String();
		email = new String();
		password = new String();
		IncomeNo = 0;
		ExpenditureNo = 0;
		balance = 0;
		lastLoginDate = LocalDate.now(); // or null if uninitialized
		this.budget = 0;
		this.budgetType = "Monthly";
	}
	public Account(String username)
	{
		IncomeNo = 0;
		ExpenditureNo = 0;
		System.out.println("Enter your phone: ");
		//take input
		System.out.println("Enter your email: ");
		//take input
		System.out.println("Enter your password: ");
		//take input
		System.out.println("Enter your current Balance: ");
		//take input
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
