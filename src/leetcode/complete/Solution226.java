package leetcode.complete;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Solution168
 * @Description: 反转二叉树
 * @Author shanz
 * @Date 2019/8/8
 * @Version V1.0
 **/
public class Solution226 {

    public TreeNode invertTree(TreeNode root) {
            if (root == null){
                return null;
            }

            TreeNode left = invertTree(root.leftTree);
            TreeNode right = invertTree(root.rightTree);

            root.leftTree = right;
            root.rightTree = left;
            return root;

    }




}
