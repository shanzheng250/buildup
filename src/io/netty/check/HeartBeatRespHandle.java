package io.netty.check;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.message.NettyMessage;

/**
 * @ClassName:HeartBeatRespHandle
 * @Description: TODO
 * @Author: shanz
 * @Date: 2019/1/10 11:00
 * @Version:1.0
 **/
public class HeartBeatRespHandle extends SimpleChannelInboundHandler<NettyMessage> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, NettyMessage nettyMessage) throws Exception {
        channelRead(channelHandlerContext,nettyMessage);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 做应答

    }
}
