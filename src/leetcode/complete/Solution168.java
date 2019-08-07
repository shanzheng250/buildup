package leetcode.complete;

/**
 * @ClassName Solution168
 * @Description: TODO
 * @Author shanz
 * @Date 2019/8/7
 * @Version V1.0
 **/
public class Solution168 {
    /**
     * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
     *
     * 例如，
     *
     *     1 -> A
     *     2 -> B
     *     3 -> C
     *     ...
     *     26 -> Z
     *     27 -> AA
     *     28 -> AB
     *     ...
     * 示例 1:
     *
     * 输入: 1
     * 输出: "A"
     * 示例 2:
     *
     * 输入: 28
     * 输出: "AB"
     * 示例 3:
     *
     * 输入: 701
     * 输出: "ZY
     */

    public static String convertToTitle(int n) {

        StringBuffer sb = new StringBuffer();

        if (n <= 0){
            return "";
        }

        while(n > 0){

            n--; //转化为26进制数

            sb.append((char) (n%26 + 'A'));

            n = n/26;

        }

        return sb.reverse().toString();

    }
}
