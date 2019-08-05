package leetcode.complete;

import leetcode.Node;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/11/29
 */
public class Solution83 {
    /**
     * Given a sorted linked list, delete all duplicates such that each element appear only once.
     *
     * Example 1:
     *
     * Input: 1->1->2
     * Output: 1->2
     * Example 2:
     *
     * Input: 1->1->2->3->3
     * Output: 1->2->3
     */

    public static Node deletedulicate(Node n){
        Set<Integer> set = new HashSet<>();
        set.add(n.getValue());

        Node  temp = n;
        Node  result = n;
        Node  addresult = result;
        while(temp!=null){
            if (!set.contains(temp.getValue())){
                set.add(temp.getValue());
                result.next = temp;
                result = result.next;
            }
            temp = temp.next;
        }

        return addresult;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(1);
        Node c = new Node(2);
        Node d = new Node(4);
        Node e = new Node(3);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        Node r= Solution83.deletedulicate(a);

        Node temp = r;
        while(temp!=null){
            System.out.println(temp.toString());
            temp = temp.next;
        }


    }
}
