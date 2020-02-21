package com.zcd.thread;

/**
 * /**
 *
 * @author zcd
 * @description: TODO
 * @date 2019/6/2514:50
 */
public class Testjoin02 {
    public static void main(String[] args) throws InterruptedException {
        ThreadTest02 t1 = new ThreadTest02("A");
        ThreadTest02 t2 = new ThreadTest02("B");
        ThreadTest02 t3 = new ThreadTest02("C");
        t1.start();
        t2.start();
    }
    
    
}

class ThreadTest02 extends Thread {
    private String name;
    
    public ThreadTest02(String name) {
        this.name = name;
    }
    
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + "-" + i);
        }
    }
}

