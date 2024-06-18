# PrintWriter打印流

`PrintWriter` 是 Java 中 `java.io` 包的一部分，用于打印流的字符输出。
它提供了便捷的方法来输出字符、字符串和其他对象，可以将数据输出到文件、控制台或其他字符流。

## 一、主要用途
- 打印各种数据类型到字符流（如文件、控制台）。

## 二、常用方法
- `print(Type x)`: 打印数据类型 `x`。
- `println(Type x)`: 打印数据类型 `x`，并在输出后自动添加一个换行符。
- `printf(String format, Object... args)`: 格式化输出，根据格式字符串和参数输出相应的格式。

## 三、便捷特性
- **直接输出各种数据类型**：可以轻松输出布尔值、字符、字符串、整数、浮点数等。
- **自动刷新和自动换行**：`println` 方法会在输出后自动添加换行符，同时可以结合流的刷新机制确保数据被写入输出目标。
- **支持字符串转义**：可以直接打印包含特殊字符的字符串，例如 `\n`、`\t` 等。
- **自动编码**：根据操作系统的默认编码或指定的编码方式自动处理字符编码，简化编码处理过程。
- **格式化输出**：通过 `printf` 方法，可以使用格式字符串来格式化输出数据。例如：
    - `%s` 表示字符串
    - `%d` 表示整数
    - `%f` 表示浮点数（如 `%.2f` 表示保留两位小数）
    - `%c` 表示字符

### 四、使用示例
```java
package com.camellia.io.PrintWriter;

import org.junit.jupiter.api.Test;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterTest {
    @Test
    public void testPrintWriter(){
        try(PrintWriter pw = new PrintWriter(new FileWriter("src/document/PrintWriter"))){
            pw.println("落霞与孤鹜齐飞，秋水共长天一色。");
            //刷新
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### 五、PrintWriter 和 PrintStream 的区分

- **`PrintWriter`**: 主要用于处理字符流，适合输出文本数据。它可以处理字符和字符串，更适合于需要进行字符编码转换的场景。
- **`PrintStream`**: 主要用于处理字节流，适合输出二进制数据或需要直接输出字节的场景。它也可以处理字符和字符串，但底层是通过字节流实现的。

> PrintWriter比PrintStream多一个构造方法，PrintStream参数只能是OutputStream类型，但PrintWriter参数可以是OutputStream，也可以是Writer。
