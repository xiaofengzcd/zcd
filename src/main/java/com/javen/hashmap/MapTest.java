package com.javen.hashmap;

import com.javen.pojo.test;
import sun.awt.SunHints;

import java.util.*;

/**
/**
 * @description: TODO
 * @author zcd
 * @date 2019/7/1511:21
 */

/************
 * @author zcd
 * @description:
 * HashMap底层通过数组和链表实现
 * put方法: 由key对象调用key.hashcode 得到hash值,hash值调用hash()方法,做位运算,结果相当于做除余,
 * 得到的结果就是要储存在桶(bucket)中的索引,如果这个桶中已经有节点了,则以链表的形式存在桶后,
 * 链表长度>=8,链表改为红黑树
 *
 * (较官方的说法)
 * 对key的hashCode()做hash，然后再计算index;
 * 如果没碰撞直接放到bucket里；
 * 如果碰撞了，以链表的形式存在buckets后；
 *
 * get方法: 重复put方法的前一半流程,得到索引,如发生冲突(hash冲突),即这个地方有很多节点,
 * 则调用key.equals(k)方法,逐个对比,直到找到相同的key对象,返回对应节点的value;
 *
 *容量(Capacity) 和负载因子(Load factor)  默认16 , 0.75
 * Capacity就是buckets的数目，Load factor就是buckets填满程度的最大比例
 *
 * @date 2019/7/15
 * @param
 * @return
 **/
public class MapTest {
    public static void main(String[] args) {
        test();
    }
    
   /*神奇的HashMap,为啥倒着排*/
    static void  test(){
        List<String> list = new ArrayList<String>();
        ArrayList<String> list02 = new ArrayList<String>();
        ArrayList<HashMap<String,String>> list03 = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        HashMap<String,String> map02 = new HashMap<>();
        list.add("element01");
        list.add("element02");
        //添加至指定位置
        list.add(1,"我插中间");
        list02.add("war3");
        list02.add("sc2");
        //list添加list
        list02.addAll(list); //result: [war3, sc2, element01, 我插中间, element02]
        map.put("key", "value");
        map.put("key02", "value02");
        map02.put("key03","value03");
        map02.put("key04","value04");
        //map里放list
        map.put(list.get(0),list02.get(0));
        System.out.println(map);
        //map添加map
        map.putAll(map02);
        map.replace("key02","newValue02");
        //list添加map
        list03.add(map);
        for (HashMap<String,String> target : list03){
            System.out.println(target.entrySet());
        }
        System.out.println(list03);
       // System.out.println("判断是否包含这个key,有则返回true"+ map.containsKey("key02"));
      //  System.out.println("显示所有的key:"+ map.keySet()  );//显示所有key
        String demo = map.get("key02");
        //System.out.println("get :" + demo); //result: get :value02

        //使用迭代器把map01的value添加到list中
        // 原文链接：https://blog.csdn.net/a1920135141/article/details/100691558
        List<String> returnResult1 = new ArrayList<String>();
     // 获取所有的hashMap键
        Set<String> keySet = map.keySet();
      // 制作关键字迭代器
        Iterator<String> it = keySet.iterator();
        while(it.hasNext()) {
            // 把对应键的值添加到list中
            returnResult1.add(map.get(it.next()));
        }
        System.out.println(returnResult1);



    }
}
