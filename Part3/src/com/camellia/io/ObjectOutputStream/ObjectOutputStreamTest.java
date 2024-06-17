package com.camellia.io.ObjectOutputStream;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * {@code ObjectOutputStreamTest} ����ʾ��ʹ�� {@link ObjectOutputStream}
 * ��Java�������л����ļ��С�
 * <p>
 * {@code ObjectOutputStream} �����ڶ�������л�������Java����ת��Ϊ����
 * д���ļ���ͨ�����紫����ֽ�����
 * </p>
 * <p>
 * ���л��ǽ�����ת��Ϊ�ֽ����еĹ��̣��������Խ���洢���ļ��С�
 * ͨ�����紫��򱣴浽���ݿ��С����л��Ķ���������Ժ����л���
 * �����ֽ�����ת����Java����
 * </p>
 */
public class ObjectOutputStreamTest {

    /**
     * ���Է�������һ�� {@link Date} �������л����ļ��С�
     * <p>
     * �÷�������һ�� {@code ObjectOutputStream}��д�뵽 "src/document/object" �ļ���
     * Ȼ�����л�һ�� {@code Date} ���󣬲�����д���ļ���
     * </p>
     */
    @Test
    public void testObjectOutputStream() {
        // �����ֽ���������������л�����
        ObjectOutputStream oos = null;
        try {
            // ����һ��д�� "src/document/object" �ļ��� ObjectOutputStream
            oos = new ObjectOutputStream(new FileOutputStream("src/document/object"));
            // ����һ���µ� Date ����׼�����л�
            Date newTime = new Date();
            // ���л� Date ����
            oos.writeObject(newTime);
            // ˢ������ȷ���������ݱ�д���ļ�
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // �ر� ObjectOutputStream ���ͷ���Դ
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * ���Է���������� {@link Date} �������л����ļ��С�
     * <p>
     * �÷�������һ�� {@code ObjectOutputStream}��д�뵽 "src/document/dates" �ļ���
     * Ȼ�����л�һ��������� {@code Date} ����� {@code List} ������д���ļ���
     * </p>
     */
    @Test
    public void testManyObjectOutputStream() {
        // �����ֽ���������������л�����
        ObjectOutputStream oos = null;
        try {
            // ����һ��д�� "src/document/dates" �ļ��� ObjectOutputStream
            oos = new ObjectOutputStream(new FileOutputStream("src/document/dates"));
            // ������� Date ����
            Date newTime1 = new Date();
            Date newTime2 = new Date();
            Date newTime3 = new Date();
            Date newTime4 = new Date();
            // �� Date ������ӵ��б���
            List<Date> list = new ArrayList<>();
            list.add(newTime1);
            list.add(newTime2);
            list.add(newTime3);
            list.add(newTime4);
            // ���л� Date �����б�
            oos.writeObject(list);
            // ˢ������ȷ���������ݱ�д���ļ�
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // �ر� ObjectOutputStream ���ͷ���Դ
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
