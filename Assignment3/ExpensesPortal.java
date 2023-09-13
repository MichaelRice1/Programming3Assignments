//author - Michael Rice - 20347541

//necessary imports
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;


//expenses portal class,keeps a list of all expenses,can submit new expenses here also
public class ExpensesPortal {
	
	//array list of type expense to hold all expenses
	public static ArrayList<Expense> expenses = new ArrayList<Expense>();

	//main method for testing functionality and running code blocks
	public static void main(String[] args)
	{
		//new expenses portal object
		ExpensesPortal ep = new ExpensesPortal();
		//instantiating multiple expense objects
		Expense exp = new Expense(LocalDate.parse("2022-09-13"),"desc1",Money.parse("EUR 20.00"),Expense.Category.ENTERTAINMENT);
		Expense exp2 = new Expense(LocalDate.parse("2022-09-14"),"desc2",Money.parse("USD 30.00"),Expense.Category.SUPPLIES);
		Expense exp3 = new Expense(LocalDate.parse("2022-09-15"),"desc3",Money.parse("USD 40.00"),Expense.Category.TRAVELANDSUBSISTENCE);
		Expense exp4 = new Expense(LocalDate.parse("2022-09-16"),"desc4",Money.parse("USD 50.00"),Expense.Category.OTHER);
		Expense exp5 = new Expense(LocalDate.parse("2022-09-17"),"desc5",Money.parse("USD 60.00"),Expense.Category.EQUIPTMENT);
		//adding all the expenses to the expenses portal objects instance of the expenses array list
		ep.addExpenses(exp,exp2,exp3,exp4,exp5);
		
		//using lambda expressions to print a basic list of the expenses in the inputted array list
		ExpensePrinter basicList = (s) -> s.stream().forEach(e -> System.out.println(e.toString()));
		System.out.println("Basic List - method one");
		ep.printExpenses(basicList);
		System.out.println();
		
		//Using a printerbylabel object as a parameter to call the printExpenses method, which overrides the print method and 
		//prints another output, this time ordering the expenses by category before printing
		PrinterByLabel pbl = new PrinterByLabel();
		System.out.println("Ordered List - method two");
		ep.printExpenses(pbl);
		
		//uses anonymous innner class to create a new instance of the expense printer class and provide a new implementation
		//of the print method,again which overrides the default one
		//this time the print method returns the amount of expenses and the total value
		System.out.println();
		System.out.println("Number of values and sum - method three");
		ep.printExpenses(new ExpensePrinter()
		{
			@Override
			public void print(ArrayList<Expense> list) {
				sumExp(list);
			}
		});
	}
	
	//method with variable argument for inputting numerous expenses at a time
	public void addExpenses(Expense... args)
	{
		for(Expense exp : args)
		{
			expenses.add(exp);
		}
	}
	
	//print expenses method taking an expenseprinter instance as an argument
	//prints the output of expenses in the specified manner
	public void printExpenses(ExpensePrinter printer)
	{
		printer.print(this.expenses);
	}
	
	//static method to sum the values of the expense objects
	//converts from USD to EUR if necessary
	public static void sumExp(ArrayList<Expense> expenses)
	{
		//currency units for comparison
		CurrencyUnit eur = CurrencyUnit.of("EUR");
		CurrencyUnit usd = CurrencyUnit.of("USD");
		//empty money object to hold the sum of the values
		Money sum = Money.parse("EUR 0.00");
		
		//loop to loop over the expenses array list, retrieving the money value of each expense
		for(Expense exp : expenses){
			Money money = exp.getMoney();
			//if the currency unit is USD, it converts it into eur and adds it to the sum
			if(money.getCurrencyUnit() == usd){
				BigDecimal conversionRate = new BigDecimal("1.02");
				Money moneyEUR = money.convertedTo(eur, conversionRate, RoundingMode.HALF_UP);
				sum = sum.plus(moneyEUR);
			}
			//if the currency unit is eur, the value is just added to the sum
			else if (money.getCurrencyUnit() == eur){
				sum = sum.plus(money);
			}
			//if the currency unit is not eur or usd an error message is written to screen
			else{
				System.out.println("The currency value is not valid");
			}
		}
		//the final formatted string is printed to the console with the size of the expenses array list and the final sum value
		System.out.printf("There are %d expenses in the system totalling to a value of %s.\n",expenses.size(),sum);
	}
}
