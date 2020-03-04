package leetcode.dynamic;

import java.util.Arrays;

/**
 * @ClassName Lc62
 * @Description: TODO
 * @Author shanz
 * @Date 2020/2/12
 * @Version V1.0
 **/
public class Lc62 {

 // 机器人智能右和下走 走M * N的方格有多少种走法

    // dp(m,n) = dp(m-1,n) + dp(m,n-1)


    public static int r(int m,int n){


        int [][] result = new int[m+1][n+1];

        result[0][1] = 1;
        result[1][0] = 1;

        for (int i=1;i<=m;i++){

            for (int j=1;j<=n;j++){

                result[i][j] = result[i-1][j] + result[i][j-1];

            }

        }

        return result[m+1][n+1];
    }


    // 二维数组转为一位数组
    public static int o(int m,int n){

        int  [] temp = new int[n];

        Arrays.fill(temp,1);


        for (int i =1;i<m;i++){

            for (int j=1;j<n;j++){
                // 此时的temp[j-1]为本轮结果， temp[j]为上次保存临时的结果，因此temp[j] = 左边和 + 上面和
                temp[j] = temp[j-1] + temp[j];
            }

        }
        return temp[n-1];
    }

}
