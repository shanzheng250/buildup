package leetcode.dynamic;

/**
 * @ClassName Lc63
 * @Description: TODO
 * @Author shanz
 * @Date 2020/2/12
 * @Version V1.0
 **/
public class Lc64 {
    // 最小路径和

    // dp[i][j] = min(dp[i-1][j],dp[i][j-1]) + a[i]


    public static int less(int [] [] a){

        int m = a.length;
        int n = a[0].length;

        int [] temp = new int[m];

        for (int i = 1;i<m;i++){

            for (int j=1;j<n;j++){

                temp[j] = Math.min(temp[j-1],temp[j]) + a[i][j];

            }


        }

        return temp[m-1];

    }
}
