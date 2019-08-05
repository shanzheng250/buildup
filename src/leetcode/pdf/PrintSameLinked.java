package leetcode.pdf;

import leetcode.pdf.node.Node;

import java.util.LinkedList;

/**
 * @ClassName:PrintSameLinked
 * @Description: 打印链表公共部分
 * @Author: shanzheng
 * @Date: 2019/7/1 10:45
 * @Version:1.0
 **/
public class PrintSameLinked {

    public void print(Node n1, Node n2){

        Node head1 = n1;
        Node head2 = n2;


        while(head1!= null && head2 != null){

            if (head1 != head2 && head1.getValue() > head2.getValue()){
                head2 = head2.getNext();
                continue;
            }

            if (head1 != head2 && head2.getValue() > head1.getValue()){
                head1 = head1.getNext();
                continue;
            }

            if (head1.getValue() == head2.getValue()){
                System.out.println(head1.getValue());
                head2 = head2.getNext();
                head1 = head1.getNext();
                continue;

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

//
//        Node n2 = new Node();
//        Node n21 = new Node();
//        Node n22 = new Node();
//        Node n23 = new Node();
//        n2.setNext(n21);
//        n2.setValue(2);
//        n21.setValue(5);
//        n22.setValue(7);
//        n23.setValue(10);
//        n21.setNext(n22);
//        n22.setNext(n23);
//        n23.setNext(null);


//        PrintSameLinked s = new PrintSameLinked();
//        s.print(n1,n2);


    }
}
