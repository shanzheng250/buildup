package leetcode.complete;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/11/16
 */
public class Solution69 {
    /**
     * 实现 int sqrt(int x) 函数。
     *
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     *
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     *
     * 示例 1:
     *
     * 输入: 4
     * 输出: 2
     * 示例 2:
     *
     * 输入: 8
     * 输出: 2
     * 说明: 8 的平方根是 2.82842...,
     *      由于返回类型是整数，小数部分将被舍去。
     */

    public static int sqrt(int x){
        int start = 0;
        int flag = 0;

        while(start*start <= x){
            start++;
        }

        return start-1;

    }


    public static void main(String[] args) {
        System.out.println(Solution69.sqrt(8));
    }

}
