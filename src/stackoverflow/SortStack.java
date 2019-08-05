package stackoverflow;

import java.util.Stack;

public class SortStack {
	
	
	private Stack<Integer> oldstack;
	
	
	private Stack<Integer> newstack;
	
	
	public SortStack() {
		oldstack = new Stack<>();
		newstack = new Stack<>();
	}
	
	
	
	public void sort() {
		if(oldstack.isEmpty()) {
			throw new RuntimeException("error");
		}
		
		int value = oldstack.pop();
		
		if(newstack.isEmpty()) {
			newstack.push(value);
		}else {
			if(value <= newstack.peek()) {
				newstack.push(value);
			}else {
				while(newstack.peek() <= value ) {
					oldstack.push(newstack.pop());
				}
				
			}
		}
		
		
	}
	
	
	

}
