package collection;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/11/6
 */
public class LinkedNode {

    /**
     * 新增到尾节点
     * @param o
     * @param n
     */
    public void addToTail(Node o,Node n){
        Node temp = o;

        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = n;
    }

    /**
     * 新增到头结点
     * @param o
     * @param n
     */
    public void addTohead(Node o,Node n){
        o.next = n;
    }

    /**
     *查找结点
     * @param n
     * @param key
     * @return
     */
    public Node findNode(Node n,String key){
        Node tempNode = n;

        while (tempNode.next!=null){
            if (key.equals(tempNode.value)){
                return tempNode;
            }
            tempNode =tempNode.next;

        }
        return null;
    }


    /**
     * 删除节点
     * @param n
     * @param key
     */
    public void delNode(Node n,String key){
        Node tempNode = n;
        Node preNode = n;

        while (tempNode.next!=null){
            if (key.equals(tempNode.value)){
                preNode.next = tempNode.next;
                return;
            }
            preNode = tempNode;
            tempNode =tempNode.next;

        }
    }



    public class Node{
        String value;
        Node next;

        public String getValue() {
            return value;
        }
    }
}
