package com.camellia.io.ObjectOutputStream;

import java.io.Serial;
import java.io.Serializable;

/**
 * {@code StudentSerialization} 类表示一个学生实体，具有姓名、年龄和ID等属性，并提供序列化功能。
 *
 * <p>实现 {@link Serializable} 接口表示此类的实例可以被序列化和反序列化。{@code serialVersionUID}
 * 用于在反序列化过程中进行版本控制，确保序列化对象与反序列化时使用的类定义之间的兼容性。</p>
 *
 * <p>注意：建议显式定义 {@code serialVersionUID}，以防止由于类结构的变化引起的问题。如果类定义发生更改，
 * 而 {@code serialVersionUID} 没有相应更改，反序列化可能会失败或行为不可预测。</p>
 *
 * <p>为了保持序列化的兼容性，不同版本的类之间 {@code serialVersionUID} 值必须保持一致。如果自动计算出的值发生变化，
 * 而类结构有显著变化，反序列化时可能会抛出 {@link java.io.InvalidClassException}。</p>
 *
 * <p>使用示例：</p>
 * <pre>
 *     {@code
 *     StudentSerialization student = new StudentSerialization("张三", 20);
 *     }
 * </pre>
 *
 * @author [Camellia.xiaohua]
 */
public class StudentSerialization implements Serializable {

    /**
     * 序列化版本标识符。此值必须在 {@code StudentSerialization} 类的不同版本之间保持一致。
     * 如果此值发生变化，反序列化将无法与先前版本兼容，从而导致 {@link java.io.InvalidClassException}。
     */
    @Serial
    private static final long serialVersionUID = 9010515980424792363L;

    private String name;
    private int age;
    private int id;

    /**
     * 构造一个新的 {@code StudentSerialization} 实例，并设置默认值。
     */
    public StudentSerialization() {}

    /**
     * 构造一个新的 {@code StudentSerialization} 实例，并设置指定的姓名和年龄。
     *
     * @param name 学生的姓名
     * @param age 学生的年龄
     */
    public StudentSerialization(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 返回学生的姓名。
     *
     * @return 学生的姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置学生的姓名。
     *
     * @param name 要设置的姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 返回学生的年龄。
     *
     * @return 学生的年龄
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置学生的年龄。
     *
     * @param age 要设置的年龄
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 返回 {@code StudentSerialization} 对象的字符串表示形式。
     *
     * @return 学生的字符串表示形式
     */
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
