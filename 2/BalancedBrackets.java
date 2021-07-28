import java.util.*;

class BalancedBrackets {
	public static boolean hasBalancedBrackets(String brackets) {
		Map<Character, Character> bracketsPair = Map.of('(', ')', '{', '}', '[', ']');
		
		var stack = new Stack<Character>();
		for(int i=0; i<brackets.length(); i++) {
			if(stack.isEmpty()) {
				if(bracketsPair.get(brackets.charAt(i)) != null) {
					stack.push(brackets.charAt(i));
				} else {
					return false;
				}
			} else {
				if(bracketsPair.get(brackets.charAt(i)) == null) {
					if(bracketsPair.get(stack.peek()) == brackets.charAt(i)) {
						stack.pop();
					} else {
						return false;
					}
				} else {
						stack.push(brackets.charAt(i));
				}
			}
		}


		return true;
	}
	
	public static void main(String args[]) {
		String brackets = "(([]()()){})";	
		System.out.println(hasBalancedBrackets(brackets));
	}
}
