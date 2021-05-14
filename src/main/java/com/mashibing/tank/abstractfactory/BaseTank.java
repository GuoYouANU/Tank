package com.mashibing.tank.abstractfactory;

import com.mashibing.tank.*;

import java.awt.*;

/**
 * @author GuoYou
 * @create 2021-02-18-14:36
 */
public abstract class BaseTank extends GameObject {
    public Rectangle rect = new Rectangle();

    public abstract void fire();

    public abstract void setMoving(boolean b);

    public abstract void setDir(Dir left);

    public abstract void paint(Graphics g);

    public abstract Group getGroup();

    public abstract void die();

    public abstract int getX();

    public abstract int getY();


    public abstract Dir getDir();
}
