package stackoverflow;

import java.util.Stack;

public class StackDemo{

	private Stack<Integer> popstack;
	
	
	private Stack<Integer> peekstack;
	
	
	
	public StackDemo() {
		popstack = new Stack<>();
		peekstack = new Stack<>();
	}
	
	
	public int pop() {
		if(popstack.isEmpty() && peekstack.isEmpty()) {
			throw new RuntimeException("队列为空，无法获取值..");
		}
		
		if(popstack.isEmpty()) {
			while(!peekstack.isEmpty()) {
				popstack.push(peekstack.pop());
			}
			
		}
		return popstack.pop();
	}



	public void push(int data) {
		peekstack.push(data);
		
		while(!peekstack.isEmpty()) {
			popstack.push(peekstack.pop());
		}
		
		
	}
	




	public static void main(String[] args) {
		
	}
	
}
