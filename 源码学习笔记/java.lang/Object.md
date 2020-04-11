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
 1. == 比较的是内存地址，equals本身底层是比较的内存地址。
```java
//源码就这一行！
public boolean equals(Object obj) {
        return (this == obj);
}
```
 2. ide中重写的equels方法
```java
    @Override
    public boolean equals(Object o) {
        //上来就先比较是不是一个地址
        //如果是一个地址，那么两个对象的属性值尽管不同，那么返回的也是false，所以尽量自己重写equals方法。
        if (this == o)
            return true;
        //false || false
        if ((o == null) || (o.getClass() != this.getClass()))
            return false;

        UserJack userJack = (UserJack) o;
        return name.equals(userJack.name) &&
                sex.equals(userJack.sex);
    }
```

 3. 重写equals方法必须重写hashcode方法吗？

- 总结：
- 碰到的问题：getClass()方法、hashcode()方法。

