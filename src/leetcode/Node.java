package leetcode;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/10/22
 */
public class Node {

    public  Node next;

    public  int value;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.value +"->";
    }
}
