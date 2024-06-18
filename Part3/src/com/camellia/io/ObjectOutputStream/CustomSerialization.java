package com.camellia.io.ObjectOutputStream;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * {@code CustomSerialization} 类用于演示 Java 对象的序列化和反序列化过程。
 *
 * <p>通过此类中的测试方法，可以了解如何将 `StudentSerialization` 对象序列化到文件中，以及如何从文件中反序列化该对象。</p>
 */
public class CustomSerialization {

    /**
     * 测试序列化：将 {@code StudentSerialization} 对象序列化到文件中。
     *
     * <p>此方法创建一个 `StudentSerialization` 对象实例，并将其序列化到指定文件中。序列化后的文件可以用于后续的反序列化测试。</p>
     */
    @Test
    public void testSerialization() {
        try (ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream("src/document/student"))) {
            StudentSerialization student = new StudentSerialization("Camellia", 23);
            oss.writeObject(student);
            oss.flush();  // 确保所有数据都被写入文件
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试反序列化：从文件中反序列化 `StudentSerialization` 对象。
     *
     * <p>此方法从序列化的文件中读取数据，并将其反序列化回 `StudentSerialization` 对象实例。</p>
     */
    @Test
    public void Deserialization() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/document/student"))) {
            Object object = ois.readObject();
            if (object instanceof StudentSerialization) {
                StudentSerialization student = (StudentSerialization) object;
                System.out.println(student.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
