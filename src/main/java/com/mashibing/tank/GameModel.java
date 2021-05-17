package com.mashibing.tank;

import com.mashibing.tank.abstractfactory.BaseTank;
import com.mashibing.tank.abstractfactory.DefaultFactory;
import com.mashibing.tank.abstractfactory.GameFactory;
import com.mashibing.tank.cor.BulletTankCollider;
import com.mashibing.tank.cor.Collider;
import com.mashibing.tank.cor.ColliderChain;
import com.mashibing.tank.cor.TankTankCollider;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author GuoYou
 * @create 2021-05-06-19:51
 */
public class GameModel {
    private static final GameModel INSTANCE = new GameModel();

    public GameFactory gf = new DefaultFactory();

    BaseTank myTank = gf.createTank(PropertyMgr.get("initTankX"),PropertyMgr.get("initTankY"),Dir.DOWN,Group.GOOD);

    private List<GameObject> objects = new ArrayList<>();

    private ColliderChain colliderChain = new ColliderChain();



    //单例模式对GameModel进行优化
    private GameModel(){
        //初始化敌人坦克
        int initTankCount = PropertyMgr.get("initTankCount");
        for(int i = 0; i < initTankCount; i++){
            add(gf.createTank(50 + i*80,200,Dir.DOWN,Group.BAD));
        }

        //初始化墙
        add(new Wall(150,150,200,50));
        add(new Wall(550,150,200,50));
        add(new Wall(300,300,50,200));
        add(new Wall(550,300,50,200));

    }

    public static GameModel getInstance(){
        return INSTANCE;
    }

    public void add(GameObject go){
        this.objects.add(go);
    }

    public void remove(GameObject go){
        this.objects.remove(go);
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
//        g.drawString("子弹的数量：" + bullets.size() ,10,60);
//        g.drawString("敌人的数量：" + tanks.size(),10,80);
//        g.drawString("爆炸的数量：" + explodes.size(),10,100);
        g.setColor(c);

        myTank.paint(g);
        //处理内存泄露问题
        for(int i = 0; i < objects.size();i++){
            objects.get(i).paint(g);
        }


        //碰撞检测
        for(int i = 0; i < objects.size();i++){
            for(int j = i+1; j < objects.size();j++){
                GameObject o1 = objects.get(i);
                GameObject o2 = objects.get(j);
                colliderChain.collide(o1,o2);
            }
        }
    }

    public Tank getMainTank() {
        return (Tank) myTank;
    }

    public void save(){
        File f = new File("D:\\JavaProjects\\Tank\\src\\main\\java\\com\\mashibing\\tank.data");
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(myTank);
            oos.writeObject(objects);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void load() {
        File f = new File("D:\\JavaProjects\\Tank\\src\\main\\java\\com\\mashibing\\tank.data");
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(f));
            myTank = (BaseTank) ois.readObject();
            objects = (List) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
