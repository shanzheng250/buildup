package io.netty.auth;

import io.netty.message.Header;
import io.netty.message.NettyMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName:LoginAuthRespHandle
 * @Description: 服务端接入和安全认证
 * @Author: shanz
 * @Date: 2019/1/9 9:58
 * @Version:1.0
 **/
public class LoginAuthRespHandle extends SimpleChannelInboundHandler<NettyMessage> {

    // 检测
    private Map<String,Boolean> nodeCheck = new ConcurrentHashMap<>();

    private String [] whiteList = {"127.0.0.1","192.16.1.104"};


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        super.channelRead(ctx, msg);

        NettyMessage message = (NettyMessage) msg;

        // 若是握手请求消息则处理，其他请求透传
        if (message.getHeader()!=null &&message.getHeader().getType() == 1){

            String nodeIndex = ctx.channel().remoteAddress().toString();
            NettyMessage loginResp = null;
            if (nodeCheck.containsKey(nodeIndex)){
                loginResp = buildResponse((byte)-1);
            }else {
                InetSocketAddress address = (InetSocketAddress) ctx.channel().remoteAddress();
                String ip = address.getAddress().getHostAddress();
                boolean isOk = false;
                // 如果是白名单
                for (String wip:whiteList){
                    if (wip.equals(ip)){
                        isOk = true;
                        break;
                    }
                }

                loginResp = isOk ? buildResponse((byte)0) : buildResponse((byte) -1);

                if (isOk){
                    nodeCheck.put(nodeIndex,true);
                }
                ctx.writeAndFlush(loginResp);
            }


        }else {
            ctx.fireChannelRead(msg);
        }




    }

    private NettyMessage buildResponse(byte b) {
        NettyMessage message = new NettyMessage();
        Header header = new Header();
        header.setType((byte) 2);
        message.setHeader(header);
        message.setBody(b);
        return message;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, NettyMessage nettyMessage) throws Exception {
        channelRead(channelHandlerContext,nettyMessage);
    }
}
