package calculator;

import static calculator.Runner.isNumber;

public class PostFix {
	
	/**
	 * Evaluates a string expression in Postfix notation
	 * @param expression the expression to evaluate
	 * @return The value of the expression
	 */
	public static int postCalc(String expression) throws IllegalArgumentException {
		String[] input = expression.split(" ");
		LinkedStack<Integer> stack = new LinkedStack<Integer>();
		
		if (input.length == 0) throw new IllegalArgumentException("The expression was empty.");
		
		for (int x = 0; x< input.length; x++) {
			if(isNumber(input[x])) {
				stack.push(Integer.parseInt(input[x]));
			} else {
				operate(1,1,input[x]);//check to see if input[x] is a valid operation before continuing
				Integer a = stack.pop();
				Integer b = stack.pop();
				try {
					stack.push(operate(a,b,input[x]));
				} catch (NullPointerException e) {
					throw new IllegalArgumentException("The expression had too many operations for the amount of numbers.");
				}
			}
		}
		Integer answer = stack.pop();
		if (stack.pop() != null) throw new IllegalArgumentException("The expression had too few operations for the amount of numbers.");
		return answer;
	}
	
	/**
	 * operates on two integers given a string operand
	 * @param a first number
	 * @param b second number
	 * @param operand the operand
	 * @return integer value of operation
	 */
	private static int operate(int b, int a, String operand) throws IllegalArgumentException {
		switch (operand) {
		case "*":
			return a*b;
		case "/":
			return a/b;
		case "+":
			return a+b;
		case "-":
			return a-b;
		default:
			throw new IllegalArgumentException("Expression includes an invalid symbol: '" + operand + "'");
		}
	}
}
