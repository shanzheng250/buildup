package collection;

/**
 * @Description:顺序表
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/11/6
 */
public class SortedCollection {
    //最大长度
    private static final int MAXSIZE = 100;

    private Node [] nodeArry = new Node[MAXSIZE];

    private  int nodeLen = 0;


    /**
     * 增加结点
     *  增加在中间的，需要倒序遍历后面后移一位
     * @param n
     * @param index
     * @return
     */
    public int addNode(Node n,int index){
        if (nodeLen+1 > MAXSIZE){
            return -1;
        }
        if (index > nodeLen + 1){
            nodeArry[index] = n;
            return 1;
        }

        for (int i=nodeLen;i>index;i--){
            nodeArry[i+1] = nodeArry[i];
        }

        nodeArry[index] = n;
        return 1;
    }

    /**
     * 删除结点
     * @param index
     * @return
     */
    public boolean delNode(int index){
        if (index > nodeLen){
            return false;
        }
        for (int i=index;i<nodeLen;i++){
            nodeArry[i] = nodeArry[i+1];
        }
        return true;
    }







    class  Node {
        String key;
        String value;
        int count;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

}
