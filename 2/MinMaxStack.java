import java.util.*;

class MinMaxStack {
	Stack<Integer> stack = new Stack<Integer>();
	Stack<HashMap<String, Integer>> minMaxStack = new Stack<>();

	public int getMax() {
		return minMaxStack.peek().get("Maximum");
	}

	public int getMin() {
		return minMaxStack.peek().get("Minimum");
	}
	
	public void push(int data) {
		if(minMaxStack.isEmpty()) {
			HashMap<String, Integer> details = new HashMap<String, Integer>();
			details.put("Maximum", data);
			details.put("Minimum", data);
			minMaxStack.push(details);
		} else {
				HashMap<String, Integer> details = new HashMap<String, Integer>();
				details.put("Maximum", Math.max(getMax(), data));
				details.put("Minimum", Math.min(getMin(), data));
				minMaxStack.push(details);
		}

		stack.push(data);
	}
	
	public void pop() {
		stack.pop();
		minMaxStack.pop();
	}
	
	public int peek() {
		return stack.peek();
	}

	public static void main(String args[]) {
		MinMaxStack stack = new MinMaxStack();
		stack.push(5);
		stack.push(7);
		stack.push(2);

		System.out.println(stack.peek());
		System.out.println(stack.getMax());
		System.out.println(stack.getMin());
		
	}
}
