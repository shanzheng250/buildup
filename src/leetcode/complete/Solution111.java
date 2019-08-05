package leetcode.complete;

/**
 * @ClassName:Solution101
 * @Description: TODO
 * @Author: shanz
 * @Date: 2019/2/20 8:35
 * @Version:1.0
 **/
public class Solution111 {
    /* 给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明: 叶子节点是指没有子节点的节点。

示例:

给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回它的最小深度  2.

     **/

    public static int getMinHeight(TreeNode treeNode){
        if (treeNode == null){
            return 0;
        }

        if (treeNode.getLeftTree() == null && treeNode.getRightTree() ==null){
            return 1;
        }

        return Integer.min(getMinHeight(treeNode.getLeftTree()),getMinHeight(treeNode.getRightTree())) + 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode leftNode2 = new TreeNode(9);
        TreeNode rightNode2 = new TreeNode(20);
        TreeNode rightNode4 = new TreeNode(15);
        TreeNode rightNode3 = new TreeNode(7);
        TreeNode rightNode33 = new TreeNode(7);

        treeNode1.setLeftTree(leftNode2);
//        treeNode1.setRightTree(rightNode2);
        rightNode2.setLeftTree(rightNode4);
        rightNode2.setRightTree(rightNode3);
        rightNode3.setRightTree(rightNode33);

        System.out.println(getMinHeight(treeNode1));
    }

}
