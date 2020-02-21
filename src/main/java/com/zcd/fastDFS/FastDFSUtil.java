package com.zcd.fastDFS;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * @author zcd
 * @description:
 * @create 2020/2/15 15:37
 */
public class FastDFSUtil {

    static {
        String fileName = new ClassPathResource("pom.xml").getPath();
        try {
            ClientGlobal.init(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    public void upload(){

    }
}
