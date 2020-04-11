package test.Object.equals;

import java.util.Objects;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/4/9 17:54<br/>
 *
 * @author Jack.Lu<br />
 * @since JDK 1.8
 */
public class UserJack {
    private String name;
    private String sex;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        //false || false
        if ((o == null) || (o.getClass() != this.getClass()))
            return false;

        UserJack userJack = (UserJack) o;
        return name.equals(userJack.name) &&
                sex.equals(userJack.sex);
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }



}
