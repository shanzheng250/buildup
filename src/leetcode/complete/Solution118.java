package leetcode.complete;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/11/3
 */
public class Solution118 {
    /**
     在杨辉三角中，每个数是它左上方和右上方的数的和。

     示例:

     输入: 5
     输出:
     [
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
     ]

     119

     给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。



     在杨辉三角中，每个数是它左上方和右上方的数的和。

     示例:

     输入: 3
     输出: [1,3,3,1]
     进阶：

     你可以优化你的算法到 O(k) 空间复杂度吗？
     */


    public static List<List<Integer>> getYangHuiByRow(int row){
        List<List<Integer>> resultList = new ArrayList<>();

        for (int i=0; i< row;i++){
            List<Integer> list = new ArrayList<>();

            for (int j=0;j <= i;j++){
                if (j ==0 || j == i){
                    list.add(j,1);
                } else {
                    list.add(j,resultList.get(i-1).get(j) + resultList.get(i-1).get(j-1));
                }
            }

            resultList.add(list);
        }

        return resultList;
    }


    public static void main(String[] args) {
        System.out.println(getYangHuiByRow(3).get(2));;
    }
}
