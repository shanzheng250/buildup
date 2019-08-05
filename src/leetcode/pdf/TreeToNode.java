package leetcode.pdf;

import leetcode.pdf.node.DoubleNode;
import leetcode.pdf.node.Node;
import leetcode.pdf.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ClassName:TreeToNode
 * @Description: TODO
 * @Author: shanzheng
 * @Date: 2019/7/3 11:16
 * @Version:1.0
 **/
public class TreeToNode {


    public DoubleNode converNode(TreeNode t){
        Queue<TreeNode> q = new ArrayDeque<>();

        converTreeToQ(t,q);

        // 用来便利的
        DoubleNode node = new DoubleNode(((ArrayDeque<TreeNode>) q).pop().value);
        node.pre = null;

        DoubleNode result = node;

        DoubleNode pre = null;

        while (!q.isEmpty()){

            DoubleNode temp = new DoubleNode(((ArrayDeque<TreeNode>) q).pop().value);
            node.pre = pre;
            node.next = temp;
            pre = node;
            node = node.next;

        }
        return  result;


    }



    public void converTreeToQ(TreeNode t,Queue<TreeNode> q){
        while(t==null){
            return ;
        }

        converTreeToQ(t.left,q);
        q.add(t);
        converTreeToQ(t.right,q);
    }


    public static void main(String[] args) {

    }

}
