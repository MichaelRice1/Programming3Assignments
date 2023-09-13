import java.time.LocalDateTime;//all necessary imports
import java.util.Random;

public class ForumPosts {
	
	//necessary variables and object instantiations with required access modifiers and states
	private String postText,title;
	private static int postID;
	static User author = new User("Michael Rice");
	private static LocalDateTime timestamp;
	
	//first constructor, takes specific timestamp as an argument, throws exception if timestamp is in the past
	public ForumPosts(String title,String postText,LocalDateTime timestamp,User author) throws InvalidTimestampException
	{
		if(timestamp.isBefore(LocalDateTime.now()))
		{
			throw new InvalidTimestampException("The entered timestamp is in the past");//exception with error message
		}
		else
		{
			//sets variables to values inputted in construtor arguments
			this.title = title;
			this.postText = postText;
		    this.timestamp = timestamp;
		//generates random 4 digit int as post id 	
		Random rnd = new Random();
		postID = rnd.nextInt(10000);
		}
	}
	
	//second constructor, no specified timestamp therefore uses current time
	public ForumPosts(String title,String postText,User author)
	{
		//giving variables values 
		this.title = title;
		this.postText = postText;			
		this.timestamp = LocalDateTime.now();
		//random 4 digit post id
		Random rnd = new Random();
		postID = rnd.nextInt(10000);
		
	}
	
	//main method
	public static void main(String[] args)
	{
		
	}
	
	//toString method, returns string representation of ForumPost object
	public String toString()
	{
		// TODO Auto-generated method stub
		String str = "";
		str += "Timestamp : ";
		str += this.timestamp;
		str += "\n";
		str += "Title : ";
		str += this.title;
		str += "\n";
		str += "Post Text : ";
		str += this.postText;
		str += "\n";
		return str;		
	}
	
	//text getter method, returns postText of ForumPost object
	public String getText()
	{
		return this.postText;
	}

	//title getter method, returns title of ForumPost object
	public String getTitle()
	{
		return this.title;
	}
	
	//postID getter method, returns postID of ForumPost object
	public int getPostID()
	{
		return this.postID;
	}

	//returns string representation of timestamp of ForumPost object
	public String getTimestamp() {
		LocalDateTime ldt = this.timestamp;
		String str = ldt.toString();
		return str;
	}

	//edits the title of a given ForumPost object
	public void editTitle(String newTitle) {
		this.title = newTitle;
	}

	//edits the postText of a given ForumPost object
	public void editText(String newText) {
		this.postText = newText;
	}
	}

