package stackoverflow;

import java.util.Stack;

public class MinStatck {
	
	private Stack<Integer> mainStack;
	
	private Stack<Integer> minStack;

	public MinStatck() {
		mainStack = new Stack<>();
		minStack = new Stack<>();
	}
	
	
	public void push(Integer data) {
		mainStack.push(data);
		
		if(minStack.isEmpty()) {
			minStack.push(data);
		}else {
			if(data < minStack.peek()) {
				minStack.push(data);
			}
		}
		
	}
	
	
	public int pop() {
		if(minStack.isEmpty()) {
			throw new RuntimeException("站内为空!");
		} else {
			int value = minStack.peek();
			int mainValue = mainStack.pop();
			
			if(mainValue <= value) {
				minStack.pop();
			}
			return mainValue;
		}
	}
	
	
	

}
