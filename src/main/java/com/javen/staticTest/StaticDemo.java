package com.javen.staticTest;

/**
 * @author zcd
 * @description: static关键字测试
 * @date 2019/6/20 9:13
 */
public class StaticDemo {
    private String name = "啊猫";
    private static int age = 12;
    
    public static void main(String[] args) {
        //如下所示.静态方法1可以直接调用,非静态方法二要new一个类对象调用
        Method01(12);
        StaticDemo staticDemo = new StaticDemo();
        String zcx = staticDemo.Method02("阿狗");
        System.out.println(System.currentTimeMillis() + zcx);
    }
    
    public static String Method01(int myage) {
        //  this.age=myage;  错误实例: static 方法无法用this,因为他没有对象
        //    System.out.println(name);  错误实例: static方法无法调用非static变量
        System.out.println(age);
        // return name ;
        return "不能返回一个非静态私有变量 name" + age;
    }
    
    public String Method02(String myname) {
        this.name = myname;
        System.out.println("static变量随便用就是了" + age);
        return myname;
    }
    
    static {
        System.out.println("我会被子类执行嘛~");
    }
}
