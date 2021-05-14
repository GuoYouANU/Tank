package com.mashibing.tank.strategy;

import com.mashibing.tank.abstractfactory.BaseTank;

/**
 * @author GuoYou
 * @create 2021-02-17-16:48
 */
public interface FireStrategy {
    void fire(BaseTank tank);
}
