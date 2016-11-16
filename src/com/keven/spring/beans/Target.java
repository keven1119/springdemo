package com.keven.spring.beans;

/**
 * Created by keven on 16/11/15.
 */
public class Target {

    public void execute(String name){
        System.out.println("程序开始执行：" + name);
    }

    public void say(String msg){
        System.out.println("说话：" + msg);
    }

    public void look(String what){
        System.out.println("看：" + what);
    }

    public void eat(String food){
        System.out.println("吃：" + food);
    }
}
