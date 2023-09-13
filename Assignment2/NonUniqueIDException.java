//author - Michael Rice - 20347541

//exception that is thrown when an ID already exists in the users array list
public class NonUniqueIDException extends Exception {
	
	public NonUniqueIDException(String message)
	{
		super(message);
	}

}
