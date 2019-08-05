package jmx;

/**
 * @ClassName:HelloMBean
 * @Description:
 * @Author: shanz
 * @Date: 2019/3/11 14:22
 * @Version:1.0
 **/
public interface HelloMBean {

    // 这里是JMX standart bean   实现一个接口必须以MBean结尾的

    // 只读属性在接口里面只有get方法 既有get 又有set的是支持读写属性的

    public String getName();

    public void setName(String name);

    public String printMsg();

    public String printMsg(String name);
}
