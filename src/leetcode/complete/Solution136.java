package leetcode.complete;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/11/3
 */
public class Solution136 {
    /**
     给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

     说明：

     你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

     示例 1:

     输入: [2,2,1]
     输出: 1
     示例 2:

     输入: [4,1,2,1,2]

     输出: 4
     */

    /**
     * 功能描述 将数组内所有的元素异或运算，相同的会消除。只剩下单独的元素
     * @param:
     * @return:
     * @date: 2019/3/11 8:34
     */
    private static int getZeroOrIt(List<Integer> list){
        int result = 0;

        for (int i=0;i<list.size();i++){

            result^= list.get(i);

        }

        return result;

    }


    public static void main(String[] args) {
       List<Integer> a = new ArrayList<>();
       a.add(2);
       a.add(2);
       a.add(1);
       a.add(3);
       a.add(3);


        System.out.println(getZeroOrIt(a));

    }
}
