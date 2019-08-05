package leetcode.complete;

import java.util.Arrays;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/11/3
 */
public class Solution53 {
    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 示例:
     *
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * 进阶:
     *
     * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     */

    /**
     * 总和小于0 归零
     * @param nums
     * @return
     */
    public static int [] getMaxChildArray(int ...nums){
        int max = 0;
        int start = 0;
        int end = 0;
        int temp = 0;

        for (int i=0;i<nums.length -1 ;i++){
            temp= nums[i] + temp;
            if (temp < 0){
                temp = 0;
                start = i+1;
                continue;
            }

            if (temp > max){
                max = temp;
                end = i;
            }
        }
        System.out.println("start..." + start);
        System.out.println("end..." + end);

        return Arrays.copyOfRange(nums,start,end);
    }

    public static void main(String[] args) {
        int [] nums = {1,-2,3,5,2,-6,1};

        System.out.println( Solution53.getMaxChildArray(nums));


    }

}
