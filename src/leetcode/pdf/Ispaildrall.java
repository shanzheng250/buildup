package leetcode.pdf;

import leetcode.pdf.node.Node;

import java.util.Stack;

/**
 * @ClassName:Ispaildrall
 * @Description: 链表是否为回文链表
 * @Author: shanzheng
 * @Date: 2019/7/2 9:23
 * @Version:1.0
 **/
public class Ispaildrall {


    public boolean  isHuiwen(Node node){
        Node temp = node;
        int count = 0;
        Stack<Integer> s = new Stack<>();

        while(temp != null){
            temp = temp.next;
            count++;
        }

        int len = 1;
        boolean isOshu = count % 2 ==0;

        while(node != null){

            if (count/2 >= len ){
                s.push(node.value);
            }else {
                if (isOshu || count/2 + 1 != len){
                    if ( s.pop() != node.value ){
                        return false;
                    }
                }
            }

            node = node.next;
            len++;
        }
        return true;

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

        Ispaildrall ispaildrall = new Ispaildrall();
        ispaildrall.isHuiwen(n1);

    }


}
