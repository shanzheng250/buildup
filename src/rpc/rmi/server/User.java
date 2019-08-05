package rpc.rmi.server;

import java.io.Serializable;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/11/14
 */
public class User  implements Serializable {

    private int age;

    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
