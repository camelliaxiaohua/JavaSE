package com.camellia.io.ResourceBundle;

import org.junit.jupiter.api.Test;

import java.util.ResourceBundle;

/**
 * 使用ResourceBundle类来读取属性配置文件。
 * ResourceBundle类用于从类路径下的属性文件中获取本地化的资源。
 */
public class BundleProperties {

    /**
     * 测试从ResourceBundle中读取属性配置。
     */
    @Test
    public void testBundleProperties() {
        // 获取资源绑定器对象
        // 只能获取类的根路径下(idea源代码根目录)的.properties文件
        ResourceBundle bundle = ResourceBundle.getBundle("com.camellia.io.ResourceBundle.jdbc");

        // 通过key获取value
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String username = bundle.getString("username");
        String password = bundle.getString("password");

        // 打印读取到的配置信息
        System.out.println(driver + "\n" + url + "\n" + username + "\n" + password);
    }
}
