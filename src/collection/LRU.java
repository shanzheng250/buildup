package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * @ClassName:LRU
 * @Description: TODO
 * @Author: shanz
 * @Date: 2019/1/18 10:21
 * @Version:1.0
 **/
public class LRU {

    /**
     * 功能描述 lru算法
     * 使用链表 + map来实现
     * 首先判断是否存在 存在则放到头部，否则返回-1
     * 如果该链表满了 则移除尾部
     */
    private static int LENGTN = 10;

    private LinkedList<HashMap<String,String>> container = new LinkedList<>();


    private LinkedHashMap<String,String> isReal = new LinkedHashMap<>();

    // 增加一个缓存
    public void read(String value){

        if (container.size() < 10 && !isExist(value)){
            HashMap<String,String> stringHashMap = new HashMap<>();
            stringHashMap.put(value,System.currentTimeMillis()/1000+"");
            container.addFirst(stringHashMap);
        }else if (container.size() >= 10 && !isExist(value)){

            container.removeLast();
            HashMap<String,String> stringHashMap = new HashMap<>();
            stringHashMap.put(value,System.currentTimeMillis()/1000+"");

            container.addFirst(stringHashMap);

        }else{
            isExist(value);
        }

    }





    /**
     * 功能描述 是否存在
     * @param:
     * @return:
     * @date: 2019/1/18 10:39
     */
    private boolean isExist(String value) {
        HashMap<String,String> stringHashMap = new HashMap<>();
        boolean isExist = false;
        for (Iterator<HashMap<String,String>> iterator = container.descendingIterator();iterator.hasNext();){
               stringHashMap = iterator.next();
                // 存在则放置头部，并且更新时间
                if (stringHashMap.containsKey(value)){
                    isExist =  true;
                }
        }

        if (isExist){
            container.remove(stringHashMap);
            stringHashMap.put(value,System.currentTimeMillis()/1000+"");
            container.addFirst(stringHashMap);
        }

        return isExist;
    }


}
