package com.zcd.demo;/**
 * 此处填写说明
 *
 * @author wuyiwen
 * @createDate 2019/6/4
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @description: TODO
 * @date 2019/6/415:58
 */
public class pdf {

    public static void main(String[] agrs) throws Exception {

        //FileReader data = new FileReader("C:/Users/Administrator/Desktop/国家电网“互联网+营销服务”.pdf");
        final BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(
                "C:/Users/Administrator/Desktop/国家电网“互联网+营销服务”.txt"), "UTF-8"));
        String line = null;
        final List<String> sqls = new ArrayList<>();
        while ((line = reader.readLine()) != null /*&& sqls.size() <= 99*/) {
            sqls.add(line);
            if (sqls.size() >= 20) {
                break;
            }
        }
        BufferedWriter writer01 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:/Users/Administrator/Desktop/zcdpdf.txt")));
        int fileLines = 0;
        BufferedWriter writer = null;
        int index = 1;
        for (String sql : sqls) {
            if (writer == null || fileLines >= 4000) {
                fileLines = 0;
                writer = new BufferedWriter(writer01);
                index++;
            }
            writer01.write(sql);
            writer01.newLine();
            writer01.flush();
            fileLines++;
        }
    }
}

