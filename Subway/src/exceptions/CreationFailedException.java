package exceptions;

/**
 * @author Nanaha
 * Exception which indicates some kind of error took place while creating a new ticket
 */
public class CreationFailedException extends Exception {
	
	private String message;

	public CreationFailedException() {
		super();
		message = "Unknown mistake";
	}
	
	public CreationFailedException(String reason) {
		super(reason);
		message = reason;
	}
	
	public CreationFailedException(Throwable cause) {
		super(cause);
	}
	
	@Override
	public String toString() {
		return message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
