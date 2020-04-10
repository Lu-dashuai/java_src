# Object
---
 
- [参考博客](https://www.cnblogs.com/Rain1203/p/10757969.html)
- [参考博客](https://www.cnblogs.com/renchunjie/p/9081326.html)
---
- 知识点
1. Object是java类库中的一个特殊类，也是所有类的父类。Object类定义了一些有用的方法，由于是根类，这些方法在其他类中都存在，一般是进行了重载或重写，实现了各自的具体功能。
2. Object中常问的三个方法，equals()、hashCode()、getClass();
3. 创建对象时，先调用静态代码块(即registerNatives()方法)。native关键字表示该方法不是由java语言编写，而是通过C/C++来完成的，并被编译成.dll 之后才由Java调用,方法的具体实现是在dll文件中。registerNatives()方法主要作用就是将C/C++中的方法映射到Java中的native方法，实现方法命名的解耦。
---
-  equels方法底层学习<br/>
 1.源码中equels比较的是==，==比较的是内存地址。
```java
//源码就这一行
public boolean equals(Object obj) {
        return (this == obj);
}
```

2.在没有重写equals方法前，测试结果。
```java
private static UserJack user1 = new UserJack();

public static void test1(){
        user1.setName("jack");
        user1.setSex("男");

        UserJack user2 = new UserJack();
        user2.setSex("男");
        user2.setName("bella");

//此时user1 和 user2 不是一个内存地址
//没有重写的情况下 无论里面值是多少 都会返回false

        System.out.println(user1==user2);//false
        System.out.println(user1.equals(user2));//false
}
public static void test2(){
    user1.setName("jack");
    user1.setSex("男");

    UserJack user2 = user1;
    user2.setName("bella");
    user2.setSex("女");

//此时user1 和 user2 是一个内存地址
//没有重写的情况下 无论里面什么值 都会返回true

    System.out.println(user1==user2);//true
    System.out.println(user1.equals(user2));//true
}
```
3.看着idea重写的equal方法
```java
@Override
public boolean equals(Object o) {
//直接比较两个地址
    if (this == o)
        return true;
//下面要学习getClass方法，我暂且理解为还是比较运行时的类
    //false || false
    if ((o == null) || (o.getClass() != this.getClass()))
        return false;
//强转后比较 属性值
    UserJack userJack = (UserJack) o;
    return name.equals(userJack.name) &&
            sex.equals(userJack.sex);
}
//还没学习
@Override
public int hashCode() {
    return Objects.hash(name, sex);
}
```
4.重写后测试比较
```java
/**
 * 重写equals后
 */
public static void test3(){
    user1.setName("jack");
    user1.setSex("男");

    UserJack user2 = new UserJack();
    user2.setName("jack");
    user2.setSex("男");
//此时两个地址，直接比较地址返回false
//重写equals后比较的是属性，所以返回true
    System.out.println(user1==user2);//false
    System.out.println(user1.equals(user2));//true
}
public static void test4(){
    user1.setName("jack");
    user1.setSex("男");

    UserJack user2 = user1;
    user2.setName("bella");
    user2.setSex("女");
//此时是同一个地址，直接==返回true
//同一个地址，equals第一行比较地址，返回true，这里容易错。

    System.out.println(user1==user2);//true
    System.out.println(user1.equals(user2));//true
}
```
- 总结：== 比较的是内存地址，equals本身底层是比较的内存地址，重写后比较的是属性。这和重写equals的具体实现有关。
- 碰到的问题：getClass()方法、hashcode()方法。

