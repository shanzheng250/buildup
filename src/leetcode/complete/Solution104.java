package leetcode.complete;

/**
 * @ClassName:Solution101
 * @Description: TODO
 * @Author: shanz
 * @Date: 2019/2/20 8:35
 * @Version:1.0
 **/
public class Solution104 {
    /* 给定一个二叉树，找出其最大深度。

        二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

        说明: 叶子节点是指没有子节点的节点。

        示例：
        给定二叉树 [3,9,20,null,null,15,7]，

            3
           / \
          9  20
            /  \
           15   7
        返回它的最大深度 3 。
     **/

    public static int maxDept(TreeNode treeNode){
        int res = 0;
        // 不等于空 本节点先+1
        if (treeNode == null){
            return 0;
        }
        res++;

        int leftRes = res + maxDept(treeNode.getLeftTree());
        int rightRes = res + maxDept(treeNode.getRightTree());

        return Math.max(leftRes,rightRes);

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
        leftNode2.setRightTree(leftNode4);

        treeNode1.setRightTree(rightNode2);
        rightNode2.setLeftTree(rightNode4);
        rightNode2.setRightTree(rightNode3);
    }

}
