package leetcode.tanxi;

/**
 * @ClassName Lc69
 * @Description: TODO
 * @Author shanz
 * @Date 2020/3/16
 * @Version V1.0
 **/
public class Lc69 {


    public static int sqrt(int x){

        int h = x;
        int l = 1;


        while (l<=h){

            int middle = (h+l)/2;

            if (middle*middle > x){

                h=middle-1;
            }else if (middle*middle < x){

                l = middle+1;
            }else {
                return middle;
            }

        }

        return h;
    }


    public static void main(String[] args) {


        System.out.println(sqrt(8));
    }
}
