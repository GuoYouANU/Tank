package com.mashibing.tank.observer;

import com.mashibing.tank.Tank;

/**
 * @author GuoYou
 * @create 2021-05-08-16:28
 */
public class TankFireHandler implements TankFireObserver{
    @Override
    public void actionOnFire(TankFireEvent e) {
        Tank t = e.getSource();
        t.fire();
    }
}
