package com.javen.MD5;/**
 * 此处填写说明
 *
 * @author wuyiwen
 * @createDate 2019/6/27
 */

import java.util.*;

/**
 * @author ZCD
 * @description: TODO
 * @date 2019/6/27  9:31
 */
public class F {
    public static void main(String[] args) {
        Map<String, String> param = new HashMap<>();
        param.put("seller_email", "zlm123123@163.com");
        param.put("_input_charset", "utf-8");
        param.put("subject", "%E8%B4%AD%E4%B9%B0abc");
        param.put("sign", "41e0d2a64cd62335cf0c74e6fdfa0b50");
        F f = new F();
        f.generateRequestQueryString(param);
    }
    
    public static final String generateRequestQueryString(final Map<String, String> params) {
        final List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);
        final StringBuilder paramString = new StringBuilder("");
        for (final String key : keys) {
            if (paramString.length() > 0) {
                paramString.append("&" + key + "=" + params.get(key));
            } else {
                paramString.append(key + "=" + params.get(key));
            }
        }
        System.out.println(paramString.toString());
        return paramString.toString();
    }
}
