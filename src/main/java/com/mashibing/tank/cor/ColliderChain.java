package com.mashibing.tank.cor;

import com.mashibing.tank.GameObject;
import com.mashibing.tank.PropertyMgr;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author GuoYou
 * @create 2021-05-07-11:07
 */
public class ColliderChain implements Collider{
    private List<Collider> colliders = new LinkedList<>();

    public ColliderChain(){
        //把添加不同种类的Collider写到配置文件中
        String str = PropertyMgr.getString("colliders");
        String[] colliderStr = Objects.requireNonNull(str).split(",");
        for (String s : colliderStr) {
            try {
                colliders.add((Collider) Class.forName(s).getDeclaredConstructor().newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void add(Collider c){
        colliders.add(c);
    }

    public boolean collide(GameObject o1, GameObject o2) {
        for(Collider c : colliders){
            if(!c.collide(o1,o2)) return false;
        }
        return true;
    }
}
