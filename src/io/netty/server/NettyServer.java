package io.netty.server;

import io.netty.auth.LoginAuthRespHandle;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.check.HeartBeatRespHandle;
import io.netty.code.NettyMessageEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;

/**
 * @ClassName:NettyServer
 * @Description: TODO
 * @Author: shanz
 * @Date: 2019/1/10 11:19
 * @Version:1.0
 **/
public class NettyServer {

    EventLoopGroup boss = new NioEventLoopGroup();
    EventLoopGroup worker = new NioEventLoopGroup();

    public void bind(int port){
        ServerBootstrap bootstrap = new ServerBootstrap();

        bootstrap.group(boss,worker)
                .channel(NioServerSocketChannel.class)
                .handler(new LoggingHandler(LogLevel.DEBUG))
                .childHandler(new ChannelInitializer() {
                    @Override
                    protected void initChannel(Channel channel) throws Exception {
                        ChannelPipeline pipeline =  channel.pipeline();
                        pipeline.addLast(new NettyMessageEncoder(1));
                        pipeline.addLast("readTimeoutHandle",new ReadTimeoutHandler(50));
                        pipeline.addLast("loginAuthHandle",new LoginAuthRespHandle());
                        pipeline.addLast("heartBeatHandle",new HeartBeatRespHandle());
                    }
                });

        try {
            bootstrap.bind(port).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }




}
