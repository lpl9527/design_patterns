package com.lpl.singleton;

/**
 * 懒汉式单例模式
 */
public class LazySingletonTest {

    public static void main(String[] args) {

        //创建两个线程，获取单例对象
        new Thread(() -> {
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println(instance);
        }).start();

        new Thread(() -> {
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println(instance);
        }).start();
    }
}

/**
 * 单例对象
 */
class LazySingleton {

    //防止指令重排序
    private volatile static LazySingleton instance;

    /**
     * 设置为私有构造方法，防止外部使用构造器创建对象
     */
    private LazySingleton(){
    }
    /**
     * 提供一个公有的方法用于外部访问获取单例对象
     */
    public static LazySingleton getInstance() {
        if (instance == null) {
            /*//线程休眠2秒，查看多线程获取到的是否是同一对象实例
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            //此处加锁，提升性能
            synchronized (LazySingleton.class) {
                //防止线程并发访问时重复实例化
                if (null == instance) {
                    instance = new LazySingleton();
                }
            }

        }
        return instance;
    }

}
