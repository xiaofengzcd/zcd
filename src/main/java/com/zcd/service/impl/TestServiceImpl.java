package com.zcd.service.impl;

import com.zcd.service.TestService;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * /**
 *
 * @author zcd
 * @description: TODO
 * @date 2019/6/20 14:39
 */
@Service
@EnableScheduling
public class TestServiceImpl implements TestService {
    
    
    public String Put() {
        return null;
    }
    
    @Override
    //@Scheduled(fixedRate = 3000)
    public List list01() {
        List<Map<String,String>> list = new ArrayList();
        Map<String,String> map01 = new HashMap<>();
        map01.put("zcd", "niubi");
        map01.put("zcx", "niubi");
        map01.put("zxx", "niubi");
        map01.put("zzz", "niubi");
        list.add(map01);
        
        return list;
    }
    
    @Override
    public List<String> list02() {
        List<String> list = new ArrayList<String>();
        list.add("abcd");
        list.add("0101");
        list.add("0101");
        list.add("0101");
        list.add("0101");
        return list;
    }
    
    @Override
    //此注解标记在实现类上,不可有参数,不可有返回值
    //@Scheduled(fixedRate = 3000)  //这个是在上一个任务执行完后等3s执行一次
    //@Scheduled(fixedDelay=5000)   这个是在上一个任务执行   后等5s执行一次
    public  void testScheduled(/*int args*/) throws InterruptedException {
        String code = null;
        for (int count = 4; count <=1000; count++){
            if (count % 4== 0){
                code = "从前有座山";
                System.out.println(code);
                Thread.sleep(3000);
            }
            if (count % 4 == 1){
                 code ="山里有座庙";
                System.out.println(code);
                Thread.sleep(3000);
            }
            if (count % 4 == 2){
                code ="庙里有两个和尚";
                System.out.println(code);
                Thread.sleep(3000);
            }
            if (count % 4 == 3){
                code ="大和尚对小和尚说";
                System.out.println(code);
                Thread.sleep(3000);
            }
        }
    }




}
