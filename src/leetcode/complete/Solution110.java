package leetcode.complete;

/**
 * @ClassName:Solution101
 * @Description: TODO
 * @Author: shanz
 * @Date: 2019/2/20 8:35
 * @Version:1.0
 **/
public class Solution110 {
    /*  给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：

一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。

示例 1:

给定二叉树 [3,9,20,null,null,15,7]

    3
   / \
  9  20
    /  \
   15   7
返回 true 。


示例 2:

给定二叉树 [1,2,2,3,3,null,null,4,4]

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
返回 false 。
     **/


    /**
     * 功能描述
     *
     * 先递归获取各个树节点的高度
     * 判断左右字树高度差是不是为1
     *
     */


    /**
     * 功能描述 树的高度
     * @param:
     * @return:
     * @date: 2019/2/28 8:43
     */
    public static  int getHeight(TreeNode treeNode){
        if (treeNode == null){
            return 0;
        }

        if (treeNode.getLeftTree() == null && treeNode.getRightTree() == null){
            return 1;
        }

        return Integer.max(getHeight(treeNode.getLeftTree()),getHeight(treeNode.getRightTree())) + 1;
    }



    public static boolean isBlance(TreeNode treeNode){
        if (treeNode == null){
            return true;
        }

        int left = getHeight(treeNode.getLeftTree());
        int right = getHeight(treeNode.getRightTree());

        if ((left > right && left -right >1) || (right > left && right -left >1)){
            return false;
        }else {
            return isBlance(treeNode.getLeftTree()) && isBlance(treeNode.getRightTree());
        }
    }


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode leftNode2 = new TreeNode(2);
        TreeNode leftNode3 = new TreeNode(3);
        TreeNode leftNode4 = new TreeNode(4);
        TreeNode rightNode2 = new TreeNode(2);
        TreeNode rightNode4 = new TreeNode(4);
        TreeNode rightNode3 = new TreeNode(3);

        treeNode1.setLeftTree(leftNode2);
        leftNode2.setLeftTree(leftNode3);
        leftNode3.setLeftTree(leftNode4);

        treeNode1.setRightTree(rightNode2);
        rightNode2.setLeftTree(rightNode4);
//        rightNode2.setRightTree(rightNode3);
        System.out.println(isBlance(treeNode1));
    }



}
