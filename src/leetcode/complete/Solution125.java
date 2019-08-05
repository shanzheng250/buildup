package leetcode.complete;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/11/3
 */
public class Solution125 {
    /**
     给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

     说明：本题中，我们将空字符串定义为有效的回文串。

     示例 1:

     输入: "A man, a plan, a canal: Panama"
     输出: true
     示例 2:

     输入: "race a car"
     输出: false
     */

  public static boolean isHuiWen(String s){
      int start = 0;
      int end = s.length() - 1;
      char [] chars = s.toCharArray();

      while (start < end){

          if (!Character.isLetterOrDigit(chars[start])){
              start ++ ;
          } else  if (!Character.isLetterOrDigit(chars[end])){
              end -- ;
          } else  if (Character.toLowerCase(chars[start]) == Character.toLowerCase(chars[end])){
              start++;
              end --;
          }else {
              return false;
          }

      }
      return true;
  }


    public static void main(String[] args) {
        System.out.println(isHuiWen("A man, a plan, a canal: Panama"));
    }


}
