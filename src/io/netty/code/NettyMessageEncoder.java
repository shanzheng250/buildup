package io.netty.code;

import io.netty.message.NettyMessage;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;

import java.util.List;
import java.util.Map;

/**
 * @ClassName:NettyMessageEncoder 编码工具 支持protobuf 和marshalling
 * @Description: TODO
 * @Author: shanz
 * @Date: 2019/1/7 13:59
 * @Version:1.0
 **/
public class NettyMessageEncoder extends MessageToMessageEncoder<NettyMessage> {

    private int type;

    ProtobufEncoder encoder;

    public NettyMessageEncoder(int type) {
        if (type == 1){
            encoder = new ProtobufEncoder();
        }else{
//            encoder = MarshallingCoder
        }

    }

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, NettyMessage nettyMessage, List<Object> list) throws Exception {
        ByteBuf byteBuf = Unpooled.buffer();
        byteBuf.writeInt(nettyMessage.getHeader().getCrcCode());
        byteBuf.writeInt(nettyMessage.getHeader().getLength());
        byteBuf.writeLong(nettyMessage.getHeader().getSessionID());
        byteBuf.writeByte(nettyMessage.getHeader().getType());
        byteBuf.writeByte(nettyMessage.getHeader().getPriority());
        byteBuf.writeInt(nettyMessage.getHeader().getAttachment().size());

        String key = null;
        byte [] keyArray = null;
        Object value = null;

        for (Map.Entry<String,Object> param : nettyMessage.getHeader().getAttachment().entrySet()){
            key = param.getKey();

            keyArray = key.getBytes("utf-8");

            byteBuf.writeInt(keyArray.length);

            byteBuf.writeBytes(keyArray);

            value = param.getValue();

//            encoder.encode(value,byteBuf);
        }




    }
}
