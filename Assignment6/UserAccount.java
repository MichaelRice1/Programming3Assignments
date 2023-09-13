/**
 * imports
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * 
 * @author Michael Rice
 *  - UserAccount class , implements the Comparable interface with the type UserAccount
 *  - has many attributes
 *  - Long userID, String name, String email address, bufferedReader bRead, String line and a list for the User accounts from the csv
 *
 */
public class UserAccount implements Comparable<UserAccount>{
	
	private Long userID;
	private String name;
	private String emailAddress;
	BufferedReader bRead;
	String line;
	static List<UserAccount> acc = new ArrayList<>();
	
	
	/**
	 *  - UserAccount constructor with no parameters
	 */
	public UserAccount()
	{
		
	}
	
	/**
	 *  - constructor that takes in the required variables
	 * @param userID - UserAccount id number variable
	 * @param name - UserAccount name variable 
	 * @param emailAddress - UserAccount emailAddress variable
	 */
	public UserAccount(long userID,String name,String emailAddress)
	{
		this.userID = userID;
		this.name = name;
		this.emailAddress = emailAddress;
	}
	
	/**
	 * @param o - An object o to be compared to the current object
	 * this particular class compares based on the userID of the objects
	 * @return true if the IDs are equals, false if they aren't 
	 */
	public boolean equals(Object o)
	{
		if(this == o)
			return true;
		if(o == null)
			return false;
		if(getClass() != o.getClass())
			return false;
		
		UserAccount ua = (UserAccount) o;
		
		return userID.equals(ua.getUserID());
	}
	
	
	/**
	 * 
	 *  - opens up  bufferedReader and FileReader streams and while the next line is not null, read a line in from csv file
	 *  - uses a comma as a delimiter when the tokens are scanned in
	 *  - scans in ID,name and email from the csv, creates a UserAccount object and adds it to the List of type User Account
	 *  - closes the stream
	 * @return - The List of type User Account
	 */
	public List<UserAccount> loadUsers()
	{
		 try {
			bRead = new BufferedReader(new FileReader("users.csv"));
			while((line = bRead.readLine()) != null )
			{	
				Scanner scan = new Scanner(line);
				scan.useDelimiter(",");
				
				while(scan.hasNext())
				{
					long ID = scan.nextLong();
					String name = scan.next();
					String email = scan.next();
					UserAccount ua1 = new UserAccount(ID,name,email);
					acc.add(ua1);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		 {
			try {
				bRead.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 return acc;
	}
	
	@Override
	/**
	 * @return - int representing the hashCode of an object
	 */
	public int hashCode()
	{
		int prime = 31;
		int result = 1;
		
		result = prime*result + ((this.userID == null) ? 0 : this.userID.hashCode());
		return result;
	}
	
	@Override
    /**
     * @return - Formatted String, representing the string representation of a UserAccount object
     */
	public String toString()
	{
		return String.format("%d,%s,%s",this.getUserID(),this.getName(),this.getEmailAddress());
	}
	
	/** 
	 * @return Long userID - gets the user ID of a UserAccount object
	 */
	public Long getUserID() {
		return userID;
	}
	
	/**
	 * @return String name - gets the name of a UserAccount object
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name - can set the name of a UserAccount object
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return String emailAddress - returns the emailAddress of a UserAccount object
	 */
	public String getEmailAddress() {
		return emailAddress;
	}
	
	/**
	 * @param emailAddress - sets the email address of a UserAccount object
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	/**
	 * - method to compare UserAccount objects by emailAddress
	 * @return int comp - returns 1 if the emailAddresses are equal,0 if not
	 */
	public int compareTo(UserAccount ua) {
		// TODO Auto-generated method stub
		
		int comp = emailAddress.compareTo(ua.getEmailAddress());
		return (comp);
	}

}
