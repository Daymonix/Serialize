package Exceprions;

public class InvalidMathException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5420620860345260210L;

	public InvalidMathException() {
		super("Invalid math expression.");
	}
	
	public InvalidMathException(String m) {
		super("Invalid math expression. Additional information: " + m);
	}
	
}
