package com.lpl.factory.factoryMethod;

import com.lpl.factory.Apple;
import com.lpl.factory.Fruit;

/**
 * 具体产品工厂实现类--苹果工厂（相当于工厂里的一个车间）
 */
public class AppleFactory implements FruitFactory{

    /**
     * 生产苹果
     */
    @Override
    public Fruit createFruit() {
        return new Apple();
    }
}
