package thread.jvm;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/10/24
 */
public class VoliateDemo {
    /**
     * volatile 保证的是数据的可见性，数据的原子性和可见性需要加锁
     * volatile 可以理解为内存屏障
     *      1、保证数据可见性
     *      2、禁止指令的重排序
     *
     * 当变量写入内存时，其他工作线程缓存值失效
     */
    private int a =1;
    private volatile int b =1;

    public void doSync(){
        while(a!=1){
            System.out.println("success");
        }
    }



}
