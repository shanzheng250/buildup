package leetcode.zhizhen;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @ClassName Lc26
 * @Description: TODO
 * @Author shanz
 * @Date 2020/3/30
 * @Version V1.0
 **/
public class Lc26 {

    public static void main(String[] args) {
        int [] a={0,0,1,1,2,4};

        System.out.println(Arrays.toString(getDel(a)));
    }

    private static int[] getDel(int[] a) {

        HashMap<Integer,Integer> map = new HashMap<>();

        int index = 0;

        for (int i=0;i<a.length-1;i++){

            if (!map.containsKey(a[i])){
                map.put(a[i],0);
            } else {
                if (i <= a.length - 2){
                    a[i] = a[i+1];
                }
                index++;

            }

        }

        return Arrays.copyOfRange(a,0,a.length-index);

    }


}
