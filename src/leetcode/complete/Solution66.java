package leetcode.complete;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/11/16
 */
public class Solution66 {
    /**
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     *
     * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
     *
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     * 示例 1:
     *
     * 输入: [1,2,3]
     * 输出: [1,2,4]
     * 解释: 输入数组表示数字 123。
     * 示例 2:
     *
     * 输入: [4,3,2,1]
     * 输出: [4,3,2,2]
     * 解释: 输入数组表示数字 4321。
     */

    public static int [] addOne(int ...arr){
        int flag = 1;
        for (int i=arr.length-1;i>=0;i--){
            if (arr[i] == 9 && flag ==1){
                flag = 1;
                arr[i] = 0;
            }else{
                arr[i] = arr[i] +flag;
                flag =0;
            }
        }

        for (int i =0;i<arr.length;i++){
            System.out.print(arr[i] +"->");
        }

        return arr;
    }


    public static void main(String[] args) {
        int a [] ={4,2,9,9};
        Solution66.addOne(a);
    }


}
