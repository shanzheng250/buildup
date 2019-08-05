package thread.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @ClassName:SafeCollectionDemo
 * @Description: TODO
 * @Author: shanz
 * @Date: 2019/5/20 20:50
 * @Version:1.0
 **/
public class SafeCollectionDemo {

    public void doSync(){

        HashMap<String,String> hashMap = new HashMap<>();

        Collections.synchronizedMap(hashMap);  // map 上面加了对象锁 synchronized

        Map<String,String> map = new ConcurrentHashMap<>(); // 优化后分段锁

        // ----> list

        Vector vector = new Vector();

        // -----> queue
        Queue<String> queue = new ConcurrentLinkedQueue<String>();



    }

}
