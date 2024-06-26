# Reflect Constructor（反射构造方法）


## 一、反射构造方法

> 首先要获取类
> ```java
>  Class clazz = Class.forName("java.lang.String");
> ```

1. 获取所有的构造方法

```java
Constructor[] cons = clazz.getDeclaredConstructors();
```

2. 访问所有构造方法

```java
for(Constructor con : cons){}
```

3. 获取构造方法修饰符

```java
System.out.println(Modifier.toString(con.getModifiers()));
```

4. 获取构造方法名

```java
System.out.println(con.getName());
```

## 二、反射访问调用构造方法

> 首先，获取类
>```java
>Class<?> clazz = Class.forName("java.util.Date");
>```

1. 获取无参数构造方法

```java
Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
```

2. 调用无参构造方法实例化对象

```java
Object object = declaredConstructor.newInstance();
System.out.println(object);
```

3. 获取有参构造方法

```java
Constructor<?> constructor = clazz.getDeclaredConstructor(int.class, int.class, int.class);
```
> 参数类型必须完全匹配。如果构造方法有参数，需要在获取构造方法时提供正确的参数类型。


4. 调用有参构造方法实例化对象

```java
Object object1 = constructor.newInstance(2024, 6, 25);
System.out.println(object1);
```
> 提供的参数值必须与构造方法的参数类型匹配。


**注意**
- 确保构造方法是可访问的。如果构造方法是私有的，需要调用`setAccessible(true)`来绕过访问控制检查。
- **获取构造方法时**，参数类型必须完全匹配。如果构造方法有参数，需要在获取构造方法时提供正确的参数类型。
- **在调用构造方法时**，提供的参数值必须与构造方法的参数类型匹配。如果不匹配，会抛出`IllegalArgumentException`。