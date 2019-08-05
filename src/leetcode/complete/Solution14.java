package leetcode.complete;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/10/20
 */
public class Solution14 {
    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     * 示例 1:
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * 说明:
     * 所有输入只包含小写字母 a-z 。
     */
    public static String getLongStr(String [] stringArry){
        String str="";
        for (int m = 0;m<stringArry[0].length();m++){
            for (int n = m+1;n<stringArry[0].length();n++) {
                String tempstr = stringArry[0].substring(m,n);
                for (int i =1;i<stringArry.length;i++){
                    if (!stringArry[i].contains(tempstr)){
                        break;
                    }

                    if (str.length() < tempstr.length() && (i==stringArry.length -1)){
                        str = tempstr;
                    }
                }
             }
        }
        return str;
    }

    public static void main(String[] args) {
        String [] i = {"dog"};

        System.out.println(Solution14.getLongStr(i));
    }

}
