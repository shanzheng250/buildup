package leetcode.pdf;

import leetcode.pdf.tree.TreeNode;

/**
 * @ClassName:TreeOperate
 * @Description: TODO
 * @Author: shanzheng
 * @Date: 2019/7/11 14:19
 * @Version:1.0
 **/
public class TreeOperate {
    // 前序遍历
    public static void sortpre(TreeNode node){
        if (node == null){
            return;
        }

        System.out.println(node.value);
        sortpre(node.left);
        sortpre(node.right);

    }


    // 中须遍历
    public static  void middlesort(TreeNode node){
        if (node == null){
            return;
        }
        sortpre(node.left);
        System.out.println(node.value);
        sortpre(node.right);


    }



    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node2.left = node4;
        node3.left = node6;
        node1.right = node3;
        node2.right = node5;


//        TreeOperate.sortpre(node1);
        TreeOperate.middlesort(node1);
    }
}
