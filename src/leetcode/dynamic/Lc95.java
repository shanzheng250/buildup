package leetcode.dynamic;

/**
 * @ClassName Lc95
 * @Description: TODO
 * @Author shanz
 * @Date 2020/2/13
 * @Version V1.0
 **/
public class Lc95 {

    //给定整数N 生成1~N的节点组成的二叉搜索树有多少种

    // G(N)  =  F(1) + F(2) + .....F(i) n个整数分别是以1为根的个数到N为根的个数和

    // F(i) = G(i-1) * G(n-i)

    // G(N) =  G(0) * G(N-1) +  G(1) * G(N-2) + ....+ G(N-1) * G(0)


    public static int getLen(int n){

        int [] temp = new int[n+1];

        temp[0] = 1;
        temp[1] = 1;

        for (int i=2;i<=n;i++){ // 这里的I 时机上是N

            for (int j= 0;j<=n-1;j++){

                temp[i] += temp[j] * temp[i-j];

            }

        }

        return temp[n];
    }

}
