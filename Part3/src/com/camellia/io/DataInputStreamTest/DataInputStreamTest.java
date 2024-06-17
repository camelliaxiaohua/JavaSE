package com.camellia.io.DataInputStreamTest;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * ��ʾ���ʹ��DataInputStream��ȡʹ��DataOutputStreamд����ļ���
 *
 * <p>java.io.DataInputStream�������ֽ������������ڶ�ȡDataOutputStreamд������ݡ�
 * ע�⣺��ȡ��˳�������д���˳��һ�£����������޷���ȷ�ָ���</p>
 */
public class DataInputStreamTest {

    public static void main(String[] args) {
        // ʹ��try-with-resources��䴴��DataInputStream����ȷ����ʹ����Ϻ��Զ��ر���
        try (DataInputStream dis = new DataInputStream(new FileInputStream("Part3/src/document/data"))) {
            // ��ʼ��ȡ����
            byte b = dis.readByte();
            short s = dis.readShort();
            int i = dis.readInt();
            long l = dis.readLong();
            float f = dis.readFloat();
            double d = dis.readDouble();
            boolean flag = dis.readBoolean();
            char c = dis.readChar();
            String str = dis.readUTF();

            // ��ӡ��ȡ��������
            System.out.println("Byte: " + b);
            System.out.println("Short: " + s);
            System.out.println("Int: " + i);
            System.out.println("Long: " + l);
            System.out.println("Float: " + f);
            System.out.println("Double: " + d);
            System.out.println("Boolean: " + flag);
            System.out.println("Char: " + c);
            System.out.println("UTF String: " + str);

        } catch (IOException e) {
            // ���񲢴���IO�쳣
            e.printStackTrace();
        }
    }
}
