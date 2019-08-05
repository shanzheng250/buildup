package leetcode.complete;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/11/3
 */
public class Solution112 {
    /**
     给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

     说明: 叶子节点是指没有子节点的节点。

     示例:
     给定如下二叉树，以及目标和 sum = 22，

     5
     / \
     4   8
     /   / \
     11  13  4
     /  \      \
     7    2      1
     返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。




     给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     */

    public static boolean isSatify(TreeNode treeNode,int sum){
        if (treeNode == null){
            return false;
        }

        if (treeNode.getValue() > sum){
            return false;
        }

        if (treeNode.getValue() == sum && treeNode.getLeftTree() == null && treeNode.getRightTree() == null){
            return true;
        }

        return isSatify(treeNode.getLeftTree(),sum - treeNode.getValue()) || isSatify(treeNode.getRightTree(),sum - treeNode.getValue());
    }

}
