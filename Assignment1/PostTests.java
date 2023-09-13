import static org.junit.jupiter.api.Assertions.assertThrows;//all necessary imports

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

//class using TDD to develop all necessary function of the ForumPosts class
public class PostTests {
	
	@Test//test to create a valid ForumPost obj with a specified timestamp
	void validPostCreationTestWithSpecifiedTimestamp()
	{
		try {
			ForumPosts post = new ForumPosts("title","text",LocalDateTime.of(2023,9,19,17,0) , ForumPosts.author);
		} catch (InvalidTimestampException exc) {
			exc.printStackTrace();
		}
	}
	
	@Test//test to create a valid ForumPost obj without a specified timestamp
	void validPostCreationTestWithoutTimestamp()
	{
		ForumPosts post = new ForumPosts("title","text",ForumPosts.author);
	}
	
	@Test//creating an invalid post with a timestamp in the past
	void PastPostCreationTest()
	{
		assertThrows(InvalidTimestampException.class, () -> {
			ForumPosts post = new ForumPosts("title","text",LocalDateTime.of(2018,9,18,17,43),ForumPosts.author);
		});
	}
	
	@Test//test to query for the title of a post
	void titleQuery()
	{
		try
		{
			ForumPosts post = new ForumPosts("title","text",LocalDateTime.of(2023,9,19,17,0) , ForumPosts.author);
			System.out.println(post.getTitle());
		}
		catch(InvalidTimestampException exc)
		{
			exc.printStackTrace();
		}
		
	}
	
	@Test//test to query for the text of a post
	void textQuery()
	{
		try {
			ForumPosts post = new ForumPosts("title","text",LocalDateTime.of(2023,9,19,17,0) , ForumPosts.author);
			System.out.println(post.getText());
		} catch (InvalidTimestampException exc) {
			exc.printStackTrace();
		}
	}
	
	@Test//test to query for the timestamp of a post
	void timestampQuery()
	{
		ForumPosts post = new ForumPosts("title","text", ForumPosts.author);
		post.getTimestamp();
	}
	
	@Test//test to edit the title of a post
	void editTitleTest()
	{
		ForumPosts post = new ForumPosts("title","text", ForumPosts.author);
		post.editTitle("new title");
	}
	
	@Test//test to edit the text of a post
	void editTextTest()
	{
		ForumPosts post = new ForumPosts("title","text", ForumPosts.author);
		post.editText("New Text");
	}
	
	@Test//test to create a valid ForumPost obj with a timestamp in the future
	void futurePostTest()
	{
		try {
			ForumPosts post = new ForumPosts("title","text",LocalDateTime.of(2025,9,19,17,0),ForumPosts.author);
		} catch (InvalidTimestampException exc) {
			// TODO Auto-generated catch block
			exc.printStackTrace();
		}
	}
}
