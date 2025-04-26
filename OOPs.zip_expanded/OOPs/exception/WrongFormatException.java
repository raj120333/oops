package OOPs.exception;

public class WrongFormatException extends Exception{
	public static final String MSG = "Wrong format used";
	
	public WrongFormatException()
	{
		super(MSG);
	}
	public WrongFormatException(String message)
	{
		super(message);
	}
}	
