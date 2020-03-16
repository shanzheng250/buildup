package io.nettyapi;

/**
 * @ClassName NettyResolve
 * @Description: TODO
 * @Author shanz
 * @Date 2020/3/15
 * @Version V1.0
 **/
public class NettyResolve {


    // netty 首先
    // server 注册新建eventloopgroup --》reactive线程模型
    // 初始化channel ->反射调用 使用时再创建
    // 初始化channelpipeline
    // 自定义channelhandler
    // builder模式 因为参数不固定

    //服务端
    // bind-> initAndRegister 反射调用channel, ->doRegister  ->  eventloopgroup.next  就是把channel注册到eventloop的selector上,然后获取selectkey
    //  期间通知了channelpipeline readactive方法

    // byteBuf --> 动态拓展，双指针，池化技术、堆内存和直接内存
    // 引用计数 目的是取消分配失去引用的资源，使用的事AtomicReferenceFieldUpdater和volatile来进行线程安全的判断
    //          通过引用计数器及时申请释放不再引用的对象，降低了GC频率
    // 池化技术 框架会预分配内存，然后分为trunk 和 page page是16K大小，然后进行bytebuf分配的时候是使用了树型结构，page存储树的编号，然后随机获取未被分配的


    // channel 和 channelpipleline
    // channel 是对jdk的channel的包装。里面是有unsafe类，是实际的io操作的类
    // channelpipleline 是一个线程安全的容器。这是防止多个线程操作channelpipleline的内容。里面是一个双向链表channelhandler，
    // channelhandler线程不安全，默认初始化一个header 一个tail 节点进行事件的监听。header是链接、读写等等操作。tail是异常事件
    // inbound事件是read方向触发的，outbond是write方向

    // eventloopgroup 和eventloop
    // eventloop就是重写了线程池的单线程线程池，当chanel发生动作时，把事件包装成一个task任务，放入队列中。线程有死循环进行检查处理，然后通过修改selectorKey进行不断处理
    // eventloopgroup 就是eventloop的数组形式 然后会在新的客户端连接创建channel是指定分配.因此 eventloopgroup和eventloop是1：n
    // eventloop和channel也是1：n

    // future重写：增加监听器回调函数
    // promice 就是增加future的写能力。原来主要能力是get 现在可以setSuccess之类的操作


    // netty是一个高性能无锁框架，

}
