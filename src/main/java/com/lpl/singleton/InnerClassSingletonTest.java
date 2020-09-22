package com.lpl.singleton;

/**
 * 静态内部类方式，懒加载的一种形式，只有真正使用时才会触发类的初始化。利用类加载机制保证线程安全。
 */
public class InnerClassSingletonTest {

    public static void main(String[] args) {
        //创建两个线程，获取单例对象
        new Thread(() -> {
            InnerClassSingleton instance = InnerClassSingleton.getInstance();
            System.out.println(instance);
        }).start();

        new Thread(() -> {
            InnerClassSingleton instance = InnerClassSingleton.getInstance();
            System.out.println(instance);
        }).start();
    }
}

class InnerClassSingleton {
    /**
     * 静态内部类，当外部调用内部属性值时才会对属性对应的实例进行创建
     */
    private static class InnerClassHolder {
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }

    /**
     * 提供私有构造方法，防止外部通过构造器实例化
     */
    private InnerClassSingleton() {
    }

    /**
     * 提供公有方法用于获取单例对象
     */
    public static InnerClassSingleton getInstance() {
        return InnerClassHolder.instance;
    }
}
