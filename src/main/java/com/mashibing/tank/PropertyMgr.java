package com.mashibing.tank;

import java.io.IOException;
import java.util.Properties;

/**
 * @author GuoYou
 * @create 2021-02-15-15:33
 */
public class PropertyMgr {
    static Properties props = new Properties();


    static {
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Integer get(String key){
        if(props == null) return null;
        return Integer.parseInt((String) props.get(key));
    }

    //getString
    public static String getString(String key){
        if(props == null) return null;
        return (String) props.get(key);
    }

    public static void main(String[] args) {
        System.out.println(PropertyMgr.get("initTankCount"));
    }
}
