import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 
 * @author Michael Rice
 *  - Tests class, implements the code from the UserAccount class
 *  - has a UserAccount instance, and two lists for UserAccounts and Workspaces
 */
public class Tests {
	
	static UserAccount ua = new UserAccount();
    static List<UserAccount> uAcc = ua.loadUsers();

	/**
	 * @param args
	 *  - main method for running all of the tests.
	 *  - attributes are two lists for holding UserAccount objects, for use in the sorting part of the tests.
	 *  - first the original list of UserAccounts are sorted in their natural order( by email ).
	 *  - secondly, the list is sorted by ID number using an anonymous inner class with Comparator.
	 *  - thirdly, the list is sorted by name in descending order using a lambda expression.
	 *  - fourthly, we search the list using the binarySearch method for a cerain UserAccount object.
	 *  - finally, we use a HashMap to link the workspaces class and instances, to UserAccount instances.
	 */
	public static void main(String[] args)
	{
	    List<UserAccount> newList = new ArrayList<UserAccount>(uAcc);
	    List<UserAccount> newList2 = new ArrayList<UserAccount>(uAcc);

		Collections.sort(uAcc);
		System.out.println("Sorted in Natural order(by email): \n");
		for(UserAccount ua : uAcc)
		{
			System.out.println(ua.toString());
		}
		System.out.println("\n\n");
		
		
		
		Collections.sort(uAcc, new Comparator<UserAccount>() {
		      public int compare(UserAccount p1, UserAccount p2) {
		        return p1.getUserID().compareTo(p2.getUserID());
		      }
		    });
	    System.out.println("Sorted by ID Number:\n");
	    for(UserAccount ua : uAcc)
		{
			System.out.println(ua.toString());
		}
		System.out.println("\n\n");
		
	    
	    
	    Collections.sort(uAcc, (UserAccount a1, UserAccount a2) ->
	    a2.getName().compareTo(a1.getName()));
	    System.out.println("Sorted by descending names:\n");
	    for(UserAccount ua : uAcc)
		{
			System.out.println(ua.toString());
		}
		System.out.println("\n \n");
	    
	    
	    
	    
	   
	    UserAccount test = new UserAccount(73456368674L,"Eden Hazard","e.hazard17@gmail.bel");
	    Collections.sort(newList);
	    searchList(newList,test);
        System.out.println("\nList contents after search\n");
        for(UserAccount ua : newList)
		{
			System.out.println(ua.toString());
		}
		System.out.println("\n\n");

	    
        Map<UserAccount, List<Workspace>> workspaces = new HashMap<UserAccount, List<Workspace>>();
    	    List<Workspace> workspacesList = new ArrayList<>();
	    	Workspace ws = new Workspace("HPE","Offices");
	    	workspacesList.add(ws);
	    	ws.addCollaborator(newList2.get(4));
	    	ws.addCollaborator(newList2.get(7));
	    	UserAccount key = newList2.get(0);
	    	workspaces.put(key, workspacesList);
	    	List<Workspace> finalWrkSpaces = workspaces.get(key);
	    	System.out.println("The workspaces associated with the UserAccount at index 0 are : ");
		    System.out.println(finalWrkSpaces);
	}	
	
	
	/**
	 * - SearchList method, implements the binarySearch method to search a list of type UserAccount for an instance of UserAccount
	 * @param l - list of type UserAccount
	 * @param key - instance of class UserAccount
	 * @return - the position of the instance, if it is already in the list, and returns the position if the instance is newly added
	 * to the list
	 */
	private static int searchList(List<UserAccount> l, UserAccount key) {
	    int pos = Collections.binarySearch(l, key);
	    if (pos >= 0) {
	      System.out.println(key + " already in the list in position " + pos);
	      return pos;
	    }
	    else {
	      l.add(-pos-1, key);
	      System.out.println(key + " not found in the list, added to position " + (-pos-1));
	      return pos;
	    }
	  }
		
	}

