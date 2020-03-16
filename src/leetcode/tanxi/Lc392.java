package leetcode.tanxi;

/**
 * @ClassName Lc392
 * @Description: TODO
 * @Author shanz
 * @Date 2020/3/14
 * @Version V1.0
 **/
public class Lc392 {

    // 判断子序列
    public boolean isChild(String s,String a){

        int j=-1;

        for (int i=0;i<s.toCharArray().length;i++){

            j = a.indexOf(s.charAt(i),j);

            if (j == -1){

                return false;
            }

        }
        return true;
    }

    // 双指针
    
    public boolean isChild1(String s,String a){
        int aIdx = 0;
        for (int i=0;i<s.toCharArray().length;i++){
           if (s.charAt(i) == a.charAt(aIdx)){
               aIdx++;
           }
        }
        return aIdx == a.length();
    }




}
