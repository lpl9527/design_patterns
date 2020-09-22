package com.lpl.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLIB基于子类的动态代理，需要引入CGLIB包
 */
public class CGLIBDynamicProxy {

    public static void main(String[] args) {

        //创建目标对象
        UserDao target = new UserDao();
        System.out.println("目标对象的类型：" + target.getClass());

        //生成代理对象
        UserDao proxy = (UserDao) new CGLIBProxyFactory(target).getProxyInstance();
        System.out.println("代理对象的类型：" + proxy.getClass());

        //执行代理对象方法
        proxy.save();
    }
}

/**
 * 代理对象生产工厂
 */
class CGLIBProxyFactory implements MethodInterceptor {

    //维护目标对象
    private Object target;
    public CGLIBProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 为目标对象创建代理对象
     */
    public Object getProxyInstance() {
        //工具类
        Enhancer en = new Enhancer();
        //设置代理对象的父类为目标对象
        en.setSuperclass(target.getClass());
        //设置回调函数
        en.setCallback(this);
        //创建子类代理对象
        return en.create();
    }

    /**
     * 对目标对象方法进行增强
     * @param obj
     * @param method
     * @param args
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("代理对象--事务开始控制...");

        //执行目标对象方法
        Object returnValue = method.invoke(target, args);

        System.out.println("代理对象--事务结束控制...");
        return returnValue;
    }
}

