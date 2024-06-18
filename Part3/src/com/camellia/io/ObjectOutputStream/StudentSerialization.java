package com.camellia.io.ObjectOutputStream;

import java.io.Serial;
import java.io.Serializable;

/**
 * {@code StudentSerialization} ���ʾһ��ѧ��ʵ�壬���������������ID�����ԣ����ṩ���л����ܡ�
 *
 * <p>ʵ�� {@link Serializable} �ӿڱ�ʾ�����ʵ�����Ա����л��ͷ����л���{@code serialVersionUID}
 * �����ڷ����л������н��а汾���ƣ�ȷ�����л������뷴���л�ʱʹ�õ��ඨ��֮��ļ����ԡ�</p>
 *
 * <p>ע�⣺������ʽ���� {@code serialVersionUID}���Է�ֹ������ṹ�ı仯��������⡣����ඨ�巢�����ģ�
 * �� {@code serialVersionUID} û����Ӧ���ģ������л����ܻ�ʧ�ܻ���Ϊ����Ԥ�⡣</p>
 *
 * <p>Ϊ�˱������л��ļ����ԣ���ͬ�汾����֮�� {@code serialVersionUID} ֵ���뱣��һ�¡�����Զ��������ֵ�����仯��
 * ����ṹ�������仯�������л�ʱ���ܻ��׳� {@link java.io.InvalidClassException}��</p>
 *
 * <p>ʹ��ʾ����</p>
 * <pre>
 *     {@code
 *     StudentSerialization student = new StudentSerialization("����", 20);
 *     }
 * </pre>
 *
 * @author [Camellia.xiaohua]
 */
public class StudentSerialization implements Serializable {

    /**
     * ���л��汾��ʶ������ֵ������ {@code StudentSerialization} ��Ĳ�ͬ�汾֮�䱣��һ�¡�
     * �����ֵ�����仯�������л����޷�����ǰ�汾���ݣ��Ӷ����� {@link java.io.InvalidClassException}��
     */
    @Serial
    private static final long serialVersionUID = 9010515980424792363L;

    private String name;
    private int age;
    private int id;

    /**
     * ����һ���µ� {@code StudentSerialization} ʵ����������Ĭ��ֵ��
     */
    public StudentSerialization() {}

    /**
     * ����һ���µ� {@code StudentSerialization} ʵ����������ָ�������������䡣
     *
     * @param name ѧ��������
     * @param age ѧ��������
     */
    public StudentSerialization(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * ����ѧ����������
     *
     * @return ѧ��������
     */
    public String getName() {
        return name;
    }

    /**
     * ����ѧ����������
     *
     * @param name Ҫ���õ�����
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ����ѧ�������䡣
     *
     * @return ѧ��������
     */
    public int getAge() {
        return age;
    }

    /**
     * ����ѧ�������䡣
     *
     * @param age Ҫ���õ�����
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * ���� {@code StudentSerialization} ������ַ�����ʾ��ʽ��
     *
     * @return ѧ�����ַ�����ʾ��ʽ
     */
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
