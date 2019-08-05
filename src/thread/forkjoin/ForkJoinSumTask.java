package thread.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @ClassName:ForkJoinSumTask
 * @Description: TODO
 * @Author: shanz
 * @Date: 2019/2/26 17:00
 * @Version:1.0
 **/
public class ForkJoinSumTask extends RecursiveTask<Integer> {
    private long [] nums;
    private int start;
    private int end;

    private  static  final int DEFALUT_THORTH = 10;

    public ForkJoinSumTask(long[] nums, int start, int end) {
        this.nums = nums;
        this.start = start;
        this.end = end;
    }

/**
 * 功能描述
 * 本质是斐波那契数列
 *
 * if( 在阈值内){
 *     顺序执行
 * } else{
 *
 *     1、拆分
 *     2、另起一个线程进行处理
 *     3、等待线程完成
 *     3、数据合并
 *
 * }
 *
 * @date: 2019/2/26 17:03
 */
    @Override
    protected Integer compute() {
        int length = end - start;

        if (length <= DEFALUT_THORTH){
            return computeSeq();
        }

        ForkJoinSumTask leftForkJoin = new ForkJoinSumTask(nums,start+length/2,end);
        // 另起一个线程
        leftForkJoin.fork();

        // 同步使用
        ForkJoinSumTask rightForkJoin = new ForkJoinSumTask(nums,start,start+length/2 -1);

        int right = rightForkJoin.compute();

        int left = leftForkJoin.join();

        return right + left;
    }


    private int computeSeq(){
        int sum = 0;
        for (int i=start;i<end;i++){
            sum+= nums[i];
        }
        return sum;
    }


    public static void main(String[] args) {
        long [] a = new long[]{1l,23l,4l,6l,6l,6l,6l,6l,6l,6l,6l,6l,6l,6l,6l,6l,6l,6l,6l,6l,6l,6l,6l,6l,};

        System.out.println(new ForkJoinPool().invoke(new ForkJoinSumTask(a,0,a.length)));;

    }



}
