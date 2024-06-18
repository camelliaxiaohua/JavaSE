package com.camellia.io.StandardInputStream;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 演示标准输入流：System.in的使用
 * <ul>
 *     <li>1. 如何获取标准输入流？ 通过System.in</li>
 *     <li>2. 标准输入流默认从控制台读取数据。</li>
 *     <li>3. 普通输入流可以从文件、网络等多种数据源读取数据。</li>
 *     <li>4. 标准输入流是一个全局的输入流，不需要手动关闭。JVM退出时会自动关闭。</li>
 * </ul>
 */
public class SystemInTest {

    /**
     * 演示从标准输入流读取数据
     * 默认情况下，System.in从控制台读取输入
     */
    @Test
    public void testSystemIn01() {
        // 获取标准输入流对象
        try (InputStream in = System.in) {
            byte[] bytes = new byte[1024];
            int readCount = in.read(bytes); // 读取数据到字节数组中
            for (int i = 0; i < readCount; i++) {
                System.out.println(bytes[i]); // 打印每个字节的值
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 演示如何改变标准输入流的数据源
     * 将标准输入流从控制台重定向到文件
     *
     * @throws FileNotFoundException 如果指定的文件不存在
     */
    @Test
    public void testSystemIn02() throws FileNotFoundException {
        // 重定向标准输入流到文件
        InputStream originalSystemIn = System.in; // 保存原始的System.in流
        System.setIn(new FileInputStream("src/document/滕王阁序.txt"));

        // 读取文件内容并输出
        try (InputStream in = System.in) {
            byte[] bytes = new byte[1024];
            int readCount;
            while ((readCount = in.read(bytes)) != -1) {
                System.out.print(new String(bytes, 0, readCount)); // 打印读取的内容
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 恢复原始的System.in流
            System.setIn(originalSystemIn);
        }
    }

    /**
     * 使用BufferedReader包装标准输入流
     * 从键盘读取用户输入，并在控制台输出。
     * 只做了解如何包装的，后期用Scanner。
     */
    @Test
    public void testSystemIn03() {
        // 创建BufferedReader对象来包装System.in
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String s;
            while ((s = br.readLine()) != null) {
                if ("exit".equals(s)) {
                    break; // 用户输入exit时，结束循环
                }
                System.out.println("您输入了：" + s); // 输出用户输入的内容
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
