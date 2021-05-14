package com.mashibing.tank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author GuoYou
 * @create 2021-02-06-17:15
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        TankFrame tf = new TankFrame();
        GameModel gm = GameModel.getInstance();

        while(true){
            Thread.sleep(50);
            tf.repaint();
        }

        //用于测试GitHub





    }


}
