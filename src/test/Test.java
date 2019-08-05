package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/11/12
 */
public class Test {

    public static void main(String[] args) {
        List<Long> a = new ArrayList<>();

        a.add(1l);
        a.add(5l);
        a.add(4l);
        a.add(3l);
        a.add(2l);
        a.add(2l);
        a.add(2l);
        a.add(2l);
        a.add(2l);
        a.add(2l);
        a.add(2l);
        a.add(2l);
        a.add(2l);

        Long b = 7l;

        System.out.println( a.contains(b));       ;
    }

}
