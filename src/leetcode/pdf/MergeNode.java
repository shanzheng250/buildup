package leetcode.pdf;

import leetcode.pdf.node.Node;

/**
 * @ClassName:MergeNode
 * @Description:  合并链表
 * @Author: shanzheng
 * @Date: 2019/7/10 13:52
 * @Version:1.0
 **/
public class MergeNode {


    private Node mergeNode(Node node){

        int length = 0;
        int middle = 1;
        Node left = node;
        Node right = null;
        Node temp = node;

        while(temp!= null){
            temp = temp.next;
            length ++;
        }

        if (length <= 3){
            return node;
        }

        temp = node;
        while (temp!=null){

            if (middle == length / 2){
                right = temp.next;
                temp.next = null;
            }
            temp = temp.next;
            middle++;
        }

        Node now = right;
        Node pre = left;

        Node next = null;

        while(left.next!=null){
            next = right.next;
            right.next = left.next;
            left.next = right;
            left = right.next;
            right = next;
        }
        left.next = right;

        return next;
    }

    private void serachMiddle(Node n){

        Node middle = n;
        Node head = n;

        while(head.next != null && head.next.next!=null){
            middle = middle.next;
            head = head.next.next;

        }

        Node rigth = middle.next;
        middle.next = null;
        Node left = n;

    }



    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(5);
        Node n4 = new Node(3);
        Node n5 = new Node(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        MergeNode mergeNode = new MergeNode();
        mergeNode.mergeNode(n1);

    }







}
