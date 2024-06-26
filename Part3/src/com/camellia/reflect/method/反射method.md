# Reflect method （反射方法）

> 要想反射所有的字段，首先要反射获取类。

```java
Class<?> newClass = Class.forName("xxx.xxx.xxx");
```

## 一、反射方法

1. 获取所有方法

```java
//获取所有的方法
Method[] methods = clazz.getDeclaredMethods();
```

2. 获取指定方法的方法名、形参。

```java
 Method loginMethod = clazz.getDeclaredMethod("login", String.class, String.class);
```

>注意：getDeclaredMethod方法中指定的**方法名**和**参数类型**必须与方法的声明完全一致。
> ```java
> public boolean login(String username, String password){
> return "admin".equals(username) && "123456".equals(password);
> }
> ```

3. 获取方法修饰符

```java
//方法修饰符
System.out.println(Modifier.toString(method.getModifiers()));
```

4. 获取方法返回值

```java
//方法返回值类型
System.out.println(method.getReturnType().getSimpleName());
```

5. 获取方法名

```java
 //方法名
System.out.println(method.getName());
```

6. 用getParameterTypes方法获取方法参数列表

```java
 Class<?>[] types = method.getParameterTypes();
 for (Class<?> type : types) {
    System.out.println(type.getSimpleName());
}
```

7. 用Parameter方法获取方法参数列表

```java
 Parameter[] parameters = method.getParameters();
 for (Parameter parameter : parameters) {
      //获取参数列表类型的简类名
      System.out.println(parameter.getType().getSimpleName());
      //获取参数的名字
      System.out.println(parameter.getName());
}
```

## 二、反射访问调用方法

> 首先获取类，推荐使用反射构造方法创建对象。
```java
 //获取类
Class<?> clazz = Class.forName("com.camellia.reflect.method.UserService");
UserService userService = (UserService) clazz.newInstance();
```

1. 获取指定方法:方法名、形参。

```java
Method loginMethod = clazz.getDeclaredMethod("login", String.class, String.class);
```
> `getDeclaredMethod`方法要求传入的方法名和参数类型必须与目标方法完全匹配，包括参数的顺序和类型。

2. 调用指定方法。

```java
Object returnValue = loginMethod.invoke(userService, "admin", "123456");
```

>注意：
> invoke方法调用时需要传入方法所属的对象实例和方法参数，返回值为方法的返回结果。
> 调用哪个对象(userService)、哪个方法(loginMethod)、传什么参数(admin、123456)、返回什么值(returnValue)。

eg:
```java
Method logoutMethod = clazz.getDeclaredMethod("logout");
logoutMethod.invoke(userService);
```

