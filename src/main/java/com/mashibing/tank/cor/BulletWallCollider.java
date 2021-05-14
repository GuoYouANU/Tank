package com.mashibing.tank.cor;

import com.mashibing.tank.*;

/**
 * @author GuoYou
 * @create 2021-05-07-15:56
 */
public class BulletWallCollider implements Collider{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Bullet && o2 instanceof Wall){
            Bullet bullet = (Bullet) o1;
            Wall wall = (Wall) o2;
            //如果子弹和墙相撞，子弹消失
            if(bullet.rect.intersects(wall.rect)){
                bullet.die();
                //添加子弹和墙爆炸的效果
                int EX = bullet.getX() - Explode.WIDTH / 2;
                int EY = bullet.getY() - Explode.HEIGHT / 2;
                GameModel.getInstance().gf.createExplode(EX, EY);
            }
        }else if(o1 instanceof Wall && o2 instanceof Bullet){
            return collide(o2,o1);
        }
        return true;
    }
}
