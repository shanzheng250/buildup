package io.netty.client;

import io.netty.auth.LoginAuthReqHander;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.check.HeartBeatReqHandle;
import io.netty.code.NettyMessageDecoder;
import io.netty.code.NettyMessageEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName:NettyClient
 * @Description: TODO
 * @Author: shanz
 * @Date: 2019/1/10 11:03
 * @Version:1.0
 **/
public class NettyClient {
    //定时处理
    private ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

    EventLoopGroup group = new NioEventLoopGroup();

    public void connect (int port,String host) {
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY,true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
    //                        ch.pipeline().addLast(new NettyMessageDecoder(1,1,1,1,1))
                            ch.pipeline().addLast(new NettyMessageEncoder(1));
                            ch.pipeline().addLast("readTimeoutHandle",new ReadTimeoutHandler(50));
                            ch.pipeline().addLast("loginAuthHandle",new LoginAuthReqHander());
                            ch.pipeline().addLast("heartBeatHandle",new HeartBeatReqHandle());
                        }
                    });
            ChannelFuture future = bootstrap.connect(new InetSocketAddress(host,port));
            future.sync();
            future.channel().closeFuture().sync();
        } catch (Exception e){

        } finally {
            executorService.execute(()->{
                try {
                    TimeUnit.SECONDS.sleep(5);

                    connect(7777,"127.0.0.1");

                } catch (Exception e){

                }
            });
        }

    }



}
