package collection.sort;

/**
 * @Description: 冒泡排序
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/11/14
 */
public class BubboSort {


    public static  void sort(int ... arr){
        int temp = 0;
        for (int i=1;i<arr.length;i++){
            for (int j=0;j<arr.length-1;j++){

                if (arr[j] > arr[j+1] ){
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int [] arr = {1,34,2,454,32,3,45,6,7,3,-1,545,5,0};

        BubboSort.sort(arr);

        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

    }


}
