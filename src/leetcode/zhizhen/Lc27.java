package leetcode.zhizhen;

import java.util.Arrays;

/**
 * @ClassName Lc27
 * @Description: TODO
 * @Author shanz
 * @Date 2020/3/30
 * @Version V1.0
 **/
public class Lc27 {

    public static void main(String[] args) {
        int [] a = {3,2,3,2};

        System.out.println(Arrays.toString(del(a,3)));
    }

    private static int[] del(int[] a, int val) {

        int p = 0;
        int q = 1;


        while (q < a.length){

            if (a[p] == val && a[q]!=val){
                a[p] = a[q];
                p++;
                q++;
            }else if (a[p] == val && a[q]==val){
                q++;

            }else if (a[p] != val ){
                p++;
            }

        }

        return Arrays.copyOfRange(a,0,p-1);

    }

}
