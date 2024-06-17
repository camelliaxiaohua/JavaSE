package com.camellia.io.DataOutputStream;

import org.junit.jupiter.api.Test;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 演示了如何使用DataOutputStream将各种Java数据类型写入到文件中。
 *
 * <p>DataOutputStream是一个数据字节输出流，允许将Java程序中的数据直接写入文件，以二进制格式存储。
 * DataOutputStream写数据的效率很高，因为写的过程中不需要进行转码。
 * 需要注意的是，用DataOutputStream写入的数据只能由DataInputStream来读取。</p>
 */
public class DataOutputStreamTest {

    /**
     * 测试DataOutputStream的写入功能，将各种基本数据类型写入文件。
     */
    @Test
    public void testDataOutputStreamWrite() {
        // 使用try-with-resources语句确保DataOutputStream在使用完毕后被正确关闭
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("src/document/data"))) {
            // 准备数据
            byte b = -127;
            short s = 32767;
            int i = 2147483647;
            long l = 1111111111L;
            float f = 3.0F;
            double d = 3.14;
            boolean flag = false;
            char c = 'A';
            String str = "Camellia.XIAOHUA";

            // 写入数据
            dos.writeByte(b);
            dos.writeShort(s);
            dos.writeInt(i);
            dos.writeLong(l);
            dos.writeFloat(f);
            dos.writeDouble(d);
            dos.writeBoolean(flag);
            dos.writeChar(c);
            dos.writeUTF(str);

            // 刷新流，确保所有数据都被写入
            dos.flush();
        } catch (FileNotFoundException e) {
            // 处理文件未找到异常
            e.printStackTrace();
        } catch (IOException e) {
            // 处理IO异常
            e.printStackTrace();
        }
    }
}
