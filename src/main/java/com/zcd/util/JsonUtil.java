package com.zcd.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zcd
 * @description:
 * @create 2020/2/19 13:45
 */
public class JsonUtil {

    //重载下面的,可利用参数的不同直接调用下面的getJson
    //这里直接固定了日期格式,参数只需传object即可
    public static String getJson(Object object){
        return getJson(object,"yyyy-MM-dd HH:mm:ss");
    }


    public static String getJson(Object object,String dateFormat)  {
        ObjectMapper mapper = new ObjectMapper();
        //日期类型默认返回的是时间戳,即毫秒数,这里关闭时间戳功能
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);

        //自定义日期格式化类型""
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);

        mapper.setDateFormat(sdf);

        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
