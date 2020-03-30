package leetcode.str;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName Lc49
 * @Description: TODO
 * @Author shanz
 * @Date 2020/3/27
 * @Version V1.0
 **/
public class Lc49 {
    public static void main(String[] args) {

        String [] a ={"eat","tea","tan","ate","nat","bat"};

        System.out.println(getSi(a));

    }

    private static List<List<String>> getSi(String[] a) {

        HashMap<String,List<String>> map = new HashMap<>();

        for (int i=0;i<a.length;i++){

            List<String> list =  map.getOrDefault(sort(a[i]),new ArrayList<>());

            list.add(a[i]);

            map.put(sort(a[i]),list);

        }

        List<List<String>> list = new ArrayList<>();
        map.values().forEach(l->{
            list.add(l);

        });

        return list;

    }

    private static String sort(String s){

        for (int i=0;i<s.toCharArray().length-1;i++){

            for (int j=0;j<s.toCharArray().length-i-1;j++){


                if (s.charAt(j) < s.charAt(j+1) ){

                    char temp  = s.charAt(j);

                    s.toCharArray()[j] = s.charAt(j+1);

                    s.toCharArray()[j+1] = temp;


                }


            }


        }

        return s;

    }


}
