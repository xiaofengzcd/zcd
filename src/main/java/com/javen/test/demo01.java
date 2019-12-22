package com.javen.test;

public class demo01{
    public static void demo02(){

    }

        }

///*
// public static void demo02() {  
//        // 一些朋友在向循环里向列表增加对象的时候  
//        // 经常忘记初始化，造成最终加入的都是同一个对象  
//       List<MyObject> list = new ArrayList<MyObject>();
//        MyObject obj=new MyObject();  
//        for(int i=1;i<=5;i++){
//        obj.setName("Name" + i);  
//        list.add(obj);
//        }
//        // 里面的数据都是最后一个  
//        showList(list); // [Name5, Name5, Name5, Name5, Name5]  
//
//        // 正确的做法  
//        List<MyObject> list2 = new ArrayList<MyObject>();  
//        MyObject obj2 = null;  
//        for (int i = 1; i <= 5; i++) {  
//          obj2 = new MyObject();  
//          obj2.setName("Name" + i);  
//          list2.add(obj2);  
//        }    
//        showList(list2); // [Name1, Name2, Name3, Name4, Name5]  
//          }  
//          */
///** 
//*/

//        private static void showList(List list) {
//        System.out.println(Arrays.toString(list.toArray()));
//        }
   //     }
class MyObject {
        private String name;

        public String getName() {
        return name;
        }

        public void setName(String name) {
       this.name=name;
       }

        /** 
    * 重写toString方法，输出name 
    */
        public String toString() {
        return name;
        }
        }