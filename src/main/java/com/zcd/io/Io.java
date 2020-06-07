package com.zcd.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zcd
 * @description:
 * @create 2020/5/4 15:58
 */
public class Io {
    //"C:/Users/Administrator/Desktop/爱迪尔房卡.docx"
    public static void main(String[] args) throws IOException {
        File file = new File( "C:/Users/Administrator/Desktop/爱迪尔房卡.docx");

        InputStream inputStream = new FileInputStream(file);

        byte[] bytes = new byte[( int) file.length()];

        inputStream.read(bytes);

        System. out.println( new String(bytes));

        inputStream.close();


        /*String var= "hai this is a test";

        File file02 = new File( "C:/Users/Administrator/Desktop/zcd.txt");

        OutputStream outputStream = newFileOutputStream(file);

        outputStream.write( var.getBytes);

        outputStream.close;*/


        FileReader data = new FileReader("C:/Users/Administrator/Desktop/sq.sql");
        final BufferedReader reader = new BufferedReader(data);
        final List<String> sqls = new ArrayList<>();
        String line = null;
        while ((line = reader.readLine()) != null){
            sqls.add(line);
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
