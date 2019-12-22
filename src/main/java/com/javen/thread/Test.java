package com.javen.thread;

/**
 * /**
 *
 * @author zcd
 * @description: TODO
 * @date 2019/6/2516:01
 */
public class Test {
    public static void main(String[] args) {
        Test01 runner1 = new Test01();
        Test01 runner2 = new Test01();
        //  Thread(Runnable target) 分配新的 Thread 对象。
        Thread t1 = new Thread(runner1, "orc");
        Thread t2 = new Thread(runner2, "hum");
        Thread t3 = new Thread(runner2, "ne");
        Thread t4 = new Thread(runner2, "ud");
        Thread t5 = new Thread(runner2, "random");
      
 /*     t1.setPriority(10);
      t2.setPriority(9);
      t3.setPriority(8);
      t4.setPriority(7);
      t5.setPriority(6);*/
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        
    }
}

class Test01 implements Runnable {
    @Override
    public void run() {
            /*for (int i =0 ; i<=5;i++){
                System.out.println(i);
            }*/
        System.out.println(Thread.currentThread().getName() + ":  " + Thread.currentThread().getId() + ":  " + Thread.currentThread().hashCode());
    }
}
    

