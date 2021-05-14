package com.mashibing.tank;

import com.mashibing.tank.abstractfactory.BaseTank;
import com.mashibing.tank.observer.TankFireEvent;
import com.mashibing.tank.observer.TankFireHandler;
import com.mashibing.tank.observer.TankFireObserver;
import com.mashibing.tank.strategy.FireStrategy;

import java.awt.*;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 抽象出tank类，设计出相应的属性和方法。体现面向对象的封装性
 *
 * @author GuoYou
 * @create 2021-02-07-19:56
 */
public class Tank extends BaseTank {

    private int oldX,oldY;
    private Dir dir = Dir.DOWN;
    private static final int SPEED = PropertyMgr.get("tankSpeed");
    public static final int WIDTH = ResourceMgr.goodTankU.getWidth();
    public static final int HEIGHT = ResourceMgr.goodTankD.getHeight();

    private boolean moving = true;
    //这里的目的是把Tank类中创建的Bullet类对象赋给TankFrame类中的b
    //只有传给了b才能画出一个Bullet类对象
    //一个对象持有另一个对象的引用
    private boolean living = true;
    private Group group = Group.BAD;
    private Random random = new Random();

    FireStrategy fs;


    /**
     *
     * @param x 坦克初始横坐标
     * @param y 坦克初始纵坐标
     * @param dir 坦克初始方向
     */
    public Tank(int x, int y, Dir dir,Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;


        rect.x = x;
        rect.y = y;
        rect.height = HEIGHT;
        rect.width = WIDTH;

        if(group == Group.GOOD){
           String goodFSName = PropertyMgr.getString("goodFS");
           //通过反射机制类load到内存
            try {
                fs = (FireStrategy) Class.forName(goodFSName).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            String badFSName = PropertyMgr.getString("badFS");
            try {
                fs = (FireStrategy) Class.forName(badFSName).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 画坦克，体现了坦克的封装性
     * @param g
     */
    public void paint(Graphics g){
        if(!living && this.group == Group.GOOD){
            Color c = g.getColor();
            g.setColor(Color.WHITE);
            g.drawString("Game is over!",x,y);
            g.setColor(c);
            return;
        }
        if(!living) GameModel.getInstance().remove(this);


        switch (dir) {
            case LEFT -> g.drawImage(this.group == Group.GOOD? ResourceMgr.goodTankL : ResourceMgr.badTankL, x, y, null);
            case UP -> g.drawImage(this.group == Group.GOOD? ResourceMgr.goodTankU : ResourceMgr.badTankU, x, y, null);
            case RIGHT -> g.drawImage(this.group == Group.GOOD? ResourceMgr.goodTankR : ResourceMgr.badTankR, x, y, null);
            case DOWN -> g.drawImage(this.group == Group.GOOD? ResourceMgr.goodTankD : ResourceMgr.badTankD, x, y, null);
        }
        move();
    }



    private void move() {
        //记录移动之前的位置
        oldX = x;
        oldY = y;

        if(!moving) return;
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

        if(this.group == Group.BAD && random.nextInt(10) > 8)
            this.fire();

        if(this.group == Group.BAD && random.nextInt(100) > 95)
            randomDir();

        boundsCheck();

        //update rect
        rect.x = this.x;
        rect.y = this.y;
    }

    private void boundsCheck() {
        if(this.x < 2) x = 2;
        if(this.y < 28) y = 28;
        if(this.x > TankFrame.GAME_WIDTH - Tank.WIDTH - 2) x = TankFrame.GAME_WIDTH - Tank.WIDTH-2;
        if(this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2) y = TankFrame.GAME_HEIGHT - Tank.HEIGHT-2;

    }

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }


    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public Dir getDir() {
        return dir;
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

    public void fire() {
        fs.fire(this);
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

    public void back(){
        x = oldX;
        y = oldY;
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

    private List<TankFireObserver> fireObservers = Collections.singletonList(new TankFireHandler());

    public void handleFireKey(){
        TankFireEvent event = new TankFireEvent(this);
        for(TankFireObserver o : fireObservers){
            o.actionOnFire(event);
        }
    }



}
