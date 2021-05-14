package com.mashibing.tank.decorator;

import com.mashibing.tank.GameObject;

import java.awt.*;

/**
 * @author GuoYou
 * @create 2021-05-07-20:27
 */
public abstract class GODecorator extends GameObject {
    protected GameObject go;

    public GODecorator(GameObject go){
        this.go = go;
    }


    @Override
    public abstract void paint(Graphics g);

}
