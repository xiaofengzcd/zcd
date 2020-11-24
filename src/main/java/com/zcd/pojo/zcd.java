package com.zcd.pojo;/**
 * 此处填写说明
 *
 * @author wuyiwen
 * @createDate 2019/6/4
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zcd
 * @description: TODO
 * @date 2019/6/4 15:58
 */
public class zcd {

    public static void main(String[] agrs) throws Exception {

        FileReader data = new FileReader("C:/Users/Administrator/Desktop/sql.sql");
        final BufferedReader reader = new BufferedReader(data);
        String line = null;
        final List<String> sqls = new ArrayList<>();
        long successCount = 0;
        //line = reader.readLine();
        while ((line = reader.readLine()) != null /*&& sqls.size() <= 99*/) {
            //line = line.trim();
            //line.split(";");
            if (sqls.size() == 0 || sqls.size() % 100 == 0) {
                line = line.substring(line.indexOf("insert"), line.indexOf(";"));
                line = line + ",";
                sqls.add(line);
            } else if (sqls.size() % 100 != 0) {
                line = line.substring(line.indexOf("values") + 6, line.indexOf(";"));
                line = line + ",";
                sqls.add(line);
                if ((sqls.size() - 99) == 0 || (sqls.size() - 99) % 100 == 0) {
                    line = line + ";";
                    System.out.println("a" + line);
                    line = line.substring(line.indexOf("values") + 1, line.indexOf(";") - 1);
                    line = line + ";";
                    sqls.add(line);
                }
            } /*else if ((sqls.size() -99) == 0 || (sqls.size() - 99)% 100== 0) {
			    line = line +";";
				System.out.println("a" +line);
				line = line.substring(line.indexOf("values") +6 , line.indexOf(";") -1);
				line = line + ";";
				sqls.add(line);*/
            //System.out.println("a" +line);
            else if (sqls.size() >= 1000) {
                break;
            }
        }

        FileWriter writer01 = new FileWriter("C:/Users/Administrator/Desktop/zcd.txt");
        int fileLines = 0;
        BufferedWriter writer = null;
        int index = 1;
        for (String sql : sqls) {
            if (writer == null || fileLines >= 4000) {
                fileLines = 0;
                writer = new BufferedWriter(writer01);
                index++;
            }
            writer.write(sql);
            writer.newLine();
            writer.flush();
            fileLines++;
        }
    }
}
