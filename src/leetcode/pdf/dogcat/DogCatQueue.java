package leetcode.pdf.dogcat;

import com.google.common.collect.Lists;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName:DogCatQueue
 * @Description: TODO
 * @Author: shanzheng
 * @Date: 2019/6/28 16:09
 * @Version:1.0
 **/
public class DogCatQueue {

    private Queue<Pet> stack = new LinkedList<>();
    private Queue<Dog> dStack = new LinkedList<>();
    private Queue<Cat> cStack = new LinkedList<>();


    public void addPet(Pet p){
        stack.add(p);
        if (p instanceof Dog){
            dStack.add((Dog) p);
        }
        if (p instanceof Cat){
            cStack.add((Cat) p);
        }
    }

    public List<Pet> pollAll(){
        List l = Lists.newArrayList();

        while(!stack.isEmpty()){

            l.add(stack.poll());

        }
        return l;
    }


    public List<Dog> pollDog(){
        List l = Lists.newArrayList();

        while(!dStack.isEmpty()){

            l.add(dStack.poll());

        }
        return l;
    }

    public List<Cat> pollCat(){
        List l = Lists.newArrayList();

        while(!cStack.isEmpty()){

            l.add(cStack.poll());

        }
        return l;
    }

    public boolean isEmpty(){
return stack.isEmpty();
    }


    public boolean isDogEmpty(){
        return dStack.isEmpty();
    }

    public boolean isCatEmpty(){
        return cStack.isEmpty();
    }

}
