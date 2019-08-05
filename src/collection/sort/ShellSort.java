package collection.sort;

/**
 * @Description:
 * @version:1.0 升级版的插入排序
 * @Author: shanz
 * @Date: 2018/11/16
 */
public class ShellSort {

    /**
     * 固定前面的数组
     * @param arr
     */
    public static  void sort(int ... arr){
        int x = 0;
        //这层控制分层排序
        for (int r=arr.length/2;r>=1;r=r/2){
            //这层是插入排序
            for (int i=r;i<arr.length;i++){
                int j = i - r;
                int temp = arr[i];

                while ( j>0 && arr[j] > temp ){
                    arr[j+r] = arr[j];
                    j -= r;
                }
                arr[j+r] = temp;
            }
            x++;
            System.out.println("第{}次的结果为" + x);
            for (int i=0;i<arr.length;i++){
                System.out.print(arr[i] + "-->");
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        int [] arr = {1,34,2,454,32,3,45,6,7,3,-1,545,5};

        ShellSort.sort(arr);

//        for (int i=0;i<arr.length;i++){
//            System.out.println(arr[i]);
//        }

    }
}
