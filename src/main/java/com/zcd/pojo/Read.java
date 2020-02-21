package com.zcd.pojo;/**
 * 此处填写说明
 *
 * @author wuyiwen
 * @createDate 2019/6/4
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Read {

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\Administrator\\Desktop\\sql.sql");
        if (file.exists()) {
            InputStream input = new FileInputStream(file);
            byte[] data = new byte[1024 * 2];
            input.read(data, 1, 116);
            //int len=input.read(data);
            //	System.out.println(data);
            System.out.println(new String(data, 1, 116));
        }
    }
}

	

