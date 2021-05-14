package com.mashibing.tank.abstractfactory;

import com.mashibing.tank.*;

/**
 * @author GuoYou
 * @create 2021-02-18-14:45
 */
public class DefaultFactory extends GameFactory{
    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group) {
        return new Tank(x,y,dir,group);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group) {
        return new Bullet(x,y,dir,group);
    }

    @Override
    public BaseExplode createExplode(int x, int y) {
        return new Explode(x, y);
    }
}
