package leetcode.dynamic;

/**
 * @ClassName leetcode5
 * @Description: TODO
 * @Author shanz
 * @Date 2020/1/25
 * @Version V1.0
 **/
public class leetcode5 {
    // 最长回文子字符串
    // ex: input: ababc output: aba

    // 暴力破解法 滑动窗口
    public static String getChildStr(String s){
        String result = "";

        for (int i =0 ;i<s.length();i++){

            int max = 0;


            for (int j = i+1;j<s.length();j++){

                if (Math.max(max,j-i) < j-i && isHuiwen(s.substring(i,j))){
                    result = s.substring(i,j);
                    max = j- i;
                }

            }


        }



        return result;
    }

    public static  boolean isHuiwen (String s){

        char [] a = s.toCharArray();

        for (int i=0;i <= a.length / 2 ;i++){

            if (a[i] != a[a.length -i - 1]){
                return false;
            }

        }

        return true;
    }


    // dp 破解反转一个字符串求最大的相同字符串 暴力破解法
//    public static String getChildStr1(String s){
//
//        if ("".equals(s)){
//            return "";
//        }
//
//        char c [] = s.toCharArray();
//
//        for (int i =0;i<c.length-1;i++){
//
//            int max = 0;
//
//            for (int j=0;j<c.length-1;j++){
//
////                if ()
//
//
//            }
//
//        }
//
//
//
//    }





    public static void main(String[] args) {
        System.out.println("leetcode5.main----->" + leetcode5.getChildStr("adda"));
    }
}
