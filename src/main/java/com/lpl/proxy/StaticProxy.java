package com.lpl.proxy;

/**
 * 静态代理
 */
public class StaticProxy {

    public static void main(String[] args) {

        //创建目标对象
        UserDao target = new UserDao();
        //创建代理对象，将目标对象传给代理对象，建立静态代理关系
        UserDaoProxy proxy = new UserDaoProxy(target);

        //执行的是代理方法
        proxy.save();
    }

}

/**
 * 代理对象和被代理对象需要实现的接口
 */
interface IUserDao {

    void save();
}

/**
 * 目标对象（被代理对象）
 */
class UserDao implements IUserDao {

    @Override
    public void save() {
        System.out.println("目标对象--进行了数据保存。。。");
    }
}

/**
 * 代理对象
 */
class UserDaoProxy implements IUserDao {

    //接收目标对象
    private IUserDao target;
    public UserDaoProxy(IUserDao target) {
        this.target = target;
    }

    /**
     * 代理对象方法中对目标对象进行了增强
     */
    @Override
    public void save() {
        System.out.println("代理对象--事务开始控制...");
        //执行目标对象方法
        target.save();
        System.out.println("代理对象--事务结束控制...");
    }
}
