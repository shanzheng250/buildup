package leetcode.pdf;

import java.util.HashMap;

/**
 * @ClassName:bianxingci
 * @Description: TODO
 * @Author: shanzheng
 * @Date: 2019/7/11 14:53
 * @Version:1.0
 **/
public class bianxingci {


    public static boolean isTrue(String s,String a){
        if (s.length() != a.length()){
            return false;
        }

        HashMap<Character,Integer> count = new HashMap<>();

        for (int i=0;i<s.length();i++){

            int temp = count.getOrDefault(s.charAt(i),0);

            count.put(s.charAt(i),temp+1);

        }

        for (int i=0;i<a.length();i++) {
            int temp = count.getOrDefault(a.charAt(i),0);
            count.put(a.charAt(i),temp-1);
        }


        for (int i : count.values()){
            if (i != 0){
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(bianxingci.isTrue("abcc","ccea"));
    }

}
