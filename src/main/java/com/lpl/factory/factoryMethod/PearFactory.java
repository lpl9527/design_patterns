package com.lpl.factory.factoryMethod;

import com.lpl.factory.Fruit;
import com.lpl.factory.Pear;

/**
 * 具体产品工厂实现类--梨工厂（相当于工厂里的一个车间）
 */
public class PearFactory implements FruitFactory{

    /**
     * 生产梨
     */
    @Override
    public Fruit createFruit() {
        return new Pear();
    }
}
