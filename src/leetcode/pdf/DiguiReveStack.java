package leetcode.pdf;

import java.util.Stack;

/**
 * @ClassName:diguiReveStack
 * @Description: TODO
 * @Author: shanzheng
 * @Date: 2019/6/28 15:36
 * @Version:1.0
 **/
public class DiguiReveStack {

    /*********8
     *
     * 递归倒序栈中元素
     *
     */



    /**
     * 功能描述  移除栈地元素,并返还该元素
     * @param:
     * @return:
     * @date: 2019/6/28 15:51
     */
    public int removeLastAndReturn(Stack<Integer> s){

        int i = s.pop();

        if (!s.isEmpty()){
            int  temp = removeLastAndReturn(s);

            s.push(i);
            return temp;
        } else {
            return i;
        }


    }





    public void rever(Stack<Integer> s){

        if (!s.isEmpty()){

            int i = removeLastAndReturn(s);

            rever(s);

            s.push(i);

        }

    }


}
