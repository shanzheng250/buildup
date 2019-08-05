package io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/11/13
 */
public class Nio {
    /**
     *  io模型
     *
     *
     *
     *
     * 功能描述
     * @param:
     * @return:
     * @date: 2018/12/24 15:33
     */
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(128);
        buffer.put("南京北京".getBytes(Charset.forName("utf-8")));
        buffer.flip();
        Charset  utf8 = Charset.forName("utf-8");

        CharBuffer charBuffer =  utf8.decode(buffer);


        System.out.println(charBuffer.array());



    }
}
