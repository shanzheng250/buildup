package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName:UserProxy
 * @Description: TODO
 * @Author: shanz
 * @Date: 2018/12/1 13:53
 * @Version:1.0
 **/
public class UserProxy implements InvocationHandler {

    private Object obj;


    public UserProxy(Object obj) {
        this.obj = obj;
    }


    public Object bindObj(){
        return  Proxy.newProxyInstance(this.getClass().getClassLoader(),obj.getClass().getInterfaces(),this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before");

        Object re =  method.invoke(obj,args);

        System.out.println("end");

        return obj;
    }


}
