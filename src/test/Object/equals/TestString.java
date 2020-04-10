package test.Object.equals;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;

/**
 * String == 和 equals的区别
 * Description:
 * 参考博客（ https://blog.csdn.net/KuBJavaChengXuYuan/article/details/81017251）
 * 1. String 类被final修饰，保证其不可变
 * 2. String 不可变的优点，见博客（HashKey、常量池、线性安全）
 * 3. String StringBuffer StringBuiler比较（可变性、线程安全）
 * 4. String StringBuffer StringBuiler 空构造的初始容量
 *
 * date: 2020/4/10 10:40<br/>
 *
 * @author Jack.Lu<br />
 * @since JDK 1.8
 */
public class TestString {

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
        a.length();

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.length();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.length();

        Map map = new HashMap();
    }
}
