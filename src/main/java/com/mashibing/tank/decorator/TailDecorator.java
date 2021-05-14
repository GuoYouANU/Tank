package com.mashibing.tank.decorator;

import com.mashibing.tank.GameObject;

import java.awt.*;

/**
 * @author GuoYou
 * @create 2021-05-07-21:29
 */
public class TailDecorator extends GODecorator{
    public TailDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        this.x = go.x;
        this.y = go.y;
        go.paint(g);

        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawLine(super.go.x,super.go.y,super.go.x + getWidth(),super.go.y + getHeight());
        g.setColor(c);
    }

    @Override
    public int getWidth() {
        return super.go.getWidth();
    }

    @Override
    public int getHeight() {
        return super.go.getWidth();
    }
}
