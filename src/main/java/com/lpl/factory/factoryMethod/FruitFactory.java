package com.lpl.factory.factoryMethod;

import com.lpl.factory.Apple;
import com.lpl.factory.Fruit;
import com.lpl.factory.Pear;

/**
 * 工厂方法设计模式
 *  与简单工厂设计模式不同的是：工厂方法模式将产品类抽象出来，生产什么具体的产品由工厂接口的子类决定。
 */

/**
 * 产品工厂抽象--水果工厂接口
 *  缺点：
 *      虽然解耦了，也遵循了开闭原则，但是需要更多产品的话
 */
public interface FruitFactory {

    Fruit createFruit();

    public static void main(String[] args) {
        //苹果工厂生产苹果对象
        AppleFactory appleFactory = new AppleFactory();
        Apple apple = (Apple)appleFactory.createFruit();
        System.out.println(apple);

        //梨工厂生产梨对象
        PearFactory pearFactory = new PearFactory();
        Pear pear = (Pear) pearFactory.createFruit();
        System.out.println(pear);
    }

}
