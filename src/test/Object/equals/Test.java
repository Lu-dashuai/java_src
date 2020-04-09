package test.Object;

import sun.rmi.server.UnicastServerRef2;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/4/9 17:06<br/>
 *
 * @author Jack.Lu<br />
 * @since JDK 1.8
 */
public class Test {
    private static UserJack user1 = new UserJack();

    public static void main(String[] args) {
        test3();
    }

    public static void test1(){
        user1.setName("jack");
        user1.setSex("男");

        UserJack user2 = new UserJack();
        user2.setSex("男");
        user2.setName("bella");

        System.out.println(user1==user2);//false
        System.out.println(user1.equals(user2));//false
    }
    public static void test2(){
        user1.setName("jack");
        user1.setSex("男");

        UserJack user2 = user1;
        user2.setName("bella");
        user2.setSex("女");

        System.out.println(user1==user2);//true
        System.out.println(user1.equals(user2));//true
    }
    public static void test3(){
        user1.setName("jack");
        user1.setSex("男");

        UserJack user2 = new UserJack();
        user2.setName("jack");
        user2.setSex("男");

        System.out.println(user1==user2);//false
        System.out.println(user1.equals(user2));//true
    }
    public static void test4(){
        user1.setName("jack");
        user1.setSex("男");

        UserJack user2 = user1;
        user2.setName("bella");
        user2.setSex("女");

        System.out.println(user1==user2);//true
        System.out.println(user1.equals(user2));//true
    }


}
