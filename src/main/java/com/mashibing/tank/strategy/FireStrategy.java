package com.mashibing.tank.strategy;

import com.mashibing.tank.abstractfactory.BaseTank;

import java.io.Serializable;

/**
 * @author GuoYou
 * @create 2021-02-17-16:48
 */
public interface FireStrategy extends Serializable {
    void fire(BaseTank tank);
}
