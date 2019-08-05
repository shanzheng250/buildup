package leetcode.complete;

import java.util.*;

/**
 * @ClassName:Solution101
 * @Description: TODO
 * @Author: shanz
 * @Date: 2019/2/20 8:35
 * @Version:1.0
 **/
public class Solution107 {
    /* 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

        例如：
        给定二叉树 [3,9,20,null,null,15,7],

            3
           / \
          9  20
            /  \
           15   7
        返回其自底向上的层次遍历为：

        [
          [15,7],
          [9,20],
          [3]
        ]
     **/

    /**
     * 功能描述 有层次的层级遍历
     * @param:
     * @return:
     * @date: 2019/2/26 9:34
     */
    public static Stack<List> lowTree(TreeNode treeNode){
        Queue<TreeNode> queue = new ArrayDeque<>();
        Stack<List> stack = new Stack<>();
        queue.add(treeNode);
        while (!queue.isEmpty()){

           List first = new ArrayList();
           for (int i=0;i<queue.size();i++){
               TreeNode treeNode1 =  queue.poll();
               queue.add(treeNode1.getLeftTree());
               queue.add(treeNode1.getRightTree());

               first.add(treeNode1);
               stack.add(first);
           }

        }
        return stack;
    }


}
