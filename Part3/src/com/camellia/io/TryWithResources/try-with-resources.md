# Try-With-Resources

Java 的 `try-with-resources` 语句是用于自动管理资源的一个结构化机制。
它简化了资源管理并确保资源在使用完毕后**自动关闭**，从而避免资源泄漏问题。
`try-with-resources` 语句在 Java 7 中引入，是 `try` 语句的扩展形式，主要用于处理需要显式关闭的资源，如文件流、数据库连接等。

## 一、主要特点

1. **自动关闭资源**：在 `try` 块执行完毕后，自动调用资源的 `close()` 方法。
2. **简化代码**：无需显式在 `finally` 块中关闭资源，代码更简洁。
3. **确保资源释放**：即使在异常情况下也能确保资源正确释放。

## 二、使用方法

任何实现了 `AutoCloseable` 或 `Closeable` 接口的对象都可以用在 `try-with-resources` 语句中。
`AutoCloseable` 是 `Closeable` 的父接口。

### 2.1 语法

```java
try (ResourceType resource = new ResourceType()) {
    // 使用资源的代码
} catch (ExceptionType e) {
    // 异常处理代码
}
```
其中 `ResourceType` 必须实现 `AutoCloseable` 接口。

### 2.2 示例

```java
package com.camellia.io.TryWithResources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Java 7的新特性：try-with-resources（资源自动关闭）
 * 凡是实现了AutoCloseable接口的流都可以使用try-with-resources实现自动关闭。
 */
public class TryWithResources {
    public static void main(String[] args) {
        //用于测试流是否关闭
        FileInputStream inTest = null;
        try (FileInputStream in = new FileInputStream("E:/Learn/JavaSE/File/outfile1.txt");
             FileOutputStream out = new FileOutputStream("****")) {
            inTest = in;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //测试是否关闭，若关闭inTest是无法正常读取的。
        try {
            System.out.println(inTest.read());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

```

### 2.3 多个资源管理

可以在一个 try-with-resources 语句中管理多个资源，只需用分号分隔资源声明：

```java
try (
    FileInputStream fis = new FileInputStream("input.txt");
    FileOutputStream fos = new FileOutputStream("output.txt")
) {
    int data;
    while ((data = fis.read()) != -1) {
        fos.write(data);
    }
} catch (IOException e) {
    e.printStackTrace();
}
```
在这个示例中，`FileInputStream` 和 `FileOutputStream` 都会在 try 块结束时自动关闭。
