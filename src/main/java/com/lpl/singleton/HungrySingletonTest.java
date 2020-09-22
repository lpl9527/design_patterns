package com.lpl.singleton;

/**
 * 饿汉模式，基于JVM的类加载机制保证线程安全性
 */
public class HungrySingletonTest {

    public static void main(String[] args) {
        //创建两个线程，获取单例对象
        new Thread(() -> {
            HungrySingleton instance = HungrySingleton.getInstance();
            System.out.println(instance);
        }).start();

        new Thread(() -> {
            HungrySingleton instance = HungrySingleton.getInstance();
            System.out.println(instance);
        }).start();
    }
}

/**
 * 饿汉模式单例
 */
class HungrySingleton {

    public static HungrySingleton instance = new HungrySingleton();

    /**
     * 提供私有构造方法，防止外部通过构造器实例化
     */
    private HungrySingleton() {
    }

    /**
     * 提供公有方法用于获取单例对象
     */
    public static HungrySingleton getInstance() {
        return instance;
    }
}