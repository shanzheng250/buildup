package leetcode.complete;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/11/29
 */
public class Solution70 {
    /**
     * You are climbing a stair case. It takes n steps to reach to the top.
     *
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     *
     * Note: Given n will be a positive integer.
     *
     * Example 1:
     *
     * Input: 2
     * Output: 2
     * Explanation: There are two ways to climb to the top.
     * 1. 1 step + 1 step
     * 2. 2 steps
     * Example 2:
     *
     * Input: 3
     * Output: 3
     * Explanation: There are three ways to climb to the top.
     * 1. 1 step + 1 step + 1 step
     * 2. 1 step + 2 steps
     * 3. 2 steps + 1 step
     */
    public static int getSteps2(int n){
        if (n<=2) return n;

        return getSteps(n-1) + getSteps(n-2);
    }



    public static int getSteps(int n){
        if (n<=2) return n;

        int pre = 1;
        int preNext = 2;
        int current = 0;
        for (int i=2;i<n;i++){
            current = pre + preNext;
            pre = preNext;
            preNext = current;

        }
        return current;
    }


    public static void main(String[] args) {
        System.out.println(Solution70.getSteps2(11));
        System.out.println(Solution70.getSteps(11));
    }


}
