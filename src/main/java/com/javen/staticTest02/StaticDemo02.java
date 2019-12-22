package com.javen.staticTest02;

import com.javen.staticTest.StaticDemo;

import static com.javen.staticTest.StaticDemo.Method01;

/**
 * /**
 *
 * @author 社会你栋哥
 * @description: 另一个包下的static测试,
 * @date 2019/6/20 10:08
 */
public class StaticDemo02 {
    public static void main(String[] args) {
        StaticDemo staticDemo = new StaticDemo();
        //在另外一个包下,static方法仍旧可以直接调用(写的时候idea没提示,写完方法名后才提示导包)
        Method01(12);
    }
}

class StaticDemo03 extends StaticDemo {
    //继承后仍旧可以直接调用
    public void Test01() {
        Method01(12);
        System.out.println("我没有被调用,所以我会执行嘛~");
    }

    StaticDemo staticDemo = new StaticDemo();

    static {
        StaticDemo staticDemo = new StaticDemo();
        System.out.println("请问我会被执行嘛~");
    }

    public void test() {
        staticDemo.Method02("zcd");
    }

    String name01 = staticDemo.Method02("zcd");  //错误示例: static块里的内容这里用不到,

    public static void main(String[] args) {
        System.out.println("宝宝现在有main方法了");
    }

    static {
        StaticDemo staticDemo02 = new StaticDemo();
        System.out.println("请问我是最先被执行的嘛~");
    }
}
