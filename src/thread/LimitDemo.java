package thread;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @ClassName:LimitDemo
 * @Description: TODO
 * @Author: shanz
 * @Date: 2019/5/20 19:29
 * @Version:1.0
 **/
public class LimitDemo {

    /****
      系统限流的方式
        1、漏桶算法
            利用缓存区，请求放置缓冲区，由缓冲区以固定的流量处理请求
        2、令牌桶算法
            拿到令牌才能请求，获取令牌结束放回桶内
     **/


    private RateLimiter rateLimiter = RateLimiter.create(2);


    public void limit(){

        for (int i=0;i<50;i++){

            if (!rateLimiter.tryAcquire()){
                continue;
            }
            // todo sthing...
        }


    }

}
