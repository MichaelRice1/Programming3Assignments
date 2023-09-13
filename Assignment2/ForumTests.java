//author - Michael Rice - 20347541

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.desktop.UserSessionEvent;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

//testing class
public class ForumTests {
	
	@Test//test to register a valid user on a forum, true if size of users array list is not 0
	void registerValidUser()
	{
		Forum forum = new Forum();
		Forum.User user = forum.new User(20347541,"MichaelRice");
		forum.users.add(user);
		assertTrue(forum.users.size() != 0);
	}
	
	@Test//test to see if users with the same ID can be registered together, passes if NonUniqueIDException is thrown
	void sameIDNumberTest()
	{
		Forum forum = new Forum();
		Forum.User user2 = forum.new User(20347541,"HarryPotter");
		try {
			forum.addUser(user2);
		} catch (NonUniqueIDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Forum.User user = forum.new User(20347541,"MichaelRice");
		assertThrows(NonUniqueIDException.class, () -> {
			forum.addUser(user);
		});
		}
	
	
	@Test//test to be able to delete a user from the forum using their ID number, passes if the array list size returns back to 0 after user is deleted
	void deleteWithID()
	{
		Forum forum = new Forum();
		Forum.User user = forum.new User(20347541,"MichaelRice");
		try {
			forum.addUser(user);
			try {
				forum.deleteUser(20347541);
			} catch (NonExistentUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NonUniqueIDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(forum.users.size() == 0);
		
	}
	
	@Test//testing if correct exception thrown if a non existent user is being deleted
	void deleteNonExistentUser()
	{
		Forum forum = new Forum();
				
		assertThrows(NonExistentUserException.class, () -> {
			forum.deleteUser(11111111);
		});
	}	
	
	
	@Test//testing if adding a post to a forum works, passes if the size of the posts array list is not 0
	void addForumPost()
	{
		Forum forum = new Forum();
		Forum.User user = forum.new User(20347541,"ricemi");
		try {
			forum.addUser(user);
		} catch (NonUniqueIDException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ForumPost post = new ForumPost("title", "text",20347541);
		try {
			forum.addPost(post);
			System.out.println(forum.posts);
			} catch (UnregisteredUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(forum.posts.size() != 0);
	}
		
	
	
	@Test//tests if a post can be created with a user that is not registered on the forum, passes if the correct exception is thrown
	void postWithInvalidUserID()
	{
		Forum forum = new Forum();
		ForumPost post = new ForumPost("title","text",11111111);
		assertThrows(UnregisteredUserException.class, () -> {
			forum.addPost(post);
		});		
	}
 
}
