package com.mashibing.tank;

import java.awt.*;
import java.io.Serializable;

/**
 * 作为所有物体的父类
 * @author GuoYou
 * @create 2021-05-06-20:36
 */
public abstract class GameObject implements Serializable {
     public int x,y;

     public abstract void paint(Graphics g);

     public abstract int getWidth();
     public abstract int getHeight();

}
