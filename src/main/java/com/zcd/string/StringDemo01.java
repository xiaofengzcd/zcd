package com.zcd.string;

/**
 * @author zcd
 * @description: TODO
 * @date 2019/6/2414:07
 */
public class StringDemo01 {
    private String words = "abc_zcd      +     zcx";
    private String words02 = "  abc_zcd     +     zcx   ";
    
    /*去除空格*/
    public String testDemo01() {
        System.out.println(words);
        System.out.println(words02);
        String replace = words.replace(" ", "");
        String replace02 = words.replaceAll(" +", "");
        String trim = words02.trim();   /*去除首尾空格*/
        System.out.println(replace);
        System.out.println(replace02);
        System.out.println(trim);
        return words;
    }
    
    private String words03 = "0123456789";
    
    public void testDemo02() {
        int one = words03.indexOf('4', 2);  /*从下标2开始搜索,搜索字符'4'第一次出现的索引*/
        String two = words03.substring(2, 6);  /*截取下标2至5的字符不包括6,左开右闭,返回这个字符串*/
        String three = words03.substring(words03.indexOf('2', 0), words03.indexOf('6'));
        System.out.println(one);
        System.out.println(two);
        System.out.println(three);
    }

    void testDemo03(){
        String index ="0,1234" ;
        final int result = index.indexOf(",");
        final String s = index.split(",")[0];
        System.out.println(s);
    }
    
    public static void main(String[] args) {
        StringDemo01 stringDemo01 = new StringDemo01();
        //stringDemo01.testDemo01();
        stringDemo01.testDemo02();
        stringDemo01.testDemo03();
    }
}
