//author - Michael Rice - 20347541

//imports
import java.util.Scanner;

//forum app class, console based 
public class ForumApp
{
	//variables and class objects
	Forum forum = new Forum();
	Scanner scan = new Scanner(System.in);
	static int read;
	
	//main method, used to test class
	public static void main(String[] args)
	{
		Forum forum = new Forum();
		Forum.User user = forum.new User(20347541, "ricemi");
		try {
			forum.addUser(user);
		} catch (NonUniqueIDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ForumApp fa = new ForumApp(forum);
	}
	
	//forum app constructor, takes a forum object as an argument
	public ForumApp(Forum forum)
	{
		this.forum = forum;
		System.out.println("Enter 1 to register a user, 2 to delete a user, or 3 to make a post:");
		read = scan.nextInt();
		
		Options choice = Options.numToEnum();//method to convert scanned input to enum Option
		
		switch(choice)
		{
		//if the enum option is ONE, execute the necessary code to add a user
		case ONE:
			System.out.println("Please enter the ID number of the user you wish to enter : ");
			int id = scan.nextInt();
			System.out.println("Please enter the username of the user you wish to enter : ");
			String username = scan.next();
			Forum.User user = forum.new User(id, username);
			try {
				forum.addUser(user);
				System.out.printf("The user %s has been added to the forum", username);
			} catch (NonUniqueIDException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		break;
		//if the enum option is TWO, execute the necessary code to delete a user
		case TWO:
			System.out.println("Please enter the ID Number of the user you wish to delete : ");
			int del = scan.nextInt();
			try {
				forum.deleteUser(del);
				System.out.println("The user has been deleted.");
			} catch (NonExistentUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		//if the enum option is THREE, execute the necessary code to add a post
		case THREE:
    		System.out.println("Please enter the title of the post : ");
    		String title = scan.next();
    		System.out.println("Please enter the text of the post : ");
    		String text = scan.next();
    		System.out.println("Please enter the ID of the user to be associated with this post : ");
    		int assoc = scan.nextInt();
    		ForumPost post = new ForumPost(title,text,assoc);
    		try {
				forum.addPost(post);
				System.out.println(forum.posts);
			} catch (UnregisteredUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		break;
		}
	}
	
	//enum options, contains method to convert scanned input to option
	enum Options
	{
		ONE,TWO,THREE;//enum options
		
		//converts from scanned input to one of the enum options and returns the choice
		public static Options numToEnum()
		{
			Options choice = null;
			int input = read; 
			if(input == 1)
			{
				choice = ONE;
			}
			else if(input == 2)
			{
				choice = TWO;
			}
			else if (input == 3)
			{
				choice = THREE;
			}
			else
			{
				System.out.println("The inputted value was incorrect.");
			}
			
			return choice;
		}
	}
}

