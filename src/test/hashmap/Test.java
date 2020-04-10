package test.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/4/9 16:53<br/>
 *
 * @author Jack.Lu<br />
 * @since JDK 1.8
 */
public class Test {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("1","1");
        map.put("2","2");
        System.out.println(map);
    }
}
