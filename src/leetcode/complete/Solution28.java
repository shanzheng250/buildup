package leetcode.complete;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/10/23
 */
public class Solution28 {
    /**
     * 实现 strStr() 函数。
     *
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     *
     * 示例 1:
     *
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     * 示例 2:
     *
     * 输入: haystack = "aaaaa", needle = "bba"
     * 输出: -1
     * 说明:
     *
     * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
     */

    public int strStr(String haystack,String  needle){

        return haystack.indexOf(needle);
    }

    /**
     * 先计算出第一个字符相等的位置 记录下来
     * 在比较当前位置后的字符是否一致。根据needle长度来遍历对比
     * 成功返回记录的位置
     * @param o
     * @param s
     * @return
     */
    public static int indexStr(String o,String s){

        for (int i=0;i<o.length() - s.length()+1;i++){
            if (o.charAt(i) != s.charAt(0)){
                continue;
            }

            int j = i;
            int sIndex =0;
             while (sIndex < s.length()){
                 if (o.charAt(j++) != s.charAt(sIndex++)){
                     j=-1;
                     break;
                 }
             }

             if (j!=-1){
                 return i;
             }
        }
         return -1;
    }

    public static void main(String[] args) {


        System.out.println(Solution28.indexStr("hellweo","llw"));
    }
}
