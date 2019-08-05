package collection;

import sun.rmi.transport.ObjectTable;

import java.util.Arrays;

/**
 * @ClassName:ArrayList
 * @Description: TODO
 * @Author: shanzheng
 * @Date: 2019/7/11 9:57
 * @Version:1.0
 **/
public class MyArrayList {

    Object [] elements;

    int size;


    public void add(Object o){
        ensureCaption(size+1);
    }

    /**
     默认是保存size 当size超过数组长度时，进行grow扩容，并且扩容1.5倍，,使用的是Array.copyof
     */

    private void ensureCaption(int i) {

        int newlen ;
        if (i > size){
//            // overflow-conscious code
//            int oldCapacity = elements.length;
//            int newCapacity = oldCapacity + (oldCapacity >> 1);
//            if (newCapacity - i < 0)
//                newCapacity = i;
//            if (newCapacity - MAX_ARRAY_SIZE > 0)
//                newCapacity = hugeCapacity(minCapacity);
//            // minCapacity is usually close to size, so this is a win:
//            elementData = Arrays.copyOf(elementData, newCapacity);


        }


    }
}
