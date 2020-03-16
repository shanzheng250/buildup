package leetcode.tanxi;

/**
 * @ClassName Lc35
 * @Description: TODO
 * @Author shanz
 * @Date 2020/3/16
 * @Version V1.0
 **/
public class Lc35 {


    public static int look(int [] d,int a){

        int h = d.length-1;
        int l = 0;

        while (l<=h){

            int middle = (h+l)/2;

            if (d[middle] > a){

               h = middle-1;

            }else if(d[middle] < a){

                l = middle+1;
            }else {
                return middle;
            }
        }

        return l;
    }


    public static void main(String[] args) {
        int [] a= {};

        System.out.println("Lc35.main");
    }

}
