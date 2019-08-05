package collection.sort;

/**
 * @Description: 快排
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/11/21
 */
public class QuickSort {

    /**
     * 确定中轴
     * @param low   中轴
     * @param high
     * @param arr
     */
    public static  int  getMiddle(int low,int high,int ... arr){
        int temp = arr[low];
        while(low < high){
            while (low < high && arr[high]> temp ){
                high --;
            }
            arr[low] = arr[high];

            while (low < high &&arr[low]< temp ){
                low ++;
            }
            arr[high] = arr[low];
        }
        arr[low] = temp;

        return low;
    }

    public static void sort(int low,int high,int ... arr){
        if (low < high){
            int middle = getMiddle(low,high,arr);
            sort(low,middle-1,arr);
            sort(middle+1,high,arr);
        }

    }



    public static void main(String[] args) {
        int [] arr = {1,34,2,454,32,3,45,6,7,3,-1,545,5,0};

        QuickSort.sort(0,arr.length-1,arr);

        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

    }

}
