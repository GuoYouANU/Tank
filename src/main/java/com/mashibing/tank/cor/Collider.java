package com.mashibing.tank.cor;

import com.mashibing.tank.GameObject;

import java.io.Serializable;

/**
 * @author GuoYou
 * @create 2021-05-07-9:21
 */
public interface Collider extends Serializable {
    boolean collide(GameObject o1, GameObject o2);
}
