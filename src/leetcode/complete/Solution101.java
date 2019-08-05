package leetcode.complete;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @ClassName:Solution101
 * @Description: TODO
 * @Author: shanz
 * @Date: 2019/2/20 8:35
 * @Version:1.0
 **/
public class Solution101 {
    /* 给定一个二叉树，检查它是否是镜像对称的。

        例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

            1
           / \
          2   2
         / \ / \
        3  4 4  3
        但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

            1
           / \
          2   2
           \   \
           3    3
     **/

    // 递归使用
    // a.left == b.right
    private static boolean isDuicheng(TreeNode treeNode1,TreeNode treeNode2){

        if (treeNode1== null && treeNode2==null){
            return true;
        }

        if (treeNode1 == null || treeNode2 ==null){
            return false;
        }

        if (treeNode1.getValue() != treeNode2.getValue()){
            return false;
        }else{

                return isDuicheng(treeNode1.getLeftTree(),treeNode2.getRightTree()) &&
            isDuicheng(treeNode1.getRightTree(),treeNode2.getLeftTree());
        }


    }


    /**
     * 功能描述 树节点翻转
     * @param:
     * @return:
     * @date: 2019/2/21 9:05
     */
    public static TreeNode revise(TreeNode treeNode){
        Queue<TreeNode> q = new LinkedBlockingQueue();
        q.add(treeNode);

        while (!q.isEmpty()){
            TreeNode node = q.poll();
            TreeNode temp = node.getLeftTree();
            node.setLeftTree(node.getRightTree());
            node.setRightTree(temp);
            if (node.getLeftTree() != null){
                 q.add(node.getLeftTree());

            }
            if (node.getRightTree() != null){
                q.add(node.getRightTree());
            }
        }

        return treeNode;
    }


    public static boolean isSame(TreeNode node1,TreeNode node2){
        if (node1 == null && node2 ==null){
            return true;
        }

        if (node1 ==null || node2 == null) {
            return false;
        }

        if (node1.getValue() != node2.getValue()){
            return false;
        }else {
            return isSame(node1.getLeftTree(),node1.getRightTree()) && isSame(node2.getLeftTree(),node2.getRightTree());
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
        leftNode2.setRightTree(leftNode4);

        treeNode1.setRightTree(rightNode2);
        rightNode2.setLeftTree(rightNode4);
        rightNode2.setRightTree(rightNode3);

//        leftNode2 =  revise(leftNode2);


        System.out.println(isSame(treeNode1,leftNode2));
//
//        boolean is = isDuicheng(leftNode2,rightNode2);
//
//        System.out.println(is);

    }




}
