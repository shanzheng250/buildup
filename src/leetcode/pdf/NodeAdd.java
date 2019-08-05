package leetcode.pdf;

import leetcode.pdf.node.Node;

/**
 * @ClassName:NodeAdd
 * @Description:链表相加
 * @Author: shanzheng
 * @Date: 2019/7/2 14:10
 * @Version:1.0
 **/
public class NodeAdd {

    public Node add (Node n1,Node n2){




        return null;
    }


    public int conver(Node n){
        Node temp = n;
        int len = 1;
        int i = 1;
        int result = 0;

        while (temp!=null){
            temp = temp.next;
            len++;
        }


        while (n!=null){
            result += Math.pow(10,len-i-1) * n.value;
            n = n.next;
            i++;
        }
        return result;

    }


//    public Node conver(int a){
//
//        Node n = null;
//
//        while (a / 10 != 0){
//
//            int value = a%10;
//
//            a = (a -value)/10;
//
//            if (n == null){
//                n = new Node(value);
//            }else {
//                Node b = n;
//                Node temp = new Node(value);
//                b.next = temp;
//
//            }
//
//        }
//
//
//    }


    public static void main(String[] args) {
        NodeAdd add = new NodeAdd();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(5);
        Node n4 = new Node(3);
        Node n5 = new Node(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.println(add.conver(n1));

    }

}
