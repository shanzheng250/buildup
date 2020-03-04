package leetcode.dynamic;

import java.util.Arrays;

/**
 * @ClassName Ms63
 * @Description: TODO
 * @Author shanz
 * @Date 2020/3/4
 * @Version V1.0
 **/
public class Ms63 {

    // 股票的最大利润

    public static int maxProfile(int [] prices){

        int res = 0;

        for (int i=0;i<prices.length;i++){

            for (int j=i+1;j<prices.length;j++){

                 res = Math.max(prices[j] - prices[i],res);

            }

        }

        return res;

    }


    public static int maxLTF(int [] prices){

        int min = prices[0];
        int max = 0;

        for (int i=1;i<prices.length;i++){


            max = Math.max(prices[i] - min,max);

            min = Math.min(min,prices[i]);
        }
        return max;


    }
}
