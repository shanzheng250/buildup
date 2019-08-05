package jmx;

/**
 * @ClassName:Hello
 * @Description: TODO
 * @Author: shanz
 * @Date: 2019/3/11 14:36
 * @Version:1.0
 **/
public class Hello implements HelloMBean {

    // 命名

    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String printMsg() {
        return "hello";
    }

    @Override
    public String printMsg(String name) {
        return "hello " + name;
    }
}
