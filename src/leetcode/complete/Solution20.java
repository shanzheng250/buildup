package leetcode.complete;

import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/10/20
 */
public class Solution20 {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     * 示例 1:
     * 输入: "()"
     * 输出: true
     * 示例 2:
     * 输入: "()[]{}"
     * 输出: true
     * 示例 3:
     * 输入: "(]"
     * 输出: false
     * 示例 4:
     *
     * 输入: "([)]"
     * 输出: false
     * 示例 5:
     *
     * 输入: "{[]}"
     * 输出: true
     */

    public static  boolean isValid(String str){
        HashMap<String,String> map = new HashMap<>();
        map.put("(",")");
        map.put("{","}");
        map.put("[","]");

        Queue<String> leftQueue = new LinkedBlockingQueue<>();
        Stack rightStack = new Stack();

        if (!map.containsKey(String.valueOf(str.charAt(0)))){
            return false;
        }

        for (int i=0;i<str.length();i++){
            String flgStr = String.valueOf(str.charAt(i));

            // 若出现{}则不处理
            if (map.containsKey(flgStr) && map.get(flgStr).equals(String.valueOf(str.charAt(i+1))) && i<str.length()-1){
                i=i+1;
                continue;
            }
            // 若立刻匹配到，则不进行保存操作
            if(map.containsKey(flgStr)){
                leftQueue.add(flgStr);
            }else{
                rightStack.push(flgStr);
            }
        }

        if(leftQueue.size() != rightStack.size()){
            return  false;
        }

        while(!leftQueue.isEmpty() && !rightStack.isEmpty()){
            if(!map.get(leftQueue.poll()).equals(rightStack.pop())){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(Solution20.isValid("{[]}"));
    }
}
