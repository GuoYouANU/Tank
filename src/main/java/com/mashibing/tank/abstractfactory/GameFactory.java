package com.mashibing.tank.abstractfactory;

import com.mashibing.tank.Dir;
import com.mashibing.tank.GameModel;
import com.mashibing.tank.Group;
import com.mashibing.tank.TankFrame;

import java.io.Serializable;

/**
 * @author GuoYou
 * @create 2021-02-18-14:32
 */
public abstract class  GameFactory implements Serializable {
    //抽象工厂，生产抽象坦克，爆炸与子弹
    public abstract BaseTank createTank(int x, int y, Dir dir, Group group);
    public abstract BaseBullet createBullet(int x, int y, Dir dir, Group group);
    public abstract BaseExplode createExplode(int x, int y);

}
