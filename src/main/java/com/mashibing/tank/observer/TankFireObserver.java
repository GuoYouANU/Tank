package com.mashibing.tank.observer;

import java.io.Serializable;

/**
 * @author GuoYou
 * @create 2021-05-08-16:29
 */
public interface TankFireObserver extends Serializable {
    void actionOnFire(TankFireEvent e);
}
