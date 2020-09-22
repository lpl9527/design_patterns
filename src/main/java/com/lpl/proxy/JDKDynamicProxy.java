package com.lpl.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK基于接口的动态代理
 */
public class JDKDynamicProxy {

    public static void main(String[] args) {
        //创建目标对象
        IUserDao target = new UserDao();
        System.out.println("目标对象的类型：" + target.getClass());

        //生成代理对象
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        System.out.println("代理对象的类型：" + proxy.getClass());

        //执行代理对象方法
        proxy.save();
    }
}

/**
 * 代理对象工厂类，用于生成代理对象
 */
class ProxyFactory {

    //接收、维护目标对象
    private Object target;
    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 生成目标对象的代理对象实例
     */
    public Object getProxyInstance() {

        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 对目标对象进行增强的代理方法
                     * @param proxy 代理对象
                     * @param method 增强的方法
                     * @param args 方法参数列表
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("代理对象--事务开始控制...");

                        //执行目标对象方法
                        Object returnValue = method.invoke(target, args);

                        System.out.println("代理对象--事务结束控制...");
                        return returnValue;
                    }
                });
    }
}
