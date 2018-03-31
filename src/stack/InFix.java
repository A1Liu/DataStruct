package stack;

import static stack.StackUtil.isNumber;
import static stack.PostFix.postCalc;

public class InFix {

	public static int inCalc(String expression) throws IllegalArgumentException {
		String[] input = parseIn(expression);
		ArrayStack<String> operators = new ArrayStack<String>();
		String postFix = "";
		for (int x = 0; x < input.length; x++) {
			if (isNumber(input[x])) {
				postFix+=input[x] + " ";
			} else {
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
		
		System.out.println(postFix);
		return postCalc(postFix);
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
	
	private static int convert(String operator) {
		switch (operator) {
		case "(":
			return 0;
		case "/":
			return 1;
		case "*":
			return 1;
		case "+":
			return 2;
		case "-":
			return 2;
		case ")":
			return 3;
		default:
			return 0;	
		}
	}
	
	/**
	 * parses an expression into an array of strings using a regular expression
	 * @param expression the expression to be parsed
	 * @return an array of strings that each contain either a number or an operator
	 */
	public static String[] parseIn(String expression) {
		return expression.replaceAll(" ","").split("(?<=[-+*/()])|(?=[-+*/()])");
	}
}
