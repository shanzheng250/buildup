package leetcode.complete;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/11/16
 */
public class Solution67 {
    /**
     *给定两个二进制字符串，返回他们的和（用二进制表示）。
     *
     * 输入为非空字符串且只包含数字 1 和 0。
     *
     * 示例 1:
     *
     * 输入: a = "11", b = "1"
     * 输出: "100"
     * 示例 2:
     *
     * 输入: a = "1010", b = "1011"
     * 输出: "10101"
     */
    public static String getBinary(String a,String b){

        String result ="";
        int c = 0;
        int i = a.length()-1;
        int j = b.length() -1;

        while (i>=0 || j>=0|| c==1){
            c+=i>=0?a.charAt(i--) - '0':0;
            c+=j>=0?b.charAt(i--) - '0':0;
            result = c%2+'0' +result;
            c/=2;
        }
        return  result;
    }

}
