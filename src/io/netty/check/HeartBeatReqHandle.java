package io.netty.check;

import io.netty.message.Header;
import io.netty.message.NettyMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName:HeartBeatReqHandle
 * @Description: 客户端发送心跳请求 检测链路可用性
 * @Author: shanz
 * @Date: 2019/1/9 13:51
 * @Version:1.0
 **/
public class HeartBeatReqHandle extends SimpleChannelInboundHandler<NettyMessage> {

    private volatile ScheduledFuture<?> heartbeat;

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, NettyMessage nettyMessage) throws Exception {
        channelRead(channelHandlerContext,nettyMessage);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        NettyMessage message = (NettyMessage) msg;

        // 若是握手成功后发送心跳消息
        if (message.getHeader() != null && message.getHeader().getType() == 5) {
            heartbeat = ctx.executor().scheduleAtFixedRate(new HeartBeatTask(ctx),0,5000,TimeUnit.MILLISECONDS);

        }else if (message.getHeader() != null && message.getHeader().getType() == 6){

        }else{
            ctx.writeAndFlush(message);
        }


    }

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


    /**
     * 功能描述 定时处理线程
     * @param:
     * @return:
     * @date: 2019/1/9 15:05
     */
    public class HeartBeatTask implements Runnable{

        private final ChannelHandlerContext ctx;

        public HeartBeatTask(ChannelHandlerContext ctx) {
            this.ctx = ctx;
        }

        @Override
        public void run() {
            NettyMessage  heatBeat = buildHeartBeat();

            ctx.writeAndFlush(heatBeat);
        }



        private NettyMessage buildHeartBeat() {
            NettyMessage  message = new NettyMessage();
            Header header = new Header();
            // 客户端的心跳任务
            header.setType((byte) 4);
            message.setHeader(header);
            return message;
        }
    }
}
