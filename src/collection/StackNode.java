package collection;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/11/6
 */
public class StackNode {

    private int stacksize = 1000;

    private Node [] node = new Node[stacksize];


    private  int top =0;


    public boolean push(Node n){
        if (top < stacksize){
            node[top+1] = n;
            top++;
            return true;
        }
        return false;
    }


    public boolean pop(Node n){
        if (top !=0){
           Node ns = node[top --];
        }
        return false;
    }



    public boolean isEmpty(){
        if (top ==0){
            return true;
        }
        return false;
    }








    public class Node{
        String value;
        LinkedNode.Node next;
    }


}
