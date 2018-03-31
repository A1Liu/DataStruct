package stack;

public class PostFix {
	
	/**
	 * Evaluates a string expression in Postfix notation
	 * @param expression the expression to evaluate
	 * @return The value of the expression
	 */
	public static int postCalc(String expression) {
		String[] input = expression.split(" ");
		LinkedStack<Integer> stack = new LinkedStack<Integer>();
		
		for (int x = 0; x< input.length; x++) {
			if(isNumber(input[x])) {
				stack.push(Integer.parseInt(input[x]));
			} else {
				int b = stack.pop();
				int a = stack.pop();
				stack.push(operate(a,b,input[x]));
			}
		}
		return stack.pop();
	}
	
	/**
	 * operates on two integers given a string operand
	 * @param a first number
	 * @param b second number
	 * @param operand the operand
	 * @return integer value of operation
	 */
	private static int operate(int a, int b, String operand) {
		switch (operand) {
		case "*":
			return a*b;
		case "/":
			return a/b;
		case "+":
			return a+b;
		default:
			return a-b;
		}
	}
	
	/**
	 * checks if a string is an integer
	 * @param in string to test
	 * @return true if the string can be parsed to an integer
	 */
	private static boolean isNumber(String in) {
		try{
			Integer.parseInt(in);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}
