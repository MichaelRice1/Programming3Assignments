//author - Michael Rice - 20347541

import java.util.ArrayList;

//Forum class
public class Forum {
	
	static ArrayList<User> users = new ArrayList<User>();
	static ArrayList<ForumPost> posts = new ArrayList<ForumPost>();
	
	//constructor
	public Forum()
	{
		
	}
	
	//nested class, type User
	public class User
	{
		//necessary variables
		private int ID;
		private String username;
		
		//user constructor, takes int and username as arguments
		public User(int ID, String username) 
		{
			this.ID = ID;
			this.username = username;
		}
		
		//getter methods
		public int getID()
		{
			return this.ID;
		}
		
		public String getUsername()
		{
			return this.username;
		}
	}

	//methods to delete a user by their ID number, throws an exception if a user with the ID does not exist
	public void deleteUser(int ID) throws NonExistentUserException{
		
		int size1 = users.size();//size of arraylist at beginning
		
		//removes user with desired ID number if exists
		for(int i=0;i<users.size();i++)
		{
			int id2 = users.get(i).getID();
			if(id2 == ID)
			{
				users.remove(i);
			}
		}
		int size2 = users.size();//size of array list after operations
		//if the size of the array list before the operation is the same as after,
		//the user does not exist and therefore an exception is thrown
		if(size1 == size2)
		{
		throw new NonExistentUserException("This user does not exist.");
		}
	}

	//method to add a user to the forum, throws an exception if the ID of the inputted user already exists in the forum
	public void addUser(User user) throws NonUniqueIDException {
		
		int j = 0;//variable for keeping track of elements in array list with unique ID 
		
		//for each loop to go through each user in users
		for(User target : users){
			if(user.getID() == target.getID()){
				throw new NonUniqueIDException("The ID entered already exists in the forum.");//if the ID already exists an exception is thrown
			}
			else
			j++;//if not the j variable in incremented
		}
		if(j == users.size())
		users.add(user);//if the j variable is incremented for each user in the array list, the ID is unique and the user is added to the forum
	}
	
	//method to add a post to the forum, throws exception if the user associated with the post doesnt exist in the form
	public void addPost(ForumPost post) throws UnregisteredUserException{		
		
		int id = post.getUserID();//gets ID of the inputted post
		int j =0;//incrementing variable
		
		for(User user : users)//for each loop to go through each user in array list
		{
			int id2 = user.getID();//gets id of each user in array list
			
			if(id != id2)
			{
				j++;
			}
			else
			{
				this.posts.add(post);
			}
		}
		if(j == users.size())//if the incremented variable is equal to the size of the users array list a new exception is thrown
		{
			throw new UnregisteredUserException("The user entered in the post is not registered on the forum.");
		}
	}
}
