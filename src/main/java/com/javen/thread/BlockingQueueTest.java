package com.javen.thread;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;


class BlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        // 声明一个容量为10的缓存队列
         BlockingQueue<String> queue = new LinkedBlockingQueue<String>(10);
  
         //new了三个生产者和一个消费者
         Producer02 producer1 = new Producer02(queue);
         Producer02 producer2 = new Producer02(queue);
         Producer02 producer3 = new Producer02(queue);
        //Consumer consumer =new Consumer(queue);
        
        
  
         // 借助Executors
         ExecutorService service = Executors.newCachedThreadPool();
         // 启动线程
         service.execute(producer1);
         service.execute(producer2);
         service.execute(producer3);
        // service.execute(consumer);
         
  
         // 执行10s
         Thread.sleep(10 * 1000);
         producer1.stop();
         producer2.stop();
         producer3.stop();
  
         Thread.sleep(2000);
         // 退出Executor
         service.shutdown();
     }
 }
 
 