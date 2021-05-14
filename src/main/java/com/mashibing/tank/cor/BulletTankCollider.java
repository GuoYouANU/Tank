package com.mashibing.tank.cor;

import com.mashibing.tank.*;

/**
 * @author GuoYou
 * @create 2021-05-07-9:21
 */
public class BulletTankCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank) {
            Bullet bullet = (Bullet) o1;
            Tank tank = (Tank) o2;
            //具体碰撞逻辑
            if (bullet.getGroup() == tank.getGroup()) return false;
            //子弹与坦克相撞，判断是否相交
            if (bullet.rect.intersects(tank.rect)) {
                tank.die();
                bullet.die();
                int EX = tank.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
                int EY = tank.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
                GameModel.getInstance().gf.createExplode(EX, EY);
                return false;
            }
            return true;
        } else if (o1 instanceof Tank && o2 instanceof Bullet) {
            return collide(o2,o1);
        }else {
            return true;
        }
    }
}
