package com.mashibing.tank.observer;

import com.mashibing.tank.Tank;

/**
 * @author GuoYou
 * @create 2021-05-08-11:44
 */
public class TankFireEvent {
    Tank tank;

    public Tank getSource(){
        return tank;
    }

    public TankFireEvent(Tank tank){
        this.tank = tank;
    }
}
