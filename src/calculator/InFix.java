package calculator;

import static calculator.PostFix.postCalc;
import static calculator.Runner.isNumber;

/**
 * This class represents an InFix Calculator. It contains methods to evaluate and convert infix expressions.
 * @author Alyer
 *
 */
public class InFix {
	
	private InFix() {
		
	}

	/**
	 * Converts an expression to postfix and then evaluates it
	 * @param expression the expression to evaluate
	 * @return integer evaluation of the expression
	 * @throws IllegalArgumentException if the expression is formatted incorrectly
	 */
	public static int inCalc(String expression) throws IllegalArgumentException {
		return postCalc(toPostFix(expression));
	}
	
	/**
	 * Converts an expression to postfix
	 * @param expression the expression to evaluate
	 * @return postfix conversion of expression
	 */
	public static String toPostFix(String expression) {
		String[] input = parseIn(expression);
		ArrayStack<String> operators = new ArrayStack<String>();
		String postFix = "";
		for (int x = 0; x < input.length; x++) {
			if (isNumber(input[x])) {
				postFix+=input[x] + " ";
			} else if (!input[x].equals("")) {
				while(priority(input[x],operators.peek())) {
					postFix+=(operators.peek().equals("(") ? "" : operators.pop() + " ");
				}
				if (!operators.isEmpty() && input[x].equals(")")) {
					if (operators.peek().equals("(")) {
						operators.pop();
					}
				}
				if (!input[x].equals(")"))
					operators.push(input[x]);
			}
		}
		while (!operators.isEmpty() && !operators.peek().equals("("))
			postFix+=operators.pop() + " ";
		return postFix;
	}
	
	/**
	 * determines whether the priority of the operator is higher or lower than the top of the stack
	 * @param operator the operator to test
	 * @param stackTop the top of the stack
	 * @return true if operator has higher priority than stackTop
	 */
	private static boolean priority(String operator, String stackTop) {
		if (stackTop == null) return false;
		if (stackTop.equals("(")) return false;
		return convert(operator) >= convert(stackTop);
	}
	
	/**
	 * converts the characters to numbers based on their priority to make code cleaner
	 * @param operator the operator to convert
	 * @return the priority level of the operator
	 */
	private static int convert(String operator) {
		switch (operator) {
		case "(":
			return 0;
		case "/":
		case "*":
			return 1;
		case "+":
		case "-":
			return 2;
		case ")":
			return 3;
		default:
			throw new IllegalArgumentException("'" + operator + "' is not a valid operator.");	
		}
	}
	
	/**
	 * parses an expression into an array of strings using a regular expression
	 * @param expression the expression to be parsed
	 * @return an array of strings that each contain either a number or an operator
	 */
	private static String[] parseIn(String expression) {
		/*The regular expression basically checks around spaces and splits by them if they're surrounded by specific characters
		 *The resulting string array includes empty strings, but that is the price paid for parsing negative signs.
		 */
		return expression.replaceAll("[^0-9 +*/()-]", "").split(//Replaces all characters that aren't a number, a space, or a known operator
				 "(?<=[-+*/()])\\s*(?=[-+*/()])"//Positive lookAround for an optional arbitrary amount of spaces surrounded by operators ("- +" or "+-")
		 + "|" + "(?<=[-])\\s+(?=[0-9])"//Positive lookAround for an arbitrary amount of spaces preceded by a minus and followed by a number ("-   1" or "- 1")
		 + "|" + "(?<=[0-9]\\-)\\s*"//Positive lookBehind for an optional arbitrary amount of spaces followed by a number and minus sign ("1- 1" or "1-1")
		 + "|" + "(?<=[0-9])\\s*(?=[-+*/()])"//Positive lookAround for an optional arbitrary amount of spaces preceded by a number and followed by an operation ("1-" or "1 -")
		 + "|" + "(?<=[+*/()])\\s*(?=[0-9])"//Positive lookAround for an optional arbitrary amount of spaces preceded by an operator and followed by a number ("+ 1" or "+1")
		 + "|" + "(?<=[0-9])\\s+(?=[0-9])"//Positive lookAround for an arbitrary amount of spaces surrounded by numbers ("1    1")
		 );
	}
}
