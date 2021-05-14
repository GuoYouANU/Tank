package com.mashibing.tank;

import com.mashibing.tank.abstractfactory.BaseExplode;

import java.awt.*;

/**
 * @author GuoYou
 * @create 2021-02-07-20:28
 */
public class Explode extends BaseExplode {
    public static final int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static final int HEIGHT = ResourceMgr.explodes[0].getHeight();



    private int step = 0;


    public Explode(int x, int y){
        this.x = x;
        this.y = y;
        GameModel.getInstance().add(this);
    }

    public void paint(Graphics g){
        g.drawImage(ResourceMgr.explodes[step++],x,y,null);
        if(step >= ResourceMgr.explodes.length)
            GameModel.getInstance().remove(this);
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

}
