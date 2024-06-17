package com.camellia.io.DataOutputStream;

import org.junit.jupiter.api.Test;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ��ʾ�����ʹ��DataOutputStream������Java��������д�뵽�ļ��С�
 *
 * <p>DataOutputStream��һ�������ֽ������������Java�����е�����ֱ��д���ļ����Զ����Ƹ�ʽ�洢��
 * DataOutputStreamд���ݵ�Ч�ʺܸߣ���Ϊд�Ĺ����в���Ҫ����ת�롣
 * ��Ҫע����ǣ���DataOutputStreamд�������ֻ����DataInputStream����ȡ��</p>
 */
public class DataOutputStreamTest {

    /**
     * ����DataOutputStream��д�빦�ܣ������ֻ�����������д���ļ���
     */
    @Test
    public void testDataOutputStreamWrite() {
        // ʹ��try-with-resources���ȷ��DataOutputStream��ʹ����Ϻ���ȷ�ر�
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("src/document/data"))) {
            // ׼������
            byte b = -127;
            short s = 32767;
            int i = 2147483647;
            long l = 1111111111L;
            float f = 3.0F;
            double d = 3.14;
            boolean flag = false;
            char c = 'A';
            String str = "Camellia.XIAOHUA";

            // д������
            dos.writeByte(b);
            dos.writeShort(s);
            dos.writeInt(i);
            dos.writeLong(l);
            dos.writeFloat(f);
            dos.writeDouble(d);
            dos.writeBoolean(flag);
            dos.writeChar(c);
            dos.writeUTF(str);

            // ˢ������ȷ���������ݶ���д��
            dos.flush();
        } catch (FileNotFoundException e) {
            // �����ļ�δ�ҵ��쳣
            e.printStackTrace();
        } catch (IOException e) {
            // ����IO�쳣
            e.printStackTrace();
        }
    }
}
