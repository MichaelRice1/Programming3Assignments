//author - Michael Rice - 20347541

//exception that is thrown when an user is not registered in the forum
public class UnregisteredUserException extends Exception {
	
	public UnregisteredUserException(String message)
	{
		super(message);
	}

}
