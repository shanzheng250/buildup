package thread.threadcreate;

import collection.LinkedNode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/11/2
 */
public class CompletableFutureDemo {

    public static void main(String[] args) {
        //顺序访问
        List<LinkedNode.Node> nodes = new ArrayList<>();
        nodes.stream().map(node ->node.getValue()).collect(Collectors.toList());

        // 并行处理
        nodes.parallelStream().map(node ->node.getValue()).collect(Collectors.toList());

        //异步执行
        nodes.stream().map(node -> CompletableFuture.supplyAsync(()->node.getValue(),Executors.newSingleThreadExecutor())).collect(Collectors.toList());


        //这里是将前一个结果返回
//        CompletableFuture.completedFuture("aaaa").thenRunAsync();

//        CompletableFuture future = new CompletableFuture();
        // 以asyc结尾的，是放在守护线程中，异步调用
        CompletableFuture future =  CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                System.out.println("aaaa");
            }
        });

        while(future.isDone()){
            System.out.println("bbbb");
        }


        System.out.println("这是用来检查是否异步执行");

//        future.completeExceptionally(new Exception());
    }


    public static void doprocess(List<LinkedNode.Node> nodes){


    }
}
