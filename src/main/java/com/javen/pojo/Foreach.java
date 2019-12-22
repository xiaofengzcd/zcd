package com.javen.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zcd
 * @description foreach测试
 * @date 2019/10/27
 */
public class Foreach {
    private String name ;
    private int id;

    public void demo(){
       List<String> list = new ArrayList<String>();
        List<String> list1 = new ArrayList<String>();
       list.add("1,2,3");
       list.add("4,5,6");
       list.add("7");

       "unknow".equalsIgnoreCase(name); // string专属的equals方法,参数和对象都只能是string
        /*
        这个target出了这个for循环就失效了,但每次循环,都是list把值
        给了target的,因此,可在循环体里,对这个target进行利用,循环结束,target失效
        */
        //这个list里面都是String,每一次遍历,都是把list里的一个元素赋给target
        for (String target : list) {
            list1.add(target);
           // System.out.println("" + list2);
        }
        System.out.println(list1);
    }

    public static void main(String[] args) {
        Foreach testObject = new Foreach();
        testObject.demo();

    }
}
