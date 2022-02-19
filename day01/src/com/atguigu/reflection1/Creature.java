package com.atguigu.reflection1;

import java.io.Serializable;

/**
 * @author denghp
 * @create 2022-02-19 16:39
 */
public class Creature<T> implements Serializable {

    static final long serialVersionUID = 16165186152L;

    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物吃东西");
    }

}
