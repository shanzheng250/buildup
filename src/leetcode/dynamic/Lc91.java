package leetcode.dynamic;

/**
 * @ClassName Lc91
 * @Description: TODO
 * @Author shanz
 * @Date 2020/2/13
 * @Version V1.0
 **/
public class Lc91 {

    // 编解码的总数
    // 1 <= a[i-1] <= 2  1 <= a[i] <= 6  就有 dp[i-2]
    // 若不符合就dp[i-1]中
    // dp[i] = dp[i-1]  + dp[i-2]


    public static int less(int [] a) {

        int [] temp = new int[a.length] ;

        temp[0] = 1;

        if (1<=a[0] && a[0]<=2 && 1<=a[1] && a[1]<= 6){
            temp[1] = 2;
        }else {
            temp[1] = 1;
        }

        for (int i = 2; i< a.length;i++){

            if (1<=a[i-1] && a[i-1]<=2 && 1<=a[i] && a[i]<= 6){

                temp[i] = temp[i-1] + temp[i-2];

            }else {
                temp[i] = temp[i-1];
            }


        }

        return temp[a.length-1];
    }



    public static int less1(int [] a) {

        int pre_temp = 1;
        int cur_temp;

        if (1<=a[0] && a[0]<=2 && 1<=a[1] && a[1]<= 6){
            cur_temp = 2;
        }else {
            cur_temp = 1;
        }

        for (int i = 2; i< a.length;i++){
            int temp = cur_temp;

            if (1<=a[i-1] && a[i-1]<=2 && 1<=a[i] && a[i]<= 6){
                cur_temp = cur_temp + pre_temp;
            }
            pre_temp = temp;
        }

        return cur_temp;
    }
}