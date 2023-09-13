//user defined exception, created to handle timestamps in the past
public class InvalidTimestampException extends Exception {

	//constructor that takes a string as an argument
	public InvalidTimestampException(String message)
	{
		super(message);
	}
}
