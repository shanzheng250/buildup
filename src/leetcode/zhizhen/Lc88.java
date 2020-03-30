package leetcode.zhizhen;

import java.util.Arrays;

/**
 * @ClassName Lc88
 * @Description: TODO
 * @Author shanz
 * @Date 2020/3/30
 * @Version V1.0
 **/
public class Lc88 {

    public static void main(String[] args) {
        int a [] = {1,2,3,0,0,0};
        int b [] = {2,5,6};
        int m = 3;

        System.out.println(Arrays.toString(getT(a,b,m)));

    }

    private static int[] getT(int[] a, int[] b, int m) {

        int bIndex = b.length-1;

        int aIndex = m-1;

        while (aIndex >= 0 && bIndex>=0){

            if (b[bIndex] >= a[aIndex]){

                a[bIndex + aIndex+1] = b[bIndex];
                bIndex--;

            }else {

                a[bIndex + aIndex+1] = a[aIndex];

                aIndex--;
            }
        }
        return a;

    }

}
