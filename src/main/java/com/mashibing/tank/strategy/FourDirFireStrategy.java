package com.mashibing.tank.strategy;

import com.mashibing.tank.Bullet;
import com.mashibing.tank.Dir;
import com.mashibing.tank.Tank;
import com.mashibing.tank.abstractfactory.BaseTank;

/**
 * @author GuoYou
 * @create 2021-02-17-16:57
 */
public class FourDirFireStrategy implements FireStrategy{
    @Override
    public void fire(BaseTank tank) {
        int bX = tank.getX() + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = tank.getY() + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        Dir[] dirs = Dir.values();
        for(Dir dir : dirs){
            new Bullet(bX,bY,dir,tank.getGroup());
        }

    }
}
