package leetcode.complete;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/11/29
 */
public class Solution100 {
    /**
     * Given two binary trees, write a function to check if they are the same or not.
     *
     * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
     *
     * Example 1:
     *
     * Input:     1         1
     *           / \       / \
     *          2   3     2   3
     *
     *         [1,2,3],   [1,2,3]
     *
     * Output: true
     * Example 2:
     *
     * Input:     1         1
     *           /           \
     *          2             2
     *
     *         [1,2],     [1,null,2]
     *
     * Output: false
     * Example 3:
     *
     * Input:     1         1
     *           / \       / \
     *          2   1     1   2
     *
     *         [1,2,1],   [1,1,2]
     *
     * Output: false
     */


    public static Object[] getLevelNode(TreeNode treeNode){
        List<Integer> integers = new ArrayList<>();
        Queue<TreeNode> q = new LinkedBlockingQueue();
        //层次遍历 根 -> 左 -> 右
        q.add(treeNode);
        while (!q.isEmpty()){
            TreeNode temp  =   q.poll();
            System.out.println(temp.value +" -> ");
            integers.add(temp.value);
            q.add(temp.leftTree);
            q.add(temp.rightTree);
        }
        return integers.toArray();
    }


}
