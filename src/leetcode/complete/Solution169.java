package leetcode.complete;

import java.util.HashMap;

/**
 * @ClassName Solution168
 * @Description: TODO
 * @Author shanz
 * @Date 2019/8/7
 * @Version V1.0
 **/
public class Solution169 {
    /**
     * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在众数。
     *
     * 示例 1:
     *
     * 输入: [3,2,3]
     * 输出: 3
     * 示例 2:
     *
     * 输入: [2,2,1,1,1,2,2]
     * 输出: 2
     */

    public static int majorityElement(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<>();

        if (nums.length == 1){
            return nums[0];
        }

        for (int i=0;i<nums.length;i++){

            if (map.containsKey(nums[i]) && map.get(nums[i]) >= nums.length /2 ){
                return nums[i];
            }else if (map.containsKey(nums[i]) && map.get(nums[i]) < nums.length /2){
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }
        return -1;

    }

    public static void main(String[] args) {
       int  [] a =  {2,2,1,1,1,2,2};

        System.out.println(Solution169.majorityElement(a));
    }

}
