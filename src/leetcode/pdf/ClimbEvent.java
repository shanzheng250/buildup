package leetcode.pdf;

/**
 * @ClassName:ClimbEvent
 * @Description: 爬楼梯事件
 * @Author: shanzheng
 * @Date: 2019/7/11 14:38
 * @Version:1.0
 **/
public class ClimbEvent {



    public static int count(int n){
        if (n == 1){
            return 0;
        }

        if (n == 2 || n==3){
            return 1;
        }

        return count(n-1) + count(n-2);
    }


    public static void main(String[] args) {

    }


}
