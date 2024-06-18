package com.camellia.io.ObjectOutputStream;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * {@code CustomSerialization} ��������ʾ Java ��������л��ͷ����л����̡�
 *
 * <p>ͨ�������еĲ��Է����������˽���ν� `StudentSerialization` �������л����ļ��У��Լ���δ��ļ��з����л��ö���</p>
 */
public class CustomSerialization {

    /**
     * �������л����� {@code StudentSerialization} �������л����ļ��С�
     *
     * <p>�˷�������һ�� `StudentSerialization` ����ʵ�������������л���ָ���ļ��С����л�����ļ��������ں����ķ����л����ԡ�</p>
     */
    @Test
    public void testSerialization() {
        try (ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream("src/document/student"))) {
            StudentSerialization student = new StudentSerialization("Camellia", 23);
            oss.writeObject(student);
            oss.flush();  // ȷ���������ݶ���д���ļ�
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ���Է����л������ļ��з����л� `StudentSerialization` ����
     *
     * <p>�˷��������л����ļ��ж�ȡ���ݣ������䷴���л��� `StudentSerialization` ����ʵ����</p>
     */
    @Test
    public void Deserialization() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/document/student"))) {
            Object object = ois.readObject();
            if (object instanceof StudentSerialization) {
                StudentSerialization student = (StudentSerialization) object;
                System.out.println(student.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
