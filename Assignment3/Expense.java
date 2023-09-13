//author - Michael Rice - 20347541

//all necessary imports
import java.time.LocalDate;
import org.joda.money.*;

//expense class
public class Expense {
	
	//Expense object argument storage variables
	private LocalDate date;
	private  String description;
	private  Money amount;
	private boolean approved = false;
	private Expense.Category cat;
	
	//enum to hold the categories of expenses
	enum Category
	{
		TRAVELANDSUBSISTENCE,SUPPLIES,ENTERTAINMENT,EQUIPTMENT,OTHER;
	}

	//constructor, takes a date,description,money object and category as parameters
	public Expense(LocalDate date,String description,Money amount,Category cat)
	{
		this.date = date;
		this.description = description;
		this.amount = amount;
		this.cat = cat;
	}
	
	//toString method that returns a formatted string in the desired format
	public String toString()
	{
		return String.format("%s" + "  -  " + "%s" + "  -  " + "%s" + " - " + "%s",date,description,amount,cat);
	}
	
	//method to approve an expense
	public void approveExpense()
	{
		this.approved = true;
	}
	
	//getter methods for the Expense argument variables
	public LocalDate getDate()
	{
		return this.date;
	}
	public String getDescription()
	{
		return this.description;
	}
	public Money getMoney()
	{
		return this.amount;
	}
	public boolean getApproved()
	{
		return this.approved;
	}
	public Expense.Category getCat()
	{
		return this.cat;
	}
}
