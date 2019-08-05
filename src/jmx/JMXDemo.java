package jmx;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @ClassName:JMXDemo
 * @Description: TODO
 * @Author: shanz
 * @Date: 2019/3/11 14:41
 * @Version:1.0
 **/
public class JMXDemo {

    public static void main(String[] args) throws Exception{
        MBeanServer server =  ManagementFactory.getPlatformMBeanServer();

        ObjectName name = new ObjectName("myMBean:name=HelloWorld");

        server.registerMBean(new Hello(),name);


        /**
         * JMXConnectorServer service
         */
        //这句话非常重要，不能缺少！注册一个端口，绑定url后，客户端就可以使用rmi通过url方式来连接JMXConnectorServer
        Registry registry = LocateRegistry.createRegistry(1099);

        //构造JMXServiceURL
        JMXServiceURL jmxServiceURL = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:1099/jmxrmi");
        //创建JMXConnectorServer
        JMXConnectorServer cs = JMXConnectorServerFactory.newJMXConnectorServer(jmxServiceURL, null, server);
        //启动
        cs.start();

    }

}
