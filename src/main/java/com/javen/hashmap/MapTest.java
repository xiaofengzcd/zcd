package com.javen.hashmap;

import com.javen.pojo.test;
import sun.awt.SunHints;

import java.util.HashMap;
import java.util.Map;

/**
/**
 * @description: TODO
 * @author zcd
 * @date 2019/7/1511:21
 */
public class MapTest {
    public static void main(String[] args) {
        test();
    }
    
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
    static void  test(){
        HashMap<String, String> map = new HashMap<>();
        map.put("key", "value");
        map.put("key02", "value02");
        String demo = map.get("key02");
        System.out.println("get :" + demo);
    }
}
