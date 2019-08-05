package leetcode.pdf;

import leetcode.pdf.node.Node;

/**
 * @ClassName:DeleteNodeWired
 * @Description: 怪异的删除节点  在不知道头结点的情况下删除本节点
 * @Author: shanzheng
 * @Date: 2019/7/8 9:18
 * @Version:1.0
 **/
public class DeleteNodeWired {


    public void delete(Node node){

        if (node.next == null){
            node = null;
            return;
        }

        Node next = node.next;

        if (next.next == null){

            node.next = null;

            return;
        }


        node.value = next.value;
        node.next = next.next;

    }


    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n11 = new Node(5);
        Node n12 = new Node(6);
        Node n13 = new Node(7);
        n1.setNext(n11);
        n1.setValue(1);
        n11.setValue(5);
        n12.setValue(6);
        n13.setValue(7);
        n11.setNext(n12);
        n12.setNext(n13);
        n13.setNext(null);

        DeleteNodeWired deleteNodeWired = new DeleteNodeWired();
        deleteNodeWired.delete(n11);
        System.out.println(n1);
    }

}
