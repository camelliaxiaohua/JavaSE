package com.camellia.io.ByteArrayOutputStream.DeepClone;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 演示如何使用`ByteArrayOutputStream`和`ByteArrayInputStream`进行对象的深克隆。
 * 通过序列化和反序列化的方式创建对象的副本，这种方法可以实现对对象的深克隆。
 */
public class DeepCloneTest {

    /**
     * 测试对象的深克隆。
     * 创建一个`User`对象，并通过序列化到字节数组和反序列化的方法来复制该对象。
     * 修改克隆后的对象的属性，验证原始对象不受影响，从而证明这是一个深克隆。
     */
    @Test
    public void testDeepClone() {
        // 创建一个Address对象
        Address address = new Address("上海", "新街口");

        // 创建一个User对象
        User user = new User("Camellia", 20, address);

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            // 将User对象写入ObjectOutputStream，将其转换为二进制格式并写入到ByteArrayOutputStream
            oos.writeObject(user);
            oos.flush();

            // 从ByteArrayOutputStream中读取数据，并使用ObjectInputStream反序列化，恢复为User对象
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            User user2 = (User) ois.readObject();

            // 修改克隆对象的地址信息
            user2.getAddr().setCity("南京");

            // 打印原始和克隆对象，验证深克隆效果
            System.out.println(user);
            System.out.println(user2);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
