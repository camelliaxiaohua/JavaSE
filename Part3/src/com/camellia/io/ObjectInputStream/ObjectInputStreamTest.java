package com.camellia.io.ObjectInputStream;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.List;

/**
 * {@code ObjectInputStreamTest} ����ʾ��ʹ�� {@link ObjectInputStream}
 * ���ļ��е��ֽ��������л�ΪJava����
 * <p>
 * {@code ObjectInputStream} ��ר�����ڷ����л��������ֽ�����ת��ΪJVM�е�Java����
 * </p>
 */
public class ObjectInputStreamTest {

    /**
     * ���Է��������ļ��з����л�һ�� {@link Date} ����
     * <p>
     * �÷�������һ�� {@code ObjectInputStream}����ȡ "src/document/object" �ļ��е��ֽ�����
     * �����䷴���л�Ϊһ�� {@code Date} ����
     * </p>
     */
    @Test
    public void testObjectInputStream() {
        // ʹ��try-with-resources��䣬�Զ��ر���Դ
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/document/object"))) {
            // ��ȡ�������л�����
            Object object = ois.readObject();
            System.out.println(object);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * ���Է��������ļ��з����л�һ��������� {@link Date} ������б�
     * <p>
     * �÷�������һ�� {@code ObjectInputStream}����ȡ "src/document/dates" �ļ��е��ֽ�����
     * �����䷴���л�Ϊһ�� {@code List<Date>} ����
     * </p>
     */
    @Test
    public void testManyObjectInputStream() {
        // ʹ��try-with-resources��䣬�Զ��ر���Դ
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/document/dates"))) {
            // ��ȡ�������л������б�
            List<Date> dates = (List<Date>) ois.readObject();
            for (Date date : dates) {
                System.out.println(date);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
