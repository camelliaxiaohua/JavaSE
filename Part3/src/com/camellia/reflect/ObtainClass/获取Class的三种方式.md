# 获取Class的三种方式

## 一、Class.forName()

```java
Class c = Class.forName("完整的全限定类名");
```

- 注意：
    1. 全限定类名带有包名的。
    2. 虽然是lang包下，java.lang也不可省略。
    3. 这个字符串是参数。
    4. 如果这个类不存在，运行会报异常：java.lang.ClassNotFoundException。
    5. 这个方法的执行会导致类的加载动作的发生。


### 1.1 Class.forName()执行期间涉及操作分析

代码 `Class c1 = Class.forName("com.camellia.reflect.ObtainClass.User");` 会触发以下一系列操作：

1. **类名验证**：
    - JVM 会验证传入的类名 `"com.camellia.reflect.ObtainClass.User"` 是否符合类名的命名规范。

2. **类加载**：
    - JVM 的类加载器会尝试找到对应的类文件 `com/camellia/reflect/ObtainClass/User.class`。
    - 类加载器会根据类路径（`CLASSPATH`）搜索该类文件。如果在类路径中找不到对应的 `.class` 文件，则会抛出 `ClassNotFoundException`。

3. **字节码读取和解析**：
    - 类加载器会读取 `User.class` 文件的字节码。
    - JVM 会解析这些字节码，将其转换成 JVM 能够理解的数据结构。

4. **类初始化**：
    - 如果 `User` 类还没有被初始化，JVM 会进行类初始化。
    - 类初始化包括静态变量的初始化和静态代码块的执行。
    - 需要注意的是，`Class.forName` 默认会触发类的初始化，如果不希望触发类初始化，可以使用 `Class.forName(className, false, classLoader)`，将 `initialize` 参数设为 `false`。

5. **Class 对象的创建**：
    - JVM 创建一个表示该类的 `Class` 对象。
    - 该 `Class` 对象包含了类的元数据信息，如类名、包名、字段、方法等。

6. **返回 Class 对象**：
    - `Class.forName` 方法返回这个 `Class` 对象，并将其赋值给变量 `c1`。

总结来说，这段代码会加载并初始化指定的类（如果尚未加载和初始化），然后返回该类的 `Class` 对象。可能发生的异常包括：
- `ClassNotFoundException`：当指定的类在类路径中找不到时。
- `NoClassDefFoundError`：当类的定义在编译时存在但在运行时不可用时。

下面是一个完整的代码示例：

```java
try {
    Class c1 = Class.forName("com.camellia.reflect.ObtainClass.User");
    // 此时 c1 已经是 com.camellia.reflect.ObtainClass.User 类的 Class 对象
} catch (ClassNotFoundException e) {
    e.printStackTrace();
}
```

## 二、getClass

`getClass()` 方法是 Java 中 `java.lang.Object` 类的一部分。
每个 Java 对象都继承自 `Object` 类，因此每个 Java 对象都可以调用 `getClass()` 方法来获取表示该对象的类的 `Class` 对象。

### 2.1 作用
- `getClass()` 返回一个 `Class` 对象，这个对象表示调用该方法的实例所属的类。
- 通过 `Class` 对象，可以获取该类的元数据，例如类名、包名、字段、方法、构造函数等信息。

### 2.2 典型用法
1. **获取对象的类**：
    - 可以用来确定某个对象的类型。
2. **反射操作**：
    - 使用 `Class` 对象进行反射操作，例如创建实例、访问方法和字段等。

    
## 三、.class

`.class `是一种获取 Class 对象的方式，它是编译时确定的，不会抛出 ClassNotFoundException。
与 `getClass()` 和` Class.forName() `相比，`.class `更简单和直接。

> 在java语言中，任何一种类型，包括基本数据类型，都有 .class 属性。用这个属性可以获取Class实例。