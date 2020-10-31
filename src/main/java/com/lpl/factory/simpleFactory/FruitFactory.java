package com.lpl.factory.simpleFactory;

/**
 * 工厂设计模式：使用工厂来创建对象。优点：对象之间解耦。
 *  分为：简单工厂模式、工厂方法模式、抽象工厂模式。
 *  对于产品名称和分类是确定的、数量是固定的，推荐使用简单工厂模式。对于相对复杂的问题，适用于一系列、大批量的对象生产适合抽象工厂模式。
 *
 * 简单工厂设计模式
 * 实现步骤：
 *  1.抽象产品，定义抽象产品接口
 *  2.具体产品，具体产品实现抽象产品接口
 *  3.具体工厂，实现具体工厂用于创建具体产品对象
 *  4.产品使用，通过工厂创建使用
 *
 *  缺点就很明显了：
 *      我们每需要添加一种水果对象就要工厂类，显然违背了软件设计的开闭原则。因此简单工厂设计模式只适合产品对象较少，且
 *          产品固定的需求，对于产品变化无常的需求不合适。
 */

import com.lpl.factory.Apple;
import com.lpl.factory.Fruit;
import com.lpl.factory.Pear;

/**
 * 水果工厂--用于根据指定的水果类型生产具体的水果对象
 */
public class FruitFactory {

    /**
     * 根据水果类型创建具体的水果对象
     * @param type
     */
    public Fruit createFruit(String type) {
        if("apple".equals(type)) {
            return new Apple();
        }
        if("pear".equals(type)) {
            return new Pear();
        }
        return null;
    }

    public static void main(String[] args) {
        FruitFactory fruitFactory = new FruitFactory();
        //使用工厂创建对象
        Apple apple = (Apple) fruitFactory.createFruit("apple");
        System.out.println(apple);
        Pear pear = (Pear)fruitFactory.createFruit("pear");
        System.out.println(pear);
    }
}
