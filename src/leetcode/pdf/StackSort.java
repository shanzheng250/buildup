package leetcode.pdf;

import java.util.Stack;

/**
 * @ClassName:StackSort
 * @Description: 栈排序 只能申请一个栈
 * @Author: shanzheng
 * @Date: 2019/6/28 16:23
 * @Version:1.0
 **/
public class StackSort {

    private Stack<Integer> s = new Stack<>();

    public Stack<Integer> sort(Stack<Integer> ss){
        while (!ss.isEmpty()){
            int i = ss.pop();

            insert(i);

        }

        return s;

    }


    /**
     * 功能描述 栈的插入
     * @param:
     * @return:
     * @date: 2019/6/28 16:38
     */
    public void insert(int a){

        if (s.isEmpty() || s.peek() > a){
            s.push(a);
        } else {
            int temp = s.pop();
            insert(a);
            s.push(temp);
        }
    }


    public static void main(String[] args) {
        StackSort stackSort = new StackSort();
        Stack<Integer> sss = new Stack<>();
        sss.add(2);
        sss.add(4);
        sss.add(1);
        sss.add(13);
        sss.add(7);




        System.out.println(stackSort.sort(sss));

    }

}
