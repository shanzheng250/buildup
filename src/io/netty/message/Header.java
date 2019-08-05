package io.netty.message;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName:Header
 * @Description: TODO
 * @Author: shanz
 * @Date: 2019/1/7 13:51
 * @Version:1.0
 **/
public class Header {


    private int crcCode = 0xabef0101;

    // 消息长度
    private int length;

    // 唯一id
    private long sessionID;

    // 消息类型
    private byte type;

    // 优先级
    private byte priority;

    // 拓展
    private Map<String,Object> attachment = new HashMap<>();

    public int getCrcCode() {
        return crcCode;
    }

    public void setCrcCode(int crcCode) {
        this.crcCode = crcCode;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public long getSessionID() {
        return sessionID;
    }

    public void setSessionID(long sessionID) {
        this.sessionID = sessionID;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public byte getPriority() {
        return priority;
    }

    public void setPriority(byte priority) {
        this.priority = priority;
    }

    public Map<String, Object> getAttachment() {
        return attachment;
    }

    public void setAttachment(Map<String, Object> attachment) {
        this.attachment = attachment;
    }
}
