package leetcode.complete;

import java.util.Stack;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/11/3
 */
public class Solution155 {
    /**
     设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。

     push(x) -- 将元素 x 推入栈中。
     pop() -- 删除栈顶的元素。
     top() -- 获取栈顶元素。
     getMin() -- 检索栈中的最小元素。
     示例:

     MinStack minStack = new MinStack();
     minStack.push(-2);
     minStack.push(0);
     minStack.push(-3);
     minStack.getMin();   --> 返回 -3.
     minStack.pop();
     minStack.top();      --> 返回 0.
     minStack.getMin();   --> 返回 -2.
     */

    // 最小元素栈
        // 这里我实现了一个按照最小排序的栈

        //实际上，只要栈b只保存最小的元素，栈a全量元素，入栈比较大小 若大于入栈元素，则b出站

  public static class MinStack{

        private Stack<Integer> q = new Stack<>();

        private Stack<Integer> stack = new Stack<>();

        public int pop(){
           return stack.pop();
        }

        public void push(int x){
            if (stack.isEmpty() || stack.peek() <= x){
                stack.push(x);
                return;
            }
            while(!stack.isEmpty()){
                if (stack.peek() > x) {
                    q.add(stack.pop());
                }
            }
            q.add(x);
            while (!q.isEmpty()){
                stack.push(q.pop());
            }
        }
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack);
    }
}
