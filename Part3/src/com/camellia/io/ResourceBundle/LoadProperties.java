package com.camellia.io.ResourceBundle;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

/**
 * 使用Properties集合类 + IO流来读取属性配置文件。
 * 将属性配置文件中的配置信息加载到内存中。
 */
public class LoadProperties {

    /**
     * 在不知道键的情况下加载属性配置文件，并打印所有的键值对。
     */
    @Test
    public void testLoadProperties01() {
        // 获取属性配置文件的路径
        String path = Thread.currentThread().getContextClassLoader()
                .getResource("com/camellia/io/ResourceBundle/jdbc.properties")
                .getPath();
        System.out.println(path);

        // 使用 try-with-resources 语句自动关闭资源
        try (FileReader reader = new FileReader(path)) {
            // 创建一个Properties对象，用于存储属性配置
            Properties properties = new Properties();
            // 加载属性配置文件中的信息到Properties对象中
            properties.load(reader);

            // 获取所有的键并打印键值对
            Enumeration<?> keys = properties.propertyNames();
            while (keys.hasMoreElements()) {
                String key = (String) keys.nextElement();
                String value = properties.getProperty(key);
                System.out.println(key + "\t" + value);
            }
        } catch (FileNotFoundException e) {
            // 捕获文件未找到异常并打印堆栈信息
            e.printStackTrace();
        } catch (IOException e) {
            // 捕获IO异常并打印堆栈信息
            e.printStackTrace();
        }
    }

    /**
     * 在知道具体键的情况下加载属性配置文件，并打印对应的值。
     */
    @Test
    public void testLoadProperties02() {
        // 获取属性配置文件的路径
        String path = Thread.currentThread().getContextClassLoader()
                .getResource("com/camellia/io/ResourceBundle/jdbc.properties")
                .getPath();
        System.out.println(path);

        // 使用 try-with-resources 语句自动关闭资源
        try (FileReader reader = new FileReader(path)) {
            // 创建一个Properties对象，用于存储属性配置
            Properties properties = new Properties();
            // 加载属性配置文件中的信息到Properties对象中
            properties.load(reader);

            // 根据具体的键获取对应的值并打印
            System.out.println(properties.getProperty("driver"));
            System.out.println(properties.getProperty("url"));
            System.out.println(properties.getProperty("username"));
            System.out.println(properties.getProperty("password"));
        } catch (FileNotFoundException e) {
            // 捕获文件未找到异常并打印堆栈信息
            e.printStackTrace();
        } catch (IOException e) {
            // 捕获IO异常并打印堆栈信息
            e.printStackTrace();
        }
    }
}
