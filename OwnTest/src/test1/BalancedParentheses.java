package test1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BalancedParentheses {

	public boolean balancedParentheses(String saved) throws Exception {
		if (saved == null || saved.isEmpty()) {
			throw new Exception("String is Empty/Null");
		}
		List<Character> output = new ArrayList<>();
		int length = saved.length();
		for (int i = 0; i < length; i++) {
			char character = saved.charAt(i);

			switch (character) {
			case '(': {
				output.add(')');
				break;
			}
			case '{': {
				output.add('}');
				break;
			}
			case '[': {
				output.add(']');
				break;
			}
			default: {
				if (output.isEmpty() || output.remove(output.size() - 1) != character) {
					return false;
				}
			}
			}
		}
		return output.isEmpty();
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		BalancedParentheses balCall = new BalancedParentheses();

		System.out.println("Enter your Parentheses");
		String value = input.nextLine();
		try {
			System.out.println(balCall.balancedParentheses(value));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		input.close();
	}

}
