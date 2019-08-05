package leetcode.pdf;

import java.util.Stack;

/**
 * @ClassName:TwoStackQueue
 * @Description: TODO
 * @Author: shanzheng
 * @Date: 2019/6/28 15:30
 * @Version:1.0
 **/
public class TwoStackQueue {


    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();


    public void add(int i){
        stack1.add(i);
    }


    public int poll(){

        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        return stack2.pop();
    }


    public int peek(){

        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        return stack2.peek();

    }


}
