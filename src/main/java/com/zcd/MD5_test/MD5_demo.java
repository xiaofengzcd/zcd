package com.zcd.MD5_test;

public class MD5_demo {
    /**
     * MD5 加密
     * @param value
     * 				待加密字符
     * @return
     */
    public static String md5Encrypt(String value){
        String result = null;
        if(value != null && !"".equals(value.trim())){
            result =  MD5Utils.encrypt(value,MD5Utils.MD5_KEY);
        }
        return result;
    }

    public static void main(String[] args) {
        final String value = md5Encrypt("王二小");
        System.out.println("生成128位字节 > 32位16进制字符串 : "+ value);
    }
}
