package leetcode.complete;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Solution168
 * @Description: TODO
 * @Author shanz
 * @Date 2019/8/8
 * @Version V1.0
 **/
public class Solution225 {

    private Queue<Integer> queue = new LinkedList<>();
    private Queue<Integer> temp = new LinkedList<>();


    /**
        队列生成栈
     */

    /** Initialize your data structure here. */
    public Solution225() {

    }

    /** Push element x onto stack. */
    public void push(int x) {

        while (!queue.isEmpty()){
            temp.add(queue.poll());
        }

        queue.add(x);

        while (!temp.isEmpty()){
            queue.add(temp.poll());
        }

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
       return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }



}
