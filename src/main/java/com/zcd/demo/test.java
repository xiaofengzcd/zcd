package com.zcd.demo;

import java.io.*;

public class test {
    public static void main(String[] args) throws IOException {
        IOsql("C:\\Users\\hasee\\Desktop\\test.sql", "C:\\Users\\hasee\\Desktop\\test1.sql");
    }

    public static void IOsql(String InputUrl, String OutUrl) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(InputUrl), "GBK"));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(OutUrl), "GBK"));
        String str = null;
        int i = 1;
        while ((str = in.readLine()) != null) {
            if (!str.equals("")) {
                if (!(i % 10 == 1)) {
                    str = str.substring(str.indexOf("values") + 6);
                }
                if (!(i % 10 == 0)) {
                    str = str.replace(';', ',');
                }
                System.out.println(str);
                out.write(str);
                out.newLine();
                i++;
            }
        }
        out.flush();
        in.close();
        out.close();
    }
}
