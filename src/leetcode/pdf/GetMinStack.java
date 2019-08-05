package leetcode.pdf;

import java.util.Stack;

/**
 * @ClassName:GetMinStack
 * @Description:
 * @Author: shanzheng
 * @Date: 2019/6/28 15:05
 * @Version:1.0
 **/
public class GetMinStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();


    public void push(int i){
        stack.push(i);

        if (minStack.isEmpty() || i< minStack.peek()){
            minStack.push(i);
        }else {
            minStack.push(minStack.peek());
        }
    }


    public void pop(){
        stack.pop();
        minStack.pop();
    }


    public int getMin(){
        if (minStack.isEmpty()){
            return 0;
        }

        return minStack.peek();
    }


    public static void main(String[] args) {
        GetMinStack stack = new GetMinStack();
        stack.push(3);
        System.out.println(stack.getMin());

        stack.push(2);
        System.out.println(stack.getMin());

        stack.push(1);
        System.out.println(stack.getMin());

        stack.pop();
        System.out.println(stack.getMin());

        stack.pop();
        System.out.println(stack.getMin());

        stack.pop();
        System.out.println(stack.getMin());
    }

}
