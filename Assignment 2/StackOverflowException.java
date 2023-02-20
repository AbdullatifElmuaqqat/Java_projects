
public class StackOverflowException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1833607713372576764L;

	public StackOverflowException() {
		super("A push method is called on a full stack.");
	}
}
