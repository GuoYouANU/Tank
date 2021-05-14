package com.mashibing.tank.strategy;

import com.mashibing.tank.Bullet;
import com.mashibing.tank.GameModel;
import com.mashibing.tank.Tank;
import com.mashibing.tank.abstractfactory.BaseTank;
import com.mashibing.tank.decorator.RectDecorator;
import com.mashibing.tank.decorator.TailDecorator;

/**
 * @author GuoYou
 * @create 2021-02-17-16:49
 */
public class DefaultFireStrategy implements FireStrategy{
    @Override
    public void fire(BaseTank tank) {
        int bX = tank.getX() + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = tank.getY() + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        GameModel.getInstance().add(new Bullet(bX,bY,tank.getDir(),tank.getGroup()));
//        GameModel.getInstance().add(new RectDecorator(new TailDecorator(new Bullet(bX,bY,tank.getDir(),tank.getGroup()))));
    }

}
