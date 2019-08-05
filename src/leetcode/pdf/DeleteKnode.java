package leetcode.pdf;

import leetcode.pdf.node.DoubleNode;
import leetcode.pdf.node.Node;

/**
 * @ClassName:DeleteKnode
 * @Description: 删除第K个节点
 * @Author: shanzheng
 * @Date: 2019/7/1 11:05
 * @Version:1.0
 **/
public class DeleteKnode {


    public static void delete(Node node,int k){
        int cnt = 1;
        Node pre = null;
        Node temp = node;

        while(temp.getNext()!=null){
            if (k == 1){
                node = temp.getNext();
                return;
            }

            if (k > cnt){
                pre = temp;
                cnt ++;
            }else if (k<= cnt){
                pre.setNext( temp.getNext());
                return ;
            }
            temp = temp.getNext();
        }

    }


    public static void delete(DoubleNode node, int k){
        int cnt = 1;
        DoubleNode pre = null;
        DoubleNode temp = node;

        while(temp.getNext()!=null){
            if (k == 1){
                node = temp.getNext();
                return;
            }

            if (k < cnt){
                pre = temp;
                temp = temp.getNext();
                cnt ++;
            }else if (k>= cnt){
                pre.setNext( temp.getNext());
                temp.setPre(pre);
                return ;
            }

        }

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

        DeleteKnode.delete(n1,2);


    }

}
