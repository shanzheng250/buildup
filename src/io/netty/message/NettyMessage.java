package io.netty.message;

/**
 * @ClassName:NettyMessage
 * @Description: netty 消息
 * @Author: shanz
 * @Date: 2019/1/7 13:50
 * @Version:1.0
 **/
public class NettyMessage  {

    private Header header;

    private Object body;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
