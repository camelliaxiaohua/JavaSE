package com.camellia.io.ByteArrayOutputStream;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Date;

/**
 * 本类展示了如何使用`ByteArrayOutputStream`和`ByteArrayInputStream`进行内存中的字节流操作。
 * 还演示了如何使用装饰器设计模式中的包装流`ObjectOutputStream`和`ObjectInputStream`。
 */
public class ByteArrayOutputInputStreamTest {

    /**
     * 演示了`ByteArrayOutputStream`的基本用法。
     * 创建一个`ByteArrayOutputStream`实例，写入一些字节数据，然后读取这些数据。
     */
    @Test
    public void testByteArrayOutputStream(){
        // 创建一个ByteArrayOutputStream实例
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        // 向流中写入字节数据
        baos.write(97); // 写入字符'a'的ASCII值
        baos.write(98); // 写入字符'b'的ASCII值
        baos.write(99); // 写入字符'c'的ASCII值

        // 获取ByteArrayOutputStream中的字节数组
        byte[] byteArray = baos.toByteArray();

        // 输出每个字节的值
        for(byte b : byteArray){
            System.out.println(b);
        }
    }

    /**
     * 演示了装饰器设计模式的应用，使用`ObjectOutputStream`和`ByteArrayOutputStream`进行对象的序列化。
     * 通过`ByteArrayInputStream`和`ObjectInputStream`来反序列化这些对象。
     */
    @Test
    public void testWrapByteArrayOutputInputStream(){
        // 不用关闭流，因为真正的流是ByteArrayOutputStream。
        // 使用了包装流就需要刷新
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try(ObjectOutputStream oos = new ObjectOutputStream(baos)){
            // 开始写
            oos.writeObject(new Date());
            oos.writeInt(100);
            oos.writeBoolean(true);
            oos.writeUTF("Camellia.xiaohua");
            // 包装流需要手动刷新
            oos.flush();
            byte[] bytes = baos.toByteArray();
            // 使用ByteArrayInputStream将上面这个byte数组恢复。
            // 读的过程，读内存中的大byte数组。
            // 节点流
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            // 包装流
            ObjectInputStream ois = new ObjectInputStream(bais);

            // 开始读,写和读顺序要一样。
            System.out.println(ois.readObject());
            System.out.println(ois.readInt());
            System.out.println(ois.readBoolean());
            System.out.println(ois.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
