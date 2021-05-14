package com.mashibing.tank.cor;

import com.mashibing.tank.GameObject;
import com.mashibing.tank.Tank;
import com.mashibing.tank.Wall;

/**
 * @author GuoYou
 * @create 2021-05-07-16:00
 */
public class TankWallCollider implements Collider{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Tank && o2 instanceof Wall){
            Tank tank = (Tank) o1;
            Wall wall = (Wall) o2;
            if(tank.rect.intersects(wall.rect)){
                tank.back();
            }
        }else if(o1 instanceof Wall && o2 instanceof Tank){
            return collide(o2,o1);
        }
        return true;
    }
}
