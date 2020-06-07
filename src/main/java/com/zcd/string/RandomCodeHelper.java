package com.zcd.string;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author zcd
 * @description:
 * @create 2020/6/1 10:49
 */
public class RandomCodeHelper {
    /**
     * 随机生成指定长度字符串
     */
    public static String randomCharCode(int length) {
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            builder.append((char) (ThreadLocalRandom.current().nextInt(33, 128)));
        }
        String code = builder.toString();
        return code;
    }

    /**
     * 随机生成一串指定长度的数字
     */
    public static String randomNumCode(int length) {
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            builder.append( ThreadLocalRandom.current().nextInt(0,10));
        }
        String code = builder.toString();
        return code;
    }

    /**
     * description 获取指定位数的随机数
     */
    public static String getRandomString(int length) {
        String base = "0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(randomCharCode(5) + "   " +  randomNumCode(5));
        System.out.println(getRandomString(5));
    }

}
