package java8.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @ClassName:FunctionDemo
 * @Description: TODO
 * @Author: shanz
 * @Date: 2019/2/11 8:46
 * @Version:1.0
 **/
public class FunctionDemo {

    /**
     * 功能描述  function<T,R> 用来格式参数转化 入参T 出参R  f.apply(T)
     * @param:
     * @return:
     * @date: 2019/6/18 16:56
     */
    public  static <T,R> List<R> map(List<T> list, Function<T,R> f){
        List<R> newlist = new ArrayList<>();
        for (T s:list){
            // f.apply(s) ===== new Apple（1）;
            newlist.add(f.apply(s));
        }
        return newlist;
    }

    /**
     * 功能描述 消费者 入参T 出参void
     * @param:
     * @return:
     * @date: 2019/6/18 17:01
     */
    public static <T> void  map(List<T> list, Consumer<T> f){
        List<T> newlist = new ArrayList<>();
        for (T s:list){
            f.accept(s);
        }
    }


    public static <T> List<T>  map(List<T> list, Supplier<T> f){
        List<T> newlist = new ArrayList<>();
        for (T s:list){
            newlist.add(f.get());
        }
        return  newlist;
    }


    @FunctionalInterface
    interface Factory{
       Apple create();
    }



    public static boolean testForWeight(Apple a,Predicate<Apple> p){
        return p.test(a);
    }



//    public static List<Apple> map(List<Integer> weights,Function<Integer,Apple> f){
//        List<Apple> apples = new ArrayList<>();
//
//        for (Integer i:weights){
//            apples.add(f.apply(i));
//        }
//
//        return apples;
//    }


    public static void main(String[] args) {


        Factory factory = new Factory() {
            @Override
            public Apple create() {
                return new Apple();
            }
        };


        Factory f1 = () -> new Apple();

        Factory f = Apple::new;









//        map()

//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//       List<Apple> a =  map(list,Apple::new);
//       List<String> a =  map(list,(i)->i+"1");
//        System.out.println(a.get(0).toString());
//        Predicate<Apple> p = (Apple a)-> a.getWeight() >150;



        // 构造函数引用方式
//        Supplier<Apple> t = Apple::new;
//        Apple apple1 = t.get();
//
//        testForWeight(apple1,(a)-> a.getWeight()>150);
//        // 有参数的构造函数使用
//        Function<Integer,Apple> t1 = Apple::new;
//        Apple apple2 = t1.apply(10);

    }

}
