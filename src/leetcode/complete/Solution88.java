package leetcode.complete;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/11/29
 */
public class Solution88 {
    /**
     * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
     *
     * Note:
     *
     * The number of elements initialized in nums1 and nums2 are m and n respectively.
     * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
     * Example:
     *
     * Input:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     */

//最多遍历k次。。。。利用数组
    public static void sort(int [] arr1,int [] arr2){
        int i = arr1.length -1;
        int j = arr2.length -1;
        int k = arr1.length + arr2.length -1;

        while (k > 0){
            if ((arr1[i] > arr2[j] && i>0) || j<0){
                arr1[k--] = arr1[i--];
            }else{
                arr1[k--] = arr1[j--];
            }

        }



    }



}
