package com.camellia.io.ObjectOutputStream;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * {@code ObjectOutputStreamTest} 类演示了使用 {@link ObjectOutputStream}
 * 将Java对象序列化到文件中。
 * <p>
 * {@code ObjectOutputStream} 类用于对象的序列化，即将Java对象转换为可以
 * 写入文件或通过网络传输的字节流。
 * </p>
 * <p>
 * 序列化是将对象转换为字节序列的过程，这样可以将其存储在文件中、
 * 通过网络传输或保存到数据库中。序列化的对象可以在以后反序列化，
 * 即将字节序列转换回Java对象。
 * </p>
 */
public class ObjectOutputStreamTest {

    /**
     * 测试方法，将一个 {@link Date} 对象序列化到文件中。
     * <p>
     * 该方法创建一个 {@code ObjectOutputStream}，写入到 "src/document/object" 文件。
     * 然后序列化一个 {@code Date} 对象，并将其写入文件。
     * </p>
     */
    @Test
    public void testObjectOutputStream() {
        // 对象字节输出流，用于序列化对象
        ObjectOutputStream oos = null;
        try {
            // 创建一个写入 "src/document/object" 文件的 ObjectOutputStream
            oos = new ObjectOutputStream(new FileOutputStream("src/document/object"));
            // 创建一个新的 Date 对象准备序列化
            Date newTime = new Date();
            // 序列化 Date 对象
            oos.writeObject(newTime);
            // 刷新流，确保所有数据被写入文件
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭 ObjectOutputStream 以释放资源
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * 测试方法，将多个 {@link Date} 对象序列化到文件中。
     * <p>
     * 该方法创建一个 {@code ObjectOutputStream}，写入到 "src/document/dates" 文件。
     * 然后序列化一个包含多个 {@code Date} 对象的 {@code List} 并将其写入文件。
     * </p>
     */
    @Test
    public void testManyObjectOutputStream() {
        // 对象字节输出流，用于序列化对象
        ObjectOutputStream oos = null;
        try {
            // 创建一个写入 "src/document/dates" 文件的 ObjectOutputStream
            oos = new ObjectOutputStream(new FileOutputStream("src/document/dates"));
            // 创建多个 Date 对象
            Date newTime1 = new Date();
            Date newTime2 = new Date();
            Date newTime3 = new Date();
            Date newTime4 = new Date();
            // 将 Date 对象添加到列表中
            List<Date> list = new ArrayList<>();
            list.add(newTime1);
            list.add(newTime2);
            list.add(newTime3);
            list.add(newTime4);
            // 序列化 Date 对象列表
            oos.writeObject(list);
            // 刷新流，确保所有数据被写入文件
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭 ObjectOutputStream 以释放资源
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
