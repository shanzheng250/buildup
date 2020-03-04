package leetcode.dynamic;

/**
 * @ClassName Ms47
 * @Description: TODO
 * @Author shanz
 * @Date 2020/3/4
 * @Version V1.0
 **/
public class Ms47 {

    // 最大礼物

    // dp[i,j] = Math.max(dp[i-1,j],dp[i,j-1] )+ a[i][j]

    public static int max(int [][] data){

        int m = data[0].length;
        int n = data.length;

        int [] [] dp = new int[m][n];

        dp[0][0] = data[0][0];
        dp[1][0] = data[0][0] + data[1][0];
        dp[0][1] = data[0][0]+ data[0][1];

        for (int i=1;i<m;i++){

            for (int j=1;j<n;j++){

                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + data[i][j];

            }

        }

        return dp[m-1][n-1];

    }


}
