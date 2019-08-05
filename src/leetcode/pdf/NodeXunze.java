package leetcode.pdf;

import leetcode.pdf.node.Node;

/**
 * @ClassName:NodeXunze
 * @Description: 链表的选择排序
 * @Author: shanzheng
 * @Date: 2019/7/3 11:39
 * @Version:1.0
 **/
public class NodeXunze {


    public void Xunze(Node node){

        Node deletePreNode = node;
        Node tail = null;
        Node samllest = null;

        int len= 1;
        while(node != null){

            node = node.next;

            if (node.next == null) tail = node;

            len++;
        }

        int level = 1;
        int minvalue = node.value;

        for (int i=0;i<len;i++){

            while (node!=null && level < len -i -1){

                if (node.value < minvalue){

                    deletePreNode.next = node.next;

                    minvalue = node.value;

//                    if (node )

                    tail.next = node;
                }

                deletePreNode = node;
                node = node.next;
                level++;

            }

        }


    }



    private Node getSamall(Node n){
//        int small

//        while (n != null){
//
//
//
//        }

        return null;
    }
}
