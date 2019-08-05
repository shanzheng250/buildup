package leetcode.pdf;

import leetcode.pdf.node.DoubleNode;
import leetcode.pdf.node.Node;

/**
 * @ClassName:ReverNode
 * @Description: TODO
 * @Author: shanzheng
 * @Date: 2019/7/1 13:47
 * @Version:1.0
 **/
public class ReverNode {

    public static Node resiver(Node node){

        Node pre = null;
        Node cur = node;

        while(cur != null){
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }


    public  static  DoubleNode resiverDouble(DoubleNode node){

        DoubleNode pre = null;
        DoubleNode cur = node;

        while(cur != null){
            DoubleNode next = cur.next;
            cur.next = pre;
            cur.pre = next;
            pre = cur;
            cur = next;
        }

        return pre;
    }


    public static Node reverPart(Node node,int s,int e){
        int cnt = 1;
        Node pre = null;
        Node rev = null;        //
        Node cur = node;
        while(cur!=null){
            if (cnt == s-1 ){
                Node  rever  = cur.next;
                cur.next = null;
                pre = node;
                cur = rever;
            }else  if(cnt >= s && cnt <= e){
                Node next =  cur.next;
                cur.next = rev;
                rev = cur;
                cur = next;
            }else  if(cnt == e+1){
                pre.next = rev;
            }

            cnt++;
            cur = cur.next;
        }
        return pre;

    }


    public static void main(String[] args) {
//        Node n1 = new Node();
//        Node n11 = new Node();
//        Node n12 = new Node();
//        Node n13 = new Node();
//        Node n14 = new Node();
//        n1.next = n11;
//        n11.next = n12;
//        n12.next = n13;
//        n13.next = n14;
//        n1.value = 1;
//        n11.value = 5;
//        n12.value = 6;
//        n13.value = 7;
//        n14.value = 11;


       ;
//        System.out.println( ReverNode.resiver(n1));
//        System.out.println( ReverNode.reverPart(n1,2,3));
    }
}
