package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/11/13
 */
public class FileChannelDemo {

    public static void main(String[] args) throws IOException {

        File f = new File("C://Users//Administrator//Desktop//1.txt");

        if (!f.exists()){
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            try (FileOutputStream fos = new FileOutputStream(f)) {
                FileChannel fileChannel = fos.getChannel();
                ByteBuffer buffer = ByteBuffer.allocate((int)fileChannel.size()+1);
                buffer.put("hello world，你好。全世界".getBytes(Charset.forName("UTF-8")));
                buffer.flip();

                fileChannel.write(buffer);
                buffer.clear();
                buffer.put("see you。再见".getBytes(Charset.forName("UTF-8")));
                buffer.flip();
                fileChannel.write(buffer);
                fileChannel.close();
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {

        }






    }

}
