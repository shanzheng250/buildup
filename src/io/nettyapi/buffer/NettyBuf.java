package io.nettyapi.buffer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufProcessor;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;

/**
 * @ClassName:NettyBuf
 * @Description: TODO
 * @Author: shanz
 * @Date: 2019/1/10 13:39
 * @Version:1.0
 **/
public class NettyBuf {

    public static void main(String[] args) {
        ByteBuf byteBuf = Unpooled.buffer();


        byteBuf.writeInt(10);
        byteBuf.writeInt(20);
        byteBuf.writeInt(30);
        byteBuf.discardReadBytes();
        byteBuf.clear();
        System.out.println(byteBuf.readableBytes());
        System.out.println(byteBuf.writableBytes());

        ChannelFuture future;

//        EventLoopGroup group = new NioEventLoopGroup();

//        ByteBufProcessor


    }

}
