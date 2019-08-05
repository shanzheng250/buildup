package stackoverflow;

import java.util.HashMap;
import java.util.Stack;

public class NodeTree {

	private HashMap<Node,Node> lmap = new HashMap<>();
	private HashMap<Node,Node> rmap = new HashMap<>();
	
	
	public void mkNodeTree(int [] a) {
		
//		for(int i =0;i<a.length;i++) {
//			Stack<Node> s = new Stack<>();
//
//			while(!s.isEmpty() && s.peek().value > a[i]) {
//				Node value = s.pop();
//				lmap.put(a[i], value);
//			}
//			s.push(a[i]);
//		}
//
//
//		for(int i=a.length;i>0;i--) {
//			Stack<Node> s = new Stack<>();
//
//			while(!s.isEmpty() && s.peek().value > a[i]) {
//				Node value = s.pop();
//				rmap.put(a[i], value);
//			}
//			s.push(a[i]);
//		}
//
		
		
		
	}
	
	
	
	
	
	
	
	
	class Node{
		private Node left;
		
		private Node right;
		
		private int value;

		public Node(int value) {
			super();
			this.value = value;
		}
	}
}
