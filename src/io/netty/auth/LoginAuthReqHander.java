package io.netty.auth;

import io.netty.message.Header;
import io.netty.message.NettyMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ClassName:LoginAuthReqHander
 * @Description: 客户端请求 并对握手请求的应答消息进行处理
 * @Author: shanz
 * @Date: 2019/1/8 20:18
 * @Version:1.0
 **/
public class LoginAuthReqHander extends SimpleChannelInboundHandler<NettyMessage> {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        NettyMessage message  = (NettyMessage) msg;
        // 不为空 并且是登陆应答状态
        // TODO 这里type为1应该使用枚举类进行管理
        if (message.getHeader() != null && message.getHeader().getType() == 1 ){

            byte loginResult = (byte) message.getBody();

            //握手失败,则关闭链路
            if (loginResult != (byte) 0){
                ctx.close();
            }else{
                ctx.fireChannelRead(message);
            }
        } else{
            // 不是握手应答请求，则发给下一个channelhandler进行处理
            ctx.fireChannelRead(message);
        }


    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        super.channelActive(ctx);
        ctx.writeAndFlush(buildLoginReq());
    }



    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, NettyMessage o) throws Exception {
        channelRead(channelHandlerContext,o);
    }


    private Object buildLoginReq() {
        NettyMessage message = new NettyMessage();
        Header header = new Header();
        // 设置为登陆成功应答状态
        // todo 这里也应该使用枚举类
        header.setType((byte) 2);
        message.setHeader(header);
        return  message;
    }
}
