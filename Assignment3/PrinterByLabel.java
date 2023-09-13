//author - Michael Rice - 20347541

//imports arraylist functionality
import java.util.ArrayList;
//printerbylabel class, implements the expense printer interface
public class PrinterByLabel implements ExpensePrinter {

	//array list of type Expense to hold the sorted array elements
	ArrayList<Expense> sorted = new ArrayList<Expense>();

	@Override
	//print method that prints the elements in the inputted arraylist back to the user but ordered by the expense category
	public void print(ArrayList<Expense> list) {
		
		for(Expense.Category c : Expense.Category.values())
		{
			for(Expense e : list)
			{
				if(e.getCat() == c)
				{
					sorted.add(e);
				}
			}
		}
		//loop to print the output of the sorted array list
		for(Expense exp : sorted)
		{
			System.out.println(exp.getCat());
			System.out.println(exp.toString());
		}
	}
}

	
	
	
	

