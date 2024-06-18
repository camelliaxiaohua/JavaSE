# PrintStream打印流

`PrintStream`是一个打印流，主要用于打印操作，支持以字节形式输出数据。它提供了一些便捷的方法和格式化功能，主要用于将内容打印到文件或控制台。
> 具体可以查看帮助文档
## 一、主要用途
- 打印各种数据类型到输出流（如文件、控制台）。

## 二、常用方法
- `print(Type x)`: 打印数据类型x。
- `println(Type x)`: 打印数据类型x，并在输出后自动添加一个换行符。
- `printf(String format, Object... args)`: 格式化输出，根据格式字符串和参数输出相应的格式。

## 三、便捷特性
- **直接输出各种数据类型**：可以轻松输出布尔值、字符、字符串、整数、浮点数等。
- **自动刷新和自动换行**：`println`方法会在输出后自动添加换行符，同时可以结合流的刷新机制确保数据被写入输出目标。
- **支持字符串转义**：可以直接打印包含特殊字符的字符串，例如`\n`、`\t`等。
- **自动编码**：根据操作系统的默认编码或指定的编码方式自动处理字符编码，简化编码处理过程。
- **格式化输出**：通过`printf`方法，可以使用格式字符串来格式化输出数据。例如：
    - `%s` 表示字符串
    - `%d` 表示整数
    - `%f` 表示浮点数（如`%.2f`表示保留两位小数）
    - `%c` 表示字符

## 四、示例代码

```java
package com.camellia.io.PrintStream;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamTest {
    @Test
    public void testPrintStream(){
        //创建一个打印流对象
        try(PrintStream ps = new PrintStream(new FileOutputStream("src/document/PrintStream.txt"),true)){
            ps.println("落霞与孤鹜齐飞，秋水共长天一色。");
            String name ="Camellia.xioahua";
            double score = 96.6;
            ps.printf("姓名：%s  考试成绩：%.2f",name,score);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
```