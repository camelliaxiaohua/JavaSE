package com.camellia.io.garbledcharacters;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.Charset;

/**
 * 这个类演示了使用OutputStreamWriter和FileWriter以GBK编码将文本写入文件。
 *
 * <p>OutputStreamWriter 是一个字符流，也是一个转换流。它将字符编码成字节并写入输出流。
 * 如果OutputStreamWriter在编码过程中使用的字符集与文件的字符集不一致，可能会导致乱码。
 * FileWriter 是 OutputStreamWriter 的子类，简化了将字符写入文件的过程。</p>
 *
 * <p>注意：FileWriter是一个包装流，而不是节点流。它封装了一个FileOutputStream来实现其功能。</p>
 */
public class OutputStreamWriterEncodingTest {

    /**
     * 使用OutputStreamWriter以GBK编码将文本写入文件。
     * 此方法将文本写入文件，覆盖文件中的现有内容。
     */
    @Test
    public void testOutputStreamWriterEncoding() {
        // 创建一个使用GBK编码的OutputStreamWriter
        // 注意：以下代码中输出流以覆盖的方式写入文件
        try (OutputStreamWriter osw = new OutputStreamWriter(
                new FileOutputStream("src/document/GBK滕王阁序out.txt", false), Charset.forName("GBK"))) {
            osw.write("花有从开日，人无再少年。");
            // 刷新流，确保所有数据被写入
            osw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用FileWriter以GBK编码将文本写入文件。
     * 此方法将文本写入文件，覆盖文件中的现有内容。
     */
    @Test
    public void testFileWriterEncoding() {
        // 创建一个使用GBK编码的FileWriter
        // 注意：以下代码中输出流以覆盖的方式写入文件
        try (FileWriter fw = new FileWriter(
                "src/document/GBK滕王阁序out.txt", Charset.forName("GBK"), false)) {
            fw.write("花有从开日，人无再少年。");
            // 刷新流，确保所有数据被写入
            fw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
