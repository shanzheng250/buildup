package leetcode.dynamic;

/**
 * @ClassName Lc375
 * @Description: TODO
 * @Author shanz
 * @Date 2020/3/4
 * @Version V1.0
 **/
public class Lc375 {

    // 猜数字 最坏情况付金额


    public  static int maxOffer(int head,int tail,int e){

        int middle = (head  + tail) /2;

        int max = middle;

        if (middle == e){

            return max -e;
        }else if (middle < e){

            return max + maxOffer(middle,tail,e);
        } else {

            return max + maxOffer(head,middle-1,e);
        }

    }

    public static void main(String[] args) {
        System.out.println("Lc375.main----" + maxOffer(0,10,8));
    }

}
