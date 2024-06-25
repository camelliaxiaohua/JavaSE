# Reflect Field（反射字段）

> 要想反射所有的字段，首先要反射获取类。

```java
Class<?> newClass = Class.forName("xxx.xxx.xxx");
```

## 一、反射字段

1. 反射类中所有public修饰的属性和字段。
```java
 Field[] fields = newClass.getFields();
```

2. 反射类中所有的属性和字段。
```java
Field[] declaredFields = newClass.getDeclaredFields();
```
>用于获取当前类中声明的字段，可以是任何访问修饰符，但不包括继承的字段。

3. 获取属性名
```java
for (Field field : declaredFields){
    System.out.println(field.getName());
}
```

4. 获取属性类型
```java
for (Field field : declaredFields){
    System.out.println(field.getType());
}
```
> 这里输出属性的全包名，`getType()`的返回类型是Class，这里只是println底层调用了`toString()`。

5. 获取属性名称
```java
for (Field field : declaredFields){
    //类名全包名
    System.out.println(field.getType().getName());
    //类名简名
    System.out.println(field.getType().getSimpleName());
}
```
6. 获取属性修饰符
```java
for (Field field : declaredFields){
    int modifiers = field.getModifiers();
    System.out.println("属性修饰符"+Modifier.toString(modifiers));
}
```

7. 获取指定的字段
```java
//获取对应的Field
Field ageField = clazz.getDeclaredField("age");
```


## 二、反射类（补充）

> 要想反射所有的字段，首先要反射获取类。
```java
//获取类
Class<?> newClass = Class.forName("xxx.xxx.xxx");
```

1. 获取类的修饰符
```java
 //获取类的修饰符
int classModifiers = newClass.getModifiers();
String strClass = Modifier.toString(classModifiers);
```

2. 获取类名
```java
//获取全包类名
String name = stringClass.getName();
//获取简类名
String simpleName = stringClass.getSimpleName();
```

3. 获取继承类
```java
strSuper = newClass.getSuperclass().getSimpleName();
```

4. 获取类的父接口
```java
Class<?>[] interfaces = stringClass.getInterfaces();
```
