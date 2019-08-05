package leetcode.complete;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/11/16
 */
public class Solution58 {
    /**
     * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
     *
     * 如果不存在最后一个单词，请返回 0 。
     *
     * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
     *
     * 示例:
     *
     * 输入: "Hello World"
     * 输出: 5
     */

    public static int getWord(String str){
        int index = 0;
        boolean flag = false;
        for (int i=str.length()-1;i>0;i--){

            if (str.charAt(i) == ' '){
                if (flag){
                    break;
                }
                flag = true;
            } else {
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
//        String s = "ddd";
//        s.trim()
        System.out.println(Solution58.getWord("hello worffd "));
    }
}
