//author - Michael Rice - 20347541

//exception that is thrown when a user does not exist in a forum
public class NonExistentUserException extends Exception{
	
	public NonExistentUserException(String message)
	{
		super(message);
	}

}
