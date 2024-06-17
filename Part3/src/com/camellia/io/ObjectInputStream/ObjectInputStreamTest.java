package com.camellia.io.ObjectInputStream;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.List;

/**
 * {@code ObjectInputStreamTest} 类演示了使用 {@link ObjectInputStream}
 * 将文件中的字节流反序列化为Java对象。
 * <p>
 * {@code ObjectInputStream} 类专门用于反序列化，即将字节序列转换为JVM中的Java对象。
 * </p>
 */
public class ObjectInputStreamTest {

    /**
     * 测试方法，从文件中反序列化一个 {@link Date} 对象。
     * <p>
     * 该方法创建一个 {@code ObjectInputStream}，读取 "src/document/object" 文件中的字节流，
     * 并将其反序列化为一个 {@code Date} 对象。
     * </p>
     */
    @Test
    public void testObjectInputStream() {
        // 使用try-with-resources语句，自动关闭资源
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/document/object"))) {
            // 读取并反序列化对象
            Object object = ois.readObject();
            System.out.println(object);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试方法，从文件中反序列化一个包含多个 {@link Date} 对象的列表。
     * <p>
     * 该方法创建一个 {@code ObjectInputStream}，读取 "src/document/dates" 文件中的字节流，
     * 并将其反序列化为一个 {@code List<Date>} 对象。
     * </p>
     */
    @Test
    public void testManyObjectInputStream() {
        // 使用try-with-resources语句，自动关闭资源
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/document/dates"))) {
            // 读取并反序列化对象列表
            List<Date> dates = (List<Date>) ois.readObject();
            for (Date date : dates) {
                System.out.println(date);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
