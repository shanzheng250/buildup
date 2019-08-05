package leetcode.pdf.node;

/**
 * @ClassName:Node
 * @Description: TODO
 * @Author: shanzheng
 * @Date: 2019/7/1 10:46
 * @Version:1.0
 **/
public class Node {

    public  Node next;

    public  int value;


    public Node(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
