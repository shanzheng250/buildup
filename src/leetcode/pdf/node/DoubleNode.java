package leetcode.pdf.node;

/**
 * @ClassName:DoubleNode
 * @Description: TODO
 * @Author: shanzheng
 * @Date: 2019/7/1 11:23
 * @Version:1.0
 **/
public class DoubleNode {

    public DoubleNode next;
    public DoubleNode pre;
    public int value;

    public DoubleNode(int value) {
        this.value = value;
    }

    public DoubleNode getNext() {
        return next;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }

    public DoubleNode getPre() {
        return pre;
    }

    public void setPre(DoubleNode pre) {
        this.pre = pre;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
