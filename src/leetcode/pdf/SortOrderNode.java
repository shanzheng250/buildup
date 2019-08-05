package leetcode.pdf;

import leetcode.pdf.node.Node;

/**
 * @ClassName:SortOrderNode
 * @Description: 有序列表合并
 * @Author: shanzheng
 * @Date: 2019/7/8 16:16
 * @Version:1.0
 **/
public class SortOrderNode {


    public void sort(Node n1, Node n2){

        Node temp = n1;
        Node temp2 = n2;
        Node pre1 = null;
        while(temp!=null && temp2!=null){
            if (temp.value > temp2.value ){
                Node  n  = temp2.next;
                pre1.next = temp2;
                temp2.next = temp;
                pre1 = temp2;
                temp2 = n;
            }else {
                pre1 = temp;
                temp = temp.next;
            }

        }

    }


}
