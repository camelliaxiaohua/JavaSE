package com.camellia.io.DataInputStreamTest;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 演示如何使用DataInputStream读取使用DataOutputStream写入的文件。
 *
 * <p>java.io.DataInputStream是数据字节输入流，用于读取DataOutputStream写入的数据。
 * 注意：读取的顺序必须与写入的顺序一致，否则数据无法正确恢复。</p>
 */
public class DataInputStreamTest {

    public static void main(String[] args) {
        // 使用try-with-resources语句创建DataInputStream对象，确保在使用完毕后自动关闭流
        try (DataInputStream dis = new DataInputStream(new FileInputStream("Part3/src/document/data"))) {
            // 开始读取数据
            byte b = dis.readByte();
            short s = dis.readShort();
            int i = dis.readInt();
            long l = dis.readLong();
            float f = dis.readFloat();
            double d = dis.readDouble();
            boolean flag = dis.readBoolean();
            char c = dis.readChar();
            String str = dis.readUTF();

            // 打印读取到的数据
            System.out.println("Byte: " + b);
            System.out.println("Short: " + s);
            System.out.println("Int: " + i);
            System.out.println("Long: " + l);
            System.out.println("Float: " + f);
            System.out.println("Double: " + d);
            System.out.println("Boolean: " + flag);
            System.out.println("Char: " + c);
            System.out.println("UTF String: " + str);

        } catch (IOException e) {
            // 捕获并处理IO异常
            e.printStackTrace();
        }
    }
}
