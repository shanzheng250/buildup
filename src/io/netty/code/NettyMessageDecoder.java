package io.netty.code;

import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

import java.nio.ByteOrder;

/**
 * @ClassName:NettyMessageDecoder
 * @Description: TODO
 * @Author: shanz
 * @Date: 2019/1/8 20:16
 * @Version:1.0
 **/
public class NettyMessageDecoder extends LengthFieldBasedFrameDecoder {

    public NettyMessageDecoder(ByteOrder byteOrder, int maxFrameLength, int lengthFieldOffset, int lengthFieldLength, int lengthAdjustment, int initialBytesToStrip, boolean failFast) {
        super(byteOrder, maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip, failFast);
    }
}
