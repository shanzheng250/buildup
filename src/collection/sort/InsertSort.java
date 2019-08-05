package collection.sort;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/11/16
 */
public class InsertSort {

    public static  void sort(int ... arr) {
        int temp = 0;
        for (int i = 1; i < arr.length; i++) {


            int insertValue = arr[i];
            int j = i - 1;

//            for (int j = i - 1; j > 0; j--) {
//
//                if (insertValue < arr[j]) {
//                    arr[j + 1] = arr[j];
//
//                } else {
//                    arr[j] = insertValue;
//                    break;
//                }
//            }

            //已经排好序的长度为0  -- > i - 1
            while (j>=0 && insertValue < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j] = insertValue;

        }
    }

    public static void main(String[] args) {
        int [] arr = {1,34,2,454,32,3,45,6,7,3,-1,545,5,0};

        InsertSort.sort(arr);

        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

    }
}
