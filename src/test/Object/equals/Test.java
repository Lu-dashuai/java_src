package test.Object.equals;

import java.lang.reflect.Method;

/**
 *
 * Description: object equals 和 == 学习
 * test1 test2 在没有重写equals 的前提下运行 返回
 * test3 test4 在重写equals 的前提下运行 返回
 *
 * date: 2020/4/9 17:06<br/>
 *
 * @author Jack.Lu<br />
 * @since JDK 1.8
 */
public class Test {
    private static UserJack user1 = new UserJack();
    /**
     * 需要删除UserJack中的equels方法
     */
    @org.junit.Test
    public  void test1(){
        user1.setName("jack");
        user1.setSex("男");

        UserJack user2 = new UserJack();
        user2.setSex("男");
        user2.setName("bella");

        System.out.println(user1==user2);//false
        System.out.println(user1.equals(user2));//false
    }
    @org.junit.Test
    public  void test2(){
        user1.setName("jack");
        user1.setSex("男");

        UserJack user2 = user1;
        user2.setName("bella");
        user2.setSex("女");

        System.out.println(user1==user2);//true
        System.out.println(user1.equals(user2));//true
    }

    /**
     * 重写equals后
     */
    @org.junit.Test
    public  void test3(){
        user1.setName("jack");
        user1.setSex("男");

        UserJack user2 = new UserJack();
        user2.setName("jack");
        user2.setSex("男");

        System.out.println(user1==user2);//false
        System.out.println(user1.equals(user2));//true
    }
    @org.junit.Test
    public  void test4(){
        user1.setName("jack");
        user1.setSex("男");

        UserJack user2 = user1;
        user2.setName("bella");
        user2.setSex("女");

        System.out.println(user1==user2);//true
        System.out.println(user1.equals(user2));//true
    }

    /**
     * getClass方法学习
     *         1. getClass 是获取当前类运行时对象，是一个native方法
     *         2. 引出另一个问题，java获取对象的4种方法（new ,class.forNmae, clnoe, 反序列化readObject）
     */
    @org.junit.Test
    public void test5() throws Exception {
        UserJack userJack = new UserJack();

        Class<?> aClass = Class.forName("test.Object.equals.UserJack");
        UserJack o = (UserJack)aClass.newInstance();

//        UserJack clone = (UserJack)userJack.clone();
        //问题：序列化和反序列化研究，深拷贝 和 浅拷贝
        int i = userJack.hashCode();
        System.out.println(i);
    }

}
