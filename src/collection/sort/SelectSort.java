package collection.sort;

/**
 * @Description: 选择排序
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/11/16
 */
public class SelectSort {

    /**
     * 固定前面的数组
     * @param arr
     */
    public static  void sort(int ... arr){
        int temp = 0;
        for (int i=0;i<arr.length;i++){
            for (int j= i+1;j<arr.length;j++){

                if (arr[j] < arr[i] ){
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int [] arr = {1,34,2,454,32,3,45,6,7,3,-1,545,5,0};

        SelectSort.sort(arr);

        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

    }

}
