
# String
---
[参考博客](https://blog.csdn.net/KuBJavaChengXuYuan/article/details/81017251)<br/>
[参考博客](https://www.cnblogs.com/tinyphp/p/3768214.html)
---
- 基础知识：
1. String 类被final修饰，保证其不可变;
2. String 不可变的优点，见博客（HashKey、常量池、线性安全）;
3. String StringBuffer StringBuiler比较（可变性、线程安全）;
4. String 底层重写了equals方法;
5. String StringBuffer StringBuiler 空构造的初始容量0、16、16（扩容问题）
6. 还有一些方法 需要继续看...
---
- jdk重写的equals方法
```java

private final char value[];
private int hash; 
public String(String original) {
        this.value = original.value;
        this.hash = original.hash;
}

public boolean equals(Object anObject) {
    if (this == anObject) {
        return true;
    }
    if (anObject instanceof String) {
        String anotherString = (String)anObject;
        int n = value.length;
        if (n == anotherString.value.length) {//先比较两个字符串长度，不同直接给false
            char v1[] = value;
            char v2[] = anotherString.value;
            int i = 0;
            while (n-- != 0) {//倒着一个一个字符
                if (v1[i] != v2[i])
                    return false;
                i++;
            }
            return true;
        }
    }
    return false;
}
```
---
- 自己的测试
```java
/**
     *当两个地址不同时比较
     */
    @Test
    public void test(){
        String s1 = new String("bella");
        String s2 = new String("bella");
        //new出来两个对象，不同的内存地址
        //但是因为string底层重写了 equals 方法，所以底层现在比较的是 值
        //String 重写equals方法底层是 将字符串拆解为每一个字符char[]，然后逆序逐个比较每个字符的值
        System.out.println(s1==s2);//false
        System.out.println(s1.equals(s2));//true
    }
    /**
     * 常量池的概念
     */
    @Test
    public void test1(){
        String s1 = "jack";
        String s2 = "bella";
        //参考博客：https://www.cnblogs.com/tinyphp/p/3768214.html
        //如果String缓冲池内不存在与其指定值相同的String对象，那么此时虚拟机将为此创建新的String对象，并存放在String缓冲池内。
        //
        //如果String缓冲池内存在与其指定值相同的String对象，那么此时虚拟机将不为此创建新的String对象，而直接返回已存在的String对象的引用。
        System.out.println(s1 == s2);//false
        System.out.println(s1.equals(s2));//false

        String s3 = "jack";
        System.out.println(s1==s3);//true
        System.out.println(s1.equals(s3));//true
    }

    @Test
    public void test2(){
        String a = new String();
        a.length();//容量0

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.length();//初始容量16

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.length();//初始容量16
    }
```