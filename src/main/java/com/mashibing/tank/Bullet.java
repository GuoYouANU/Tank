package com.mashibing.tank;

import com.mashibing.tank.abstractfactory.BaseBullet;
import com.mashibing.tank.abstractfactory.BaseTank;

import java.awt.*;

/**
 * @author GuoYou
 * @create 2021-02-07-20:28
 */
public class Bullet extends BaseBullet {
    private static final int SPEED = PropertyMgr.get("bulletSpeed");
    public static final int WIDTH = ResourceMgr.bulletD.getWidth();
    public static final int HEIGHT = ResourceMgr.bulletD.getHeight();

    public Rectangle rect = new Rectangle();

    private final Dir dir;
    private boolean living = true;
    private Group group = Group.BAD;


    public Bullet(int x,int y,Dir dir,Group group){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        GameModel.getInstance().add(this);


        rect.x = x;
        rect.y = y;
        rect.height = HEIGHT;
        rect.width = WIDTH;
    }

    public void paint(Graphics g){
        if(!living){
            GameModel.getInstance().remove(this);
        }
        switch (dir){
            case UP:
                g.drawImage(ResourceMgr.bulletU,x,y,null);
                break;
            case LEFT:
                g.drawImage(ResourceMgr.bulletL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD,x,y,null);
                break;
            default:
                break;
        }
        move();
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

    private void move() {
        switch (dir){
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }
        //update rect
        rect.x = this.x;
        rect.y = this.y;

        if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT)
            living = false;
    }

    public boolean isLive() {
        return living;
    }

    public void setLive(boolean live) {
        this.living = live;
    }


    public void die() {
        this.living = false;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
