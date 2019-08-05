package leetcode.complete;

import leetcode.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/10/20
 */
public class Solution21 {
    /**
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     *
     * 示例：
     *
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     */

    public Node connectNode(Node n1, Node n2){
        List<Integer> sortlist = new ArrayList<>();

        while(n1 != null){
            sortlist.add(n1.value);
            n1 = n1.next;
        }

        while(n2 != null){
            sortlist.add(n2.value);
            n2 = n2.next;
        }

        Collections.sort(sortlist);

        Node t = new Node(sortlist.get(0));
        Node temp = t;

        while(!sortlist.isEmpty()){
            sortlist.remove(0);
            if (!sortlist.isEmpty()){
                temp.next = new Node(sortlist.get(0));
                temp = temp.next;
            }
        }

        return t;
    }

    public static void main(String[] args) {
        Solution21 s = new Solution21();
        Node a = new Node(1);
        Node b = new Node(7);
        Node c = new Node(6);
        Node b1 = new Node(10);
        Node b2 = new Node(4);
        Node b3 = new Node(3);
        a.next = b;
        b.next = c;
        b1.next = b2;
        b2.next = b3;
        Node n = s.connectNode(a,b1);
        while(n!=null){
            System.out.print(n.toString());
            n= n.next;
        }

    }


}
