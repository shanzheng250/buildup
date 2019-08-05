package leetcode.pdf;

import leetcode.pdf.node.Node;

import java.util.HashMap;

/**
 * @ClassName:DeleteRepeatNode
 * @Description: TODO
 * @Author: shanzheng
 * @Date: 2019/7/3 9:18
 * @Version:1.0
 **/
public class DeleteRepeatNode {


    public void delete(Node node){
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(node.value,0);
        Node n = node.next;
        Node pre = node;

        while(n != null){

            if (map.get(n.value) == null){
                map.put(n.value,0);
                pre = n;
            }else {
                pre.next =  n.next;
            }


            n = n.next;
        }

    }


    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(5);
        Node n4 = new Node(3);
        Node n5 = new Node(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        DeleteRepeatNode node = new DeleteRepeatNode();
        node.delete(n1);


    }

}
